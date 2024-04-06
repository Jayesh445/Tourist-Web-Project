package com.jayesh.touristwebproject.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jayesh.touristwebproject.DTO.DestinationDTO;
import com.jayesh.touristwebproject.Entity.Destination;
import com.jayesh.touristwebproject.Mapper.DestinationMapper;
import com.jayesh.touristwebproject.Repository.DestinationRepository;
import com.jayesh.touristwebproject.Service.DestinationService;

@Service
@Transactional
public class DestinationServiceImpl implements DestinationService {

    @Autowired
    DestinationRepository destinationRepository;

    @Autowired
    DestinationMapper destinationMapper;

    @Override
    public List<DestinationDTO> findByDestinationName(String destinationName) {

        List<Destination> destinations=this.destinationRepository.findByDestinationName(destinationName);
        List<DestinationDTO> dtoList = new ArrayList<DestinationDTO>();
		destinations.forEach(
					destination -> {
						DestinationDTO dto = destinationMapper.mapDestinationDTO(destination);
						dtoList.add(dto);
					}
				);
//		return bookingdto;
		return dtoList;
    }

}
