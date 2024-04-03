package com.jayesh.touristwebproject.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jayesh.touristwebproject.DTO.HotelBookingDTO;
import com.jayesh.touristwebproject.Entity.HotelBooking;

@Component
public class HotelBookingMapper {

    @Autowired
    ModelMapper modelMapper;

    public HotelBooking mapHotelBooking(HotelBookingDTO HotelBookingDTO){
        return modelMapper.map(HotelBookingDTO, HotelBooking.class);
    }

    public HotelBookingDTO mapHotelBookingDTO(HotelBooking HotelBooking){
        return modelMapper.map(HotelBooking, HotelBookingDTO.class);
    }
}
