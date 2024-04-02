package com.jayesh.touristwebproject.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.jayesh.touristwebproject.DTO.DestinationDTO;
import com.jayesh.touristwebproject.Entity.Destination;

public class DestinationMapper {

    @Autowired
    ModelMapper modelMapper;

    public Destination mapDestination(DestinationDTO destinationDTO){
        return modelMapper.map(destinationDTO, Destination.class);
    }

    public DestinationDTO mapDestinationDTO(Destination destination){
        return modelMapper.map(destination, DestinationDTO.class);
    }
}
