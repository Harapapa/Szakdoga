package Szakdolgozat2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "item")
public class Item {
	@Id
	@SequenceGenerator( name = "item_sequence", 
						sequenceName = "item_sequence", 
						allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, 
					generator = "item_sequence")
	
	
	private Long item_id;
	private String quantity;
	private String item_name;
	private String price;
	private Long order_id;
	private Long user_id;
	
	public Item() {
		super();
	}
	
	public Item(Long item_id, String quantity, String item_name, String price, Long order_id, Long product_id) {
		super();
		this.item_id = item_id;
		this.quantity = quantity;
		this.item_name = item_name;
		this.price = price;
		this.order_id = order_id;
		this.user_id = product_id;
    }
	
	public Item(String quantity, String item_name, String price, Long order_id, Long product_id) {
		super();
        this.quantity = quantity;
        this.item_name = item_name;
        this.price = price;
        this.order_id = order_id;
        this.user_id = product_id;
    }
	
	public Long getItem_id() {
		return item_id;
	}
	
	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}
	
	public String getQuantity() {
		return quantity;
	}
	
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public String getItem_name() {
		return item_name;
	}
	
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	
	public String getPrice() {
		return price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public Long getOrder_id() {
		return order_id;
	}
	
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	
	public Long getProduct_id() {
		return user_id;
	}
	
	public void setProduct_id(Long product_id) {
		this.user_id = product_id;
	}
	
	
}
