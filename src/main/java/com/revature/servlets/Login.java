package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.models.User;
import com.revature.services.Logger;
import com.revature.services.UserService;

import static com.revature.constants.Role.*;

@WebServlet("login")
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService.diableCaching(resp);
		//create a new user with the submitted info from the form
		User client = new User(req.getParameter("username"), req.getParameter("password"));

		//authenticate the user and acquire additional user data if it exists
		client = UserService.authenticateUser(client);
		
		//if the user was successfully authenticated save the user to the session and load the app
		if(client != null){
			Logger.log(req, "requested");
			req.getSession().setAttribute("user", client);
			Logger.log("New Login: " + client.toString());
			
			//direct them to either teacher or student based on their role
			String page = "";
			if(client.getU_role_id() == STUDENT){
				page = "student.html";
			}else if(client.getU_role_id() == TEACHER){
				page = "teacher.html";
			}
			
			req.getRequestDispatcher(page).forward(req, resp);
		
		//otherwise redirect back to the login page
		}else{
			Logger.log(req, "requested");
			resp.sendRedirect("login.html");
		}
	}
}
