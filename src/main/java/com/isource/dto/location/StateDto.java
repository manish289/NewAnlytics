package com.isource.dto.location;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StateDto {

	@JsonProperty("state_id")
	private int state_id;// integer

	@JsonProperty("state_name")
	private String state_name;// character varying

	@JsonProperty("country_id")
	private String country_id;// integer

}
