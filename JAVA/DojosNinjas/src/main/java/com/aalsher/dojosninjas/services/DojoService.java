package com.aalsher.dojosninjas.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aalsher.dojosninjas.models.Dojo;
import com.aalsher.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {
	private DojoRepository dojoRepository;

	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	private List<Dojo> dojos = new ArrayList<Dojo>();

	public List<Dojo> getDojos() {
		return (List<Dojo>) dojoRepository.findAll();
	}

	public Dojo addDojo(Dojo dojo) {
		return dojoRepository.save(dojo);
	}

	public Dojo findDojoById(Long id) {
		return dojoRepository.findById(id);
	}

}
