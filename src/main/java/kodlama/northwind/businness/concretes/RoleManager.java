package kodlama.northwind.businness.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlama.northwind.businness.abstracts.RoleService;
import kodlama.northwind.core.dataAccess.RoleDao;
import kodlama.northwind.core.entities.Role;
import kodlama.northwind.core.utilities.results.Result;
import kodlama.northwind.core.utilities.results.SuccessResult;

@Service
public class RoleManager implements RoleService{


	private RoleDao _roleDao;
	
	@Autowired
	public RoleManager(RoleDao _roleDao) {
		super();
		this._roleDao = _roleDao;
	}
	
	@Override
	public Result add(Role role) {
		this._roleDao.save(role);
		return new SuccessResult("Role Eklendi");
	}

}
