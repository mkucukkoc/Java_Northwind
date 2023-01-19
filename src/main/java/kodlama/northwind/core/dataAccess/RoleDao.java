package kodlama.northwind.core.dataAccess;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlama.northwind.core.entities.ERole;
import kodlama.northwind.core.entities.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {
	
	  Optional<Role> findByName(ERole name);

}
