package com.jayesh.touristwebproject.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.jayesh.touristwebproject.DTO.BookingDTO;
import com.jayesh.touristwebproject.Entity.Booking;

public class BookingMapper {

    @Autowired
    ModelMapper modelMapper;

    public Booking mapBooking(BookingDTO bookingDTO){
        return modelMapper.map(bookingDTO, Booking.class);
    }
    public BookingDTO mapBookingDTO(Booking booking){
        return modelMapper.map(booking, BookingDTO.class);
    }

}
