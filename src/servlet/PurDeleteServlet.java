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

import Dao.*;
import database.*;

/**
 * Servlet implementation class PurDeleteServlet
 */
@WebServlet("/PurDeleteServlet")
public class PurDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurDeleteServlet() {
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
		
		String BusinessID = request.getParameter("BusinessID");
		String GoodsID = request.getParameter("GoodsID");
		String userid = (String)session.getAttribute("userid");
		
		
		if(userid == null)
		{
			out.print("<script language='JavaScript'>alert('ÇëÏÈµÇÂ¼£¡');window.location.href='login.jsp'</script>");
		}
		else
		{
			customer_ordersDao co = new customer_ordersDaoImpl();
			List<Orders> list_orders = new ArrayList<Orders>();
			
			list_orders = co.findOrders(userid);
			Orders od = new Orders();
			
			for(int i = 0;i < list_orders.size();i++)
			{
				
				if(list_orders.get(i).getBusinessID() != null && list_orders.get(i).getGoodsID() != null && list_orders.get(i).getCustomerID() != null)
				{
					if(list_orders.get(i).getDate() == null && list_orders.get(i).getBusinessID().equals(BusinessID) && list_orders.get(i).getGoodsID().equals(GoodsID) && list_orders.get(i).getCustomerID().equals(userid))
					{
						
						od = list_orders.get(i);
						manager_orderDao md = new manager_orderDaoImpl();
						md.deleteOrders(od);
						break;
						
					}
				}
			}
			list_orders = co.findOrders(userid);
			List<Orders> list1 = new ArrayList<Orders>();
			for(int i = 0;i < list_orders.size();i++)
			{
				if(list_orders.get(i).getDate()  == null)
				{
					list1.add(list_orders.get(i));
				}
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
