package com.jayesh.touristwebproject.Entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="User")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id" , length = 8)
    private long userId;

    @Column(name="email", nullable=false ,unique = true)
    @Email(message = "Invalid Email entered")
    private String Email;

    @Column(name="password" , nullable=false)
    private String password;

    @Enumerated(EnumType.STRING)
    private  Role role;

    @Column(name="Fname")
    private String FName;

    @Column(name = "LName")
    private String LName;

    @Column(name = "DOB")
    @Temporal(TemporalType.DATE)
    private LocalDate DOB;


    @Column(name = "address", length = 20 )
    private String address;

    @Column(name="phone_no", length = 10)
    private long phoneNo;


    private List<FeedBack> feedbackList;


    private List<Booking> BookingList;
}
