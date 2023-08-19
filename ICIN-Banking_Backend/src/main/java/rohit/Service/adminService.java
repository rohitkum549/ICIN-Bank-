package rohit.Service;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rohit.Model.Admin;
import rohit.Repo.adminRepo;

@Service
public class adminService 
{
	@Autowired
	adminRepo aRepo;
	
	
	public void adminSignup(Admin a)
	{
		aRepo.save(a);
	}
	
	
//	public boolean adminLoign(Admin a)
//	{
//		List<Admin> admin=new ArrayList<Admin>();
//		aRepo.findAll().forEach(i -> admin.add(i));
//		for(int i=0;i<admin.size();i++)
//		{
//			String kkuser=admin.get(i).getEmail();
//			String kkpassword=admin.get(i).getPassword();
//			if(kkuser.equals(a.getEmail()) && kkpassword.equals(a.getPassword()))
//			{
//				return true;
//			}
//		}
//		return false;
//	}
}
