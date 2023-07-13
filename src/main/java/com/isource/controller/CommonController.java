package com.isource.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isource.dto.common.IndustryDto;
import com.isource.dto.common.KeywordDto;
import com.isource.dto.common.ProductDto;
import com.isource.dto.common.ResultStageDto;
import com.isource.dto.common.SubIndustryDto;
import com.isource.handler.ip.IpHandler;
import com.isource.model.common.KeywordFilterModel;
import com.isource.service.CommonService;
import com.isource.utility.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin("*")
@RestController
@RequestMapping("api")
@Lazy
@Tag(name="all-masters")
public class CommonController {

	@Lazy
	private CommonService commonService;
	private Logger logger = null;

	@Lazy
	public CommonController(CommonService commonService) {
		this.commonService = commonService;
		logger = Logger.getLogger(CommonController.class);
	}

	/**
	 * To get Industry.
	 * @date 10-01-2023
	 * @author Harsh
	 * @return List of appropriate Model / DTO class
	 */
	@GetMapping("/get-industry")
	@Operation(summary = "get-all-industry")
	public ApiResponse<List<IndustryDto>> getAllIndustryAll() {
		logger.info("/api/IndustryAll-->>");
		return commonService.getAllIndustry();
	}
	
	/**
	 * To get Industry.
	 * @date 10-01-2023 
	 * @author Harsh 
	 * @description : @CatchPut annotation practical, practical for catch refill.
	 * @return List of appropriate Model / DTO class
	 */
	@GetMapping("/get-industry-update")
	@Operation(summary = "get-all-industry-update")
	public ApiResponse<List<IndustryDto>> getIndustryUpdate() {
		logger.info("/api/IndustryAll-->>");
		return commonService.getIndustryUpdate();
	}

	/**
	 * To get Keyword.
	 * @date 10-01-2023
	 * @author Harsh
	 * @return List of appropriate Model / DTO class
	 */
	@GetMapping("/get-keyword")
	@Operation(summary = "get-all-keyword")
	public ApiResponse<List<KeywordDto>> getAllKeyword() {
		logger.info("/api/KeywordAll-->>");
		return commonService.getAllKeyword();
	}

	/**
	 * To get Keyword.
	 * @date 10-01-2023
	 * @author Harsh
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/get-keyword-by-name")
	@Operation(summary = "get-keyword-by-name")
	public ApiResponse<List<KeywordDto>> getKeywordByName(KeywordFilterModel keywordFilterModel) {
		logger.info("/api/get-keyword-by-name-->>");
		return commonService.getKeywordByName(keywordFilterModel);
	}
	
	/**
	 * To get Product.
	 * @date 10-01-2023
	 * @author Harsh
	 * @return List of appropriate Model / DTO class
	 */
	@GetMapping("/get-product")
	@Operation(summary = "get-all-product")
	public ApiResponse<List<ProductDto>> getAllProduct() {
		logger.info("/api/getProductAll-->>");
		return commonService.getAllProduct();
	}

	
	//manish Practise Method
	@GetMapping("/get-All-Products")
	@Operation(summary ="get_All_Product")
	public ApiResponse<List<ProductDto>> getAllProductData()
	{
		logger.info("get product data started in commonContro");
		
		return commonService.getAllProductData();
	}
	
	
	/**
	 * To get Sub_Industry.
	 * @date 10-01-2023
	 * @author Harsh
	 * @return List of appropriate Model / DTO class
	 */
	@GetMapping("/get-subindustry")
	@Operation(summary = "get-all-subIndustry")
	public ApiResponse<List<SubIndustryDto>> getAllSubIndustry() {
		logger.info("api/getSubIndustry-->>");
		return commonService.getAllSubIndustry();
	}

	/**
	 * To get Result Stage.
	 * @date 10-01-2023
	 * @author Harsh
	 * @return List of appropriate Model / DTO class
	 */
	@GetMapping("/get-result-stage")
	@Operation(summary = "get-result-stage")
	public ApiResponse<List<ResultStageDto>> getResultStage() {
		logger.info("/api/get-result-stage-->>");
		return commonService.getAllResultStage();
	}

	/**
	 * To get ip address.
	 * @date 10-01-2023
	 * @author Harsh
	 * @return List of appropriate Model / DTO class
	 */
	@GetMapping("/get-ip")
	@Operation(summary = "Get Ip Address")
	public static String getIP(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String ipAddress = IpHandler.getIp(request);
		return ipAddress;
	}

}
