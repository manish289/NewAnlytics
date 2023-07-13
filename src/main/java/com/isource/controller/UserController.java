package com.isource.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.isource.config.jwt.TenderApiTokenUtil;
import com.isource.config.jwt.TenderApiUserDetailsService;
import com.isource.dto.user.LoginResponseDto;
import com.isource.dto.user.UserBidderDto;
import com.isource.dto.user.UserProfileDto;
import com.isource.dto.user.User_Dto;
import com.isource.model.user.ChangePasswordModel;
import com.isource.model.user.UserModel;
import com.isource.model.user.UserProfileDetailModel;
import com.isource.model.user.UserProfileModel;
import com.isource.service.UserService;
import com.isource.utility.ApiResponse;
import com.isource.utility.PropertiesReader;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin("*")
@RestController
@RequestMapping("api")
@Tag(name="page - 9 user-controller")
@Lazy
public class UserController {

	private Logger logger = null;
	
	@Lazy
	private UserService userService = null;
	@Lazy
	private TenderApiTokenUtil tenderApiTokenUtil;
	@Lazy
	private TenderApiUserDetailsService tenderApiUserDetailsService;

	private String invalidUserCredential = PropertiesReader.getProperty("message", "INVALID_USER_CREDENTIAL");
	private String validUserCredential = PropertiesReader.getProperty("message", "VALID_USER_CREDENTIAL");
	
	private String recordUpdate = PropertiesReader.getProperty("message", "RECORD_UPDATED");
	private String recordNotUpdate = PropertiesReader.getProperty("message", "RECORD_NOT_UPDATED");
	
	private String recordInserted = PropertiesReader.getProperty("message", "RECORD_INSERTED");
	private String recordNotInserted = PropertiesReader.getProperty("message", "RECORD_NOT_INSERTED");
	
	@Lazy
	public UserController(UserService userService, TenderApiTokenUtil tenderApiTokenUtil,
			TenderApiUserDetailsService tenderApiUserDetailsService) {
		this.userService = userService;
		this.tenderApiTokenUtil = tenderApiTokenUtil;
		this.tenderApiUserDetailsService = tenderApiUserDetailsService;
		logger = Logger.getLogger(UserController.class);
	}

	/**
	 * To get User Login
	 * 
	 * @author Harsh 12/01/23
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/user-login")                              //enables a servlet to formulate an HTTP response to a client.
	@Operation(summary = "user-login")                       //in refered task jwtRequest is mapped and used insted of HttpServletRequest  
	public ApiResponse<LoginResponseDto> userLogin(@RequestBody UserModel userModel, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		logger.info("/api/user-login-->>");
		
		userModel.setIp_address(CommonController.getIP(request, response));       //getIP will give the the remote ipAddress
		Gson gson = new Gson();
		String data = gson.toJson(userModel);
		
		final UserDetails userDetails = tenderApiUserDetailsService.loadUserByUsername(data);  // data will have ip address..& also other usermodel fields.
		                                                                                        //this method will connect to Repository to get from databases.
	//userdetails will have data of User_Data after going in further steps.
		User_Dto user_Dto = gson.fromJson(userDetails.getUsername(), User_Dto.class);
		
		System.out.println("user_Dto : "+user_Dto);
		
		if ( user_Dto.getUser_id()==0 || 
			 user_Dto.getCompany_name()==null ||
			 user_Dto.getPerson_name() == null ||
			 user_Dto.getValid_upto() == null ) {
			return new ApiResponse<LoginResponseDto>(false, invalidUserCredential, true, null, 0);
		} else {
			
			final String token = tenderApiTokenUtil.generateToken(userDetails);   // this will generate the token
			
			LoginResponseDto loginResponseDto = new LoginResponseDto();
			loginResponseDto.setUser_id(user_Dto.getUser_id());
			loginResponseDto.setPerson_name(user_Dto.getPerson_name());
			loginResponseDto.setCompany_name(user_Dto.getCompany_name());
			loginResponseDto.setValid_upto(user_Dto.getValid_upto());
			loginResponseDto.setToken(token);
			return new ApiResponse<LoginResponseDto>(true, validUserCredential, true, loginResponseDto, 1);
		}
	}

	/**
	 * To Change Password
	 * 
	 * @author jayesh 12/01/23
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/change-password")
	@Operation(summary = "change-password")
	public ApiResponse<String> changePassword(@RequestBody ChangePasswordModel changePasswordModel) {
		
		ApiResponse<Integer> changePass = userService.changePassword(changePasswordModel);
		logger.info("api/change-password-->>");
		if (changePass.Data != 0) {
	 		return new ApiResponse<String>(true, "Total 1 Record", true, recordUpdate, 1);
		} else {
			return new ApiResponse<String>(false, "Total 1 Record", false, recordNotUpdate, 0);
		}
	}

	/**
	 * To get Result Stage.
	 * 
	 * @return List of appropriate Model / DTO class
	 */
	@GetMapping("/get-user-bidder")
	@Operation(summary = "get-user-bidder")
	public ApiResponse<List<UserBidderDto>> getUserBidder() {
		
		logger.info("/api/get-result-stage-->>");
		
		return userService.getUserBidder();
	}
	
	/**
	 * To insert User Profile
	 * 
	 * @author Harsh
	 * @date 18-02-2023
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/insert-user-profile")
	@Operation(summary = "insert-user-profile")
	public ApiResponse<String> insertUserProfile(@RequestBody UserProfileModel userProfileModel) {
		logger.info("api/insert-user-profile");
		if (userService.insertUserProfile(userProfileModel).Data == 1) {
			return new ApiResponse<String>(true, "Total 1 Record", true, recordInserted, 1);
		} else {
			return new ApiResponse<String>(false, "Total 1 Record", false, recordNotInserted, 0);
		}
	}
	
	/**
	 * To get User Profile Detail.
	 * 
	 * @author Parth
	 * @date 18/02/23
	 * @return List of appropriate Model / DTO class
	 */
	@PostMapping("/get-user-profile-detail")
	@Operation(summary = "get-user-profile-detail")
	public ApiResponse<List<UserProfileDto>> getUserProfileDetail(@RequestBody UserProfileDetailModel userProfileDetailModel) {
		logger.info("/api/get-user-profile-detail-->>");
		return userService.getUserProfileDetail(userProfileDetailModel);
	}
	
	
}