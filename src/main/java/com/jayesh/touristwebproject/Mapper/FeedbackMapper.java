package com.jayesh.touristwebproject.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.jayesh.touristwebproject.DTO.FeedBackDTO;
import com.jayesh.touristwebproject.Entity.FeedBack;

public class FeedbackMapper {

    @Autowired
    ModelMapper modelMapper;

    public FeedBack mapDestination(FeedBackDTO feedBackDTO){
        return modelMapper.map(feedBackDTO, FeedBack.class);
    }

    public FeedBackDTO mapDestinationDTO(FeedBack feedBack){
        return modelMapper.map(feedBack, FeedBackDTO.class);
    }
}
