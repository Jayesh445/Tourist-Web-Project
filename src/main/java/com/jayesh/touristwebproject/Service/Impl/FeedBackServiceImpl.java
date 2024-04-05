package com.jayesh.touristwebproject.Service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jayesh.touristwebproject.Exception.ResourceNotFoundException;
import com.jayesh.touristwebproject.DTO.FeedBackDTO;
import com.jayesh.touristwebproject.Entity.FeedBack;
import com.jayesh.touristwebproject.Entity.User;
import com.jayesh.touristwebproject.Repository.FeedBackRepository;
import com.jayesh.touristwebproject.Repository.UserRepository;
import com.jayesh.touristwebproject.Service.FeedbackService;

@Service
@Transactional
public class FeedBackServiceImpl implements FeedbackService {
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	FeedBackRepository feedbackRepositry;
	@Autowired
	UserRepository userRepo;

	

	@Override
	public void deletefeedbackById(Long feedbackId) {
		FeedBack deletefeedback = this.feedbackRepositry.findById(feedbackId)
				.orElseThrow(() -> new ResourceNotFoundException("getfeedback", "feedbackId", feedbackId));
		this.feedbackRepositry.delete(deletefeedback);
	}

	

	@Override
	public FeedBackDTO createfeedback(FeedBackDTO feedbackdto, Long userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "userId", userId));
		
		FeedBack feedback = this.modelMapper.map(feedbackdto, FeedBack.class);
		feedback.setUser(user);
		FeedBack createdfeedback = feedbackRepositry.save(feedback);
		return this.modelMapper.map(createdfeedback, FeedBackDTO.class);
	}

	@Override
	public List<FeedBackDTO> getAllFeedback() {
		List<FeedBack> feedbackAll = this.feedbackRepositry.findAll();
		List<FeedBackDTO> feedbackAlldto = feedbackAll.stream().map(fb -> this.modelMapper.map(fb, FeedBackDTO.class))
				.collect(Collectors.toList());
		return feedbackAlldto;
	}

	@Override
	public List<FeedBackDTO> getByUserID(Long userId) {
		List<FeedBack> feedbacks = this.feedbackRepositry.findByUserID(userId).orElseThrow(() -> new ResourceNotFoundException("Booking", "userId", userId));
		if(feedbacks.isEmpty()) {
			throw new ResourceNotFoundException("feedbacks", "userId", userId);
		}
		
		List<FeedBackDTO> feedbackDto =new ArrayList<>();
		
		for(FeedBack f : feedbacks) {
			feedbackDto.add(this.modelMapper.map(f,FeedBackDTO.class));
		}
		
		return feedbackDto;
		
	}
}