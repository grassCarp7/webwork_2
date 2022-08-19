package servlet;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import java.util.*;
import Dao.*;
import database.*;
/**
 * Servlet implementation class BusinessStockUpServlet
 */
@WebServlet("/BusinessStockUpServlet")
public class BusinessStockUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusinessStockUpServlet() {
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
		HttpSession session=request.getSession();
		
		String userid = (String)session.getAttribute("userid");
		String GoodsID = request.getParameter("GoodsID");
		String GoodsName = request.getParameter("GoodsName");
		String Introduction = request.getParameter("Introduction");
		String Image = request.getParameter("Image");
		String SalePrice = request.getParameter("SalePrice");
		String GoodsType = request.getParameter("GoodsType");
		String PurchasePrice = request.getParameter("PurchasePrice");
		String PurchaseNum = request.getParameter("PurchaseNum");
		String Stock = request.getParameter("Stock");
		 
		manager_stockDao ms = new manager_stockDaoImpl();
		Stock stock = new Stock();
		 
		stock.setSalePrice(SalePrice);
		stock.setPurchasePrice(PurchasePrice);
		stock.setPurchaseNum(PurchaseNum);
		stock.setStock(Stock);
		stock.setGoodsID(GoodsID);
		stock.setBusinessID(userid);
		 
		ms.updateStock(stock);
		
		 	List<Stock> list = new ArrayList<Stock>();
			business_stockDao bs = new business_stockDaoImpl();
			list = bs.findAll(userid);
			request.setAttribute("list_stock",list);
			request.getRequestDispatcher("/Busienss/kucun.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
