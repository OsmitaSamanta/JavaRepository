package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Item;
import net.guides.springboot2.springboot2jpacrudexample.repository.ItemRepository;

@RestController
@RequestMapping("/api/v1")
public class ItemController {
	@Autowired
	private ItemRepository itemRepository;

	@GetMapping("/Items")
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}

	@GetMapping("/Items/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable(value = "id") Long itemId)
			throws ResourceNotFoundException {
		Item item = itemRepository.findById(itemId)
				.orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + ItemId));
		return ResponseEntity.ok().body(item);
	}

	@PostMapping("/Items")
	public Item createItem(@Valid @RequestBody Item item) {
		return itemRepository.save(item);
	}

	@PutMapping("/Items/{id}")
	public ResponseEntity<Item> updateItem(@PathVariable(value = "id") Long itemId,
			@Valid @RequestBody Item ItemDetails) throws ResourceNotFoundException {
		Item item = itemRepository.findById(itemId)
				.orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + itemId));

		item.setEmailId(ItemDetails.getEmailId());
		item.setLastName(ItemDetails.getLastName());
		item.setFirstName(ItemDetails.getFirstName());
		final Item updatedItem = itemRepository.save(item);
		return ResponseEntity.ok(updatedItem);
	}

	@DeleteMapping("/Items/{id}")
	public Map<String, Boolean> deleteItem(@PathVariable(value = "id") Long itemId)
			throws ResourceNotFoundException {
		Item item = itemRepository.findById(itemId)
				.orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + itemId));

		itemRepository.delete(item);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
