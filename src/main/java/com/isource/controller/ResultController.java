package com.isource.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isource.dto.result.BidderParticipatedResultDto;
import com.isource.dto.result.ParticipatingBidderDto;
import com.isource.dto.result.RelatedKeywordDto;
import com.isource.dto.result.ResultAnalyticsSiteLocationDetailDto;
import com.isource.dto.result.ResultDetailDto;
import com.isource.dto.result.ResultDocumentDto;
import com.isource.dto.result.ResultDto;
import com.isource.dto.result.SimilarResultDto;
import com.isource.model.comparecompetitors.BidderResultModel;
import com.isource.model.dashboard.BidderParticipatedResultModel;
import com.isource.model.result.FavoriteResultModel;
import com.isource.model.result.ResultDetailModel;
import com.isource.model.result.ResultDocumentModel;
import com.isource.model.result.ResultModel;
import com.isource.model.result.SimilarResultModel;
import com.isource.service.ResultService;
import com.isource.utility.ApiResponse;
import com.isource.utility.PropertiesReader;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin("*")
@RestController
@RequestMapping("api")
@Tag(name = "page - 2,3 result-controller")
@Lazy
public class ResultController {

	@Lazy
	private ResultService resultService;
	private Logger logger = null;

	private String recordInserted = PropertiesReader.getProperty("message", "RECORD_INSERTED");
	private String recordNotInserted = PropertiesReader.getProperty("message", "RECORD_NOT_INSERTED");

	@Lazy
	public ResultController(ResultService resultService) {
		this.resultService = resultService;
		logger = Logger.getLogger(ResultController.class);
	}

	/**
	 * To get result detail.
	 * 
	 * @author Harsh 30/01/23
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/get-result-detail")
	@Operation(summary = "get-result-detail")
	public ApiResponse<List<ResultDetailDto>> getResultDetatil(@RequestBody ResultDetailModel resultDetailModel) {
		logger.info("/api/get-result-detail");
		return resultService.getResultDetatil(resultDetailModel);
	}

	/**
	 * To get Bidder Participated Result .
	 * 
	 * @author jayesh + Harsh 30/01/23
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/get-bidder-participated-result")
	@Operation(summary = "get-bidder-participated-result")
	public ApiResponse<List<BidderParticipatedResultDto>> getBidderParticipatedResult(
			@RequestBody BidderResultModel bidderResultModel) {
		logger.info("/api/get-bidder-participated-result");
		try {
			
			BidderParticipatedResultModel bidderParticipatedModel = null;
			List<BidderParticipatedResultDto> res = new ArrayList<>();
			                                                               //just to remove , we have to take two model class.
			for (String bidderName : bidderResultModel.getBidder_name().split(",")) {
				bidderParticipatedModel = new BidderParticipatedResultModel();
				bidderParticipatedModel.setFrom_date(bidderResultModel.getFrom_date());
				bidderParticipatedModel.setTo_date(bidderResultModel.getTo_date());
				bidderParticipatedModel.setBidder_name(bidderName);
				
				res.addAll(resultService.getBidderParticipatedResult(bidderParticipatedModel).Data);
			}
			return new ApiResponse<List<BidderParticipatedResultDto>>(true, "Total 1 Record", true, res, 1);

		} catch (Exception ex) {
			return new ApiResponse<List<BidderParticipatedResultDto>>(false, ex.toString(), true, null, 0);
		}
	}

	/**
	 * To get related keyword from result_id .
	 * 
	 * @author Harsh 30/01/23
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/get-related-keyword-from-result-id")
	@Operation(summary = "get-related-keyword-from-result-id")
	public ApiResponse<List<RelatedKeywordDto>> getRelatedKeywordFromResultId(
			@RequestBody ResultDetailModel resultDetailModel) {
		logger.info("/api/get-related-keyword-from-result-id");
		return resultService.getRelatedKeywordFromResultId(resultDetailModel);
	}

	/**
	 * To get result document list .
	 * 
	 * @author jayesh + Harsh 31/01/23
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/get-document-list")
	@Operation(summary = "get result document list")
	public ApiResponse<List<ResultDocumentDto>> getResultUserDocumentlist(
			@RequestBody ResultDocumentModel resultDocumentModel) {
		return resultService.getResultUserDocumentlist(resultDocumentModel);
	}

	/**
	 * To get Similar Result
	 * 
	 * @author Parth 30/01/23
	 * @return List of appropriate Model/ DTO class
	 */
	@PostMapping("/get-similar-result")
	@Operation(summary = "get-similar-result")
	public ApiResponse<List<SimilarResultDto>> getSimilarResult(@RequestBody ResultDetailModel resultDetailModel) {
		logger.info("/api/get-similar-result");
		SimilarResultModel similarResultModel = new SimilarResultModel();

		try {                    //most of the values we are fetching from resultDtos and getting very first result.i.e.get(0);
			ResultDetailDto resultDtos = getResultDetatil(resultDetailModel).Data.get(0);
			
			similarResultModel.setResultId(resultDtos.getResult_id());
			
			similarResultModel.setKeywordIds(        //this method will return keywordId
					String.valueOf(getRelatedKeywordFromResultId(resultDetailModel).Data.get(0).getKeyword_id()));
			
			similarResultModel.setOrganization_id(String.valueOf(resultDtos.getOrganization_id()));
			
			similarResultModel.setContractValue(resultDtos.getContract_value().intValue()
					- ((resultDtos.getContract_value().intValue() * 30) / 100));
			
			similarResultModel.setSitelocationId(
					String.valueOf(getResultAnalyticsSiteLocationDetail(resultDetailModel).Data.get(0).getState_id()));
			
//resultId , keywordIds,  organization_id, contractValue ,sitelocationId all these values we are getting in similarResultModel using above code 
			
			System.out.println("the similar result model is :" + similarResultModel);
			return resultService.getSimilarResultDetail(similarResultModel);
		} catch (Exception e) {
			return new ApiResponse<List<SimilarResultDto>>(false, "No Data Found", false, null, 0);
		}
	}

	/**
	 * To get Analytics Result
	 * 
	 * @author Parth 30/01/23
	 * @return List of appropriate Model/ DTO class
	 */
	@PostMapping("/get-result-analytics-search")
	@Operation(summary = "get-result-analytics-search")
	public ApiResponse<List<ResultDto>> getResultAnalyticsSearch(@RequestBody ResultModel resultAnalyticSearchModel) {
		logger.info("/api/get-result-analytics-search");
		return resultService.getResultAnalyticsSearch(resultAnalyticSearchModel);
	}

	/**
	 * To get_participating_bidder .
	 * 
	 * @author Parth 21/02/23
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/get-participating-bidder")
	@Operation(summary = "get-participating-bidder")
	public ApiResponse<List<ParticipatingBidderDto>> getParticipatingBidder(
			@RequestBody ResultDetailModel resultDetailModel) {
		logger.info("/api/get-bidder-participated-result");
		return resultService.getParticipatingBidder(resultDetailModel);
	}

	/**
	 * To get Disclaimer
	 * 
	 * @author Harsh 04-03-2023
	 * @return List of appropriate Model / DTO class
	 */
	@GetMapping("/get-disclaimer")
	@Operation(summary = "get-disclaimer")
	public ApiResponse<String> getDisclaimer() {
		logger.info("/api/get-disclaimer");
		String disclaimer = PropertiesReader.getProperty("message", "DISCLAIMER");
		;
		return new ApiResponse<String>(true, "Total 1 Records", true, disclaimer, 1);
	}

	/**
	 * To add in fav tender result
	 * 
	 * @author Harsh 07-04-2023
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/insert-favorite-tender-result")
	@Operation(summary = "insert-favorite-tender-result")
	public ApiResponse<String> insertFavoriteTenderResult(@RequestBody FavoriteResultModel favoriteResultModel) {
		ApiResponse<Integer> fav_tender = resultService.insertFavoriteTenderResult(favoriteResultModel);
		if (fav_tender.Data == 1) {
			return new ApiResponse<String>(true, "Total 1 Record", true, recordInserted, 1);
		} else {
			return new ApiResponse<String>(false, "Total 1 Record", false, recordNotInserted, 0);
		}
	}

	/**
	 * To get-Result-Analytics-SiteLocation-Detail
	 * 
	 * @author Jayesh 14/04/23
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/get-result-analytics-site-location-detail")
	@Operation(summary = "get-result-analytics-site-location-detail")
	public ApiResponse<List<ResultAnalyticsSiteLocationDetailDto>> getResultAnalyticsSiteLocationDetail(
			@RequestBody ResultDetailModel resultDetailModel) {
		logger.info("/api/get-result-detail");
		return resultService.getResultAnalyticsSiteLocationDetail(resultDetailModel);
	}

}
