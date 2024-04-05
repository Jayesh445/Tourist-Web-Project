package com.jayesh.touristwebproject.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jayesh.touristwebproject.Exception.ResourceNotFoundException;
import com.jayesh.touristwebproject.DTO.TouristDTO;
import com.jayesh.touristwebproject.Entity.Tourist;
import com.jayesh.touristwebproject.Repository.TouristRepository;
import com.jayesh.touristwebproject.Service.TouristService;

@Service
@Transactional
public class TouristServiceImpl implements TouristService {
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	TouristRepository touristRepository;

	@Override
	public TouristDTO createTourist(TouristDTO touristdto) {
		Tourist tourist = this.modelMapper.map(touristdto, Tourist.class);
		Tourist createdTourist = touristRepository.save(tourist);
		return this.modelMapper.map(createdTourist, TouristDTO.class);
	}
	
	@Override
	public List<TouristDTO> getTouristByBId(Long bookingId) {
		List<Tourist> tourist = this.touristRepository.findByBookingBookingId(bookingId).orElseThrow(() -> new ResourceNotFoundException("tourist", "bookingId", bookingId));
		List<TouristDTO> allTouristDto = tourist.stream().map((tourists) -> this.modelMapper.map(tourists,TouristDTO.class)).collect(Collectors.toList());
		return allTouristDto;
	}
	
	@Override
	public List<TouristDTO> getAllTourist() {
		List<Tourist> tourists = this.touristRepository.findAll();
		List<TouristDTO> allTouristDto = tourists.stream()
				.map((tourist) -> this.modelMapper.map(tourist, TouristDTO.class)).collect(Collectors.toList());
		return allTouristDto;
	}

}
