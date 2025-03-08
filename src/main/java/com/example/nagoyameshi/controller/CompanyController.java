package com.example.nagoyameshi.controller;   //トップページに会社情報を表示

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.nagoyameshi.entity.Company;
import com.example.nagoyameshi.service.CompanyService;

@Controller
@RequestMapping("/company")
public class CompanyController {
	
	@GetMapping("/index")
	public String companyIndex(Model model) {
		Optional<Company> company = CompanyService.getCompany();// 会社情報を取得
		
	    model.addAttribute("company", company); // モデルに渡す
		return "company/index";
	}
}


