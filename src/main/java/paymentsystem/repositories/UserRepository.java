package paymentsystem.repositories;

import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import paymentsystem.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("from User where id = :id")
	public User findOne(Long id);
}
