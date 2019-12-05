package com.example.contoller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.RegisterUserForm;
import com.example.service.UserService;

@Controller
@RequestMapping("")
public class RegisterUserController {

	@Autowired
	private UserService service;
	
	@ModelAttribute
	public RegisterUserForm setUpForm() {
		return new RegisterUserForm();
	}
	
	@RequestMapping("")
	public String index() {
		return "register_user";
	}
	
	/**
	 * ユーザー情報を登録する.
	 * 
	 * @param user user
	 */
	@RequestMapping("/insert")
	public String insert(@Validated RegisterUserForm resisterUserForm, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			return index();
		}
		
		User user = new User();
		BeanUtils.copyProperties(resisterUserForm, user);
		service.insert(user);
		return "login";
	}
}
