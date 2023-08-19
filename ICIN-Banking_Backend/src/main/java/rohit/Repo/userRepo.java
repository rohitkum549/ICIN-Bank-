package rohit.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import rohit.Model.User;

@EnableJpaRepositories
@Repository
public interface userRepo extends JpaRepository<User, String> 
{
	User findByUemail(String email);
}
