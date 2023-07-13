package com.isource.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginResponseDto {

	@JsonProperty("user_id")
	int user_id;// integer

	@JsonProperty("company_name")
	private String company_name;// character varying

	@JsonProperty("user_name")
	private String person_name;// character varying

	@JsonProperty("valid_upto")
	private String valid_upto;// character varying

	@JsonProperty("token")
	private String token;// character varying

//	@JsonProperty("ipAddress")
//	private String ipAddress;// character varying
}
