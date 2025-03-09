package com.example.nagoyameshi.controller;   //トップページに会社情報を表示

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.nagoyameshi.repository.CompanyRepository;

@Controller
@RequestMapping("/company")
public class CompanyController {
	
	private final CompanyRepository companyRepository;
	
	public CompanyController(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}
	
	//@GetMapping("index")  //会社概要ページ
	//public String companyIndex(Model model) {
	//	Optional<Company> optionalCompany = companyRepository.findById(1); //IDが１の者を取得
	//	if(optionalCompany.isPresent()) {
		//	Company company = optionalCompany.get();
	//	}
		
	 //    model.addAttribute("company", company); // モデルに渡す
	//	return "company/index";
	
//}
}

	