package com.example.nagoyameshi.service;  //フォームから送信された会員情報をデータベースに登録する

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.nagoyameshi.entity.Role;
import com.example.nagoyameshi.entity.User;
import com.example.nagoyameshi.form.SignupForm;
import com.example.nagoyameshi.form.UserEditForm;
import com.example.nagoyameshi.repository.RoleRepository;
import com.example.nagoyameshi.repository.UserRepository;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    
    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;        
        this.passwordEncoder = passwordEncoder;
    }    
	
@Transactional
public User create(SignupForm signupForm) {
	User user = new User();
	Role role = roleRepository.findByName("ROLE_GENERAL");
	
	user.setName(signupForm.getName());
	user.setFurigana(signupForm.getFurigana());
	user.setPostalCode(signupForm.getPostalCode());
	user.setAddress(signupForm.getAddress());
	user.setPhoneNumber(signupForm.getPhoneNumber());
	user.setEmail(signupForm.getEmail());
	user.setPassword(passwordEncoder.encode(signupForm.getPassword()));
	user.setRole(role);
	user.setEnabled(false);
	
	return userRepository.save(user);
}

@Transactional  //会員情報編集ページ
public void update(UserEditForm userEditForm) {
	User user = userRepository.getReferenceById(userEditForm.getId());
	
	user.setName(userEditForm.getName());
	user.setFurigana(userEditForm.getFurigana());
	user.setPhoneNumber(userEditForm.getPhoneNumber());
	user.setPostalCode(userEditForm.getPostalCode());
	user.setAddress(userEditForm.getAddress());
	user.setEmail(userEditForm.getEmail());
	
	userRepository.save(user);
	}
	
	//メールアドレスが登録済か確認する
    public boolean isEmailRegistered(String email) {
    	User user = userRepository.findByEmail(email);
    	return user !=null;
    }
    
    //パスワードとパスワード（確認用）の入力が一致するかどうかチェックする
    public boolean isSamePassword(String password, String passwordConfirmation) {
    	return password.equals(passwordConfirmation);
    }
    
    //ユーザーを有効にする。認証に成功した時に実行するメソッド
    @Transactional
    public void enableUser(User user) {
    	user.setEnabled(true);
    	userRepository.save(user);
    }
    
    //メールアドレスが変更されたかどうか確認する
    public boolean isEmailChanged(UserEditForm userEditForm) {
    	User currentUser = userRepository.getReferenceById(userEditForm.getId());
    	return !userEditForm.getEmail().equals(currentUser.getEmail());
    }
}