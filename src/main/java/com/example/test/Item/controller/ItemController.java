package com.example.test.Item.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.test.Item.service.ItemService;

@RestController
public class ItemController {

	private final ItemService itemService;

	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}
}
