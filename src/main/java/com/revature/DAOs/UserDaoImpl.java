package com.revature.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.User;
import com.revature.services.Logger;

public class UserDaoImpl implements UserDao{

	@Override
	public void saveUser(User u) {
		String query = "INSERT INTO users (u_role_id, u_username, u_password, u_email, u_fname, u_lname) VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement ps;

		try(Connection con = getCon()){
			ps = con.prepareStatement(query);
			ps.setInt   (1, u.getU_role_id());
			ps.setString(2, u.getU_username());
			ps.setString(3, u.getU_password());
			ps.setString(4, u.getU_email().toLowerCase());
			ps.setString(5, u.getU_fname().toLowerCase());
			ps.setString(6, u.getU_lname().toLowerCase());
			ps.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	@Override
	public User getUserByUsername(User u) {
	String query = "SELECT * FROM users WHERE u_username = ?";
	PreparedStatement ps;
	
	try(Connection con = getCon()){
		ps = con.prepareStatement(query);
		ps.setString(1, u.getU_username());
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
						return new User(
								rs.getInt(1),		//u_id
								rs.getInt(2), 		//u_role_id
								rs.getString(3), 	//u_username
								rs.getString(4),	//u_password
								rs.getString(5),	//u_email
								rs.getString(6),	//u_fname
								rs.getString(7)		//u_lname
								);
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	return null;
	}
}