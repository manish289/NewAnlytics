package com.isource.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.isource.connection.web.DbContextServiceWeb;
import com.isource.dto.watchlist.WatchListDto;
import com.isource.model.watchlist.WatchListDeleteModel;
import com.isource.model.watchlist.WatchListInsertModel;
import com.isource.query.QueryMasters;
import com.isource.service.CacheManagerService;
import com.isource.service.WatchListService;
import com.isource.utility.ApiResponse;

@Repository
@Lazy
public class WatchListRepository implements WatchListService {

	private Logger logger = null;
	@Lazy
	private CacheManagerService cacheManagerService;
	@Lazy
	private DbContextServiceWeb _DbContextserviceWeb;
	@Lazy
	public WatchListRepository(CacheManagerService cacheManagerService, DbContextServiceWeb _DbContextserviceWeb) {
		this.cacheManagerService = cacheManagerService;
		this._DbContextserviceWeb = _DbContextserviceWeb;
		logger = Logger.getLogger(WatchListRepository.class);
	}
	
	@Override
	public ApiResponse<List<WatchListDto>> getAllWatchList() {

		List<WatchListDto> watchListDto = null;
		try {
			logger.info("Start getAllWatchList ");
			watchListDto = cacheManagerService.getWatchList();
			logger.info("End getAllWatchList ");
			return new ApiResponse<List<WatchListDto>>(true, "Total " + watchListDto.size() + " Records", true,
					watchListDto, watchListDto.size());
		} catch (Exception ex) {
			logger.info("getWatchList Exception : " + ex.toString());
			return new ApiResponse<List<WatchListDto>>(false, ex.toString(), true, watchListDto, 0);
		}
	}

	@Override
	public ApiResponse<Integer> getWatchListDelete(WatchListDeleteModel watchListDeleteModel) {
		Object Param[] = { watchListDeleteModel.getBidder_id(),watchListDeleteModel.getBidder_name() };
		logger.info("Start WatchlistDelete ");
		try {
			int	 resultset  = _DbContextserviceWeb.QueryToFirstWithInt(QueryMasters.watch_list_delete, Param);
			logger.info("End WatchlistDelete ");
			
			return new ApiResponse<Integer>(true, "Total " + resultset + " Records", true, resultset, 1);
		} catch (Exception ex) {
			logger.info("getWatchListDelete Exception : " + ex.toString());
			return new ApiResponse<Integer>(false, ex.toString(), true, null, 0);
		}
	}

	@Override
	public ApiResponse<Integer> getWatchListInsert(WatchListInsertModel watchListInsertModel) {
		try {
			Object Param[] = { 
					watchListInsertModel.getUser_id(), 
					watchListInsertModel.getBidder_id(),
					watchListInsertModel.getBidder_name()
					};
			logger.info("Start WatchlistInsert ");
			
			int resultset = _DbContextserviceWeb.QueryToFirstWithInt(QueryMasters.watchlist_insert, Param);
			
			logger.info("End WatchlistInsert ");
			return new ApiResponse<Integer>(true, "Total " + resultset + " Records", true, resultset, 1);
		} catch (Exception ex) {
			logger.info("insertUserProfile Exception : " + ex.toString());
			return new ApiResponse<Integer>(false, ex.toString(), true, null, 0);
		}
	}
	
}
