package kodlama.northwind.core.dataAccess;

import org.springframework.data.repository.CrudRepository;

import kodlama.northwind.core.entities.Role;

public interface RoleDao extends CrudRepository<Role,String> {

}
