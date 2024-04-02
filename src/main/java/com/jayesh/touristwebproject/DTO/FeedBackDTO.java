package com.jayesh.touristwebproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FeedBackDTO {

	private Long feedbackId;
	private String comment;
	private String email;
	private String firstName;
	private Integer rating;
	private UserDTO user;
}
