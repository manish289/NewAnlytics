package com.isource.service;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.isource.dto.result.BidderParticipatedResultDto;
import com.isource.dto.result.ParticipatingBidderDto;
import com.isource.dto.result.RelatedKeywordDto;
import com.isource.dto.result.ResultAnalyticsSiteLocationDetailDto;
import com.isource.dto.result.ResultDetailDto;
import com.isource.dto.result.ResultDocumentDto;
import com.isource.dto.result.ResultDto;
import com.isource.dto.result.SimilarResultDto;
import com.isource.model.dashboard.BidderParticipatedResultModel;
import com.isource.model.result.FavoriteResultModel;
import com.isource.model.result.ResultDetailModel;
import com.isource.model.result.ResultDocumentModel;
import com.isource.model.result.ResultModel;
import com.isource.model.result.SimilarResultModel;
import com.isource.utility.ApiResponse;

@Service
@Lazy
public interface ResultService {

	ApiResponse<List<ResultDetailDto>> getResultDetatil(ResultDetailModel resultDetailModel);
	ApiResponse<List<BidderParticipatedResultDto>> getBidderParticipatedResult(BidderParticipatedResultModel bidderParticipatedResultModel);
	ApiResponse<List<RelatedKeywordDto>> getRelatedKeywordFromResultId(ResultDetailModel resultDetailModel);
	ApiResponse<List<ResultDocumentDto>> getResultUserDocumentlist(ResultDocumentModel resultDocumentModel);
	ApiResponse<List<SimilarResultDto>>getSimilarResult(ResultDetailModel resultDetailModel);
	ApiResponse<List<ResultDto>>getResultAnalyticsSearch(ResultModel resultAnalyticSearchModel);
	ApiResponse<List<SimilarResultDto>>getSimilarResultDetail(SimilarResultModel similarResultModel);
	ApiResponse<List<ParticipatingBidderDto>>getParticipatingBidder(ResultDetailModel resultDetailModel);
	ApiResponse<Integer>insertFavoriteTenderResult(FavoriteResultModel favoriteResultModel);
	ApiResponse<List<ResultAnalyticsSiteLocationDetailDto>> getResultAnalyticsSiteLocationDetail(ResultDetailModel resultDetailModel);
}
