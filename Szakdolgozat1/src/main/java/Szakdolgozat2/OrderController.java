package Szakdolgozat2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "Order")
public class OrderController {

	@Autowired
	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping
	public List<Order> getOrders() {
		return orderService.getOrders();
	}
	@PostMapping
	public void addNewOrder(@RequestBody Order order) {
		orderService.addNewOrder(order);
	}
	@PatchMapping
	public void updateOrder(@RequestBody Order order) {
		orderService.updateOrder(order);
	}
	@DeleteMapping
	public void deleteOrder(@RequestBody Order order) {
		orderService.deleteOrder(order);
	}
}