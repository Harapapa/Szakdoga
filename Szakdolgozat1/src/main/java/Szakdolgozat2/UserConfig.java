package Szakdolgozat2;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UserConfig {
	@Bean  //CommandLineRunner interface-t implementáló bean, amely a program indulásakor lefut, felviszi az adatbázisba a kezdő adatokat
CommandLineRunner commandLineRunner(UserRepository user_repository){
	return args -> {
        User john= new User(
        			"John",
        			"123@gmail.com",
        			"Kecskebeka"
        		);
        
   		
		  User adam= new User( "Adam", 
				  				"321@gmail.com", 
				  				"Pingvin"
				  				);
		  
		  user_repository.saveAll(List.of(john, adam));  //User-ek elmentése az adatbázisba
		  
		  };
		 
}
}