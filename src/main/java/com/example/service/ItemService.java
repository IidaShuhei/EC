package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Item;
import com.example.repository.ItemRepository;

/**
 * 商品を扱うサービス.
 * 
 * @author iidashuhei
 *
 */
@Service
@Transactional
public class ItemService {

	@Autowired
	public ItemRepository repository;

	/**
	 * 商品全件検索する.
	 * 
	 * @return 商品全件
	 */
	public List<Item> findAll() {
		List<Item> itemList = repository.findAll();
		return itemList;
	}

	/**
	 * 曖昧検索する.
	 * 
	 * @return 曖昧検索結果
	 */
	public List<Item> findByName(String name) {
		List<Item> itemList = null;
		if (name == null || name.isEmpty()) {
			itemList = repository.findAll();
		} else {
			itemList = repository.findByName(name);
		}
		return itemList;
	}
}
