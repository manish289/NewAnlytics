package com.isource.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChangePasswordModel {
	
	private int user_id;
	private String old_password;
	private String new_password;
}
