package com.isource.model.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FavoriteResultModel {

	private int user_id; // bigint,
	private int result_id; // bigint,
	private Boolean is_favorite; // boolean
}
