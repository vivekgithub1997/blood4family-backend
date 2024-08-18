package com.b4f.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b4f.entity.Register;
import com.b4f.repository.RegisterRepository;
import com.b4f.response.DonorSearchResult;

import jakarta.transaction.Transactional;

@Service
public class RegisterServicesImpl implements RegisterService {

	@Autowired
	private RegisterRepository registerRepository;

	@Transactional
	@Override
	public String registerUser(Register register) {
		// TODO Auto-generated method stub

		Register save = registerRepository.save(register);

		if (save != null) {
			return "User Registration Successfully";
		} else {
			return "Registration Un-Successfully";
		}

	}

	@Override
	public DonorSearchResult findDonorDetails(String bloodGroup, String country, String state, String district,
			String city) {

		List<Register> donorDetails = registerRepository.findDonorDetails(bloodGroup, country, state, district, city);

		String message = donorDetails.isEmpty() ? "Donor not found in this location" : "Donors found";

		return new DonorSearchResult(donorDetails, message);

	}

}
