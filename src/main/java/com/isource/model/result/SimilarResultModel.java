package com.isource.model.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SimilarResultModel {
	
	private int resultId;
	private String keywordIds;
	private String sitelocationId;
	private int contractValue;
	private String organization_id;
}
