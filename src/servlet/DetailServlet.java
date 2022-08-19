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
 * Servlet implementation class DetailServlet
 */
@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
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
		
		String store_id = request.getParameter("store_id");
		String goods_id = request.getParameter("goods_id");
		
		List<Stock> list = new ArrayList<Stock>();
		customer_goodsDao cd = new customer_goodsDaoImpl();
		
		list = cd.findAll();
		Stock st = new Stock();
		for(int i = 0 ;i < list.size();i++)
		{
			st = list.get(i);
			if(store_id.equals(st.getBusinessID()) && goods_id.equals(st.getGoodsID()))
			{
				request.setAttribute("BusinessName",st.getBusinessName());
				request.setAttribute("GoodsName",st.getGoodsName());
				request.setAttribute("Introduction",st.getIntroduction());
				request.setAttribute("SalePrice",st.getSalePrice());
				request.setAttribute("Image",st.getImage());
				request.setAttribute("Stock",st.getStock());
				request.setAttribute("BusinessID",st.getBusinessID());
				request.setAttribute("GoodsID",st.getGoodsID());
				request.getRequestDispatcher("xiangqing.jsp").forward(request, response);
			}
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
