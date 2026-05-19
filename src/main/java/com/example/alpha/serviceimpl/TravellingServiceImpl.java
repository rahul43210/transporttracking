package com.example.alpha.serviceimpl;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.alpha.controller.service.TravellingService;
import com.example.alpha.dao.TravellingDao;
import com.example.alpha.model.Depo;
import com.example.alpha.pojo.DepoDto;
import com.example.alpha.utility.AppUtility;
import com.example.alpha.utility.WebFluxUtility;

@Service
public class TravellingServiceImpl implements TravellingService{
	
	private TravellingDao travellingDao;
	
	private WebFluxUtility webFluxUtility;
	
	public TravellingServiceImpl(TravellingDao travellingDao, WebFluxUtility webFluxUtility) {
		super();
		this.travellingDao = travellingDao;
		this.webFluxUtility = webFluxUtility;
	}

	@Override
	public List<DepoDto> listOfAllAvailableDepo() {
		final List<Depo> depoList = travellingDao.listOfAllAvailableDepo();
		if(depoList == null || depoList.isEmpty()) {
			return Collections.emptyList();
		}
		final List<DepoDto> depoDtos = depoList.stream().map(DepoDto::new).toList();
		for(DepoDto depoDto: depoDtos) {
			try {
			depoDto.setEmployee(webFluxUtility.getAllEmployees(depoDto.getUniqueId()));
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println(LocalDateTime.now() + " - Error fetching employee data for Depo ID: " + depoDto.getUniqueId() + " - " + e.getMessage());
				depoDto.setEmployee(null);
			}
		}
		
		return depoDtos;
	}

	@Override
	public List<DepoDto> addDepos(List<DepoDto> depos) {
		final List<Depo> depoList = travellingDao.addDepos(depos.stream().map(Depo::new).toList());
		return depoList.stream().map(DepoDto::new).toList();
	}

}
