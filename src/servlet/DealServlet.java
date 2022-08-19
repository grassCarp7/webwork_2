package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import Dao.*;
import database.*;
import java.util.*;
/**
 * Servlet implementation class DealServlet
 */
@WebServlet("/DealServlet")
public class DealServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealServlet() {
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
		List<Orders> list = new ArrayList<Orders>();
		customer_ordersDao co = new customer_ordersDaoImpl();
		manager_orderDao mo = new manager_orderDaoImpl();
		
		String userID = request.getParameter("userID");
		String BusinessID = request.getParameter("BusinessID");
		String GoodsID = request.getParameter("GoodsID");
		
		
		
		String[] str = userID.split(",");
		String[] str2 = BusinessID.split(",");
		String[] str3 = GoodsID.split(",");
		
		String userid = (String)session.getAttribute("userid");
		Orders od = new Orders();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        
		for(int i = 0;i < str.length;i++)
		{
			list = co.findOrders(userid);
			for(int j  = 0;j < list.size();j++)
			{
				if(list.get(j).getDate() == null && list.get(j).getBusinessID().equals(str2[i]) && list.get(j).getGoodsID().equals(str3[i]))
				{
					od = list.get(j);
					od.setDate(df.format(new Date()));
					mo.updateOrders(od);
				}
			}
			
		}
		
		request.getRequestDispatcher("dingdanzhongxin.jsp").forward(request, response);
		
		 
         
         
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
