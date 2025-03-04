package com.example.nagoyameshi.form;  //ユーザーが登録したレビューの編集ができるページ(店舗詳細ページから編集ボタンをおす)

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewEditForm {
	public ReviewEditForm() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	private Integer restaurantId;

	@NotNull(message = "評価してください")
	@Min(value = 1, message = "評価は１以上に設定してください")
	@Max(value = 5, message = "評価は５以内に設定してください")
	private Integer score;
	
	@NotBlank(message = "コメントを入力してください")
	private String content;
}