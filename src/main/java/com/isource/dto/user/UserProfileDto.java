package com.isource.dto.user;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserProfileDto {
	
	
	@JsonProperty("user_id")
	private int user_id; // integer,
	
	@JsonProperty("subscribe_category")
	private String subscribe_category; //  text
	
	@JsonProperty("subscription_duration")
	private String subscription_duration; //  character varying
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@JsonProperty("last_date_of_subscription")
	private Date last_date_of_subscription; //  date
	
	@JsonProperty("subscription_amount")
	private BigDecimal subscription_amount; //  numeric
	
	@JsonProperty("tax_invoice")
	private String tax_invoice; //  character varying
	
	@JsonProperty("key_manager_details")
	private String key_manager_details; //  text
}