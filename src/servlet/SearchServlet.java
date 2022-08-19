package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.*;
import database.*;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String GoodsName = request.getParameter("goodsName");
		double minPrice = 0;
		if(request.getParameter("price1") != null && (!request.getParameter("price1").equals("")))
		{
			minPrice = Double.valueOf(request.getParameter("price1"));
		}
		double maxPrice = 10000000;
		if(request.getParameter("price2") != null && (!request.getParameter("price2").equals("")))
		{
			maxPrice = Double.valueOf(request.getParameter("price2"));
		}
		
		System.out.println(minPrice  + " " + maxPrice);
		List<Stock> list = new ArrayList<Stock>();
		customer_goodsDao cd = new customer_goodsDaoImpl();
		
		list = cd.findGoods(GoodsName,minPrice,maxPrice);
		
		request.setAttribute("list_search",list);
		request.getRequestDispatcher("sousuo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
