package com.jayesh.touristwebproject.Service;


import java.util.List;

import com.jayesh.touristwebproject.DTO.BookingDTO;
import com.jayesh.touristwebproject.DTO.TouristDTO;

public interface BookingService {

    public BookingDTO createBooking(BookingDTO bookingDTO,Long userId, Long tourDetailId, List<TouristDTO> touristList);

    public void DeleteBookingById(Long bookingId);

	public BookingDTO getBookingById(Long bookingId);

	public List<BookingDTO> getAllBooking();

	public List<BookingDTO> getBooksByTourId(Long tourId);

	public List<BookingDTO> getBookingsByUserId(Long userId);

}
