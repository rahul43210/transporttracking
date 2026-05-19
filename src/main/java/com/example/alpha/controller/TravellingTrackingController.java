package com.example.alpha.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.alpha.controller.service.TravellingService;
import com.example.alpha.pojo.AppResponseMessage;
import com.example.alpha.pojo.DepoDto;

@RestController
@RequestMapping("/api/v1/travelling")
public class TravellingTrackingController {
	
	private TravellingService travellingService;
	
	public TravellingTrackingController(TravellingService travellingService) {
		super();
		this.travellingService = travellingService;
	}



	@GetMapping("/depo")
	public ResponseEntity<?> listOfAllAvailableDepo() {
		final List<DepoDto> depoList = travellingService.listOfAllAvailableDepo();
		if(depoList == null || depoList.isEmpty()) {
			return new ResponseEntity<AppResponseMessage>(new AppResponseMessage(HttpStatus.NO_CONTENT.value(), "No Depo Found", Collections.emptyList()), HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(new AppResponseMessage<>(HttpStatus.OK.value(),"List of Depo status", depoList), HttpStatus.OK);
		}
	}
	
	@PostMapping("/depo/add")
	public ResponseEntity<?> addDepo(@RequestBody List<DepoDto> depos) {
		final List<DepoDto> depoList = travellingService.addDepos(depos);
		if(depoList == null || depoList.isEmpty()) {
			return new ResponseEntity<>(new AppResponseMessage(HttpStatus.EXPECTATION_FAILED.value(), "No Depo Added", depos), HttpStatus.EXPECTATION_FAILED);
		}
		return new ResponseEntity<>(new AppResponseMessage<>(HttpStatus.CREATED.value(),"List of Depo Added", depoList), HttpStatus.OK);
	}

}
