package com.admin.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.admin.bean.Hotel;

public class HotelDao {

	private String jdbcURL = "jdbc:mysql://127.0.0.1:3306/java_programs?useSSL=false";

	private String username = "root";

	private String password = "Rohithraj1999";

	private static final String INSERT_USERS_SQL = "INSERT INTO hotel" + "  (name, number,designation) VALUES "
			+ " (?, ?, ?);";

	private static final String SELECT_USER_BY_ID = "select no,name,number,designation from hotel where no =?";
	private static final String SELECT_ALL_USERS = "select * from hotel";
	private static final String DELETE_USERS_SQL = "delete from hotel where no = ?;";
	private static final String UPDATE_USERS_SQL = "update hotel set name = ?,number= ?, designation =? where no = ?;";

	Connection getConnection() {
		Connection con = null;

		try {
			// 1 Load mySql driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			System.out.println("Drivers loaded successfully");

			con = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connection Made.");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;

	}

	public void insertUser(Hotel hotel) {
		System.out.println(INSERT_USERS_SQL);

		// try with resource will auto close connection
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(INSERT_USERS_SQL);) {

			ps.setString(1, hotel.getName());
			ps.setInt(2, hotel.getNumber());
			ps.setString(3, hotel.getDesignation());

			ps.executeUpdate();
			System.out.println("Inserted record.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean updateUser(Hotel hotel) {
		System.out.println(UPDATE_USERS_SQL);
		boolean rowUpdated = false;
		// try with resource will auto close connection
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(UPDATE_USERS_SQL);) {

			ps.setString(1, hotel.getName());
			ps.setInt(2, hotel.getNumber());
			ps.setString(3, hotel.getDesignation());
			ps.setInt(4, hotel.getNo());
System.out.println(hotel.getNo()+" update User method");
			int result = ps.executeUpdate();
			rowUpdated = result > 0;
			System.out.println("Record Updated Successfully.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rowUpdated;
	}

	public boolean deleteUser(int no) {
System.out.println("record fetched for "+no);
		boolean rowDeleted = false;
		System.out.println(DELETE_USERS_SQL);
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(DELETE_USERS_SQL);) {

			ps.setInt(1, no);

			int result = ps.executeUpdate();
			rowDeleted = result > 0;
			System.out.println("Record Deleted  Successfully.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rowDeleted;
	}

	public Hotel selectUser(int no) {
		Hotel hotel = null;
		System.out.println(SELECT_USER_BY_ID);
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(SELECT_USER_BY_ID);) {

			ps.setInt(1, no);

			System.out.println(ps + " prepared Statment object created for select query by id");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String name = rs.getString("name");
				int number = rs.getInt("number");
				String designation = rs.getString("designation");

				hotel = new Hotel( name, number, designation,no);
				System.out.println("Select user by id " + no);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hotel;
	}

	public List<Hotel> selectAllHotel() {
		List<Hotel> hotel = new ArrayList<Hotel>();

		System.out.println(SELECT_ALL_USERS);
		try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(SELECT_ALL_USERS);) {

			System.out.println(ps + " prepared Statment object created for select query for all users");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				int number = rs.getInt("number");
				String designation = rs.getString("designation");

				hotel.add(new Hotel( name, number, designation,no));
				System.out.println("user added to ArrayList");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return hotel;
	}
}


