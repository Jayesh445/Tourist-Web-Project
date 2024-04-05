package com.jayesh.touristwebproject.Service;

import java.util.List;

import com.jayesh.touristwebproject.DTO.FeedBackDTO;

public interface FeedbackService {
	
	void deletefeedbackById(Long feedbackId);

	FeedBackDTO createfeedback(FeedBackDTO feedbackdto, Long userId);

	List<FeedBackDTO> getAllFeedback();
	
	List<FeedBackDTO> getByUserID(Long userId);
	
}
