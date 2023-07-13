package com.isource.dto.companyprofile;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MonthwiseBidderDetailDto {
	String bidderName;
	List<MonthWiseListChartDto> biddertDetail;
}
