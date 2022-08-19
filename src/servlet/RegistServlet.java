package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.*;
import database.*;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
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
		String userid = request.getParameter("userid"); 
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String tel = request.getParameter("tel");
		String type = request.getParameter("type");
		String address = request.getParameter("adress");
		
		
		Customer cs = new Customer();
		Business bs = new Business();
		Regist rg = new Regist();
		
		if(!password.equals(repassword))
		{
			out.print("<script type='text/javascript'>alert('两次密码不一致!请重新输入!');window.location.href = document.referrer;</script>");
		}
		
		if(type.equals("1"))
		{
			cs.setCustomerID(userid);
			cs.setCustomerName(username);
			cs.setCustomerPhone(tel);
			cs.setCustomerPsw(password);
			cs.setCustomerAddress(address);
			int flag = rg.customerRegist(cs);
			System.out.println(flag);
			if(flag == 1)
			{
				session.setAttribute("userid",userid);
				session.setAttribute("username",username);
				out.print("<script language='JavaScript'>alert('注册成功！');window.location.href='index.jsp'</script>");
			}
			else
			{
				out.print("<script type='text/javascript'>alert('用户id或手机号码已存在!');window.location.href = document.referrer;</script>");
			}
		}
		else if(type.equals("2"))
		{
			bs.setBusinessID(userid);
			bs.setBusinessName(username);
			bs.setBusinessPhone(tel);
			bs.setBusinessPsw(password);
			bs.setBusinessAddress(address);
			int flag = rg.businessRegist(bs);
			
			if(flag == 1)
			{
				session.setAttribute("userid",userid);
				session.setAttribute("username",username);
				out.print("<script language='JavaScript'>alert('注册成功！');window.location.href='index.jsp'</script>");
				
			}
			else
			{
				out.print("<script type='text/javascript'>alert('用户id或手机号码已存在!');window.location.href = document.referrer;</script>");
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
