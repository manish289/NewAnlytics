package com.isource.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isource.dto.watchlist.WatchListDto;
import com.isource.model.watchlist.WatchListDeleteModel;
import com.isource.model.watchlist.WatchListInsertModel;
import com.isource.service.WatchListService;
import com.isource.utility.ApiResponse;
import com.isource.utility.PropertiesReader;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin("*")
@RestController
@RequestMapping("api")
@Tag(name="page - 4 competitor-controller")
@Lazy
public class WatchListController {

	@Lazy
	private WatchListService watchListService;
	private Logger logger = null;

	private String recordUpdate = PropertiesReader.getProperty("message", "RECORD_UPDATED");
	private String recordNotUpdate = PropertiesReader.getProperty("message", "RECORD_NOT_UPDATED");
	
	private String recordInserted = PropertiesReader.getProperty("message", "RECORD_INSERTED");
	private String recordNotInserted = PropertiesReader.getProperty("message", "RECORD_NOT_INSERTED");
	
	@Lazy
	public WatchListController(WatchListService watchListService) {
		this.watchListService = watchListService;
		logger = Logger.getLogger(WatchListController.class);
	}

	/**
	 * To get Watch List
	 * 
	 * @author Jayesh
	 * @date 12/01/2023
	 * @return List of appropriate Model / DTO class
	 */
	@GetMapping("/get-watchlist")
	@Operation(summary = "get-all-the-watchlist")
	public ApiResponse<List<WatchListDto>> getAllWatchList() {
		logger.info("/api/get-watchlist-->>");
		return watchListService.getAllWatchList();
	}

	/**
	 * To get Watch List Delete Update.
	 * 
	 * @author Jayesh
	 * @date 12/01/2023
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/watchlist-delete")
	@Operation(summary = "get-all-the-watch-list-delete")
	public ApiResponse<String> watchListDelete(@RequestBody WatchListDeleteModel watchListDeleteModel) {
		logger.info("/api/getWatchListDelete-->>");
		ApiResponse<Integer> watchListDelete = watchListService
				.getWatchListDelete(watchListDeleteModel);
		if (watchListDelete != null) {
			return new ApiResponse<String>(true, "Total 1 Record", true, recordUpdate, 1);
		} else {
			return new ApiResponse<String>(false, "Total 1 Record", false, recordNotUpdate, 0);
		}
	}

	/**
	 * To get Watch List Insert
	 * 
	 * @author Jayesh
	 * @date 12/01/2023
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/watchlist-insert")
	@Operation(summary = "get-all-the-watch-list-insert")
	public ApiResponse<String> watchListInsert(@RequestBody WatchListInsertModel watchListInsertModel) {
		logger.info("/api/get-all-the-watch-list-insert-->>");
		ApiResponse<Integer> watchListInsert = watchListService
				.getWatchListInsert(watchListInsertModel);
		if (watchListInsert.Data == 1) {
			return new ApiResponse<String>(true, "Total 1 Record", true, recordInserted, 1);
		} else {
			return new ApiResponse<String>(false, "Total 1 Record", false, recordNotInserted, 0);
		}
	}
}
