package com.example.nagoyameshi.controller;   //トップページに会社情報を表示

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.nagoyameshi.entity.Company;
import com.example.nagoyameshi.repository.CompanyRepository;

@Controller   
@RequestMapping("/company")
public class CompanyController {
	
	private final CompanyRepository companyRepository;
	
	public CompanyController(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}
	
	@GetMapping("index")  //会社概要ページ
	public String companyIndex(Model model) {
		Company company = companyRepository.getReferenceById(1);
		
		model.addAttribute("company" ,company);
		
		return "company/index";
	}
	
}


	