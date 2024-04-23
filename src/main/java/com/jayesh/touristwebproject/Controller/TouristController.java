package com.jayesh.touristwebproject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jayesh.touristwebproject.DTO.TouristDTO;
import com.jayesh.touristwebproject.Service.TouristService;

@Controller
@RequestMapping("/tourist")
public class TouristController {
	@Autowired
	TouristService touristService;

	@GetMapping("/addTourist")
	public String addTourist(){
		return "TouristAdd.html";
	}

	@GetMapping("/create")
	public String createTourist(@ModelAttribute TouristDTO touristdto,Model m) {
		TouristDTO createdTourist = this.touristService.createTourist(touristdto);
		m.addAttribute("tourist", createdTourist);
		return "redirect:/";
	}

	@GetMapping("/getAllTouristByBookingId/{bookingId}")
	public ResponseEntity<List<TouristDTO>> getTouristByBookingId(@PathVariable Long bookingId) {
		List<TouristDTO>getTourist = this.touristService.getTouristByBId(bookingId);
		return new ResponseEntity<List<TouristDTO>>(getTourist, HttpStatus.OK);
	}

	@GetMapping("/getall")
	public ResponseEntity<List<TouristDTO>> getAllTourist() {
		List<TouristDTO> getTourist = this.touristService.getAllTourist();
		return new ResponseEntity<List<TouristDTO>>(getTourist, HttpStatus.OK);
	}
	
}
