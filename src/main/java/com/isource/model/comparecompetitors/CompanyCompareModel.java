package com.isource.model.comparecompetitors;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompanyCompareModel {

	private Date from_date;// date,
	private Date to_date; // date,
	private int keyword_id; // category = keyword character varying
	private int state_id; // character varying
	private String bidder_name; // character varying
}
