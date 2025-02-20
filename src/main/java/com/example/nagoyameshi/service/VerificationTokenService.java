package com.example.nagoyameshi.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.entity.VerificationTokens;
import com.example.nagoyameshi.repository.VerificationTokenRepository;

@Service
public class VerificationTokenService {
	private final VerificationTokenRepository verificationTokenRepository;
	
	public VerificationTokenService(VerificationTokenRepository verificationTokenRepository) {
		this.verificationTokenRepository = verificationTokenRepository;
	}

@Transactional
public void create(User user, String token) {
	VerificationTokens verificationToken = new VerificationTokens();
	verificationToken.setUser(user);
	verificationToken.setToken(token);
	
	verificationTokenRepository.save(verificationToken);
}

//トークンの文字列で検索した結果を返す
public VerificationTokens getVerificationToken(String token) {
	return verificationTokenRepository.findByToken(token);
}
	
}