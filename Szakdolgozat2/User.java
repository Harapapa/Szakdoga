package Szakdolgozat2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id //Primary key
	@SequenceGenerator( name = "user_sequence",   //Sequence generator
						sequenceName = "user_sequence", 
						allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,  //Automatikusan növekvő id
					generator = "user_sequence")
	
	
	private Long user_id;
	private String email;
	private String name;
	private String password;
	
	public User() { // Default constructor
	}
	
	
	public User(Long id, String name, String email, String password) {  //Konstruktor
		
		this.user_id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}


	public User(String name, String email , String password) { //Konstruktor
		this.name = name; 
		this.email = email;
		this.password = password;
	}



	public Long getId() {
		return user_id;
	}


	public void setId(Long id) {
		this.user_id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + user_id + ", name=" + name + ", email=" + email + ", password=" + password + "]"; 
	}
	
	
}

