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
 * Servlet implementation class BusinessStockAddServlet
 */
@WebServlet("/BusinessStockAddServlet")
public class BusinessStockAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusinessStockAddServlet() {
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
		List<Stock> list = new ArrayList<Stock>();
		String userid = (String)session.getAttribute("userid");
		business_stockDao bs = new business_stockDaoImpl();
		String GoodsID = request.getParameter("GoodsID");
		String GoodsName = request.getParameter("GoodsName");
		String Introduction = request.getParameter("Introduction");
		String Image = request.getParameter("Image");
		String SalePrice = request.getParameter("SalePrice");
		String GoodsType = request.getParameter("GoodsType");
		String PurchasePrice = request.getParameter("PurchasePrice");
		String PurchaseNum = request.getParameter("PurchaseNum");
		String Stock = request.getParameter("Stock");
		
		manager_goodsDao mg = new manager_goodsDaoImpl();
		List<Goods> list_goods = new ArrayList<Goods>();
		list_goods = mg.findAll();
		if(mg.findGoodsID(GoodsID) == null)
		{
			out.print("<script type='text/javascript'>alert('商品ID重复!请重新输入!');window.location.href = document.referrer;</script>");
		}
		
		
		/*
		 * for(int i = 0;i < list_goods.size();i++) {
		 * 
		 * if(list_goods.get(i).getGoodsID().equals(GoodsID)) {
		 * System.out.println(GoodsID + " " + list_goods.get(i).getGoodsID()); out.
		 * print("<script type='text/javascript'>alert('商品ID重复!请重新输入!');window.location.href = document.referrer;</script>"
		 * ); } }
		 */
		
		Goods gd = new Goods();
		gd.setGoodsID(GoodsID);
		gd.setImage(Image);
		gd.setIntroduction(Introduction);
		gd.setGoodsName(GoodsName);
		gd.setGoodsType(GoodsType);
		
		mg.addGoods(gd);
		
		
		
		
		Stock stock = new Stock();
		stock.setBusinessID(userid);
		stock.setGoodsID(GoodsID);
		stock.setSalePrice(SalePrice);
		stock.setPurchasePrice(PurchasePrice);
		stock.setPurchaseNum(PurchaseNum);
		stock.setStock(Stock);
		
		bs.addStock(stock);
		
		
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
