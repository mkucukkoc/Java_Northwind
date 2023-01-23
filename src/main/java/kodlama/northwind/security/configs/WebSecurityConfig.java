package kodlama.northwind.security.configs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import kodlama.northwind.businness.concretes.UserDetailsServiceImpl;
import kodlama.northwind.security.jwt.AuthEntryPointJwt;
import kodlama.northwind.security.jwt.AuthTokenFilter;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableGlobalMethodSecurity tüm kullandıgımız metotlardan önce bu security devreye al demektir.
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
	//WebSecurityConfig dosyası jwt ile ilgili olarak oluşturdgugumuz sınıfların birbiriyle iletişimini sağlaycak
	//yani bir nevi adapter görevi görecektir.
	
	@Autowired
	UserDetailsServiceImpl userDetailsService;

	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

	//bu configure metotunda password u encoder yapıyoruz. ve aşagıdaki PasswordEncoder constructor ile BCryptPasswordEncoder ile
	//passwordu hashleyip veritabanına kaydetiyor..
	@Override
	public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	
	}
	
    //Passwordu nasıl şifrelemesini söylüyoruz.Hashlemesini söylüyoruz.
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().mvcMatchers(HttpMethod.OPTIONS, "/**");
	    web.ignoring().mvcMatchers("/swagger-ui.html/**", "/configuration/**", "/swagger-resources/**", "/v2/api-docs","/webjars/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//csrf->disable etmemiz gerekir.
		http.cors().and().csrf().disable()
			.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
			.authorizeRequests().antMatchers("/api/auth/**").permitAll()
			.antMatchers("/api/test/**").permitAll()
			.anyRequest().authenticated();
		//.authorizeRequests().antMatchers("/api/auth/**").permitAll()->bu satırdaki kod ile sunu diyoruz.
		///api/auth/ şu yol hariç diger isteklerded giriş yetkisi verme 
		//yani önce ilk bu istek yapmak zorunda bırak ve authorize olmdana diğer istekleri yapma demektir.
		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
		//http.addFilterBefore(authenticationJwtTokenFilter() ile de her request önünde AuthTokenFilter belirtmemiz gerek.
		
	}
}
