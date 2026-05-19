package com.example.alpha.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.alpha.model.Depo;
import com.example.alpha.repository.DepoRepository;

@Repository
public class TravellingDao {
	
	@Autowired
	private DepoRepository depoRepository;
	
	public List<Depo> listOfAllAvailableDepo() {
		return depoRepository.findAll();
	}

	public List<Depo> addDepos(List<Depo> list) {
		list = depoRepository.saveAll(list);
		return list;
	}
}
