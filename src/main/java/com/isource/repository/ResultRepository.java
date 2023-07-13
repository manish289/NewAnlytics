package com.isource.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.isource.connection.web.DbContextServiceWeb;
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
import com.isource.query.QueryMasters;
import com.isource.service.ResultService;
import com.isource.utility.ApiResponse;

@Repository
@Lazy
public class ResultRepository implements ResultService {

	private Logger logger = null;
	@Lazy
	private DbContextServiceWeb _DbContextserviceWeb;

	@Lazy
	public ResultRepository(DbContextServiceWeb _DbContextserviceWeb) {
		this._DbContextserviceWeb = _DbContextserviceWeb;
		logger = Logger.getLogger(ResultRepository.class);
	}

	@Override
	public ApiResponse<List<ResultDetailDto>> getResultDetatil(ResultDetailModel resultDetailModel) {

		List<ResultDetailDto> resultDetailDtos = null;
		try {
			logger.info("Start ResultDetatil ");
			Object[] param = { resultDetailModel.getResult_id() };
			
			resultDetailDtos = _DbContextserviceWeb.QueryToListWithParam(QueryMasters.result_analytics_detail, param,
					ResultDetailDto.class);
			logger.info("End ResultDetatil ");
			
			return new ApiResponse<List<ResultDetailDto>>(true, "Total Record " + resultDetailDtos.size() + " ", true,
					resultDetailDtos, resultDetailDtos.size());
		} catch (Exception ex) {
			logger.info("getResultDetatil Exception : " + ex.toString());
			return new ApiResponse<List<ResultDetailDto>>(false, ex.toString(), false, resultDetailDtos, 0);
		}
	}

	@Override
	public ApiResponse<List<BidderParticipatedResultDto>> getBidderParticipatedResult(
			BidderParticipatedResultModel bidderParticipatedResultModel) {

		List<BidderParticipatedResultDto> bidderParticipatedResult = null;
		try {
			logger.info("Start BidderParticipatedResult ");
			Object param[] = { bidderParticipatedResultModel.getFrom_date(), bidderParticipatedResultModel.getTo_date(),
					bidderParticipatedResultModel.getBidder_name()
			};
			bidderParticipatedResult = _DbContextserviceWeb.QueryToListWithParam(
					QueryMasters.get_bidder_participated_result, param, BidderParticipatedResultDto.class);
			logger.info("End BidderParticipatedResult ");
			
			return new ApiResponse<List<BidderParticipatedResultDto>>(true,
					"Total " + bidderParticipatedResult.size() + " Records", true, bidderParticipatedResult,
					bidderParticipatedResult.size());
		} catch (Exception ex) {
			logger.info("getBidderParticipatedResult Exception : " + ex.toString());
			return new ApiResponse<List<BidderParticipatedResultDto>>(false, ex.toString(), true,
					bidderParticipatedResult, 0);
		}
	}

	@Override
	public ApiResponse<List<RelatedKeywordDto>> getRelatedKeywordFromResultId(ResultDetailModel resultDetailModel) {
		List<RelatedKeywordDto> relatedKeywordDto = null;
		try {
			logger.info("Start RelatedKeywordFromResultId ");
			Object param[] = { resultDetailModel.getResult_id() };
			relatedKeywordDto = _DbContextserviceWeb.QueryToListWithParam(
					QueryMasters.get_related_keyword_from_result_id, param, RelatedKeywordDto.class);
			logger.info("End RelatedKeywordFromResultId ");
			return new ApiResponse<List<RelatedKeywordDto>>(true, "Total " + relatedKeywordDto.size() + " Records",
					true, relatedKeywordDto, relatedKeywordDto.size());
		} catch (Exception ex) {
			logger.info("getRelatedKeywordFromResultId Exception : " + ex.toString());
			return new ApiResponse<List<RelatedKeywordDto>>(false, ex.toString(), true, relatedKeywordDto, 0);
		}
	}

	@Override
	public ApiResponse<List<ResultDocumentDto>> getResultUserDocumentlist(ResultDocumentModel resultDocumentModel) {

		List<ResultDocumentDto> resultDocument = null;

		try {
			logger.info("Start UserResultDocument");
			Object Param[] = { resultDocumentModel.getResult_id() };
			
			resultDocument = _DbContextserviceWeb.QueryToListWithParam(QueryMasters.result_analytics_document_detail,
					Param, ResultDocumentDto.class);
			logger.info("End UserResultDocument ");
			
			return new ApiResponse<List<ResultDocumentDto>>(true, "Total " + resultDocument.size() + " Records", true,
					resultDocument, resultDocument.size());
		} catch (Exception ex) {
			logger.info("getResultUserDocumentlist Exception : " + ex.toString());
			return new ApiResponse<List<ResultDocumentDto>>(false, ex.toString(), true, resultDocument, 0);
		}
	}

	@Override
	public ApiResponse<List<SimilarResultDto>> getSimilarResult(ResultDetailModel resultDetailModel) {
		Object[] param = { resultDetailModel.getResult_id() };
		List<SimilarResultDto> similarResultDto = null;
		try {
			logger.info("Start SimilarResult");
			similarResultDto = _DbContextserviceWeb.QueryToListWithParam(QueryMasters.get_similar_result_by_result_id,
					param, SimilarResultDto.class);
			logger.info("End SimilarResult ");
			return new ApiResponse<List<SimilarResultDto>>(true, "Total Record " + similarResultDto.size() + " ", true,
					similarResultDto, similarResultDto.size());
		} catch (Exception ex) {
			logger.info("getSimilarResult Exception : " + ex.toString());
			return new ApiResponse<List<SimilarResultDto>>(false, ex.toString(), false, similarResultDto, 0);
		}
	}

	@Override
	public ApiResponse<List<ResultDto>> getResultAnalyticsSearch(ResultModel resultAnalyticSearchModel) {

		Object[] param = { resultAnalyticSearchModel.getResult_id(), 
				resultAnalyticSearchModel.getSearch_text(),
				resultAnalyticSearchModel.getContract_date_from(), 
				resultAnalyticSearchModel.getContract_date_to(),
				resultAnalyticSearchModel.getPublication_date_from(),
				resultAnalyticSearchModel.getPublication_date_to(), 
				resultAnalyticSearchModel.getState_ids(),
				resultAnalyticSearchModel.getCity_ids(), 
				resultAnalyticSearchModel.getKeyword_ids(),
				resultAnalyticSearchModel.getOrganization_name(), 
				resultAnalyticSearchModel.getOrganization_type_name(),
				resultAnalyticSearchModel.getTender_value_operator(),
				resultAnalyticSearchModel.getContract_value_operator(),
				resultAnalyticSearchModel.getContract_value_from(), 
				resultAnalyticSearchModel.getContract_value_to(),
				resultAnalyticSearchModel.getTender_value_from(), 
				resultAnalyticSearchModel.getTender_value_to(),
				resultAnalyticSearchModel.getBidder_name(),
				resultAnalyticSearchModel.getParticipant_name(), 
				resultAnalyticSearchModel.getWinner_bidder(),
				resultAnalyticSearchModel.getStage(), 
				resultAnalyticSearchModel.getSort_by(),
				resultAnalyticSearchModel.getSort_type(), 
				resultAnalyticSearchModel.getPage_no(),
				resultAnalyticSearchModel.getRecord_per_page(),
				resultAnalyticSearchModel.getTender_status() };
		List<ResultDto> resultAnalyticSearchDto = null;
		try {
			logger.info("Start ResultAnalyticsSearch ");
			resultAnalyticSearchDto = _DbContextserviceWeb.QueryToListWithParam(QueryMasters.result_analytics_search,
					param, ResultDto.class);
			logger.info("End ResultAnalyticsSearch ");
			return new ApiResponse<List<ResultDto>>(true, "Total Record " + resultAnalyticSearchDto.size() + " ", true,
					resultAnalyticSearchDto, resultAnalyticSearchDto.size());
		} catch (Exception ex) {
			logger.info("getResultAnalyticsSearch Exception : " + ex.toString());
			return new ApiResponse<List<ResultDto>>(false, ex.toString(), false, resultAnalyticSearchDto, 0);
		}
	}

	@Override
	public ApiResponse<List<SimilarResultDto>> getSimilarResultDetail(SimilarResultModel similarResultModel) {
		Object[] param = { similarResultModel.getResultId(), similarResultModel.getKeywordIds(), similarResultModel.getSitelocationId(),
				similarResultModel.getContractValue(), similarResultModel.getOrganization_id() };
		List<SimilarResultDto> similarResultDto = null;
		try {
			logger.info("Start SimilarResultDetail ");
			similarResultDto = _DbContextserviceWeb.QueryToListWithParam(QueryMasters.get_similar_result, param,
					SimilarResultDto.class);
			logger.info("End SimilarResultDetail ");
			return new ApiResponse<List<SimilarResultDto>>(true, "Total Record " + similarResultDto.size() + " ", true,
					similarResultDto, similarResultDto.size());
		} catch (Exception ex) {
			logger.info("SimilarResultDetail Exception : " + ex.toString());
			return new ApiResponse<List<SimilarResultDto>>(false, ex.toString(), false, similarResultDto, 0);
		}
	}

	@Override
	public ApiResponse<List<ParticipatingBidderDto>> getParticipatingBidder(ResultDetailModel resultDetailModel) {

		List<ParticipatingBidderDto> participatingBidderDto = null;
		try {
			logger.info("Start ParticipatingBidder ");
			Object param[] = { resultDetailModel.getResult_id() };
			participatingBidderDto = _DbContextserviceWeb.QueryToListWithParam(QueryMasters.get_participating_bidder,
					param, ParticipatingBidderDto.class);
			logger.info("End ParticipatingBidder ");
			return new ApiResponse<List<ParticipatingBidderDto>>(true,
					"Total " + participatingBidderDto.size() + " Records", true, 
					participatingBidderDto,
					participatingBidderDto.size());
		} catch (Exception ex) {
			logger.info("ParticipatingBidder Exception : " + ex.toString());
			return new ApiResponse<List<ParticipatingBidderDto>>(false, ex.toString(), true, participatingBidderDto, 0);
		}
	}

	@Override
	public ApiResponse<Integer> insertFavoriteTenderResult(FavoriteResultModel favoriteResultModel) {
		try {
			Object Param[] = { favoriteResultModel.getUser_id(), favoriteResultModel.getResult_id(),
					favoriteResultModel.getIs_favorite() };
			logger.info("Start insert Favorite Tender ");
			int resultset = _DbContextserviceWeb.QueryToFirstWithInt(QueryMasters.insert_fav_tender, Param);
			logger.info("End insert Favorite Tender ");
			return new ApiResponse<Integer>(true, "Total " + resultset + " Records", true, resultset, 1);
		} catch (Exception ex) {
			logger.info("insert Favorite Tender  Exception : " + ex.toString());
			return new ApiResponse<Integer>(false, ex.toString(), true, null, 0);
		}
	}

	@Override
	public ApiResponse<List<ResultAnalyticsSiteLocationDetailDto>> getResultAnalyticsSiteLocationDetail(
			ResultDetailModel resultDetailModel) {
		List<ResultAnalyticsSiteLocationDetailDto> resultAnalyticsSiteLocationDetailDto = null;
		Object[] param = { resultDetailModel.getResult_id() };
		try {
			logger.info("Start result_analytics_sitelocation_detail ");
			resultAnalyticsSiteLocationDetailDto = _DbContextserviceWeb.QueryToListWithParam(
					QueryMasters.result_analytics_sitelocation_detail, param,
					ResultAnalyticsSiteLocationDetailDto.class);
			
			System.out.println("resultDetailModel : "+resultDetailModel.getResult_id());
			System.out.println("ResultAnalyticsSiteLocationDetailDto : " + resultAnalyticsSiteLocationDetailDto);
			logger.info("End result_analytics_sitelocation_detail ");
			
			return new ApiResponse<List<ResultAnalyticsSiteLocationDetailDto>>(true, "Total Record " + resultAnalyticsSiteLocationDetailDto.size() + " ", true,
					resultAnalyticsSiteLocationDetailDto, resultAnalyticsSiteLocationDetailDto.size());
		} catch (Exception ex) {
			logger.info("getResultDetatil Exception : " + ex.toString());
			return new ApiResponse<List<ResultAnalyticsSiteLocationDetailDto>>(false, ex.toString(), false,
					resultAnalyticsSiteLocationDetailDto, 0);
		}
	}
}
