package com.jayesh.touristwebproject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jayesh.touristwebproject.DTO.BookingDTO;
import com.jayesh.touristwebproject.DTO.BookingWrapper;
import com.jayesh.touristwebproject.Service.BookingService;

@Controller
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	BookingService bookingService;

	@PostMapping("/createBooking/tour/{tourId}/user/{userId}")
	public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingWrapper bookingWrapper ,  @PathVariable Long tourId,@PathVariable Long userId) {
		BookingDTO bookingcreated = this.bookingService.createBooking(bookingWrapper.getBookingDTO(),tourId, userId,bookingWrapper.getTouristDTOList());
		return new ResponseEntity<BookingDTO>(bookingcreated, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{bookingId}")
	public String deleteBooking(@PathVariable Long bookingId) {
		this.bookingService.DeleteBookingById(bookingId);
		return"";
	}
	@GetMapping("/getAllbyuserId/{userId}")
	public ResponseEntity<List<BookingDTO>>getBookingByUserId(@PathVariable Long userId) {
		List<BookingDTO> bookingDto =this.bookingService.getBookingsByUserId(userId);
		return new ResponseEntity<List<BookingDTO>>(bookingDto,HttpStatus.OK);
	}
	@GetMapping("/get/{bookingId}")
	public ResponseEntity<BookingDTO> getBooking(@PathVariable Long bookingId) {
		BookingDTO getBooking = this.bookingService.getBookingById(bookingId);
		return new ResponseEntity<BookingDTO>(getBooking, HttpStatus.OK);
	}

	// for checking purpose only
	@GetMapping("/getallbookings")
	public ResponseEntity<List<BookingDTO>> getAllBookings() {
		List<BookingDTO> bookingDto = this.bookingService.getAllBooking();
		return new ResponseEntity<List<BookingDTO>>(bookingDto, HttpStatus.OK);
	}
	@GetMapping("/getAllByTourId/{tourId}")
	public ResponseEntity<List<BookingDTO>> getBookingsByTourID(@PathVariable Long tourId ){
		List<BookingDTO> bookingDto =this.bookingService.getBooksByTourId(tourId);
		return new ResponseEntity<List<BookingDTO>>(bookingDto,HttpStatus.OK);
		
	}
	// for getting the booking by tour date
	
}