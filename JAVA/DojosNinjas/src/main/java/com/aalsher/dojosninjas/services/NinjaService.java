package com.aalsher.dojosninjas.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aalsher.dojosninjas.models.Ninja;
import com.aalsher.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private NinjaRepository ninjaRepository;

	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	private List<Ninja> ninjas = new ArrayList<Ninja>();

	public List<Ninja> getNinjas() {
		return (List<Ninja>) ninjaRepository.findAll();
	}

	public void addNinja(Ninja ninja) {
		ninjaRepository.save(ninja);
	}

	public Ninja findNinjaById(Long id) {
		return ninjaRepository.findById(id);
	}

}
