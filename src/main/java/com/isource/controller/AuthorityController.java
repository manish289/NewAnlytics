package com.isource.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isource.dto.authority.OrganizationDto;
import com.isource.dto.authority.OrganizationTypeDto;
import com.isource.model.authority.AuthorityFilterModel;
import com.isource.service.AuthorityService;
import com.isource.utility.ApiResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin("*")
@RestController
@RequestMapping("api")
@Tag(name="all-masters")
@Lazy
public class AuthorityController {

	@Lazy
	private AuthorityService authorityService;
	private Logger logger = null;

	@Lazy
	public AuthorityController(AuthorityService authorityService) {
		this.authorityService = authorityService;
		logger = Logger.getLogger(AuthorityController.class);
	}

	/**
	 * To get Organization type
	 * 
	 * @author Jayesh 
	 * @date 12/01/2023
	 * @return List of appropriate Model / DTO class
	 */
	@GetMapping("/get-organization-type")
	@Operation(summary = "get-all-organizationType")
	public ApiResponse<List<OrganizationTypeDto>> getOrganizationType() {
		logger.info("/api/get-organization-type");
		return authorityService.getOrganizationType();
	}

	/**
	 * To get Organization.
	 * 
	 * @author Jayesh 
	 * @date 12/01/2023
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/get-organization")
	@Operation(summary = "get-all-organization")
	public ApiResponse<List<OrganizationDto>> getOrganization(AuthorityFilterModel authorityFilter) {
		logger.info("/api/get-organization");
		return authorityService.getOrganization(authorityFilter);
	}

}
