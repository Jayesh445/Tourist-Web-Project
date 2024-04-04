package com.jayesh.touristwebproject.DTO;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelBookingDTO {
   
    private int HotelID;
    private int BookingId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int TotalGuest;
    private int TotalRooms;
}
