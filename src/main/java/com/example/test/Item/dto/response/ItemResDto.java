package com.example.test.Item.dto.response;

import com.example.test.Item.domain.Item;

public record ItemResDto(
	Long id,
	String username,
	String title,
	String content,
	int price
) {
	public ItemResDto(Item item) {
		this(item.getId(), item.getUsername(), item.getTitle(), item.getContent(), item.getPrice());
	}
}
