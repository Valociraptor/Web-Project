package com.valociraptor.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.valociraptor.languages.models.Language;
import com.valociraptor.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
    private LanguageRepository languageRepository;
	
	
	
	
    public LanguageService(LanguageRepository LanguageRepository){
        this.languageRepository = LanguageRepository;
    }
        
	
    
	public List<Language> allLangs(){
		return languageRepository.findAll();
	}
	
	
    public Language findLang(Long id) {
    	return languageRepository.findOne(id);
    	
    	
    }
    
    
    public void addLanguage(Language language) {
        languageRepository.save(language);
    }
    
    
    public void updateLanguage(Language language) {
    	
        languageRepository.save(language);
    }
    
    
    public void deleteLang(Long id) {
        languageRepository.delete(id);
    }
    
}
