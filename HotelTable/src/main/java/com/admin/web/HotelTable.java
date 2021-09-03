package com.admin.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.bean.Hotel;
import com.admin.dao.HotelDao;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/")
public class HotelTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HotelDao hotelDao;

	public HotelTable() {
		super();

	}

	@Override
	public void init() {
		hotelDao = new HotelDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

		String action = request.getServletPath();
		System.out.println(action);

		switch(action) {
		case "/new":
			showNewForm(request, response);
			break;

		case "/insert":
			insertUser(request, response);
			break;

		case "/delete":
			deleteUser(request, response);
			break;

		case "/update":
			updateUser(request, response);
			break;

		case "/edit":
			showEditForm(request, response);
			break;

		default:
			listHotel(request, response);
			break;

		}
	}

	private void listHotel(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Hotel> listHotel = hotelDao.selectAllHotel();
		request.setAttribute("listHotel", listHotel);

		RequestDispatcher rd = request.getRequestDispatcher("Hotel-list.jsp");
		rd.forward(request, response);
	}

	// blank form
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) {

		RequestDispatcher rd = request.getRequestDispatcher("Hotel-form.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// existing user
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) {

		int no = Integer.parseInt(request.getParameter("no"));
        System.out.println("User Servlets "+no);
		
        Hotel existing = hotelDao.selectUser(no);

		RequestDispatcher rd = request.getRequestDispatcher("Hotel-form.jsp");
		// to display existing users details in user-form.jsp
		request.setAttribute("hotel", existing);

		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String name = request.getParameter("name");
		int number = Integer.parseInt(request.getParameter("number"));
		String designation = request.getParameter("designation");

		Hotel newUser = new Hotel(name, number, designation, 0);
		hotelDao.insertUser(newUser);
		System.out.println("new user is added --servlets");
		try {
			response.sendRedirect("Hotel-list.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));
		String name = request.getParameter("name");
		int number = Integer.parseInt(request.getParameter("number"));
		String designation = request.getParameter("designation");

		Hotel existingUser = new Hotel( name, number, designation,no);

		hotelDao.updateUser(existingUser);

		System.out.println("existing user updated --servlets");
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		int no = Integer.parseInt(request.getParameter("no"));

		hotelDao.deleteUser(no);

		System.out.println("existing user deleted --servlets");
		try {
			response.sendRedirect("list");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
