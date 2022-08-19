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
 * Servlet implementation class DisplayServlet
 */
@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServlet() {
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
		
		String type = request.getParameter("type");
		
		List<Stock> list = new ArrayList<Stock>();
		List<Stock> list_type = new ArrayList<Stock>();
		customer_goodsDao cd = new customer_goodsDaoImpl();
		System.out.println(type);
		list = cd.findAll();
		Stock st = new Stock();
		for(int i = 0;i < list.size();i++)
		{
			st = list.get(i);
			if(type.equals(st.getGoodsType()))
			{
				list_type.add(st);
			}
		}
		
		request.setAttribute("list",list_type);
		
		if(type.equals("phone"))
		{
			request.setAttribute("GoodsType","�ֻ�");
		}
		else if(type.equals("ipan"))
		{
			request.setAttribute("GoodsType","ƽ��-�ʼǱ�");
		}
		else if(type.equals("book"))
		{
			request.setAttribute("GoodsType","�鼮");
		}
		else if(type.equals("tv"))
		{
			request.setAttribute("GoodsType","����");
		}
		else if(type.equals("ai"))
		{
			request.setAttribute("GoodsType","����Ӳ��");
		}
		else if(type.equals("cloth"))
		{
			request.setAttribute("GoodsType","�·�");
		}
		else if(type.equals("router"))
		{
			request.setAttribute("GoodsType","·����");
		}
		else if(type.equals("shoe"))
		{
			request.setAttribute("GoodsType","Ь��");
		}
		else if(type.equals("vidio"))
		{
			request.setAttribute("GoodsType","���ӡ�Ӱ��");
		}
		request.getRequestDispatcher("liebiao.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
