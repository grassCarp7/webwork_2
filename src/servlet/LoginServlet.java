package servlet;

import java.io.IOException;


import java.io.PrintWriter;
import Dao.*;
import database.*;
import java.util.*;
import database.Business;
import database.Customer;
import database.Manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		
		
		
		
		
		Login lg = new Login();
		
		if(type != null)
		{
			if(type.equals("1"))
			{
				Customer cs = lg.customerLogin(username,password);
				if(cs.getCustomerID() == null)
				{
					
					out.print("<script language='JavaScript'>alert('您的用户名或密码有误，请重新输入');window.location.href='login.jsp'</script>");
				}
				else
				{
					List<Stock> list = new ArrayList<Stock>();
					session.setAttribute("username", cs.getCustomerName());
					session.setAttribute("userid", cs.getCustomerID());
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
					
			}
			else if(type.equals("2"))
			{
				Business bs = lg.businessLogin(username,password);
				if(bs.getBusinessID() == null)
					out.print("<script language='JavaScript'>alert('您的用户名或密码有误，请重新输入');window.location.href='login.jsp'</script>");
				else
				{
					session.setAttribute("username", bs.getBusinessName());
					session.setAttribute("userid", bs.getBusinessID());
					request.getRequestDispatcher("/Busienss/main.jsp").forward(request, response);
				}
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
