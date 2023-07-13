package com.isource.model.comparecompetitors;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SameBidComparisionStateWiseModel {
	
	private Date from_date;// date,
	
	private Date to_date; // date,
	
	@NotNull
	@NotBlank
	String bidder1;

	@NotNull
	@NotBlank
	String bidder2;
	
	String bidder3;

}