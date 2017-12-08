package com.valociraptor.countries.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.valociraptor.countries.models.City;
import com.valociraptor.countries.models.Country;
import com.valociraptor.countries.services.ApiService;



@Controller
public class Countries {
	private final ApiService apiService;
	
	public Countries(ApiService apiService) {
		this.apiService = apiService;
	}

	@RequestMapping("/")
	public String index() {

				List<Object[]> countries = apiService.findCountriesByLanguage("Slovene");		
				for(Object[] row : countries) {
					System.out.println(row[0]);
					System.out.println(row[1]);
					System.out.println(row[2]);
				}
				

				List<Object[]> countries = apiService.findCountriesWithNumCities();
				for(Object[] row : countries) {
					System.out.println(row[0]);
					System.out.println(row[1]);
				}		

				List<City> cities = apiService.findCitiesInCountryWithPopulationGreaterThan("Mexico", 500000);
				for(City c : cities) {
					System.out.println(c.getName());
					System.out.println(c.getPopulation());
				}

				List<Object[]> countries = apiService.findLanguagesWithPercentageGreaterThan(89.0);
				for(Object[] row : countries) {
					System.out.println(row[0]);
					System.out.println(row[1]);
					System.out.println(row[2]);
				}

				List<Country> countries = apiService.findCountriesWithSurfaceAreaBelowThanAndPopulationGreaterThan(501.0, 100000);
				for(Country c : countries) {
					System.out.println(c.getName());
					System.out.println(c.getSurfaceArea());
					System.out.println(c.getPopulation());
				}
				

				List<Country> countries = apiService.findCountriesWithGovermentFormAndCapitalGreaterThanAndLifeExpectancyGreaterThan("Constitutional Monarchy", 200, 75.0);
				for(Country c : countries) {
					System.out.println(c.getName());
					System.out.println(c.getGovernmentForm());
					System.out.println(c.getCapital());
					System.out.println(c.getLifeExpectancy());
				}
				

				List<Object[]> countries = apiService.findCitiesInArgentinaInBuenosAiresWithPopulationGreaterThan(500000);
				for(Object[] row : countries) {
					System.out.println(row[0]);
					System.out.println(row[1]);
					System.out.println(row[2]);
					System.out.println(row[3]);
				}
				

			   List<Object[]> countries = apiService.findNumberOfCountriesInEachRegion();
				for(Object[] row : countries) {
					System.out.println(row[0]);
					System.out.println(row[1]);
				}
			
				return "index.jsp";
			}
		}