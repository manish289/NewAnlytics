package com.isource.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isource.dto.location.CityDto;
import com.isource.dto.location.RegionDto;
import com.isource.dto.location.StateDto;
import com.isource.model.location.LocationFilterModel;
import com.isource.service.LocationService;
import com.isource.utility.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin("*")
@RestController
@RequestMapping("api")
@Tag(name="all-masters")
@Lazy
public class LocationController {

	@Lazy
	private LocationService locationService;
	private Logger logger = null;

	@Lazy
	public LocationController(LocationService locationService) {
		this.locationService = locationService;
		logger = Logger.getLogger(LocationController.class);
	}

	/**
	 * To get Region.
	 * 
	 * @author Jayesh
	 * @date 12/01/2023
	 * @return List of appropriate Model / DTO class
	 */
	@GetMapping("/get-region")
	@Operation(summary = "get-all-region")
	public ApiResponse<List<RegionDto>> getAllRegion() {
		logger.info("/api/get-region");
		return locationService.getAllRegion();
	}

	/**
	 * To get City.
	 * 
	 * @author Jayesh
	 * @date 12/01/2023
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/get-city")
	@Operation(summary = "get-all-city")
	public ApiResponse<List<CityDto>> getAllCity(LocationFilterModel locationFilter) {
		logger.info("/api/get-all-city >>");
		return locationService.getAllCity(locationFilter);
	}

	/**
	 * To get State.
	 * 
	 * @author Jayesh
	 * @date 12/01/2023
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/get-state")
	@Operation(summary = "get-all-state")
	public ApiResponse<List<StateDto>> getAllState(LocationFilterModel locationFilter) {
		logger.info("/api/get-all-state");
		return locationService.getAllState(locationFilter);
	}

}
