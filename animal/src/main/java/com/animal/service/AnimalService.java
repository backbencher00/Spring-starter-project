package com.animal.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animal.Store.ClientDetail;
import com.animal.repository.AnimalRepository;

@Service
public class AnimalService {
	private String CAT_FACT = "Cats have a total of 18 toes";
	private String DOG_FACT = "Dog sense of smell is at least 40x better than ours";
	private String INVALID_REQUEST_MESSAGE = "only cats and dogs allowed in request param";
	
	@Autowired
	AnimalRepository animalRepository;
	
	public String saveClientHistoryAndGetAnimalFact(String animal, String deviceId) throws Exception {
		 if(!validateRequest(animal)) return INVALID_REQUEST_MESSAGE;
		 String fact = getAnimalFact(animal);
		 saveClientHistoryInH2(fact,deviceId);
		 return fact;
	}

	private String getAnimalFact(String animal) throws Exception {
		String fact = CAT_FACT;
 		 if(animal.equals("cat")) {
			  fact = CAT_FACT;
		 }else if(animal.equals("dog")) {
			 fact = DOG_FACT;
		 }else {
			 throw new Exception(fact);
		 }
		return fact;
	}
    private boolean validateRequest(String animal) {
       return (animal.equals("cat") || animal.equals("dog")) ? true : false;
    }
	private void saveClientHistoryInH2(String fact, String deviceId) {
		ClientDetail clientDetail = new ClientDetail();
		 clientDetail.setAnimalFact(fact);
		 clientDetail.setAccessDate(getCurrentDateTime());
		 clientDetail.setIpAddress(deviceId);
		 animalRepository.save(clientDetail);
	}

	private String getCurrentDateTime() {
		 Date date = new Date();  
		 SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		 return formatter.format(date);
	}
	
	public  List<ClientDetail> getClientHistoryData() {
		return animalRepository.findAll();
	}
	 

}
