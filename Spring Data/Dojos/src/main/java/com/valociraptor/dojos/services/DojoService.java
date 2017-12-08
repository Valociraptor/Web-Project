package com.valociraptor.dojos.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.valociraptor.dojos.models.Dojo;
import com.valociraptor.dojos.models.Ninja;
import com.valociraptor.dojos.repositories.DojoRepo;
import com.valociraptor.dojos.repositories.NinjaPageRepo;
import com.valociraptor.dojos.repositories.NinjaRepo;


@Service
@Transactional
public class DojoService {
	
	private final NinjaRepo ninjaRepo;
	private final DojoRepo dojoRepo;
	@Autowired
	private final NinjaPageRepo ninjaPageRepo;
	private static final int PAGE_SIZE = 5;
	public Page<Ninja> ninjasPerPage(int pageNumber){
		PageRequest pageRequest = new PageRequest(pageNumber, PAGE_SIZE, Sort.Direction.ASC, "age");
		return ninjaPageRepo.findAll(pageRequest);
	}
	
	public DojoService(NinjaRepo ninjaRepo, DojoRepo dojoRepo, NinjaPageRepo ninjaPageRepo) {
		this.ninjaRepo = ninjaRepo;
		this.dojoRepo = dojoRepo;
		this.ninjaPageRepo = ninjaPageRepo;
	}
	
	
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	
	public List<Ninja> ninjasInDojo(Dojo dojo){
		Long id = dojo.getId();
		return ninjaRepo.findByDojo_Id(id);
	}
	
	public Dojo findDojo(Long id) {
		Dojo dojo = dojoRepo.findOne(id);
		return dojo;
	}


	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
		
	}
	
	
	public Ninja createNinja(Ninja ninja) {
		
		return ninjaRepo.save(ninja);
	}
	
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}
}
