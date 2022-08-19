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
 * Servlet implementation class PurchaseServlet
 */
@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseServlet() {
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
			List<Stock> list = new ArrayList<Stock>();
			customer_goodsDao cd = new customer_goodsDaoImpl();
			
			list = cd.findAll();
			Stock st = new Stock();
			Stock st1 = new Stock();
			for(int i = 0;i < list.size();i++)
			{
				st = list.get(i);
				if(BusinessID.equals(st.getBusinessID()) && GoodsID.equals(st.getGoodsID()))
				{
					st1 = list.get(i);
					break;
				}
			}
			
			customer_ordersDao co = new customer_ordersDaoImpl();
			List<Orders> list_orders = new ArrayList<Orders>();
			
			list_orders = co.findOrders(userid);
			boolean flag = false;
			Orders od = new Orders();
			for(int i = 0;i < list_orders.size();i++)
			{
				
				if(list_orders.get(i).getBusinessID() != null && list_orders.get(i).getGoodsID() != null && list_orders.get(i).getCustomerID() != null)
				{
					if(list_orders.get(i).getDate() == null && list_orders.get(i).getBusinessID().equals(BusinessID) && list_orders.get(i).getGoodsID().equals(GoodsID) && list_orders.get(i).getCustomerID().equals(userid))
					{
						
							flag = true;
							od = list_orders.get(i);
							break;
						
						
					}
				}
			}
			if(flag)
			{
				int nb = Integer.valueOf(request.getParameter("number"));
				System.out.println("nb = " + nb);
				int n = Integer.valueOf(od.getNumber()) + nb;
				System.out.println("n = " + n);
				od.setNumber(n + "");
				manager_orderDao md = new manager_orderDaoImpl();
				md.updateOrders(od);
			}
			else
			{
				int nb = Integer.valueOf(request.getParameter("number"));
				od.setCustomerID(userid);
				od.setBusinessID(BusinessID);
				od.setGoodsID(GoodsID);
				od.setNumber(nb+"");
				od.setGoodsName(st1.getGoodsName());
				od.setSalePrice(st1.getSalePrice());
				od.setSum(st1.getSalePrice());
				od.setImage(st1.getImage());
				co.addOrders(od);
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
