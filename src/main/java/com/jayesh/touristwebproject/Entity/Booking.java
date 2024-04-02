package com.jayesh.touristwebproject.Entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "booking" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @Column(name= "booking_Id" , length = 10)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long BookingId;

    @Column(name = "booking_date",nullable=false)
    @Temporal(TemporalType.DATE)
    private LocalDate BookingDate;

    @Column(name = "payment_status",nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @Column(name = "seat_count",nullable=false)
    private int SeatCount;

    @Column(name = "total_amount",nullable=false)
    private long TotalAmount;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id")
    private TourDetails tourDetails;

    @OneToMany(mappedBy = "booking" , cascade = CascadeType.ALL)
    private List<Tourist> TouristList;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private HotelBooking hotelBooking;
}
