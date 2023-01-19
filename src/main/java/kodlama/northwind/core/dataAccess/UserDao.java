package kodlama.northwind.core.dataAccess;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import  kodlama.northwind.core.entities.User;

@Repository
public interface UserDao extends JpaRepository<User,Long>
{
	
	  Optional<User> findByUsername(String username);

	  Boolean existsByUsername(String username);

	  Boolean existsByEmail(String email);
}
