package com.codingdojoassignments.axsos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojoassignments.axsos.models.Dojo;
import com.codingdojoassignments.axsos.models.Ninja;
import com.codingdojoassignments.axsos.repositories.DojoRepository;
import com.codingdojoassignments.axsos.repositories.NinjaRepository;

@Service
public class DojoNinjaService {
	
	private DojoRepository dojoRepository;
	private NinjaRepository ninjaRepository;


public DojoNinjaService(DojoRepository dojoRepository, NinjaRepository ninjaRepository) {
	super();
	this.dojoRepository=dojoRepository;
	this.ninjaRepository=ninjaRepository;
}

public Dojo createDojo(Dojo dojo) {
	return dojoRepository.save(dojo);
}

public Ninja createNinja(Ninja ninja) {
	return ninjaRepository.save(ninja);
}

public List<Dojo> getAllDojos(){
	return dojoRepository.findAll();
}

public List<Ninja> getAllNinjas(){
	return ninjaRepository.findAll();
}

public Dojo getDojo(Long id) {
	Optional<Dojo> optionalDojo = this.dojoRepository.findById(id);
	if (optionalDojo.isPresent()) {
		return optionalDojo.get();
	}
	return null;
}

}


