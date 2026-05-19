package com.example.alpha.serviceimpl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.alpha.controller.service.TravellingService;
import com.example.alpha.dao.TravellingDao;
import com.example.alpha.model.Depo;
import com.example.alpha.pojo.DepoDto;

@Service
public class TravellingServiceImpl implements TravellingService{
	
	private TravellingDao travellingDao;
	
	public TravellingServiceImpl(TravellingDao travellingDao) {
		super();
		this.travellingDao = travellingDao;
	}

	@Override
	public List<DepoDto> listOfAllAvailableDepo() {
		final List<Depo> depoList = travellingDao.listOfAllAvailableDepo();
		if(depoList == null || depoList.isEmpty()) {
			return Collections.emptyList();
		}
		return depoList.stream().map(DepoDto::new).toList();
	}

	@Override
	public List<DepoDto> addDepos(List<DepoDto> depos) {
		final List<Depo> depoList = travellingDao.addDepos(depos.stream().map(Depo::new).toList());
		return depoList.stream().map(DepoDto::new).toList();
	}

}
