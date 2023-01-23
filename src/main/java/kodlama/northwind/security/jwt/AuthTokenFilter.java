package kodlama.northwind.security.jwt;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import kodlama.northwind.businness.concretes.UserDetailsServiceImpl;


//OncePerRequestFilter Sınıfı->Her request için 1 kere uygulancak işlemler için kullanılır.
public class AuthTokenFilter extends OncePerRequestFilter {

	  //Token in dogru olup olmadıgını ögrenmek için jwtUtils classını kullanıyoruz.
	  @Autowired
	  private JwtUtils jwtUtils;

	  @Autowired
	  private UserDetailsServiceImpl userDetailsService;

	  private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

	  @Override
	  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	      throws ServletException, IOException {
	    try {
	    	
	    	//jwt degişkeni parseJwt(request) gelen token i atamış olduk.
	      String jwt = parseJwt(request);
	      
	      //string ifade boş degilse ve  jwtUtils.validateJwtToken(jwt)->bu ifade true ise yani
	      //validate başsarılı ise böyle bir token varsa içeri girecek.
	      if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
	        String username = jwtUtils.getUserNameFromJwtToken(jwt);

	        //userDetails ile loadUserByUsername metotuyla username alıyoruz.UserDetailsServiceImpl classında loadUserByUsername metotuyla
	        //veritabanına erişip username aldık.ve şimdi aşagıda userDetails ile agetirdik buraya.
	        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
	        //UsernamePasswordAuthenticationToken ile userDetails object i alınan username spring e veriyoruz ve diyoruz ki alsana username ve password.
	        
	        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
	            userDetails.getAuthorities());
	        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	        
	        //aşagıdaki kod ile birlikte springe bu işlemi algılaması için bunu yazıyoruz.
	        //bu kodla birlikte jwtutils haberdar olacak.
	        SecurityContextHolder.getContext().setAuthentication(authentication);
	      }
	    } catch (Exception e) {
	      logger.error("Cannot set user authentication: {}", e);
	    }

	    filterChain.doFilter(request, response);
	  }

	  private String parseJwt(HttpServletRequest request) {
	    
		  //headerAuth degişkenime Authorization başlıgını veriyoruz bu token oluşturuldugunda Header kısmında başlık olarak Authorization yazacak.
		  //Authorization başlık olarak string veriyoruz.
		  String headerAuth = request.getHeader("Authorization");

		  //StringUtils classında hastext metotuna ve headerAuth başlığı veriyoruz.
		  //bizim token üretildiğinde aslında görünümü
		  //headerAuth.startsWith("Bearer ") -> bu metotla Bearer ile başlayacagını veriyoruz.
		  
	    if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
	    	//return headerAuth.substring(7, headerAuth.length());->burada ise Bearer kelimesi 7 harf oldugu için
	    	//ve bizim sadece üretilen token görmek için substring metotunu kullanıyoruz ve böylece sadece token elimizde olmuş olacaktır.
	      return headerAuth.substring(7, headerAuth.length());
	    }

	    return null;
	  }
}
