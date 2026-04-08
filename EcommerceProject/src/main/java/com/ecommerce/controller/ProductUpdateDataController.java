package com.ecommerce.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.bean.Product;
import com.ecommerce.dao.ProductUpdateDataDao;

/**
 * Servlet implementation class ProductUpdateDataController
 */
@WebServlet("/ProductUpdateDataController")
public class ProductUpdateDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductUpdateDataController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id= Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		Double price=Double.parseDouble(request.getParameter("price"));
		String image=request.getParameter("image");
		String description=request.getParameter("description");
		
		Product p = new Product();
		p.setId(id);
		p.setName(name);
		p.setPrice(price);
		p.setImage(image);
		p.setDescription(description);
		
		ProductUpdateDataDao PDD = new ProductUpdateDataDao();
		try {
			
			PDD.updateProduct(p);
			response.sendRedirect("ShowProductController");
			
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
