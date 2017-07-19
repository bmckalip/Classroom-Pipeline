package com.revature.servlets;

import static com.revature.constants.Role.STUDENT;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.models.User;
import com.revature.services.Emailer;
import com.revature.services.UserService;

@WebServlet("register")
public class Register extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService.diableCaching(resp);
		
		if(!UserService.registrationIsValid(req)){
			resp.sendRedirect("register.html");
		}else{
			User student = new User(STUDENT,
								   req.getParameter("username"),
								   req.getParameter("password"),
								   req.getParameter("email"),
								   req.getParameter("first_name"),
								   req.getParameter("last_name")
								   );
			
			UserService.registerStudent(student);
			
			//log in the recently registered user
			req.getSession().setAttribute("user", student);
			
			//send the email using a new thread
			Thread t = new Thread(new Emailer(req));
			t.start();

			//redirect to the home page
			resp.sendRedirect("student.html");
		}
	}
}
