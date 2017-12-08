package com.valociraptor.license.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.valociraptor.license.models.License;
import com.valociraptor.license.models.Person;
import com.valociraptor.license.repositories.LicenseRepository;
import com.valociraptor.license.repositories.PersonRepository;


@Service
public class LicenseService {
	private final LicenseRepository licenseRepository;
	private final PersonRepository personRepository;
	
    public LicenseService(LicenseRepository licenseRepository, PersonRepository personRepository){
        this.licenseRepository = licenseRepository;
        this.personRepository = personRepository;
        
    }
    
	public List<Person> allPersons() {
		return personRepository.findAll();
	}
	
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}
	
	public Person getPerson(Long id) {
		return personRepository.findOne(id);
	}
	
	public License createLicense(License license) {
		Long personId = license.getPerson().getId();
		// Pad with 0 with a width of 6
		String licNumber = String.format("%06d", personId);

		license.setNumber(licNumber);
		License lic = licenseRepository.save(license);
		
		return lic;
	}
    
    
}
