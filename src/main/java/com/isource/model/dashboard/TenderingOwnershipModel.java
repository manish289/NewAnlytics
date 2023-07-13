package com.isource.model.dashboard;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TenderingOwnershipModel {
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date from_date;// date,
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date to_date; // date,
	
	private String bidder_name; // character varying
}
