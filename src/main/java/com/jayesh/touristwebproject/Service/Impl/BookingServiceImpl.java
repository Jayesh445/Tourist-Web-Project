package com.jayesh.touristwebproject.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayesh.touristwebproject.DTO.BookingDTO;
import com.jayesh.touristwebproject.DTO.TouristDTO;
import com.jayesh.touristwebproject.Entity.Booking;
import com.jayesh.touristwebproject.Entity.TourDetails;
import com.jayesh.touristwebproject.Entity.Tourist;
import com.jayesh.touristwebproject.Entity.User;
import com.jayesh.touristwebproject.Exception.ResourceNotFoundException;
import com.jayesh.touristwebproject.Mapper.BookingMapper;
import com.jayesh.touristwebproject.Mapper.TourDetailsMapper;
import com.jayesh.touristwebproject.Mapper.TouristMapper;
import com.jayesh.touristwebproject.Repository.BookingRepository;
import com.jayesh.touristwebproject.Repository.TourDetailsRepository;
import com.jayesh.touristwebproject.Repository.TouristRepository;
import com.jayesh.touristwebproject.Repository.UserRepository;
import com.jayesh.touristwebproject.Service.BookingService;


@Service
public class BookingServiceImpl  implements BookingService{

    @Autowired
    BookingRepository BookingRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookingMapper bookingMapper;

    @Autowired
	TourDetailsRepository tourDetailsRepository;

    @Autowired
    TourDetailsMapper tourDetailsMapper;

	@Autowired
	TouristRepository touristRepository;

    @Autowired
    TouristMapper touristMapper;


    @Override
	public BookingDTO createBooking(BookingDTO bookingdto, Long userId, Long tourDetailId,
			List<TouristDTO> touristDtos) {
		Booking booking = bookingMapper.mapBooking(bookingdto);
		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "userId", userId));
		TourDetails tour = this.tourDetailsRepository.findById(tourDetailId)
				.orElseThrow(() -> new ResourceNotFoundException("tour", "tourDetailId", tourDetailId));

		tour.setMaxSeats(55);
		booking.setUser(user);

		booking.setTourDetails(tour);
			
		Booking createdBooking = BookingRepository.save(booking);

		Long bookingId = createdBooking.getBookingId();

		Booking bookingObj = this.BookingRepository.findById(bookingId).get();

		List<Tourist> tourists = new ArrayList<>();
	
		
		for (TouristDTO tr : touristDtos) {
			System.err.println("In loop +++++");
			Tourist tourist = touristMapper.mapTourist(tr);
			touristRepository.save(tourist);
			tourist.setBooking(bookingObj);
			// saving into the tourists List
			System.err.println("adding tourist_------------------------------ -");
			tourists.add(tourist);
			
		}
		System.out.println("---------------------------------------");
		tourists.stream().forEach(tourist->System.err.println(tourist+"Tourist added"));
		System.out.println("---------------------------------------");

		System.err.println("after for loop++++++++++++++++++++++++++++++++++");
		
		
		bookingObj.setTouristList(tourists);
		
		System.err.println("after for loop++++++++++++++++++++++++++++++++++11111111111111111");
		tour.setMaxSeats(tour.getMaxSeats() - createdBooking.getSeatCount());
		System.err.println("after for loop++++++++++++++++++++++++++++++++++ 1222222222222222222222");
		BookingDTO updatedBookingDto = bookingMapper.mapBookingDTO(this.BookingRepository.save(bookingObj));
		return updatedBookingDto;
	}

    @Override
	public void DeleteBookingById(Long bookingId) {
		Booking deleteBooking = this.BookingRepository.findById(bookingId)
				.orElseThrow(() -> new ResourceNotFoundException("booking", "bookingId", bookingId));
		this.BookingRepository.delete(deleteBooking);
	}

	@Override
	public BookingDTO getBookingById(Long bookingId) {
		Booking getBooking = this.BookingRepository.findById(bookingId)
				.orElseThrow(() -> new ResourceNotFoundException("booking", "bookingId", bookingId));
		return bookingMapper.mapBookingDTO(getBooking);
	}

	@Override
	public List<BookingDTO> getAllBooking() {
		List<Booking> getAllBooking = this.BookingRepository.findAll();
		List<BookingDTO> getAllBookingDTO = getAllBooking.stream()
				.map((getbooking) -> bookingMapper.mapBookingDTO(getbooking)).collect(Collectors.toList());
		return getAllBookingDTO;
	}



	@Override
	public List<BookingDTO> getBooksByTourId(Long tourId) {
		List<Booking> bookings=this.BookingRepository.findByTourDetailsTourId(tourId);
		List<BookingDTO> bookingdto=bookings.stream().map((booking)-> bookingMapper.mapBookingDTO(booking)).collect(Collectors.toList());
		return bookingdto;
	}

	@Override
	public List<BookingDTO> getBookingsByUserId(Long userId) {
		List<Booking> bookings=this.BookingRepository.findByUserUserId(userId);
		List<BookingDTO> dtoList = new ArrayList<BookingDTO>();
		bookings.forEach(
					booking -> {
						BookingDTO dto = bookingMapper.mapBookingDTO(booking);
						dto.setTourDetails(tourDetailsMapper.mapTourDetailsDTO(booking.getTourDetails()));
						dtoList.add(dto);
					}
				);
		return dtoList;
	}
}
