package com.isource.dto.competitors;

import java.util.List;

import com.isource.dto.dashboard.BidderTopCompetitorsListChartDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BiddertDetailDto {

	String bidderName;
	List<BidderTopCompetitorsListChartDto > bidderDetail;
}
