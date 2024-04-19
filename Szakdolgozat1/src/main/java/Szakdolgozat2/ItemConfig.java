package Szakdolgozat2;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ItemConfig {
	
	@Bean 
	CommandLineRunner commandLineRunner2(ItemRepository item_repository){
        return args -> {
              Item item1= new Item("kg", "paradicsom", "2500ft", 1L, 1L);
              Item item2= new Item("kg", "uborka", "1500ft", 2L, 2L);
              Item item3= new Item("kg", "hagyma", "500ft", 3L, 3L);
              Item item4= new Item("kg", "káposzta", "300ft", 4L, 4L);
              Item item5= new Item("kg", "sárgarépa", "400ft", 5L, 5L);
              Item item6= new Item("kg", "burgonya", "200ft", 6L, 6L);
              Item item7= new Item("kg", "zeller", "600ft", 7L, 7L);
              Item item8= new Item("kg", "retek", "300ft", 8L, 8L);
              Item item9= new Item("kg", "cékla", "400ft", 9L, 9L);
              Item item10= new Item("kg", "karalábé", "300ft", 10L, 10L);
              Item item11= new Item("kg", "káposzta", "300ft", 11L, 11L);
              
            
            item_repository.saveAll(List.of(item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11));
	};
}
}
