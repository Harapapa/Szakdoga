package Szakdolgozat2;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{ 

	@Query("SELECT s FROM User s WHERE s.email = ?1")
	Optional<User> findUserByEmail(String email);
}
