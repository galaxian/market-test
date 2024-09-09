package com.example.test.Item.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.test.Item.domain.Item;
import com.example.test.Item.dto.request.ItemReqDto;
import com.example.test.Item.dto.response.ItemDeleteResDto;
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

	@Transactional
	public ItemResDto updatePost(Long id, ItemReqDto reqDto) {
		Item findItem = itemRepository.findById(id).orElseThrow(
			() -> new RuntimeException("게시글을 찾을 수 없습니다.")
		);

		findItem.update(reqDto.username(), reqDto.title(), reqDto.content(), reqDto.price());

		return new ItemResDto(findItem);
	}

	@Transactional
	public ItemDeleteResDto deletePost(Long id) {
		itemRepository.deleteById(id);
		return new ItemDeleteResDto("삭제 완료");
	}

	private ItemResDto convertToFindPostDto(Item item) {
		return new ItemResDto(item);
	}
}
