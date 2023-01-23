package kodlama.northwind.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;
import kodlama.northwind.businness.concretes.UserDetailsImpl;

@Component
public class JwtUtils 
//JWT Nedir?
//jwt server a giden isteklerin aynı kişiden gidip girmediğini kontrol etmek için kullanılır.

{
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	  //token içinde olan key i verdigimiz değişken ->private String jwtSecret;
	  //${app.jwtSecret}"->bu value degerini application.properties dosayasından alıyoruz.
	  //oraya ekliyoruz eger istersen el ile girmek istersek 31 satırdaki gibi el ile verebilirz.
	  @Value("${app.jwtSecret}")
	  private String jwtSecret;

	  //${app.jwtExpirationMs}"->bu value degerini application.properties dosayasından alıyoruz.
	  //oraya ekliyoruz eger istersen el ile girmek istersek şu şekilde yazabiliriz->private static final int jwtExpirationMs=5*60*1000
	  //bir degişkenle de verebiliriz.
	  @Value("${app.jwtExpirationMs}")
	  private int jwtExpirationMs;
	  
	  
	  

	  
	  //generateJwtToken metotu bize token oluşturacagımız metotdur.
	  //return ile token geri döndürüyor.
	  //Authentication sınıfı yardımıyla bu işlemi yapıyoruz.
	  public String generateJwtToken(Authentication authentication) {

	    UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
	    //setSubject içine UserDetailsImpl class ının içindeki username alanını veriyoruz ve bu tokenin
	    //payload ksımında sub:"mustafa" olarak gözükecektir.
	    //setIssuedAt(new Date())-> kısmı token ne zaman oluşturldu kısmıdır.
	    //setExpiration kısmı ise tokenın ne zamana kadar geçerli oldugunu belirtigimiz ksımıdır.
	    //ve bu kısmı bir degişkenden alıyoruz->jwtExpirationMs degişkeninden 
	    //(new Date((new Date()).getTime() + jwtExpirationMs)->şimdiki zaman ekleme yapıp atıyorum 4 gun süre veriyoruz jwtExpirationMs degişkeniyle 
	    //signWith ile->SignatureAlgorithm.HS256 algoritma verebiliyoruz ve secretKey de veriyoruz.
	    return Jwts.builder().setSubject((userPrincipal.getUsername())).setIssuedAt(new Date())
	        .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs)).signWith(SignatureAlgorithm.HS256, jwtSecret)
	        .compact();
	    
	    
	  }

	  //Claims ler örnek oalrak-> setIssuedAt bir claim dir.setIssuer bir claim dir.
	  
	  //jwt token içinde username i çıkaran metotdur-> getUserNameFromJwtToken
	  public String getUserNameFromJwtToken(String token) {
		  
	    return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	  }

	  //validateJwtToken netot verilen token in oluşturulan tokenin kontrol etmemizi sağlayan metot ve metot içine ise
	  //gerekli exception ları kontrol ediyoruz.
	  
	  public boolean validateJwtToken(String authToken) {
	    try {
	      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
	      return true;
	    } catch (SignatureException e) {
	      logger.error("Invalid JWT signature: {}", e.getMessage());
	    } catch (MalformedJwtException e) {
	      logger.error("Invalid JWT token: {}", e.getMessage());
	    } catch (ExpiredJwtException e) {
	      logger.error("JWT token is expired: {}", e.getMessage());
	    } catch (UnsupportedJwtException e) {
	      logger.error("JWT token is unsupported: {}", e.getMessage());
	    } catch (IllegalArgumentException e) {
	      logger.error("JWT claims string is empty: {}", e.getMessage());
	    }

	    return false;
	  }
}
