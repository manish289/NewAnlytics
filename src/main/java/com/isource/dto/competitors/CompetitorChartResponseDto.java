package com.isource.dto.competitors;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompetitorChartResponseDto {

	String month[];
	List<CompetitorsBiddertDetailDto> bidderInfo;
}
