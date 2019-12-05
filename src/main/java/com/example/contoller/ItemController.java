package com.example.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;
import com.example.service.ItemService;

/**
 * 商品を操作するコントローラー.
 * 
 * @author iidashuhei
 *
 */
@Controller
@RequestMapping("")
public class ItemController {

	@Autowired
	public ItemService service;
	
	/**
	 * 商品一覧表示、曖昧検索する.
	 * 
	 * @param name 名前
	 * @return 商品一覧、曖昧検索結果
	 */
	@RequestMapping("/")
	public String findByName(String name,Model model) {
		System.out.println("name : " + name);
		List<Item> itemList = service.findByName(name);
		if(itemList.isEmpty()) {
			itemList = service.findAll();
			model.addAttribute("message", "該当する商品はありません");
		} else {
			itemList = service.findByName(name);
		}
		model.addAttribute("itemList", itemList);
		return "item_list";
	}
}
