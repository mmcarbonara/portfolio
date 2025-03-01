package com.example.nagoyameshi.service;

import org.springframework.stereotype.Service;

@Service
public class ReservationService {
	//予約人数が定員以下かどうか確認する
	public boolean isWithcapacity(Integer numberOfPeople, Integer capacity) {
		return numberOfPeople <= capacity;
	}
	
	
	//予約時間外でないかを確認する
	
		
	}
