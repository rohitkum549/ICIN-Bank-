package rohit.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import rohit.Model.Admin;

@EnableJpaRepositories
@Repository
public interface adminRepo extends JpaRepository<Admin, String>
{
	Admin findByEmail(String email);
}
