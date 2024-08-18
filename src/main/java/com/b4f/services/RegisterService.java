package com.b4f.services;

import com.b4f.entity.Register;
import com.b4f.response.DonorSearchResult;

public interface RegisterService {

	String registerUser(Register register);

	DonorSearchResult findDonorDetails(String bloodGroup, String country, String state, String district, String city);

}
