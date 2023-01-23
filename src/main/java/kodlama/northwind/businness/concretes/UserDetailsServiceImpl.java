package kodlama.northwind.businness.concretes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import kodlama.northwind.core.dataAccess.UserDao;
import kodlama.northwind.core.entities.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	
	  @Autowired
	  UserDao userRepository;

	  //UserDetailsServiceImpl bu sınıfa UserDetailsService interface implement ediyoruz.
	  //ve bu interface implement etmek için loadUserByUsername metotunun kullanmak zorundayız.
	  //veritabanında username almak için bunları yapıyoruz.findByUsername username bakıyor var mı yok mu diye varsa 
	  //UserDetailsImpl.build(user)->UserDetailsImpl sınıfını build ediyor.
	  //ve kontrol ediyoruz eger username bulunamazsa hata fırlatacak.
	  //ve bu UserDetailsServiceImpl classını jwt token ürettiğimiz JwtUtils sınıfında kullnanacağız.
	  @Override
	  @Transactional
	  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    User user = userRepository.findByUsername(username)
	        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
	    return UserDetailsImpl.build(user);
	  }
}
