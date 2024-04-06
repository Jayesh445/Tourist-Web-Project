package com.jayesh.touristwebproject.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tour_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TourDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tour_id")
	private Long tourId;

	@Column(name = "tour_name", nullable = false)
	@Length(min = 2, max = 30, message = "Invalid length of the tour name")
	private String tourName;

	@Column(name = "source")
	@Length(min = 2, max = 30, message = "Invalid length of the source")
	private String source;
	
	@OneToMany(mappedBy= "tourDetails",cascade = CascadeType.ALL)
	private List<Destination> destination = new ArrayList<>();

	@Length(min = 2, max = 30, message = "Invalid length of the tour name")
	private String activities;
	
	@Column(name = "booking_amount", nullable = false)
	@Min(value = 0, message = "The value must be positive")
	private Double bookingAmount;
	
	@Column(name = "tour_detail_info")
	@Length(min = 2, max = 50, message = "Invalid length of the tour description")
	private String tourDetailInfo;
	
	@Column(name = "tour_start_date", nullable = false)
	private LocalDate tourStartDate;

	@Column(name = "tour_end_date", nullable = false)
	// tour end date must be after tour start date validation required
	private LocalDate tourEndDate;
	
	@Column(name = "max_seats")
	@Min(value = 0)
	private Integer maxSeats;
	
	@Column(name = "transportation_mode")
	@Enumerated(EnumType.STRING)
	private TransportationMode transportationMode;

	@Column(name = "tour_type")
	@Enumerated(EnumType.STRING)
	private TourTypeEnum tourType;

	@OneToMany(mappedBy = "tourDetails", cascade = CascadeType.ALL)
	List<Booking> bookingList = new ArrayList<>();


}