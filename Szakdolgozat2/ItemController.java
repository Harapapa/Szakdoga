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
@RequestMapping("Item")
public class ItemController {

	@Autowired
	private final ItemService itemService;

	
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@GetMapping
	public List<Item> getItems() {
		return itemService.getItems();
	}
	
	@PostMapping
	public void registerNewItem(@RequestBody Item item) {
		itemService.addNewItem(item);
	}
	@PatchMapping
	public void updateItem(@RequestBody Item item) {
		itemService.updateItem(item);
	}
	@DeleteMapping
	public void deleteItem(@RequestBody Item item) {
		itemService.deleteItem(item);
	}
	
}