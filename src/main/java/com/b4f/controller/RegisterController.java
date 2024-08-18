package com.b4f.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.b4f.entity.Register;
import com.b4f.response.DonorSearchResult;
import com.b4f.services.RegisterService;

@RestController
@RequestMapping("/register")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class RegisterController {

	@Autowired
	private RegisterService registerService;

	@PostMapping("/new/user")
	public ResponseEntity<String> registerUser(@RequestBody Register register) {

		String registerUser = registerService.registerUser(register);
		System.out.println(registerUser);
		return new ResponseEntity<String>(registerUser, HttpStatus.CREATED);

	}

	@GetMapping("/find/donor/{bloodGroup}/{country}/{state}/{district}/{city}")
	public ResponseEntity<DonorSearchResult> findDonor(@PathVariable String bloodGroup, @PathVariable String country,
			@PathVariable String state, @PathVariable String district, @PathVariable String city) {

		DonorSearchResult donorDetails = registerService.findDonorDetails(bloodGroup, country, state, district, city);

		return new ResponseEntity<>(donorDetails, HttpStatus.OK);
	}

}
