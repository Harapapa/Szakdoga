package Szakdolgozat2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
	
	@Autowired
	private final ItemRepository itemRepository;
	
	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	public List<Item> getItems() {
		return itemRepository.findAll();
	}

	public void addNewItem(Item item) {
		itemRepository.save(item);
		
	}

	public void updateItem(Item item) {
		itemRepository.save(item);
		
	}

	public void deleteItem(Item item) {
		itemRepository.delete(item);
		
	}
	
}