package com.tts.WeatherApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.tts.WeatherApp.model.Response;
import com.tts.WeatherApp.model.ZipCode;
import com.tts.WeatherApp.repository.ZipCodeRepository;

@Service
public class WeatherService {
// This introduces our API Key
	@Value("${api_key}")
	private String apiKey;

//Wire Repo in
	@Autowired
	private ZipCodeRepository zipCodeRepository;

// Using our Response model, we getForecast with the zip in order to receive our appropriate api return
	public Response getForecast(String zipCode) {

		ZipCode recentSearch = new ZipCode(zipCode);
		// This URL determines where our data comes from
		String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + "&units=imperial&appid="
				+ apiKey;
		// Creates the rest Template that will communicate with the http
		RestTemplate restTemplate = new RestTemplate();

		// Try checks if the return is correct
		try {
			zipCodeRepository.save(recentSearch);
			// Rest Template gets url and returns it in response class form
			return restTemplate.getForObject(url, Response.class);
		}
		// This is our fallback error
		catch (HttpClientErrorException ex) {
			Response response = new Response();
			response.setName("error");
			return response;
		}

	}

	public List<ZipCode> getRecentSearches() {
		return (List<ZipCode>) zipCodeRepository.findAll();
	}

}
