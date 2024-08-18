package com.b4f.response;

import java.util.List;

import com.b4f.entity.Register;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DonorSearchResult {
	private List<Register> donors;
	private String message;

}
