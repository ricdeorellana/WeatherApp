package com.tts.WeatherApp.model;

public class Request {
 private String zipCode;

public Request() {
}

public Request(String zipCode) {
	this.zipCode = zipCode;
}

public String getZipCode() {
	return zipCode;
}

public void setZipCode(String zipCode) {
	this.zipCode = zipCode;
}
 
 
}
