package com.isource.bean;

import java.io.Serializable;

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
public class JwtRequest implements Serializable {
	
	private static final long serialVersionUID = 5926468583005150707L;

	@NotNull
	@NotBlank
	private String email_id;

	@NotNull
	@NotBlank
	private String password;

}
