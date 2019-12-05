package com.example.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;
import com.example.domain.Topping;
import com.example.repository.ToppingRepository;
import com.example.service.ShowItemDetailService;

/**
 * 商品詳細を操作するコントローラー.
 * 
 * @author iidashuhei
 *
 */
@Controller
@RequestMapping("")
public class ShowItemDetailController {

	@Autowired
	private ShowItemDetailService service;
	
	@Autowired
	private ToppingRepository toppingRepository;
	
	/**
	 * 商品詳細を表示する.
	 * 
	 * @param id ID
	 * @param model モデル
	 * @return 商品詳細画面
	 */
	@RequestMapping("/showItemDetail")
	public String showItemDetail(Integer id, Model model) {
		Item item = service.showItemDetail(id);
		List<Topping> toppingList = toppingRepository.findAll();
		model.addAttribute("toppingList", toppingList);
		model.addAttribute("item", item);
		return "item_detail";
	}
	
}
