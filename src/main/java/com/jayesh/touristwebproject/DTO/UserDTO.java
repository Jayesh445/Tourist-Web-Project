package com.jayesh.touristwebproject.DTO;

import java.time.LocalDate;

import com.jayesh.touristwebproject.Entity.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {

    private long userId;
    private String Email;
    private String password;
    private Role role;
    private String FName;
    private String LName;
    private LocalDate DOB;
    private String address;
    private long phoneNo;
}
