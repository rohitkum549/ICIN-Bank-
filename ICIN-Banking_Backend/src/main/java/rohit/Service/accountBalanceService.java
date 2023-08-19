package rohit.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rohit.Model.accountBalance;
import rohit.Repo.accountBalanceRepo;

@Service
public class accountBalanceService 
{
	@Autowired
	accountBalanceRepo abRepo;
	
	public void insertBankBalance(accountBalance ab)
	{
		abRepo.save(ab);
	}
}
