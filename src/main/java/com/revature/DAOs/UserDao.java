package com.revature.DAOs;

import com.revature.abstracts.Connection;
import com.revature.models.User;

public interface UserDao extends Connection{
	//CREATE
	public void saveUser(User u);
	
	//READ
	public User getUserByUsername(User u);
	
	//UPDATE
	
	
	//DELETE
}
