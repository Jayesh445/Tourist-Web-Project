package com.jayesh.touristwebproject.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jayesh.touristwebproject.DTO.TourDetailsDTO;
import com.jayesh.touristwebproject.Entity.TourDetails;

@Component
public class TourDetailsMapper {

    @Autowired
    ModelMapper modelMapper;

    public TourDetails mapTourDetails(TourDetailsDTO TourDetailsDTO){
        return modelMapper.map(TourDetailsDTO, TourDetails.class);
    }

    public TourDetailsDTO mapTourDetailsDTO(TourDetails TourDetails){
        return modelMapper.map(TourDetails, TourDetailsDTO.class);
    }
}
