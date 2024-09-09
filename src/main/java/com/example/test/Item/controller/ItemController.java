package com.example.test.Item.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.test.Item.dto.request.ItemReqDto;
import com.example.test.Item.dto.response.ItemDeleteResDto;
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

	@GetMapping("/post")
	public ResponseEntity<List<ItemResDto>> findAllPost() {
		List<ItemResDto> response = itemService.findAllPost();
		return ResponseEntity.ok(response);
	}

	@PutMapping("/post/{id}")
	public ResponseEntity<ItemResDto> updatePost(@PathVariable Long id, @RequestBody ItemReqDto itemReqDto) {
		ItemResDto response = itemService.updatePost(id, itemReqDto);
		return ResponseEntity.ok(response);
	}
	@DeleteMapping("/post/{id}")
	public ResponseEntity<ItemDeleteResDto> deletePost(@PathVariable Long id) {
		ItemDeleteResDto response = itemService.deletePost(id);
		return ResponseEntity.ok(response);
	}
}
