package com.isource.model.dashboard;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PublishTenderStateWiseModel {

	private Date from_date;// date,
	private Date to_date; // date,
	private String bidder_name; // character varying
}
