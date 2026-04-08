package com.ecommerce.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.ecommerce.bean.Cart;
import com.ecommerce.bean.CartItem;
import com.ecommerce.bean.order;
import com.ecommerce.dao.AddToCartDao;
import com.ecommerce.dao.OrderDAO;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

/**
 * Servlet implementation class paymentController
 */
@WebServlet("/paymentController")
public class paymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public paymentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		System.out.println(data);
//		int amt=Integer.parseInt(data.get("amount").toString());
		System.out.println("in get");
			
			
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("in post");
		
		
		int user_id=Integer.parseInt(request.getParameter("user_id"));
		CartItem c=new CartItem();
		c.setUserId(user_id);
		
		AddToCartDao AD =new AddToCartDao();
		ArrayList<Cart> list;
		OrderDAO od=new OrderDAO();
			try {
				list = AD.showCart(c);
				
				for(Cart c1:list) {
					
					order o=new order();
					o.setProductId(c1.getProductId());
					o.setUserId(user_id);
					o.setQuantity(c1.getQuantity());
					
					od.AddToOrder(o);
					
					
					
				}
				od.emptyCart(c);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
		
//		RazorpayClient client = null;
//		try {
//			client = new RazorpayClient("rzp_test_HYCG9XE3B6gozQ","7BySOPI6P2G2Gihg9tUGfrEz");
//		} catch (RazorpayException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		JSONObject obj=new JSONObject();
//		obj.put("amount", 1000*100);
//		obj.put("currency", "INR");
//		obj.put("receipt", "txn_235425");
//		
//		Order order;
//		try {
//			order = client.orders.create(obj);
//			System.out.println(order);
//		} catch (RazorpayException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		doGet(request, response);
	}

}
