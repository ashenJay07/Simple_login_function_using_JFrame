package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.*;

import model.User;

public class UserRegisterUtil {
	
	// SQL Queries
	private static String REGISTER_USER = "INSERT INTO registered_user (userName, fullName, userType, address, phone, password) VALUES(?, ?, ?, ?, ?, ?)";
	private static String USER_EXIST = "SELECT COUNT(userName) FROM registered_user WHERE userName = ?";
	private static String CHECKING_USER = "SELECT * FROM registered_user WHERE userName = ?";
	private static String ALL_USERS = "SELECT * FROM registered_user";
	

	public static boolean registerNewUser(User newUser) {
		int result = 0;
		int userCount = 0;
		
		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preStmt = connection.prepareStatement(USER_EXIST);) {
			
			preStmt.setString(1, newUser.getUserName());
			ResultSet rs = preStmt.executeQuery();
			
			while (rs.next()) {
				userCount = rs.getInt(1);
			}
			
			if(userCount > 0)
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preStmt = connection.prepareStatement(REGISTER_USER);) {
			
			preStmt.setString(1, newUser.getUserName());
			preStmt.setString(2, newUser.getFullName());
			preStmt.setString(3, newUser.getUserType());
			preStmt.setString(4, newUser.getAddress());
			preStmt.setString(5, newUser.getPhone());
			preStmt.setString(6, newUser.getPassword());
			
			result = preStmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result == 1 ? true : false;
		
	}
	
	
	public static boolean loginUser(User user) {
		
		String userId = null, userPsw = null;
		boolean result = false;
		
		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preStmt = connection.prepareStatement(CHECKING_USER);) {
			
			preStmt.setString(1, user.getUserName());
			ResultSet rs = preStmt.executeQuery();
			
			while (rs.next()) {
				userId = rs.getString(2);
				userPsw = rs.getString(7);
			}
			
			if (user.getUserName().equals(userId) && user.getPassword().equals(userPsw)) 
				result = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	
	public static Object[][] selectAllStocks() {
		
		Object[][] array = {};
		
		try (Connection connection = DatabaseConnection.getConnection();
				PreparedStatement preStmt = connection.prepareStatement(ALL_USERS);) {
			
			ResultSet rs = preStmt.executeQuery();
			
			while (rs.next()) {
				
				Object[] newRow = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)};
				
				Object[][] newArray = new Object[array.length + 1][newRow.length];
				for (int i = 0; i < array.length; i++) {
				    newArray[i] = array[i];
				}
				newArray[array.length] = newRow;

				array = newArray;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return array;
		
	}
	
}
