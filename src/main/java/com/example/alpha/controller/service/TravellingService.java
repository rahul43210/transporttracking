package com.example.alpha.controller.service;

import java.util.List;

import com.example.alpha.pojo.DepoDto;

public interface TravellingService {

	List<DepoDto> listOfAllAvailableDepo();

	List<DepoDto> addDepos(List<DepoDto> depos);

}
