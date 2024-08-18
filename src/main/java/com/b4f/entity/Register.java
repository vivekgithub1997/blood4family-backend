package com.b4f.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Register {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userId;

	private String userName;
	private String bloodGroup;
	private String userEmail;
	private String userPassword;
	private long userMobile;
	private String userCountry;
	private String userState;
	private String userDistrict;
	private String userCity;
	private String userAvailbility;

}
