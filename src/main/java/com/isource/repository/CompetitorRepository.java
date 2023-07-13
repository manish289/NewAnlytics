package com.isource.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.isource.connection.web.DbContextServiceWeb;
import com.isource.dto.competitors.CompetitorsDto;
import com.isource.dto.competitors.ShortListChartMonthwiseDto;
import com.isource.dto.competitors.ShortListCompetitorsListDto;
import com.isource.dto.competitors.TopCompetitorListChartDto;
import com.isource.model.competitors.CompetitorsModel;
import com.isource.model.competitors.ShortListCompetitorsModel;
import com.isource.model.competitors.ShortListCompetitorsMonthWiseModel;
import com.isource.model.competitors.TopCompetitorsMonthWiseModel;
import com.isource.query.QueryMasters;
import com.isource.service.CacheManagerService;
import com.isource.service.CompetitorService;
import com.isource.utility.ApiResponse;

@Repository
@Lazy
public class CompetitorRepository implements CompetitorService {

	private Logger logger = null;
	@Lazy
	private DbContextServiceWeb _DbContextserviceWeb;
	@Lazy
	private CacheManagerService cacheManagerService;

	@Lazy
	public CompetitorRepository(DbContextServiceWeb _DbContextserviceWeb, CacheManagerService cacheManagerService) {
		this._DbContextserviceWeb = _DbContextserviceWeb;
		this.cacheManagerService = cacheManagerService;
		logger = Logger.getLogger(CompetitorRepository.class);
	}

	@Override
	public ApiResponse<List<CompetitorsDto>> getGeneralCompetitorList(CompetitorsModel competitorsModel) {

		List<CompetitorsDto> competitorsDto = null;
		try {
			logger.info("Start GeneralCompetitorList ");
			Object param[] = { 
					competitorsModel.getFrom_date(), 
					competitorsModel.getTo_date(),
					competitorsModel.getBidder_name(),
					competitorsModel.getParticipate_bidder_name(),
					competitorsModel.getState_ids(),
					competitorsModel.getKeyword_ids(),
					competitorsModel.getOrganization_name(), 
					competitorsModel.getOrganization_type_name(),
					competitorsModel.getPage_no(),
					competitorsModel.getRecord_per_page(),
					competitorsModel.getSort_by(),
					competitorsModel.getSort_type()};
			
			competitorsDto = _DbContextserviceWeb.QueryToListWithParam(
					QueryMasters.competitor_get_general_competitors_list, param, CompetitorsDto.class);
		
			logger.info("End GeneralCompetitorList ");
			
			return new ApiResponse<List<CompetitorsDto>>(true, "Total " + competitorsDto.size() + " Records", true,
					competitorsDto, competitorsDto.size());
			
		} catch (Exception ex) {
			logger.info("getGeneralCompetitorList Exception : " + ex.toString());
			return new ApiResponse<List<CompetitorsDto>>(false, ex.toString(), false, competitorsDto, 0);
		}
	}

	@Override
	public ApiResponse<List<CompetitorsDto>> getTopCompetitorList(CompetitorsModel competitorsModel) {

		List<CompetitorsDto> competitorsDto = null;
		try {
			logger.info("Start TopCompetitorList ");
			
			competitorsDto = cacheManagerService.getTopCompetitorList(competitorsModel);
			
			logger.info("End TopCompetitorList ");
			
			return new ApiResponse<List<CompetitorsDto>>(true, "Total " + competitorsDto.size() + " Records", true,
					competitorsDto, competitorsDto.size());
		} catch (Exception ex) {
			logger.info("getTopCompetitorList Exception : " + ex.toString());
			return new ApiResponse<List<CompetitorsDto>>(false, ex.toString(), false, competitorsDto, 0);
		}
	}

	@Override
	public ApiResponse<List<TopCompetitorListChartDto>> getTopCompetitorListChart(
			TopCompetitorsMonthWiseModel topCompetitorsMonthWiseModel) {

		List<TopCompetitorListChartDto> topCompetitorListChartDto = null;
		try {
			logger.info("Start TopCompetitorListChart ");

			topCompetitorListChartDto = cacheManagerService.getTopCompetitorListChart(topCompetitorsMonthWiseModel);
			logger.info("End TopCompetitorList ");
			return new ApiResponse<List<TopCompetitorListChartDto>>(true,
					"Total " + topCompetitorListChartDto.size() + " Records", true, topCompetitorListChartDto,
					topCompetitorListChartDto.size());
		} catch (Exception ex) {
			logger.info("getTopCompetitorListChart Exception : " + ex.toString());
			return new ApiResponse<List<TopCompetitorListChartDto>>(false, ex.toString(), false,
					topCompetitorListChartDto, 0);
		}
	}

	@Override
	public ApiResponse<List<ShortListCompetitorsListDto>> getShortListCompetitors(
			ShortListCompetitorsModel shortListCompetitorsModel) {

		List<ShortListCompetitorsListDto> shortListCompetitorsDto = null;
		try {
			logger.info("Start ShortListCompetitor ");
			logger.info("From Cache ShortListCompetitor ");
			shortListCompetitorsDto = cacheManagerService.getShortListCompetitors(shortListCompetitorsModel);
			logger.info("End getTopCompetitorList Repository ");
			return new ApiResponse<List<ShortListCompetitorsListDto>>(true,
					"Total " + shortListCompetitorsDto.size() + " Records", true, shortListCompetitorsDto,
					shortListCompetitorsDto.size());
		} catch (Exception ex) {
			logger.info("getShortListCompetitors Exception : " + ex.toString());
			return new ApiResponse<List<ShortListCompetitorsListDto>>(false, ex.toString(), false,
					shortListCompetitorsDto, 0);
		}
	}

	@Override
	public ApiResponse<List<ShortListChartMonthwiseDto>> getShortListCompetitorsChartMonthwise(
			ShortListCompetitorsMonthWiseModel shortListCompetitorsMonthWiseModel) {

		List<ShortListChartMonthwiseDto> shortListChartMonthwiseDto = null;
		try {
			logger.info("Start ShortListChartMonthwiseDto ");
			shortListChartMonthwiseDto = cacheManagerService
					.getShortListCompetitorsChartMonthwise(shortListCompetitorsMonthWiseModel);
			logger.info("End ShortListChartMonthwiseDto ");
			return new ApiResponse<List<ShortListChartMonthwiseDto>>(true,
					"Total " + shortListChartMonthwiseDto.size() + " Records", true, shortListChartMonthwiseDto,
					shortListChartMonthwiseDto.size());
		} catch (Exception ex) {
			logger.info("getShortListCompetitorsChartMonthwise Exception : " + ex.toString());
			return new ApiResponse<List<ShortListChartMonthwiseDto>>(false, ex.toString(), false,
					shortListChartMonthwiseDto, 0);
		}
	}

	@Override
	public ApiResponse<List<ShortListCompetitorsListDto>> getShortListCompetitorsUpdate(
			ShortListCompetitorsModel shortListCompetitorsModel) {
		List<ShortListCompetitorsListDto> shortListCompetitorsDto = null;
		try {
			logger.info("Start ShortListCompetitor ");
			shortListCompetitorsDto = cacheManagerService.getShortListCompetitorsUpdate(shortListCompetitorsModel);
			logger.info("End ShortListCompetitor ");
			return new ApiResponse<List<ShortListCompetitorsListDto>>(true,
					"Total " + shortListCompetitorsDto.size() + " Records", true, shortListCompetitorsDto,
					shortListCompetitorsDto.size());
		} catch (Exception ex) {
			logger.info("getShortListCompetitors Exception : " + ex.toString());
			return new ApiResponse<List<ShortListCompetitorsListDto>>(false, ex.toString(), false,
					shortListCompetitorsDto, 0);
		}
	}

}
