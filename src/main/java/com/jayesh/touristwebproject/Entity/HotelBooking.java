package com.jayesh.touristwebproject.Entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Hotel_booking")
public class HotelBooking {
    @Id
    @Column(name = "hotel_id", length = 8)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int HotelID;

    @OneToOne(fetch= FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_id")
    private int BookingId;

    @Column(name = "check_in_date" , nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate checkInDate;

    @Column(name = "check_out_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate checkOutDate;

    @Column(name = "total_guest", nullable = false ,length = 2)
    private int TotalGuest;

    @Column(name = "total_rooms" , nullable = false, length = 2)
    private int TotalRooms;
}
