package com.isource.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDto {

	@JsonProperty("product_id")
	private int product_id;// integer

	@JsonProperty("industry_id")
	private int industry_id;// integer

	@JsonProperty("sub_industry_id")
	private int sub_industry_id;// integer

	@JsonProperty("product_name")
	private String product_name;// character varying

}
