package Szakdolgozat2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.util.List;

@Configuration
public class OrderConfig {
	
	@Bean //CommandLineRunner interface-t implementáló bean, amely a program indulásakor lefut, felviszi az adatbázisba a kezdő adatokat 
	CommandLineRunner commandLineRunner1(OrderRepository order_repository){
        return args -> {
            Order order1= new Order(LocalDate.now(), 1L);
            Order order2= new Order(LocalDate.now(), 2L);
            
            order_repository.saveAll(List.of(order1, order2));
	};
		
}
}
