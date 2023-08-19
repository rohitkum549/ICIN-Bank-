package rohit.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import rohit.Model.accountBalance;

@EnableJpaRepositories
@Repository
public interface accountBalanceRepo extends JpaRepository<accountBalance, String>
{
	accountBalance findByUemail(String email);
	accountBalance findByaccountnumber(String a);
}
