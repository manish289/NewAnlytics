package com.isource.dto.authority;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrganizationTypeDto {

	@JsonProperty("organization_type_id")
	private int organization_type_id;// integer

	@JsonProperty("organization_type_name")
	private String organization_type_name;// character varying

}
