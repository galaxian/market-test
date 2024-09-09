package com.example.test.Item.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.Item.dto.request.ItemReqDto;
import com.example.test.Item.dto.response.ItemResDto;
import com.example.test.Item.service.ItemService;

@RestController
public class ItemController {

	private final ItemService itemService;

	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}

	@PostMapping("/post")
	public ResponseEntity<ItemResDto> createPost(@RequestBody ItemReqDto itemReqDto) {
		ItemResDto response = itemService.createPost(itemReqDto);
		return ResponseEntity.ok(response);
	}
}
