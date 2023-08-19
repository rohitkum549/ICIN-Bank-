package rohit.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import rohit.Model.TranHistory;

@EnableJpaRepositories
@Repository
public interface TranRepo extends JpaRepository<TranHistory, Integer>
{
	@Query("SELECT k FROM TranHistory k WHERE k.uemail = ?1")
	public List<TranHistory> findAllByUemail(String uemail);
	
	TranHistory findByUemail(String email);
	
}
