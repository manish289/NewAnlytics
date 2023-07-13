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
public class MonthwiseResponseDto {
	String month[];
	List<MonthwiseBidderDetailDto> bidderInfo;
}
