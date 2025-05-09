package com.ecommerce.order.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Document(collection = "Users")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User
{

	@MongoId
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String profileImage;
	private Boolean isActive;
	private Gender gender;
	private Country country;
	private Boolean isDeleted;
	@CreatedDate
	private LocalDateTime createDateTime;

	@LastModifiedDate
	private LocalDateTime modifiedDateTime;

}
