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
public class TenderingOwnershipDto {

	@JsonProperty("organization_type_name")
	private String organization_type_name;// character varying

	@JsonProperty("total_result")
	private BigInteger total_result;// bigint

	@JsonProperty("total_bidder_result")
	private BigInteger total_bidder_result;// bigint

}
