package com.ecommerce.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ecommerce.bean.Cart;
import com.ecommerce.bean.CartItem;
import com.ecommerce.bean.Product;
import com.ecommerce.dao.AddToCartDao;

/**
 * Servlet implementation class AddToCartController
 */
@WebServlet("/AddToCartController")
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("productId"));
		int userid=Integer.parseInt(request.getParameter("userId"));
		int quantity=1;
		
		CartItem c=new CartItem();
		c.setProductId(id);
		c.setUserId(userid);
		c.setQuantity(quantity);
			
		AddToCartDao AD= new AddToCartDao();
		try {
			
			boolean status=AD.checkCart(c);
			if(status==true) {
				AD.updateCart(c);
				
				HttpSession session=request.getSession();
				session.setAttribute("Cart", c);
				
				
				
			}else {
			AD.AddToCart(c);
			
			HttpSession session=request.getSession();
			session.setAttribute("Cart", c);
			
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("ShowCartServlet");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
