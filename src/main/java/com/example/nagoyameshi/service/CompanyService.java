package com.example.nagoyameshi.service;

import java.util.Optional;

import com.example.nagoyameshi.entity.Company;
import com.example.nagoyameshi.repository.CompanyRepository;

public class CompanyService {
	private final CompanyRepository companyRepository;
		
		public CompanyService(CompanyRepository companyRepository) {
		     this.companyRepository = companyRepository;	     
	}

		 // 会社IDで特定の会社情報を取得
	     public Optional<Company> getCompanyById(Integer id) {
	         return companyRepository.findById(id);	     
}

		public static Optional<Company> getCompany() {
			// TODO 自動生成されたメソッド・スタブ
			return null;
		}
}


