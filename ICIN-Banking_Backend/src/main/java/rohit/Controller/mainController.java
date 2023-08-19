package rohit.Controller;



import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import rohit.Model.TranHistory;
import rohit.Model.User;
import rohit.Repo.TranRepo;
import rohit.Repo.accountBalanceRepo;
import rohit.Repo.createBankAccountRepo;
import rohit.Repo.userRepo;
import rohit.Service.accountBalanceService;
import rohit.Service.createBankAccountService;
import rohit.Service.userService;
import rohit.Model.createBankAccount;
import rohit.Model.accountBalance;
@RestController
@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("api/icin-banking")
public class mainController 
{

	@Autowired
	userRepo uRepo;
	@Autowired
	userService uService;
	@Autowired
	createBankAccountRepo cbaRepo;
	@Autowired
	createBankAccountService cbaService;
	@Autowired
	accountBalanceRepo abRepo;
	@Autowired
	accountBalanceService abService;

	@Autowired
	TranRepo trRepo;
	
	boolean login=false;
	
	String userLogin="";
	String user="";
//	public boolean login=false;

	
	
	
	@PostMapping(path = "/userlogin")
	public String login(@RequestBody User u) 
	{
		userLogin=u.getUemail();
		System.out.println("Checking "+userLogin);
	   try 
	   {
		   User p=uRepo.findByUemail(u.getUemail());
		   if(p.getUpassword().equals(u.getUpassword())) 
		   {
//			   b=true;
			   login=true;
			   user=u.getUemail();
		   }
			  
		   else
		   {
//			   b=false;
			   login=false;
		   }
			   
	   }
	   catch(NullPointerException e)
	   {
		   login=false; 
	       System.out.print("NullPointerException Caught");
	   }
	   return "null";
	}

	
	
	@GetMapping(path = "/userlogin")
	public boolean valid()
	{
	  return login;  
	}
	
	
	
	
	@PostMapping("/usersignup")
	public String userSignup(@RequestBody User u)
	{
		uService.userSignup(u);
//		uRepo.save(u);
		
		return "Signup hogaya apka";
	}	
	
	
	
	@GetMapping("/usersignup")
	public String userSignupDone()
	{
		return null;
	}
	
	
	
	@PostMapping("/createbankaccount")
	public String createBankAccount(@RequestBody createBankAccount c)
	{
		System.out.println(userLogin);
		
		
		String img=c.getPhoto();
		c.setPhoto("../../assets/"+img.substring(12 , img.length()));
		c.setEmail(userLogin);
		cbaService.createBankAccount(c);
		accountBalance ab=new accountBalance();
		ab.setAccountnumber(c.getPhone());
		ab.setIfsc(c.getBranch());
		ab.setBalance(500);
		ab.setUemail(userLogin);
		abService.insertBankBalance(ab);
		return null;
	}
	
	
	
	@GetMapping("/createbankaccount")
	public String bankAccountCreated()
	{
		return null;
	}
	
	
	
	@GetMapping("/homeDetail")
	public String homeDetail()
	{
		String userName=uRepo.findByUemail(userLogin).getUname();
//		System.out.println(userName);

		return userName;
		
	}
	
	
	
	@GetMapping("/viewphoto")
	public createBankAccount ViewPhoto()
	{
		createBankAccount c=cbaRepo.findByEmail(userLogin);
	
//		System.out.println(c.getPhoto());
		return c;
	}
	
	
	
	
	@GetMapping("/accountView")
	public accountBalance accountView()
	{
		accountBalance a=abRepo.findByUemail(userLogin);
		return a;
	}
	
	
	@PostMapping("/addMoney")
	public void addMoney(@RequestBody accountBalance ab)
	{
		TranHistory tr=new TranHistory();
		
		String kno=ab.getAccountnumber();
		accountBalance k=abRepo.findByaccountnumber(kno);
		k.setBalance(ab.getBalance()+k.getBalance());
		abService.insertBankBalance(k);
		tr.setAmount(ab.getBalance());
		tr.setToacc(kno);
		tr.setFromcc("ICIN-Bank");
		tr.setUemail(abRepo.findByaccountnumber(kno).getUemail());
		tr.setStatus("Credit");
		tr.setRemarks("Admin");
		trRepo.save(tr);
//		System.out.println(ab.getBalance()+"Next"+k.getBalance());
//		System.out.println("Paisa aa gaya");
	}
	
	
	
	@GetMapping("/accountnumber")
	public String Accountnumber()
	{
		String account=abRepo.findByUemail(userLogin).getAccountnumber();
		return account;
	}
	
	
	
	@PostMapping("/fundtransfer")
	public boolean fundtransfer(@RequestBody TranHistory th)
	{
		TranHistory th1=new TranHistory();
		String fromacc=abRepo.findByUemail(userLogin).getAccountnumber();
		th.setUemail(userLogin);
		th.setFromcc(fromacc);
		th.setStatus("Debit*");
		String accountto=th.getToacc();
//		System.out.println(accountto);

		accountBalance kto=abRepo.findByaccountnumber(accountto);
		int amount=th.getAmount();
		accountBalance kfrom=abRepo.findByaccountnumber(Accountnumber());
		th.setFromcc(kfrom.getAccountnumber());
		int balance=kfrom.getBalance();
		if(amount<=balance)
		{
			
			kto.setBalance(kto.getBalance()+amount);
			abService.insertBankBalance(kto);
			kfrom.setBalance(balance-amount);
			abService.insertBankBalance(kfrom);
//			System.out.println("Paisa aa gaya hai ");
			th1.setUemail(abRepo.findByaccountnumber(accountto).getUemail());
			th1.setToacc(fromacc);
			th1.setFromcc(accountto);
			th1.setStatus("Credit");
			th1.setAmount(amount);
			trRepo.save(th);
			trRepo.save(th1);
			System.out.println("History created");
			return true;
		}
		return false;	
	}
	
	
	
	@GetMapping("/showhistory")
	public List<TranHistory> showHistory()
	{
		List<TranHistory> t=trRepo.findAllByUemail(userLogin);
		System.out.println(t.size());
		return t;
	}

	@GetMapping("/logout")
	public boolean logout()
	{
		login=false;
		user="";
		return login;
	}
	
	
	 
}
