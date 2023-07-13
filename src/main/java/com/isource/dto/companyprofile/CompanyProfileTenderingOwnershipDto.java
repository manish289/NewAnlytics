package com.isource.dto.companyprofile;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompanyProfileTenderingOwnershipDto {
	
	@JsonProperty("organization_type_id")
	private int organization_type_id;// integer 

	@JsonProperty("organization_type_name")
	private String organization_type_name;// character varying

	@JsonProperty("total_participate")
	private BigInteger total_participate;// bigint

	@JsonProperty("total_awarded")
	private BigInteger total_awarded;// bigint

}
