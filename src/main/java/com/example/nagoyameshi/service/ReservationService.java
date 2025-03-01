package com.example.nagoyameshi.service;

import org.springframework.stereotype.Service;

@Service
public class ReservationService {
	//予約人数が定員以下かどうか確認する
	public boolean isWithcapacity(Integer numberOfPeople, Integer capacity) {
		return numberOfPeople <= capacity;
	}
	
	// 予約時間が営業時間内であるかどうかを確認する
	public boolean isWithreservedTime(Integer reservedTime, Integer openingTime, Integer closingTime) {
	    // 予約時間が営業時間内であることを確認できた時のみ予約ができるようにする
	    return reservedTime >= openingTime && reservedTime <= closingTime;
	}
	
	
		
	}
