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
 * Servlet implementation class BusinessOrdersSearchServlet
 */
@WebServlet("/BusinessOrdersSearchServlet")
public class BusinessOrdersSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusinessOrdersSearchServlet() {
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
		
		
		String CustomerName = request.getParameter("keyword");
		String userid = (String)session.getAttribute("userid");
		String Type = request.getParameter("type");
		
		System.out.println("USERID: " + userid);
		System.out.println("CustomerName: " + CustomerName);
		System.out.println("Type: " + Type);
		
		List<Orders> list = new ArrayList<Orders>();
		List<Customer> list_cut = new ArrayList<Customer>();
		List<Orders> list_orders = new ArrayList<Orders>();
		
		
		business_ordersDao bo = new business_ordersDaoImpl();
		list = bo.findAll(userid);
		
		System.out.println("SIZE: " + list.size());
		
		if(CustomerName != null && !CustomerName.equals("null"))
		{
			System.out.println("1");
			manager_customerDao mc = new manager_customerDaoImpl();
			list_cut = mc.findCustomerName(CustomerName);
			for(int i = 0;i < list.size();i++)
			{
				for(int j = 0;j < list_cut.size();j++)
				{
					if(list.get(i).getCustomerID().equals(list_cut.get(j).getCustomerID()) && (list.get(i).getGoodsType().equals(Type) || Type.equals("*")))
					{
						list_orders.add(list.get(i));
						break;
					}
				}
			}
			
		}
		else
		{
			System.out.println("2");
			for(int i = 0;i < list.size();i++)
			{
				System.out.println("3");
				
				if(list.get(i).getGoodsType().equals(Type) || Type.equals("*"))
				{
					System.out.println("TP: " + list.get(i).getGoodsType());
					list_orders.add(list.get(i));
					System.out.println(list.get(i).getGoodsName());
				}
			}
		}
		request.setAttribute("list_orders",list_orders);
		request.getRequestDispatcher("/Busienss/inOrderList.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
