package com.ecommerce.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.bean.Cart;
import com.ecommerce.bean.CartItem;
import com.ecommerce.dao.AddToCartDao;
import com.ecommerce.dao.removeFromCart;

/**
 * Servlet implementation class RemoveFromCartController
 */
@WebServlet("/RemoveFromCartController")
public class RemoveFromCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int productId=Integer.parseInt(request.getParameter("productId"));
		int userId=Integer.parseInt(request.getParameter("userId"));
		
		
		CartItem c = new CartItem();
		c.setProductId(productId);
		c.setUserId(userId);
		
		
		removeFromCart rc = new removeFromCart();
		try {
			
			boolean status=rc.removeCart(c);
			if(status) {

				HttpSession session=request.getSession();
				session.setAttribute("Cart", c);
				response.sendRedirect("ShowCartServlet");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
