package com.example.test.Item.dto.request;

import com.example.test.Item.domain.Item;

public record ItemReqDto(
	String username,
	String title,
	String content,
	int price
) {
	public Item toEntity() {
		return new Item(username, title, content, price);
	}
}
