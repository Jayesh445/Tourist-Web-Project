package com.jayesh.touristwebproject.DTO;

import java.time.LocalDate;

import com.jayesh.touristwebproject.Entity.Role;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long userID;
    private String Email;
    private String password;
    private Role role;
    private String FName;
    private String LName;
    private LocalDate DOB;
    private String address;
    private Long phoneNo;
}
