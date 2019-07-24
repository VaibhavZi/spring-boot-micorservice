package com.vz.bankaccountservice.common;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.vz.hashservice.common.HashService;

@Component
public class RequestHeaderValidator implements HandlerInterceptor {

	// TODO defining a static List of users who will be accessing the web app
	// TODO This Map need to be taken from database.

	//We will be providing a API key for each user,
	//this key will be generated on the basis of userSalt and private key(salt)
	private static final List<User> userList = Arrays.asList(new User("Vaibhav", "Salt4Vaibhav", "45908"),
			new User("Vikram", "Salt4Vikram","45543"));

	@Value("${application.environment}")
	private String environment;
	
	private final String DEV_ENVIRONMENT="DEV";
	/**
	 * This method checks if the incoming request has the required information provided by calling system 
	 * or not. If the request does not have the required information then reject the request.
	 * This authentication is implemented in the flag basis. if the flag is DEV then authentication will not be required.
	 * 
	 */
	@SuppressWarnings("null")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(!environment.equals(DEV_ENVIRONMENT)) {
			String api_key = request.getHeader("API_KEY");
			String USR = request.getHeader("USR");
			//Check if request header has the necessary information befo
			if (api_key != null || !api_key.isEmpty() && USR != null || !USR.isEmpty()) {
				System.out.println("****PROVIDED API_KEY****" + api_key);
				String calculatedApiKey = null;
				//TODO get the user information from the DB, Currently it is being picked up from Static List 
				User user = userList.stream().filter(us -> us.getUsername().equalsIgnoreCase(USR)).findFirst().get();
				if(user==null)
					//If user is not in the list then return the response statue as unAthorized
					response.setStatus(HttpStatus.SC_UNAUTHORIZED);
				try {
					//calculate the hash on the basis of user information.
					calculatedApiKey = HashService.getHashPassword(user.getApi_key(), user.getPrivate_salt());
					System.out.println("****CALCULATED API_KEY****" + api_key);
				} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
					e.printStackTrace();
					response.setStatus(HttpStatus.SC_PRECONDITION_FAILED);
				}
				// Check if the calculated hash and provided hash matches.
				if (api_key.equals(calculatedApiKey)) {
					return HandlerInterceptor.super.preHandle(request, response, handler);
				}
			}
			response.setStatus(HttpStatus.SC_BAD_REQUEST);
			return false;
		}else {
			return HandlerInterceptor.super.preHandle(request, response, handler);
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

}

@Entity
@Table(name="User_Info")
class User {
	@Id
	@Column
	String username;
	@Column
	String api_key;
	@Column
	String private_salt;

	public User(String username, String api_key, String private_salt) {
		super();
		this.username = username;
		this.api_key = api_key;
		this.private_salt = private_salt;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getApi_key() {
		return api_key;
	}

	public void setApi_key(String api_key) {
		this.api_key = api_key;
	}

	public String getPrivate_salt() {
		return private_salt;
	}

	public void setPrivate_salt(String private_salt) {
		this.private_salt = private_salt;
	}

}