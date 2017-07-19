package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.services.Logger;
import com.revature.services.UserService;

@WebServlet("getPersonalInfo")
public class PersonalInfoServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService.diableCaching(resp);
		User user = (User) req.getSession().getAttribute("user");
		
		User sanitizedUser = user;
		//make sure not to publicly display the user's password
		sanitizedUser.setU_password(StringUtils.repeat("*", user.getU_password().length()));
		
		//Object to JSON in file
		String userInfo = new ObjectMapper().writeValueAsString(user);

		Logger.log(req, "requested");
		resp.getWriter().write(userInfo);
	}
}
