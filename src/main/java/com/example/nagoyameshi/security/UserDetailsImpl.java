package com.example.nagoyameshi.security;  //ユーザー名やパスワード、ロールなどのユーザー情報を保持する

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.nagoyameshi.entity.User;

public  class UserDetailsImpl implements UserDetails {
	private final User user;
	private final Collection<GrantedAuthority> authorities;
	
	public UserDetailsImpl(User user, Collection<GrantedAuthority> authorities) {
		this.user = user;
		this.authorities = authorities;
	}
	
	public User getUser() {
		return user;
	}
	
	//ハッシュ化済みのパスワードを隠す
	@Override
	public String getPassword() {
		return user.getPassword();
	}
	
	//ログイン時に利用するユーザー名(メールアドレス)を返す
	@Override
	public String getUsername() {
		return user.getEmail();
	}
	
	//ロールのコレクションを返す
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	//アカウントが期限切れ出なければtureを返す
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	//ユーザーがロックされていなければtureを返す
	@Override
	public boolean isEnabled() {
		return user.getEnabled();
	}
}
