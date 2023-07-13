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
public class OrganizationDto {

	@JsonProperty("organization_id")
	private int organization_id;// integer

	@JsonProperty("organization_name")
	private String organization_name;// character varying

	@JsonProperty("organization_type_id")
	private String organization_type_id;// integer

	@JsonProperty("organization_type_name")
	private String organization_type_name;// character varying

}
