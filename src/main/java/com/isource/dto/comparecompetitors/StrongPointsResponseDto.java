package com.isource.dto.comparecompetitors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StrongPointsResponseDto {

	StrongPointDepartmentDto departmentInfo;
	StrongPointStateDto stateInfo;
	StrongPointsOwnershipwiseDto ownershipInfo;
}
