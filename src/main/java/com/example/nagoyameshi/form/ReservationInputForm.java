package com.example.nagoyameshi.form;  //予約フォームから予約内容確認ページに入力内容を渡すフォーム

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReservationInputForm {
	
	@NotBlank(message = "予約日を入力してください")
	private String reservedDate;
	
	@NotBlank(message = "予約時間を選択してください")
	@DateTimeFormat(pattern = "HH:mm")
	private String reservedTime;
	
	@NotNull(message = "人数を入力してください")
	@Min(value = 1, message = "人数は１人以上に設定してください")
	private Integer numberOfPeople;
	
}



