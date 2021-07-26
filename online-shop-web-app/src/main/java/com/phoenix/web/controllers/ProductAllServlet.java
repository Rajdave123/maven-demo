package com.phoenix.web.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.phoenix.data.Product;
import com.phoenix.exceptions.ServiceException;
import com.phoenix.services.ProductService;
import com.phoenix.services.ProductServiceImpl;

/**
 * Servlet implementation class ProductAllServlet
 */
@WebServlet("/ProductAllServlet")
public class ProductAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Invoking business logic
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		HttpSession session = request.getSession(false);
		if (session != null) {
			try {
				ProductService productService = new ProductServiceImpl();
				List<Product> products = productService.findAll();
				// System.out.println(products);
				session.setAttribute("products", products);
				response.sendRedirect("products.jsp");
				System.out.println(products);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			out.println("<center>"
					+ "<h1 style='color:white; background: black; font-family: monospace;'> <marquee behavior='alternate' direction='left' scrollamount='12'> Welcome To JSP & SERVLET With MVC Design Pattern </marquee>"
					+ " </h1><h2 style='margin-top: 50px;'>Sorry! &#128542; your session has "
					+ "	expired.</h2><h3 style='margin-top: 20px; color: red'>You can try again after login successfully.</h3>"
					+ "<h2 style='position: fixed;font-family: monospace; left: 0; bottom: 0; width: 100%; background-color: cyan; color: black; text-align: center;'><b>Copyright &copy; Sterlight Technology Ltd. </b></h2>"
					+ "</center>");
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
