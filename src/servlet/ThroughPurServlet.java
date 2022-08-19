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
import javax.servlet.http.HttpSession;

import Dao.customer_ordersDao;
import Dao.customer_ordersDaoImpl;
import Dao.manager_orderDao;
import Dao.manager_orderDaoImpl;
import database.Orders;


import Dao.*;
import database.*;
import java.util.*;
/**
 * Servlet implementation class ThroughPurServlet
 */
@WebServlet("/ThroughPurServlet")
public class ThroughPurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThroughPurServlet() {
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
		List<Orders> list1 = new ArrayList<Orders>();
		customer_ordersDao co = new customer_ordersDaoImpl();
		manager_orderDao mo = new manager_orderDaoImpl();
		
		String userid = (String)session.getAttribute("userid");
		if(userid == null)
		{
			out.print("<script language='JavaScript'>alert('ÇëÏÈµÇÂ¼£¡');window.location.href='login.jsp'</script>");
		}
		else {
			list = co.findOrders(userid);
			
			for(int i = 0;i < list.size();i++)
			{
				if(list.get(i).getDate() == null)
					list1.add(list.get(i));
			}
			
			request.setAttribute("list_purchase",list1);
			request.getRequestDispatcher("gouwuche.jsp").forward(request, response);
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
