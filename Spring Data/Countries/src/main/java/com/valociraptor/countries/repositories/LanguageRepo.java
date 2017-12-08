package com.valociraptor.countries.repositories;

import org.springframework.stereotype.Repository;

import com.valociraptor.countries.models.Language;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface LanguageRepo extends CrudRepository<Language, Long> {

}
