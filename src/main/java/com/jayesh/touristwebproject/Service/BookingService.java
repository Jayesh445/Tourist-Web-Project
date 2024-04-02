package com.jayesh.touristwebproject.Service;


import java.util.List;

import com.jayesh.touristwebproject.DTO.BookingDTO;
import com.jayesh.touristwebproject.DTO.HotelBookingDTO;
import com.jayesh.touristwebproject.DTO.TouristDTO;

public interface BookingService {

    public BookingDTO createBooking(BookingDTO bookingDTO,Long userId, Long tourDetailId, List<TouristDTO> touristList, HotelBookingDTO hotelBookingDTO);
}
