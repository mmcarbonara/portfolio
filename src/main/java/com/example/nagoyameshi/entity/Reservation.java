package com.example.nagoyameshi.entity;

import java.sql.Timestamp;
import java.time.LocalDate;

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
@Table(name = "reservations")
@Data

public class Reservation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "restaurant_id")
  private Restaurants restaurantId;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
  
  @ManyToOne
  @JoinColumn(name = "restaurant_price")
  private Restaurants restaurantPrice;
  
  @Column(name = "reserved_date")
  private LocalDate reservedDate;
  
  @Column(name = "reserved_time")
  private String reservedTime;

  @Column(name = "number_of_people")
  private Integer numberOfPeople;

  @Column(name = "created_at", insertable = false, updatable = false)
  private Timestamp  createdAt;

  @Column(name = "updated_at", insertable = false, updatable = false)
  private Timestamp updatedAt;

}


