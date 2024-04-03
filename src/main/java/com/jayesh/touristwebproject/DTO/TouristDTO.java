package com.jayesh.touristwebproject.DTO;

import com.jayesh.touristwebproject.Entity.Booking;
import com.jayesh.touristwebproject.Entity.IDProof;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TouristDTO {

	private Long touristId;
	private Integer age;
	private IDProof idProof;
	private String idProofNo;
	private String touristName;
	private Booking booking;
}
