package com.jayesh.touristwebproject.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.jayesh.touristwebproject.DTO.TouristDTO;
import com.jayesh.touristwebproject.Entity.Tourist;

public class TouristMapper {

    @Autowired
    ModelMapper modelMapper;

    public Tourist mapTourist(TouristDTO TouristDTO){
        return modelMapper.map(TouristDTO, Tourist.class);
    }

    public TouristDTO mapTouristDTO(Tourist Tourist){
        return modelMapper.map(Tourist, TouristDTO.class);
    }
}
