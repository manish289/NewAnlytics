package com.isource.model.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserModel {
	
	@NotNull
	@NotBlank
	private String email_id;
	
	@NotNull
	@NotBlank
	private String password;
	
	private String ip_address;
}
