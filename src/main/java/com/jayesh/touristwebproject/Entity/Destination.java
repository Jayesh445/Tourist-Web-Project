package com.jayesh.touristwebproject.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "destination")
@Entity
public class Destination {

    @Id
    @Column(name = "destination_id",nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long destinationId;

    @Column(name = "destination_name", length = 30,nullable = false,updatable = true)
    private String destinationName;
    
    @Column(name = "description")
    private String Desciption;

    @Column(name = "location" ,length=30 , nullable = false)
    private String Location;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "tour_id")
    private TourDetails tourDetails;
}
