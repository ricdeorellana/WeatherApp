package com.tts.WeatherApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.tts.WeatherApp.model.ZipCode;

public interface ZipCodeRepository extends CrudRepository<ZipCode, Long> {
	// ZipCode findZip(String zipCode);
}
