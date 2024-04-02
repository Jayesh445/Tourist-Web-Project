package com.jayesh.touristwebproject.DTO;

import java.time.LocalDate;

import com.jayesh.touristwebproject.Entity.PaymentStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {

    private long BookingId;
    private LocalDate BookingDate;
    private PaymentStatus paymentStatus;
    private int SeatCount;
    private long TotalAmount;
    private UserDTO user;
    private TourDetailsDTO TourDetails;

}