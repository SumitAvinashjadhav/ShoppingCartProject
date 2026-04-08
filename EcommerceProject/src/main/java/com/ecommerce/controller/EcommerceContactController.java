package com.ecommerce.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.bean.contact;
import com.ecommerce.dao.EcommerceContactDao;

/**
 * Servlet implementation class EcommerceContactController
 */
@WebServlet("/EcommerceContactController")
public class EcommerceContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EcommerceContactController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String message=request.getParameter("message");
		
		contact c = new contact();
		c.setFirstname(firstname);
		c.setLastname(lastname);
		c.setEmail(email);
		c.setMessage(message);
		 
		EcommerceContactDao EC= new EcommerceContactDao();
		try {
			
			Boolean status = EC.insertContact(c);
			
			if(status) {
				response.sendRedirect("index_login.jsp");
			}else {
				response.sendRedirect("contact.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
