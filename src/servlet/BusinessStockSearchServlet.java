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
 * Servlet implementation class BusinessStockSearchServlet
 */
@WebServlet("/BusinessStockSearchServlet")
public class BusinessStockSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusinessStockSearchServlet() {
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
		String GoodsName = request.getParameter("keyword");
		String GoodsType = request.getParameter("type");
		
		business_stockDao bs = new business_stockDaoImpl();
		List<Stock> list_st = new ArrayList<Stock>();
		List<Stock> list = new ArrayList<Stock>();
		
		list_st = bs.findAll(userid);
		if(GoodsName != null && !GoodsName.equals("null"))
		{
			
			for(int i = 0;i < list_st.size();i++)
			{
				if(list_st.get(i).getGoodsName().equals(GoodsName) && (list_st.get(i).getGoodsType().equals(GoodsType) || GoodsType.equals("")))
				{
					list.add(list_st.get(i));
				}
			}
		}
		else
		{
			
			for(int i = 0;i < list_st.size();i++)
			{
				if(list_st.get(i).getGoodsType().equals(GoodsType) || GoodsType.equals(""))
				{
					list.add(list_st.get(i));
				}
			}
			
		}
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
