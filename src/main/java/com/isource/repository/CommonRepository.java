package com.isource.repository;

import java.util.Comparator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.isource.dto.common.IndustryDto;
import com.isource.dto.common.KeywordDto;
import com.isource.dto.common.ProductDto;
import com.isource.dto.common.ResultStageDto;
import com.isource.dto.common.SubIndustryDto;
import com.isource.model.common.KeywordFilterModel;
import com.isource.service.CacheManagerService;
import com.isource.service.CommonService;
import com.isource.utility.ApiResponse;

@Repository
@Lazy
public class CommonRepository implements CommonService {

	private Logger logger = null;
	@Lazy
	private CacheManagerService cacheManagerService;
	@Lazy
	public CommonRepository(CacheManagerService cacheManagerService) {
		this.cacheManagerService = cacheManagerService;
		logger = Logger.getLogger(CommonRepository.class);
	}

	public ApiResponse<List<IndustryDto>> getAllIndustry() {

		List<IndustryDto> industry = null;
		try {
			logger.info("Start Industry  ");
			industry = cacheManagerService.getIndustry();
			logger.info("End Industry  ");
			return new ApiResponse<List<IndustryDto>>(true, "Total " + industry.size() + " Records", true, industry,
					industry.size());
		} catch (Exception ex) {
			logger.info("getIndustry Exception : " + ex.toString());
			return new ApiResponse<List<IndustryDto>>(false, ex.toString(), true, industry, 0);
		}
	}

	public ApiResponse<List<IndustryDto>> getIndustryUpdate() {

		List<IndustryDto> industry = null;
		try {
			logger.info(" Start Industry Update");
			industry = cacheManagerService.getIndustryUpdate();
			logger.info(" End Industry  Update");
			return new ApiResponse<List<IndustryDto>>(true, "Total " + industry.size() + " Records", true, industry,
					industry.size());
		} catch (Exception ex) {
			logger.info("getIndustryUpdate Exception : " + ex.toString());
			return new ApiResponse<List<IndustryDto>>(false, ex.toString(), true, industry, 0);
		}
	}

	public ApiResponse<List<KeywordDto>> getAllKeyword() {

		List<KeywordDto> keyword = null;
		try {
			logger.info("Start Keyword ");
			keyword = cacheManagerService.getKeyword();
			logger.info(" End Keyword ");
			return new ApiResponse<List<KeywordDto>>(true, "Total " + keyword.size() + " Records", true, keyword,
					keyword.size());
		} catch (Exception ex) {
			logger.info("getKeyword Exception : " + ex.toString());
			return new ApiResponse<List<KeywordDto>>(false, ex.toString(), true, keyword, 0);
		}
	}

	public ApiResponse<List<ProductDto>> getAllProduct() {
		List<ProductDto> product = null;
		try {
			logger.info("Start Product ");
			
			product = cacheManagerService.getProduct();
			
			logger.info("End Product ");
			return new ApiResponse<List<ProductDto>>(true, "Total " + product.size() + " Records", true, product,
					product.size());
		} catch (Exception ex) {
			logger.info("getProduct Exception : " + ex.toString());
			return new ApiResponse<List<ProductDto>>(false, ex.toString(), true, product, 0);
		}
	}

	public ApiResponse<List<SubIndustryDto>> getAllSubIndustry() {

		List<SubIndustryDto> subIndustry = null;
		try {
			logger.info("Start SubIndustry ");
			subIndustry = cacheManagerService.getSubIndustry();
			logger.info("End SubIndustry ");
			return new ApiResponse<List<SubIndustryDto>>(true, "Total " + subIndustry.size() + " Records", true,
					subIndustry, subIndustry.size());
		} catch (Exception ex) {
			logger.info("getSubIndustry Exception : " + ex.toString());
			return new ApiResponse<List<SubIndustryDto>>(false, ex.toString(), true, subIndustry, 0);
		}
	}

	@Override
	public ApiResponse<List<ResultStageDto>> getAllResultStage() {

		List<ResultStageDto> bidder = null;
		try {
			logger.info("Start ResultStage ");
			bidder = cacheManagerService.getResultStage();
			logger.info("End ResultStage ");
			return new ApiResponse<List<ResultStageDto>>(true, "Total " + bidder.size() + " Records", true, bidder,
					bidder.size());
		} catch (Exception ex) {
			logger.info("getResultStage Exception : " + ex.toString());
			return new ApiResponse<List<ResultStageDto>>(false, ex.toString(), true, bidder, 0);
		}
	}

	@Override
	public ApiResponse<List<KeywordDto>> getKeywordByName(KeywordFilterModel keywordFilterModel) {
	
		List<KeywordDto> keyword = null;
		try {
			logger.info("Start Keyword ");
			keyword = cacheManagerService.getKeyword();
			if (keywordFilterModel.getKeywordName() != "" && keywordFilterModel.getKeywordName() != null) {
				keyword = keyword.stream().filter(orges -> orges.getKeyword_name().toLowerCase()
						.startsWith(keywordFilterModel.getKeywordName().toLowerCase())).toList();
			}
			keyword = keyword.stream().sorted(Comparator.comparing(KeywordDto::getKeyword_name))
					.skip((keywordFilterModel.getPageNo() - 1) * keywordFilterModel.getNoOfRecords())
					.limit(keywordFilterModel.getNoOfRecords()).toList();
			logger.info(" End Keyword ");
			return new ApiResponse<List<KeywordDto>>(true, "Total " + keyword.size() + " Records", true, keyword,
					keyword.size());
		} catch (Exception ex) {
			logger.info("getKeyword Exception : " + ex.toString());
			return new ApiResponse<List<KeywordDto>>(false, ex.toString(), true, keyword, 0);
		}
	}

	
	//Manish Practise Method
	@Override
	public ApiResponse<List<ProductDto>> getAllProductData() {
		List<ProductDto> listofProd= null;
		
		try {
			logger.info("Start to get the data ");
			
			listofProd= cacheManagerService.getAllProductData();
			
			logger.info("End to Get The Data");
			return new ApiResponse<List<ProductDto>>(true, "Total"+ listofProd.size()+ "Records", true, listofProd, listofProd.size());
			
		    }
		catch (Exception e) {
			return new ApiResponse<List<ProductDto>>(true, e.toString(), true, listofProd, 0);
		}

	}
	
	
	
}
