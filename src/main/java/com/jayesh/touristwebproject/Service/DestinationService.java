package com.jayesh.touristwebproject.Service;

import java.util.List;

import com.jayesh.touristwebproject.DTO.DestinationDTO;

public interface DestinationService {

    public List<DestinationDTO> findByDestinationName(String destinationName);
}
