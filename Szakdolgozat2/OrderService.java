package Szakdolgozat2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
private final OrderRepository orderRepository;  
	
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	public List<Order> getOrders() {
		return orderRepository.findAll();
	}

	public void addNewOrder(Order order) {
		orderRepository.save(order);
		
	}

	public void updateOrder(Order order) {
		orderRepository.save(order);
		
	}

	public void deleteOrder(Order order) {
		orderRepository.delete(order);
		
	}
	
}