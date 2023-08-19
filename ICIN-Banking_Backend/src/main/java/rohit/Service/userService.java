package rohit.Service;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rohit.Model.User;
import rohit.Repo.userRepo;

@Service
public class userService 
{
	@Autowired
	userRepo uRepo;
	
	
	public void userSignup(User u)
	{
		uRepo.save(u);
	}
	
	
//	public boolean userLogin(User u)
//	{
//		List<User> user=new ArrayList<User>();
//		uRepo.findAll().forEach(i -> user.add(i));
//		for(int i=0;i<user.size();i++)
//		{
//			String xxUser=user.get(i).getUemail();
//			String xxPassword=user.get(i).getUpassword();
//			if(xxUser.equals(u.getUemail()) && xxPassword.equals(u.getUpassword()))
//			{
//				return true;
//			}
//		}
//		return false;
//	}
}
