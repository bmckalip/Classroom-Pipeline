package com.revature.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.DAOs.UserDao;
import com.revature.DAOs.UserDaoImpl;
import com.revature.models.User;

public class UserService {
	private static UserDao dao = new UserDaoImpl();
	
	//parsing methods
	public static String getEndpoint(String url){
		String[] segments = url.split("/");
		String idStr = segments[segments.length-1];
		return idStr;
	}
	
	//data validation
	public static User authenticateUser(User u){
		User dbUser = getUserByUsername(u);

		if(dbUser == null) return null;
		
		if( dbUser.getU_username().equals(u.getU_username()) &&
			dbUser.getU_password().equals(u.getU_password())){
			return dbUser;	
		}
		return null;
	}
	
	//dao related methods
	public static void saveUser(User u){
		dao.saveUser(u);
	}
	
	public static User getUserByUsername(User u){
		return dao.getUserByUsername(u);
	}
	
	public static void registerStudent(User student) {
		dao.saveUser(student);
	}
	
	//called as the first line of each servlet's service method to prevent caching
	public static void diableCaching(HttpServletResponse resp) {
		resp.setHeader("Cache-Control","no-cache");
		resp.setHeader("Cache-Control","no-store");
	}

	public static boolean registrationIsValid(HttpServletRequest req) {
		//if anything is null or the passwords don't match, return false
		if(req.getParameter("first_name") == null ||
		   req.getParameter("last_name") == null ||
		   req.getParameter("username") == null ||
		   req.getParameter("password") == null ||
		   req.getParameter("password_confirm") == null ||
		   !req.getParameter("password").equals(req.getParameter("password_confirm"))
		   )
		{
			return false;
		}
		//otherwise, registration is valid, return true
		return true;
	}


}
