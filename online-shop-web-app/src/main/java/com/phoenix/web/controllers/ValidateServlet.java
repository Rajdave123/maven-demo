package com.phoenix.web.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.phoenix.exceptions.ServiceException;
import com.phoenix.exceptions.UserNotFoundException;
import com.phoenix.web.models.LoginBean;

/**
 * Servlet implementation class ValidateServlet
 */
@WebServlet("/LoginS")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name = request.getParameter("username");
		String password = request.getParameter("password");
		//
		// System.out.println(name);
		// System.out.println(password);

		LoginBean bean = new LoginBean();

		request.setAttribute("bean", bean);

		bean.setUsername(name);
		bean.setPassword(password);

		PrintWriter out = response.getWriter(); // get printWrite obj

		try {
			if (bean.isValid()) {

				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher reqDispacher = request.getRequestDispatcher("login.html");
				reqDispacher.include(request, response);
				out.println("<script> var err = document.querySelector('.err-text');"
						+ " err.innerHTML = 'Invalid Credentials Please Try Again!'; </script>");

			}
		} catch (UserNotFoundException e) {
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
