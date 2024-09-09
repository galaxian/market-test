package com.example.test.Item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.test.Item.domain.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
