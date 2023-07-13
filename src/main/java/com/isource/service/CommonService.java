package com.isource.service;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.isource.dto.common.IndustryDto;
import com.isource.dto.common.KeywordDto;
import com.isource.dto.common.ProductDto;
import com.isource.dto.common.ResultStageDto;
import com.isource.dto.common.SubIndustryDto;
import com.isource.model.common.KeywordFilterModel;
import com.isource.utility.ApiResponse;

@Service
@Lazy
public interface CommonService {

	ApiResponse<List<IndustryDto>> getAllIndustry();
	ApiResponse<List<IndustryDto>> getIndustryUpdate();
	ApiResponse<List<KeywordDto>> getAllKeyword();
	ApiResponse<List<KeywordDto>> getKeywordByName(KeywordFilterModel keywordFilterModel);
	ApiResponse<List<ProductDto>> getAllProduct();
	ApiResponse<List<SubIndustryDto>> getAllSubIndustry();	
	ApiResponse<List<ResultStageDto>> getAllResultStage();
	
	//manish practise method
	ApiResponse<List<ProductDto>> getAllProductData();
	
	
}