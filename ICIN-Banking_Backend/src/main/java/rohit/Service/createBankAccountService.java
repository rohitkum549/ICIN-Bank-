package rohit.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rohit.Repo.createBankAccountRepo;
import rohit.Model.createBankAccount;
@Service
public class createBankAccountService 
{
	@Autowired
	createBankAccountRepo cbaRepo;
	
	
	public void createBankAccount(createBankAccount c)
	{
		cbaRepo.save(c);
	}
	
	public List<createBankAccount> list()
	{
		return cbaRepo.findAll();
	}
}
