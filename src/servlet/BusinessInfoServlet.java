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
 * Servlet implementation class BusinessInfoServlet
 */
@WebServlet("/BusinessInfoServlet")
public class BusinessInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusinessInfoServlet() {
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
		manager_bussinessDao mb = new manager_bussinessDaoImpl();
		
		List<Business> list = new ArrayList<Business>();
		list = mb.findAll();
		
		for(int i = 0 ;i < list.size();i++)
		{
			if(list.get(i).getBusinessID().equals(userid))
			{
				request.setAttribute("BusinessPhone",list.get(i).getBusinessPhone());
				request.setAttribute("BusinessAddress",list.get(i).getBusinessAddress());
				System.out.println("ADD : " + list.get(i).getBusinessAddress());
				request.getRequestDispatcher("/Busienss/userInfo.jsp").forward(request, response);
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
