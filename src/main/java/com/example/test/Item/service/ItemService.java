package com.example.test.Item.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.test.Item.domain.Item;
import com.example.test.Item.dto.request.ItemReqDto;
import com.example.test.Item.dto.response.ItemResDto;
import com.example.test.Item.repository.ItemRepository;

@Service
public class ItemService {

	private final ItemRepository itemRepository;

	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Transactional
	public ItemResDto createPost(ItemReqDto reqDto) {
		Item item = reqDto.toEntity();

		Item savedItem = itemRepository.save(item);

		return new ItemResDto(savedItem);
	}

	@Transactional(readOnly = true)
	public List<ItemResDto> findAllPost() {
		List<Item> items = itemRepository.findAll();
		return items.stream()
			.map(this::convertToFindPostDto)
			.toList();
	}

	private ItemResDto convertToFindPostDto(Item item) {
		return new ItemResDto(item);
	}
}
