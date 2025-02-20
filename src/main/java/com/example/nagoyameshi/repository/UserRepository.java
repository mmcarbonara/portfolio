package com.example.nagoyameshi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyameshi.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByEmail(String email);
	public Page<User>findByNameLikeOrFuriganaLike(String namekeyword, String furiganakeyword, Pageable pageable);  //名前やフリガナ検索
}