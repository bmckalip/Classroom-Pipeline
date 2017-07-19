package com.revature.services;

import javax.servlet.http.HttpServletRequest;

import com.revature.models.User;

public class Logger {
	public static final boolean DO_ECHO = true;
	public static final boolean DO_LOG = true;
	
	public static void log(HttpServletRequest request, String message){
		StringBuilder sb = new StringBuilder();
		User user = (User) request.getSession().getAttribute("user");
		String name;
		if(user != null){
			name = user.getU_fname() + " " + user.getU_lname();
		}else{
			name = "Anonymous";
		}
		
		sb.append(UserService.getEndpoint(request.getRequestURI()) + " ");
		sb.append(message);
		sb.append(" for user: ");
		sb.append(name);
		
		if(DO_ECHO) System.out.println(sb.toString());
	}
	
	public static void log(HttpServletRequest request, String message, User user){
		StringBuilder sb = new StringBuilder();
		String name;
		if(user != null){
			name = user.getU_fname() + " " + user.getU_lname();
		}else{
			name = "Anonymous";
		}
		
		sb.append(UserService.getEndpoint(request.getRequestURI()) + " ");
		sb.append(message);
		sb.append(" for user: ");
		sb.append(name);
		
		if(DO_ECHO) System.out.println(sb.toString());
	}
	
	public static void log(String message){
		if(DO_ECHO)	System.out.println(message);
	}
}
