package com.jayesh.touristwebproject.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jayesh.touristwebproject.DTO.BookingDTO;
import com.jayesh.touristwebproject.DTO.BookingWrapper;
import com.jayesh.touristwebproject.DTO.TouristDTO;
import com.jayesh.touristwebproject.Entity.PaymentStatus;
import com.jayesh.touristwebproject.Service.BookingService;
import com.jayesh.touristwebproject.Service.TourDetailsService;
import com.jayesh.touristwebproject.Service.Impl.UserServiceImpl;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	BookingService bookingService;

	@Autowired
	TourDetailsService tourDetailsServiceImpl;

	@Autowired
	UserServiceImpl userServiceImpl;

	@GetMapping("/createBooking/tour/{tourId}/user/{userId}")
	public String createBooking( BookingWrapper bookingWrapper, BookingDTO bookingDTO ,  @PathVariable(name = "tourId") Long tourId , @PathVariable(name = "userId") Long userId, HttpSession session) {
		bookingDTO.setBookingDate( LocalDate.now());
		bookingDTO.setPaymentStatus(PaymentStatus.NOT_DONE);
		bookingDTO.setSeatCount( 1);
		bookingDTO.setTourDetails(tourDetailsServiceImpl.getTourDetailsById(tourId));
		bookingDTO.setUser(userServiceImpl.getUserById(userId));
		bookingDTO.setTotalAmount( (long) (tourDetailsServiceImpl.getTourDetailsById(tourId).getBookingAmount() * bookingDTO.getSeatCount()));
		bookingWrapper.setBookingDTO(bookingDTO);
		bookingWrapper.setTouristDTOList(new ArrayList<TouristDTO>());
		BookingDTO bookingcreated = this.bookingService.createBooking( bookingWrapper.getBookingDTO() ,  userId ,tourId , bookingWrapper.getTouristDTOList());
		session.setAttribute("booking" , bookingcreated);
		return "redirect:/tourdetails/getall";
	}

	@GetMapping("/delete/{bookingId}")
	public String deleteBooking(@PathVariable Long bookingId, HttpSession session,Model model) {
		BookingDTO bookingDTO=bookingService.getBookingById(bookingId);
		this.bookingService.DeleteBookingById(bookingId);
		model.addAttribute("user",session.getAttribute("user"));
		return "redirect:/booking/getAllbyuserId/"+bookingDTO.getUser().getUserId();
	}

	@GetMapping("/getAllbyuserId/{userId}")
	public String getBookingByUserId(@PathVariable Long userId, Model model , HttpSession session) {
		List<BookingDTO> bookingDto =this.bookingService.getBookingsByUserId(userId);
		model.addAttribute("bookings", bookingDto);
		model.addAttribute("user",session.getAttribute("user"));
		return "booking.html";
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