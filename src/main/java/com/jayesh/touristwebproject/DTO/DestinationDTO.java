package com.jayesh.touristwebproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DestinationDTO {

    private int destinationId;
    private String DestinationName;
    private String Desciption;
    private String Location;
}
