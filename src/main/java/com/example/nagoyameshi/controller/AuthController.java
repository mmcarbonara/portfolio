package com.example.nagoyameshi.controller;  //認証機能（ログイン・会員登録）用のコントローラー

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller 
public class AuthController {
	@GetMapping("/login")
	public String login() {
		return "auth/login";
	}
}