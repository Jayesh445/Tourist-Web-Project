package com.jayesh.touristwebproject.Entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "user_id" , length = 8 )
    private long userId;

    @Column(name="email", nullable=false ,unique = true)
    @Email(message = "Invalid Email entered")
    private String Email;

    @Column(name="password" , nullable=false)
    private String password;

    @Enumerated(EnumType.STRING)
    private  Role role;

    @Column(name="Fname" )
    @Length(min= 2 , max = 25 , message = "Invalid Length of Fname")
    private String FName;

    @Column(name = "LName")
    @Length(min= 2 , max = 25 , message = "Invalid Length of Lname")
    private String LName;

    @Column(name = "DOB")
    @Past(message = "Invalid DOB")
    private LocalDate DOB;


    @Column(name = "address", length = 20 )
    @Length( max = 100 , message = "Invalid Length of Address")
    private String address;

    @Column(name="phone_no", length = 10)
    private long phoneNo;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<FeedBack> feedbackList;

    @OneToMany(mappedBy= "user", cascade = CascadeType.ALL)
    private List<Booking> BookingList;
}
