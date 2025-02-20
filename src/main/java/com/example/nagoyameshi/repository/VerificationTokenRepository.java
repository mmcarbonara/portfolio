package com.example.nagoyameshi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.nagoyameshi.entity.VerificationTokens;

public interface VerificationTokenRepository extends JpaRepository <VerificationTokens,Integer> {
	public VerificationTokens findByToken(String token);
}