package rohit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rohit.Model.Admin;
import rohit.Model.createBankAccount;
import rohit.Repo.adminRepo;
import rohit.Service.adminService;
import rohit.Service.createBankAccountService;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("api/icin-banking")
public class adminController 
{
	@Autowired
	adminService aService;
	@Autowired
	createBankAccountService cbaService;
	boolean login=false;
	 String adminLogin="";
	@Autowired
	adminRepo aRepo;
	
	@PostMapping("/signup")
	public void adminRegister(@RequestBody Admin a)
	{
		aService.adminSignup(a);
	}
		//boolean b=false;
	
	
	@PostMapping(path = "/adminlogin")
	public String login(@RequestBody Admin a) 
	{
		adminLogin=a.getEmail();
		System.out.println("Email"+adminLogin);
	   try 
	   {
		   Admin k=aRepo.findByEmail(a.getEmail());
		   if(k.getPassword().equals(a.getPassword())) 
			   login=true;
		   else
			   login=false;
	   }
	   catch(NullPointerException e)
	   {
		   login=false; 
	       System.out.print("NullPointerException Caught");
	   }
	   return "null";
	}
	
	@GetMapping("/adminlogin")
	public boolean adminLoginComplete()
	{
		return login;
	}
	
	@GetMapping("/displayadminname")
	public String displayAdminName()
	{
		String adminName=aRepo.findByEmail(adminLogin).getName();
		System.out.println(adminName);
		return adminName;
	}
	
	@GetMapping("/viewaccountholder")
	public List<createBankAccount> ViewAccountHolder()
	{
		List<createBankAccount> m= cbaService.list();
		return m;
	}
	
	@GetMapping("/adminlogout")
	public boolean adminlogout()
	{
		login=false;
		adminLogin="";
		return login;
		
	}
}
