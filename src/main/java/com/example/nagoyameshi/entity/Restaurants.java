package com.example.nagoyameshi.entity;

import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "restaurants")
@Data
public class Restaurants {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "image_name")
	private String imageName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "postal_code")
	private String postalCode;
	
	@Column(name = "capacity")
	private Integer capacity;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "holiday")
	private String holiday;
	
	@Column(name = "opening_time")
	@DateTimeFormat(pattern = "HH:mm")
	private String openingTime;
	
	@Column(name = "closing_time", insertable = false)
	@DateTimeFormat(pattern = "HH:mm")
	private String closingTime;
	
	@Column(name = "price")
	private Integer price;
	
    @ManyToOne
    @JoinColumn(name = "categories_id")
    private Categories categories;
	
    
	@Column(name = "created_at", insertable = false, updatable = false)
	private Timestamp createdAt;
	
	@Column(name = "updated_at", insertable = false, updatable = false)
    private Timestamp updatedAt;

	public Restaurants getRestaurantId() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	}


