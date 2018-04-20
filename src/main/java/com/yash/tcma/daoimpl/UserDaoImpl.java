package com.yash.tcma.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.yash.tcma.dao.UserDao;
import com.yash.tcma.exception.ConnectionNotSetUpException;
import com.yash.tcma.pojo.User;
import com.yash.tcma.util.DBUtil;

public class UserDaoImpl implements UserDao {
	private Connection con = null;
	private PreparedStatement pstmt = null;

	public UserDaoImpl() {
		try {
			con = DBUtil.connect();
		} catch (ConnectionNotSetUpException e) {

			e.printStackTrace();
		}
	}

	public void insertUser(User user) {
		String sql = "insert into users(firstName,lastName,userName,password) values(?,?,?,?)";
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getFirstName());
			pstmt.setString(2, user.getLastName());
			pstmt.setString(3, user.getUserName());
			pstmt.setString(4, user.getPassword());
			pstmt.execute();
			pstmt.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public User getUser(String userName, String password) {

		return null;
	}

	public void updateUser(int id) {

	}

}
