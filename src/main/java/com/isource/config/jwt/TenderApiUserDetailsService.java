package com.isource.config.jwt;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.isource.dto.user.User_Dto;
import com.isource.model.user.UserModel;
import com.isource.repository.UserRepository;
import com.isource.utility.ApiResponse;

@Service
@Configuration
@Lazy
public class TenderApiUserDetailsService implements UserDetailsService {

	private Logger logger = null;
	private UserRepository userRepository;

	public TenderApiUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
		logger = Logger.getLogger(TenderApiUserDetailsService.class);
	}

	@Override                                            //is that method where username and password condn is given in refered task. and we need to assign it to the repository, in task it was no database is used.
	public UserDetails loadUserByUsername(String data) throws UsernameNotFoundException {

		Gson g = new Gson();
		UserModel userModel = g.fromJson(data, UserModel.class);        //emailId and password is given into the usermodel class
		
		logger.info("Start loadUserByUsername   ");
		
		ApiResponse<List<User_Dto>> userData = userRepository.userLogin(userModel.getEmail_id(), userModel.getPassword(), userModel.getIp_address());
		
		logger.info("End loadUserByUsername   " );
		
		if (userData.Data.get(0) != null) {
			
			User_Dto userDto = userData.Data.get(0);  
			
			String result = g.toJson(userDto);   //Userdto will set the value of userdata
			String detail = String.valueOf(userDto.getUser_id());
			
			return new org.springframework.security.core.userdetails.User(result, detail, new ArrayList<>());
		}else {
			return new org.springframework.security.core.userdetails.User(null, null, new ArrayList<>());
		}
	}
}










