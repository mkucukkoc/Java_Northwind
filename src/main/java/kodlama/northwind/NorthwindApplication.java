package kodlama.northwind;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
 

@SpringBootApplication
@EnableCaching
@EnableSwagger2
public class NorthwindApplication {

	private static final Logger logger= LogManager.getLogger(NorthwindApplication.class);
	public static void main(String[] args)  
	{
		SpringApplication.run(NorthwindApplication.class, args);
		    logger.info("asfasfasdfasaw");
		
	} 
	/*@Bean
	 public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          .apis(RequestHandlerSelectors.basePackage("kodlama.northwind"))                                       
	          .build();                                          
	    }
	 @Bean
	 public ModelMapper modelPaper()
	 {
		 return new ModelMapper();
	 }*/
	 //.apis(RequestHandlerSelectors.basePackage("kodlama.northwind"))->bu satır şu demek
	 //kodlama.northwind paketinde gez api leri bul ve dökümantasyona ekle demektir.
	 //docket metotu bizim projemizde ki controller i tarıyor ve api leri buluyor ve onları swagger arayüzünde gösteriyor
	 //Neden swagger i kullanıyoruz?Swagger api leri göstermemizi sağlayan bir arayğz dür.
	 //istersek kullanmayız ve Postman kullanabiliriz.
}