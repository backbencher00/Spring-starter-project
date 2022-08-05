package com.animal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.animal.Store.ClientDetail;
import com.animal.service.AnimalService;

/**
 * 
 * @author sourabh singh
 *
 */
@RestController
public class AnimalController {
      
	@Autowired
	AnimalService service;
	//ideally it should be post api because it has a business logic to save the data of caller client in embedded db (H2)
	@PostMapping("/fact")
	public String animalFact(@RequestParam String animal , HttpServletRequest request) throws Exception {
		 return service.saveClientHistoryAndGetAnimalFact(animal, request.getHeader("device-id"));
 	}
	
	@GetMapping("/client-history")
	public List<ClientDetail> getApiAccessData() {
        return service.getClientHistoryData();
  	}

}
