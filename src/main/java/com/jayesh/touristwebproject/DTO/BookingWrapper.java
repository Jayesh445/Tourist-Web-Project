package com.jayesh.touristwebproject.DTO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingWrapper {

    private BookingDTO bookingDTO;
    private List<TouristDTO> TouristDTOList;
}
