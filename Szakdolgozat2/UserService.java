package Szakdolgozat2;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private final UserRepository userRepository;  
	
	public UserService(UserRepository userRepository) { 
		this.userRepository = userRepository;
	}

	public List<User> getUsers(){ //Összes user lekérdezése
                return userRepository.findAll();     		
    }
	
	public void addNewUser(User user) { //Új user regisztrálása
		Optional<User> userByEmail = userRepository.findUserByEmail(user.getEmail()); //Email alapján keresés, ha van már ilyen email, akkor hibaüzenet
		if (userByEmail.isPresent()) {
			throw new IllegalStateException("email taken");
		}	
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();//Jelszó titkosítása
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword); //Titkosított jelszó beállítása
		user.setId(userRepository.count()+1); //ID beállítása (a legnagyobb ID + 1)
		userRepository.save(user); //Ha nincs ilyen email, akkor mentés
		System.out.println(user);
    }

	public String authenticateUser(User user) throws UserNotFound
		{ //User bejelentkeztetése
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();//Jelszó titkosítása
        Optional<User> userByID = userRepository.findById(user.getId()); //ID alapján keresés
        if (userByID.isPresent()) 
        {
        	User userByDbID = userByID.get(); //Ha található user, akkor adatainak ellenőrzése
        	if (userByDbID.getEmail().equals(user.getEmail())){ //Email ellenőrzése
        		
        		if (passwordEncoder.matches(user.getPassword(), userByDbID.getPassword())) //Jelszó visszafejtése          
        			return "Sikeres bejelentkezés"; //Sikeres bejelentkezés
            }
			else 
			{
				return "Hibás email vagy jelszó"; //Hibás email vagy jelszó
			}
        }
    	throw new UserNotFound(" :A jelszó nem létezik"); // Nem található user
}	

	public void updateUser(User user) { //User adatainak módosítása
		Optional<User> userByID = userRepository.findById(user.getId()); //ID alapján keresés
		if (userByID.isPresent()) 
		{
			User userByDbID = userByID.get(); //Ha található user, akkor adatainak módosítása
			userByDbID.setEmail(user.getEmail()); //Email módosítása
			userByDbID.setPassword(user.getPassword()); //Jelszó módosítása
			userRepository.save(userByDbID);
		} else {
			throw new IllegalStateException("User not found");
		}
		
	}

	public void deleteUser(User user) { //User törlése
		Optional<User> userByID = userRepository.findById(user.getId()); //ID alapján keresés
		if (userByID.isPresent()) {
			userRepository.delete(user); //Ha található user, akkor törlése
		} else {
			throw new IllegalStateException("User not found");
		}
		
	}
}