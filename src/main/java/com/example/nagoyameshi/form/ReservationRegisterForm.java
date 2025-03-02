package com.example.nagoyameshi.form;  //予約内容の確認ページから登録処理にデータを渡す・データを格納する役割に徹する

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReservationRegisterForm {
	private Integer restaurantId;
	
	private Integer restaurantPrice;
	
    private Integer userId;
    
    private String reservedDate;
    
    private String reservedTime;
    
    private Integer numberOfPeople;
    
    private Integer amount;
	}

