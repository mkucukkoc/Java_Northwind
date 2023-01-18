package kodlama.northwind.businness.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.northwind.businness.abstracts.UserService;
import kodlama.northwind.core.dataAccess.UserDao;
import kodlama.northwind.core.entities.User;
import kodlama.northwind.core.utilities.results.DataResult;
import kodlama.northwind.core.utilities.results.Result;
import kodlama.northwind.core.utilities.results.SuccessDataResult;
import kodlama.northwind.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService{

	private UserDao _userDao;
	
	@Autowired
	public UserManager(UserDao _userDao) {
		super();
		this._userDao = _userDao;
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		
		return new SuccessDataResult<User>(this._userDao.getByEmail(email),"Kullanici Bulundu");
	}

	@Override
	public Result add(User user) {
		
		 this._userDao.save(user);
		return new SuccessResult("User Eklendi");
	}
	public void initiliazerRolesAndUser()
	{
		
	
	}

}
