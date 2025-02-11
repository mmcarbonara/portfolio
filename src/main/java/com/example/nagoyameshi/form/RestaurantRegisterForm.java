package com.example.nagoyameshi.form; //管理者が店舗登録できるページ

import org.springframework.web.multipart.MultipartFile;

import com.example.nagoyameshi.entity.Categories;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RestaurantRegisterForm {
	@NotBlank(message = "店舗名を入力してください")
	private String name;
	
	private MultipartFile imageFile;
	
	@NotBlank(message = "説明を入力してください")
	private String description;
	
	@NotNull(message = "店舗料金を入力してください")
	@Min(value = 1, message = "料金は１円以上に設定してください")
	private Integer lowestPrice;
	
	@NotBlank(message = "営業時間を入力してください")
	private String openingTime;
	
	@NotNull(message = "座席数を入力してください")
	@Min(value = 1, message = "座席数は１人以上に設定してください")
	private Integer capacity;
	
	@NotBlank(message = "定休日を入力してください")
	private String holiday;
	
	@NotBlank(message = "電話番号を入力してください")
	private String phoneNumber;
	
	@NotBlank(message = "郵便番号を入力してください")
	private String postalCode;
	
	@NotBlank(message = "カテゴリを入力してください")
	private Categories categories; 
}

