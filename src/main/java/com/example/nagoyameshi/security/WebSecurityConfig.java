package com.example.nagoyameshi.security; //SpringSecurityの設定を行う

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
					.requestMatchers("/css/**","/images/**", "/js/**", "/storage/**", "/", "/signup/**","/restaurants/**","/category","/restaurants/{id}","/review/**","/company/**").permitAll() //全てのユーザーにアクセス許可するURL
					.requestMatchers("/admin/**").hasRole("ADMIN") //管理者のみにアクセス許可するURL
					.anyRequest().authenticated()       //上記以外のURLはログインが必要（会員・管理者どちらでも可能）
					)
					.formLogin((form) -> form
							.loginPage("/login")  //ログインページのURL
							.loginProcessingUrl("/login") //ログインフォームの送信先URL
							.defaultSuccessUrl("/?loggedIn") //ログイン成功時のリダイレクト先URL
							.failureUrl("/login?error")  //ログイン失敗時のリダイレクト先URL
							.permitAll()
					)
					.logout((logout) -> logout
							.logoutSuccessUrl("/?loggedOut")     //ログアウト時のリダイレクト先URL
							.permitAll()
							);
					return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}