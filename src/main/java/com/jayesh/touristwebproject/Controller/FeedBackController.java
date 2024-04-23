package com.jayesh.touristwebproject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jayesh.touristwebproject.DTO.FeedBackDTO;
import com.jayesh.touristwebproject.Service.FeedbackService;

@Controller
@RequestMapping("/feedback")
public class FeedBackController {
	@Autowired
	FeedbackService feedbackService;

	@PostMapping("/create/{userId}")
	public String createFeedback(@ModelAttribute FeedBackDTO feedBackdto,@PathVariable Long userId ,Model m) {
		FeedBackDTO feedbackCreated = this.feedbackService.createfeedback(feedBackdto,userId);
		m.addAttribute("feedbackResponse", feedbackCreated);
		// return new ResponseEntity<FeedBackDTO>(feedbackCreated, HttpStatus.CREATED);
		return "";
	}

	@DeleteMapping("/delete/{feedbackId}")
	public String deleteFeedback(@PathVariable Long feedbackId) {
		this.feedbackService.deletefeedbackById(feedbackId);
		return "";
	}



	@GetMapping("/getall")
	public ResponseEntity<List<FeedBackDTO>> getAllFeedbacks() {
		List<FeedBackDTO> getallFeedbacks = this.feedbackService.getAllFeedback();
		return new ResponseEntity<List<FeedBackDTO>>(getallFeedbacks, HttpStatus.OK);
	}

	@GetMapping("/getByUserId/{userId}")
	public ResponseEntity<List<FeedBackDTO>> getByUserId(@PathVariable Long userId) {
		List<FeedBackDTO> getFeedbacks = this.feedbackService.getByUserID(userId);
		return new ResponseEntity<List<FeedBackDTO>>(getFeedbacks, HttpStatus.OK);
	}
}