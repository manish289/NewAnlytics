package com.isource.service;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.isource.dto.user.UserBidderDto;
import com.isource.dto.user.UserProfileDto;
import com.isource.dto.user.User_Dto;
import com.isource.model.user.ChangePasswordModel;
import com.isource.model.user.UserProfileDetailModel;
import com.isource.model.user.UserProfileModel;
import com.isource.utility.ApiResponse;

@Service
@Lazy
public interface UserService {
	
	ApiResponse<List<User_Dto>> userLogin(String email,String password,String ipAddress);
	
	ApiResponse<Integer> changePassword(ChangePasswordModel changePasswordModel);
	ApiResponse<Integer> insertUserProfile(UserProfileModel userProfileModel);
	
	ApiResponse<List<UserProfileDto>> getUserProfileDetail(UserProfileDetailModel userProfileDetailModel);	
	ApiResponse<List<UserBidderDto>> getUserBidder();
	
}