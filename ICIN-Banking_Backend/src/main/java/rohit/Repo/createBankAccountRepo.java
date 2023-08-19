package rohit.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

//import rohit.Model.User;
import rohit.Model.createBankAccount;

@EnableJpaRepositories
@Repository
public interface createBankAccountRepo extends JpaRepository<createBankAccount, String>
{
	createBankAccount findByEmail(String email);
}
