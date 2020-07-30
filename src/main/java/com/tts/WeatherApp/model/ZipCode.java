package com.tts.WeatherApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ZipCode {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "zip_id")
	private Long id;
	
	private String zipCode;

	public ZipCode() {
	}

	public ZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	

}
