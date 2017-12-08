package com.valociraptor.dieinafire2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DieInAFire2Application {

	public static void main(String[] args) {
		SpringApplication.run(DieInAFire2Application.class, args);
	}
	
	@RequestMapping("/")
	public String die() {
		return "Die in a Fire";
	}
}
