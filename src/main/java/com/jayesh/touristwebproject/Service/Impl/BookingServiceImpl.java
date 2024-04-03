package com.jayesh.touristwebproject.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayesh.touristwebproject.DTO.BookingDTO;
import com.jayesh.touristwebproject.DTO.HotelBookingDTO;
import com.jayesh.touristwebproject.DTO.TouristDTO;
import com.jayesh.touristwebproject.Repository.BookingRepository;
import com.jayesh.touristwebproject.Repository.UserRepository;
import com.jayesh.touristwebproject.Service.BookingService;


@Service
public class BookingServiceImpl  implements BookingService{

    @Autowired
    BookingRepository BookingRepository;

    UserRepository userRepository;



    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO, Long userId, Long tourDetailId, List<TouristDTO> touristList,
            HotelBookingDTO hotelBookingDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createBooking'");
    }



}
