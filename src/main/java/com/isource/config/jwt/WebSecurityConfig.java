package com.isource.config.jwt;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Lazy
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	private TenderApiAuthenticationEntryPoint tenderApiAuthenticationEntryPoint;
	private UserDetailsService userDetailsService;
	private TenderApiRequestFilter tenderApiRequestFilter;
	
	public WebSecurityConfig(TenderApiAuthenticationEntryPoint tenderApiAuthenticationEntryPoint,UserDetailsService userDetailsService,TenderApiRequestFilter tenderApiRequestFilter)
	{
		this.tenderApiAuthenticationEntryPoint=tenderApiAuthenticationEntryPoint;
		this.userDetailsService=userDetailsService;
		this.tenderApiRequestFilter=tenderApiRequestFilter;
	}
	@Bean
	public UserDetailsService userDetailsService() {
	    return super.userDetailsService();
	}
	
	
	@Autowired  //1st override method
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// configure AuthenticationManager so that it knows from where to load
		// user for matching credentials
		// Use BCryptPasswordEncoder
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	@Override         // this bean is mapped here to use AuthenticationManager in controller
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	
	@Override    // 2nd override method  got it
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		//csrf is an attack and we have disabled it 
		// We don't need CSRF for this example
//		httpSecurity
		httpSecurity.cors().and().csrf().disable()
		.cors().configurationSource(corsConfigurationSource()).and()
		.csrf()
				.disable()
				// dont authenticate this particular request
				.authorizeRequests()
				.antMatchers("/api/user/authenticate", "/account/createuser", //antMatcher is used to allow the permissions which we need to give 
						"/v2/api-docs",
		                "/configuration/ui",
		                "/swagger-resources/**",
		                "/configuration/security",
		                "/swagger-ui.html",
		                "/api/UserLogin",
		                "/webjars/**",
		                "/v3/api-docs/**",
		                "/swagger-ui/**", 
		                "/common/**",
		                "/swagger-ui/index.html/**",
		                "/api/user-login/**",
		                "/api/get-ip/**",
		                "/api/result/tender-result-download-document/**",
		                "/api/result/tender-result-download-document-All/**"
//		                ,
//		                "/api/**"
						)
				.permitAll().
				// all other requests need to be authenticated
				anyRequest()
				.authenticated()
				.and().
				// make sure we use stateless session; session won't be used to
				// store user's state.
				exceptionHandling().authenticationEntryPoint(tenderApiAuthenticationEntryPoint)
				.and()
				.sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		// Add a filter to validate the tokens with every request
		httpSecurity.addFilterBefore(tenderApiRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.addAllowedHeader("*");
		configuration.addAllowedMethod("*");
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}
