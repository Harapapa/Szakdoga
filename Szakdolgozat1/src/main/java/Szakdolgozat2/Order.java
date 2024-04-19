package Szakdolgozat2;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_number")
public class Order {
	
	@Id
	@SequenceGenerator( name = "order_sequence", 
						sequenceName = "order_sequence", 
						allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
					generator = "order_sequence")

	
	private Long order_id;
	private LocalDate date;
	private Long user_id;
	//private int order_number;
	
	public Order() {
		super();
	}
	
	public Order(Long order_id, LocalDate date, Long user_id) {
		super();
		this.order_id = order_id;
		this.date = date;
		this.user_id = user_id;
	}
	
	public Order(LocalDate date, Long user_id) {
		super();
		this.date = date;
		this.user_id = user_id;
	}
	
	public Long getOrder_id() {
		return order_id;
	}
	
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public Long getUser_id() {
		return user_id;
	}
	
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
}
