package com.valociraptor.strings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StringsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringsApplication.class, args);
	}
	
	@RequestMapping("/")
	public String die() {
		return "Hi! Die in a fire!";
	}
	
	@RequestMapping("/random")
	public String sprang() {
		return "SPRANG SPRANG SPRANG";
	}
	
}
