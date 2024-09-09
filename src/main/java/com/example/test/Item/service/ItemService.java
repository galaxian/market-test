package com.example.test.Item.service;

import org.springframework.stereotype.Service;

import com.example.test.Item.repository.ItemRepository;

@Service
public class ItemService {

	private final ItemRepository itemRepository;

	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
}
