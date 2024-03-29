package com.jayesh.touristwebproject.Entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Booking" )
public class Booking {
    
    @Id
    @Column(name= "bookingId" , length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long BookingId;

    @Column(name = "bookingDate")
    @Temporal(TemporalType.DATE)
    private LocalDate BookingDate;

    private PaymentStatus paymentStatus;
    private int SeatCount;
    private long TotalAmount;
    private User user;
    private TourDetails TourDetails;
    private List<Tourist> TouristList;
}
