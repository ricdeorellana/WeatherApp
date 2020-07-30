package com.tts.WeatherApp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.WeatherApp.model.Request;
import com.tts.WeatherApp.model.Response;
import com.tts.WeatherApp.model.ZipCode;
import com.tts.WeatherApp.service.WeatherService;

@Controller
public class WeatherController {

		@Autowired
		private WeatherService weatherService;
		
		@GetMapping
		public String getIndex(Model model) { 
			List<ZipCode> zipCodeList = weatherService.getRecentSearches();
			// Response response = weatherService.getForecast("78203");
			model.addAttribute("request", new Request());
			model.addAttribute("zip_codes", zipCodeList);

			//model.addAttribute("data", response);
			return "index";
		}
		
		@PostMapping
		public String PostIndex(Request request, Model model) {
			List<ZipCode> zipCodeList = weatherService.getRecentSearches();
			Response data = weatherService.getForecast(request.getZipCode());
			model.addAttribute("data", data);
			model.addAttribute("zip_codes", zipCodeList);
			return "index";
		}
}
