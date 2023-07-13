package com.isource.repository;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.isource.connection.web.DbContextServiceWeb;
import com.isource.dto.user.UserBidderDto;
import com.isource.dto.user.UserProfileDto;
import com.isource.dto.user.User_Dto;
import com.isource.model.user.ChangePasswordModel;
import com.isource.model.user.UserProfileDetailModel;
import com.isource.model.user.UserProfileModel;
import com.isource.query.QueryMasters;
import com.isource.service.UserService;
import com.isource.utility.ApiResponse;

@Repository
@Lazy
public class UserRepository implements UserService {

	private Logger logger = null;

//	@Autowired
	@Lazy
	private DbContextServiceWeb _DbContextserviceWeb;

	@Lazy
	public UserRepository(DbContextServiceWeb _DbContextserviceWeb) {
		this._DbContextserviceWeb = _DbContextserviceWeb;
		logger = Logger.getLogger(UserRepository.class);
	}

	public ApiResponse<List<User_Dto>> userLogin(String email, String password, String ipAddress) {

		Object Parm[] = { email, password, ipAddress };
		List<User_Dto> userdetail = null;
		
		logger.info("Start Userdetail ");
		
		try {
			userdetail = _DbContextserviceWeb.QueryToListWithParam(QueryMasters.user_login, Parm, User_Dto.class);
			logger.info("End Userdetail ");
			
			return new ApiResponse<List<User_Dto>>(true, "Total " + userdetail.size() + " Records", true, userdetail,
					userdetail.size());
			
		} catch (Exception ex) {
			logger.info("userLogin Exception : " + ex.toString());
			return new ApiResponse<List<User_Dto>>(false, ex.toString(), true, userdetail, 0);
		}
	}

	@Override
	public ApiResponse<Integer> changePassword(ChangePasswordModel changePasswordModel) {
		try {
			Object Parm[] = { changePasswordModel.getUser_id(), changePasswordModel.getOld_password(),
					changePasswordModel.getNew_password() };
			logger.info("Start Changepassword ");
			Object resultSet = _DbContextserviceWeb.QueryToFirstWithInt(QueryMasters.change_password, Parm);
			logger.info("End Changepassword ");

			return new ApiResponse<Integer>(true, "Total " + resultSet + " Records", true, (Integer) resultSet, 1);
		} catch (Exception ex) {
			logger.info("changePassword Exception : " + ex.toString());
			return new ApiResponse<Integer>(false, ex.toString(), true, null, 0);
		}
	}
	
	@Override
	public ApiResponse<Integer> insertUserProfile(UserProfileModel userProfileModel) {
		int result = 0;
		try {
			Object Parm[] = { 
					userProfileModel.getUser_id(), 
					userProfileModel.getSubscribe_category(),
					userProfileModel.getSubscription_duration(), 
					userProfileModel.getLast_date_of_subscription(),
					userProfileModel.getSubscription_amount(),
					userProfileModel.getTax_invoice(),
					userProfileModel.getKey_manager_details()
					};
			logger.info("Start insertUserProfile ");
			result= _DbContextserviceWeb.QueryToFirstWithInt(QueryMasters.insert_user_profile_harsh, Parm);
			logger.info("End insertUserProfile ");

			return new ApiResponse<Integer>(true, "Total " + 1 + " Records", true, result, 1);
		} catch (Exception ex) {
			logger.info("insertUserProfile Exception : " + ex.toString());
			return new ApiResponse<Integer>(false, ex.toString(), true, result, 0);
		}
	}

	@Override
	public ApiResponse<List<UserBidderDto>> getUserBidder() {

		List<UserBidderDto> bidder = null;
		try {
			logger.info("Start Result-Stage ");
			
			bidder = _DbContextserviceWeb.QueryToList(QueryMasters.user_bidder_getall, UserBidderDto.class);
			
			logger.info("End Result-Stage ");
			return new ApiResponse<List<UserBidderDto>>(true, "Total " + bidder.size() + " Records", true, bidder,
					bidder.size());
			
		} catch (Exception ex) {
			logger.info("getUserBidder Exception : " + ex.toString());
			return new ApiResponse<List<UserBidderDto>>(false, ex.toString(), true, bidder, 0);
		}
	}
	
	@Override
	public ApiResponse<List<UserProfileDto>> getUserProfileDetail(UserProfileDetailModel userProfileDetailModel) {

		Object[] param = { userProfileDetailModel.getUser_id() };
		List<UserProfileDto> userProfileDto = null;
		try {
			logger.info("Start UserProfileDetail ");
			userProfileDto = _DbContextserviceWeb.QueryToListWithParam(QueryMasters.user_profile_detail, param,
					UserProfileDto.class);
			logger.info("End UserProfileDetail ");
			return new ApiResponse<List<UserProfileDto>>(true, "Total Record " + userProfileDto.size() + " ", true,
					userProfileDto, userProfileDto.size());
		} catch (Exception ex) {
			logger.info("getResultAnalyticsSearch Exception : " + ex.toString());
			return new ApiResponse<List<UserProfileDto>>(false, ex.toString(), false, userProfileDto, 0);
		}
	}
}