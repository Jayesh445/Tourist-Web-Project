package com.jayesh.touristwebproject.DTO;

import java.time.LocalDate;

import com.jayesh.touristwebproject.Entity.TourTypeEnum;
import com.jayesh.touristwebproject.Entity.TransportationMode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TourDetailsDTO {
    
    private Long tourId;
	private String tourName;
	private String source;
	private String activities;
	private Double bookingAmount;
	private String tourDetailInfo;
	private LocalDate tourStartDate;
	private LocalDate tourEndDate;
	private Integer maxSeats;
	private TransportationMode transportationMode;
	private TourTypeEnum tourType;
}
