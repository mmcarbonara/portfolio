package com.example.nagoyameshi.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.nagoyameshi.entity.Restaurants;
import com.example.nagoyameshi.form.RestaurantEditForm;
import com.example.nagoyameshi.form.RestaurantRegisterForm;
import com.example.nagoyameshi.repository.RestaurantRepository;

@Service
public class RestaurantService {
	private final RestaurantRepository restaurantRepository;
	
	public RestaurantService(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}

@Transactional
public void create(RestaurantRegisterForm restaurantRegisterForm) { //店舗登録
	Restaurants restaurants = new Restaurants();
	MultipartFile imageFile = restaurantRegisterForm.getImageFile();
	
    if (!imageFile.isEmpty()) {
        String imageName = imageFile.getOriginalFilename(); 
        String hashedImageName = generateNewFileName(imageName);
        Path filePath = Paths.get("src/main/resources/static/storage/" + hashedImageName);
        copyImageFile(imageFile, filePath);
        restaurants.setImageName(hashedImageName);
    }
	
	restaurants.setName(restaurantRegisterForm.getName());
	restaurants.setDescription(restaurantRegisterForm.getDescription());
	restaurants.setPrice(restaurantRegisterForm.getPrice());
	restaurants.setOpeningTime(restaurantRegisterForm.getOpeningTime());
	restaurants.setCapacity(restaurantRegisterForm.getCapacity());
	restaurants.setHoliday(restaurantRegisterForm.getHoliday());
	restaurants.setPhoneNumber(restaurantRegisterForm.getPhoneNumber());
	restaurants.setPostalCode(restaurantRegisterForm.getPostalCode());
	restaurants.setAddress(restaurantRegisterForm.getAddress());
	restaurants.setCategories(restaurantRegisterForm.getCategories());
	
	restaurantRepository.save(restaurants);
}

@Transactional
public void update(RestaurantEditForm restaurantEditForm) { //店舗更新
	Restaurants restaurants = restaurantRepository.getReferenceById(restaurantEditForm.getId());
	MultipartFile imageFile = restaurantEditForm.getImageFile();
	
    if (!imageFile.isEmpty()) {
        String imageName = imageFile.getOriginalFilename(); 
        String hashedImageName = generateNewFileName(imageName);
        Path filePath = Paths.get("src/main/resources/static/storage/" + hashedImageName);
        copyImageFile(imageFile, filePath);
        restaurants.setImageName(hashedImageName);
    }
	
	restaurants.setName(restaurantEditForm.getName());
	restaurants.setDescription(restaurantEditForm.getDescription());
	restaurants.setPrice(restaurantEditForm.getPrice());
	restaurants.setOpeningTime(restaurantEditForm.getOpeningTime());
	restaurants.setCapacity(restaurantEditForm.getCapacity());
	restaurants.setHoliday(restaurantEditForm.getHoliday());
	restaurants.setPhoneNumber(restaurantEditForm.getPhoneNumber());
	restaurants.setPostalCode(restaurantEditForm.getPostalCode());
	restaurants.setAddress(restaurantEditForm.getAddress());
	restaurants.setCategories(restaurantEditForm.getCategories());
	
	restaurantRepository.save(restaurants);
}


//UUIDを使用して生成したファイル名を返す
public String generateNewFileName(String fileName) {
	String[] fileNames = fileName.split("\\.");
	for(int i = 0; i < fileNames.length -1; i++) {
		fileNames[i] = UUID.randomUUID().toString();
	}
	String hashedFileName = String.join(".", fileNames);
	return hashedFileName;
}

//画像ファイルを指定したファイルにコピーする
public void copyImageFile(MultipartFile imageFile, Path filePath) {
	try {
		Files.copy(imageFile.getInputStream(), filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
}
}