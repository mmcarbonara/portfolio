package com.example.nagoyameshi.form; //レビューの登録（ユーザーが店舗詳細ページからレビューの登録を行う）

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReviewInputForm {
	private Integer restaurantId;
	
	@NotNull(message = "評価してください")
	@Min(value = 1, message = "評価は１以上に設定してください")
	@Max(value = 5, message = "評価は５以内に設定してください")
	private Integer score;
	
	@NotBlank(message = "コメントを入力してください")
	private String content;
	
}

