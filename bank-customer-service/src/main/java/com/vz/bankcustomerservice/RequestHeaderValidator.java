package com.vz.bankcustomerservice;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.vz.hashservice.common.HashService;

@Component
public class RequestHeaderValidator implements HandlerInterceptor {

	// TODO defining a Map of users who will be accessing the web service
	// application
	// TODO This Map need to be taken from database.

	private static final List<User> userList = Arrays.asList(new User("Vaibhav", "Salt4Vaibhav"),
			new User("Vikram", "Salt4Vikram"));
			

/*	private static final ServerHttpResponse ACCESS_DENIED = new ServerResponse("Access Denied Please Try Again", 401,
			new Headers<Object>());
*/
	
	
	
	
	/*public ServerResponse preProcess(HttpRequest request, ResourceMethod method)
			throws Failure, WebApplicationException {
		javax.ws.rs.core.HttpHeaders headers = request.getHttpHeaders();
		MultivaluedMap<String, String> requestHeaders = headers.getRequestHeaders();
		if(requestHeaders.isEmpty()) {
			return ACCESS_DENIED;
		}
		if(requestHeaders.containsKey("API_KEY") && requestHeaders.containsKey("USR")) {
			List<String> api_key = requestHeaders.get("API_KEY");
			List<String> users = requestHeaders.get("USR");
			if(api_key.size()!=0 &&users.size()!=0) {
				String provideApiKey = api_key.get(0);
				System.out.println("****PROVIDED API_KEY****"+provideApiKey);
				String calculatedApiKey=null;
				String user = users.get(0);
				
				String api_key_for_user = userList.stream().filter(us -> us.getUsername().equalsIgnoreCase(user)).findFirst().get().api_key;
				try {
					calculatedApiKey = HashService.getHashPassword(api_key_for_user);
					System.out.println("****CALCULATED API_KEY****"+provideApiKey);
				} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
					e.printStackTrace();
					return ACCESS_DENIED;
				}
				if(provideApiKey.equals(calculatedApiKey)) {
					//API KEY MATCHED Continue Request Processing
					return null;
				}
				
			}
		}
		return ACCESS_DENIED;
	}*/

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String api_key = request.getHeader("API_KEY");
		String USR = request.getHeader("USR");
		
		if(api_key!=null || !api_key.isEmpty() && USR!=null || !USR.isEmpty()) {
				System.out.println("****PROVIDED API_KEY****"+api_key);
				String calculatedApiKey=null;
				
				String api_key_for_user = userList.stream().filter(us -> us.getUsername().equalsIgnoreCase(USR)).findFirst().get().api_key;
				try {
					calculatedApiKey = HashService.getHashPassword(api_key_for_user);
					System.out.println("****CALCULATED API_KEY****"+api_key);
				} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
					e.printStackTrace();
				}
				if(api_key.equals(calculatedApiKey)) {
					//API KEY MATCHED Continue Request Processing
					return HandlerInterceptor.super.preHandle(request, response, handler);
				}
		}
		response.setStatus(401);
		return false;
	}


	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}


	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	

}
class User {
	String username;
	String api_key;

	public User(String username, String api_key) {
		super();
		this.username = username;
		this.api_key = api_key;
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

}