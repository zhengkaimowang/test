package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhuoyue.factory.DAOFactory;
import zhuoyue.vo.Userinfo;

public class AddStaff extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddStaff() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		Userinfo user = new Userinfo();
		String error = null;
		user.setUserCode(request.getParameter("UserCode"));
		user.setUserName(request.getParameter("UserName"));
		if(user.getUserName() == null || user.getUserName() == "" ||user.getUserName().length()>10)
		{
			error = "用户名过长或为空";
			request.setAttribute("error", error);
			request.getRequestDispatcher("fail.jsp").forward(request,response);
			return;
		}
		user.setPwd(request.getParameter("Pwd"));
		if(user.getPwd() == null || user.getPwd() == "" ||user.getPwd().length()>10)
		{
			error = "密码过长或为空";
			request.setAttribute("error", error);
			request.getRequestDispatcher("fail.jsp").forward(request,response);
			return;
		}
		user.setFunctionPrivilege(request.getParameter("FunctionPrivilege"));
		user.setDeptCode(request.getParameterValues("DeptCode")[0]);
		user.setDeptName(request.getParameter("DeptName"));
		user.setEmail(request.getParameter("Email"));
		user.setAddress(request.getParameter("Address"));
		if(user.getAddress() == null || user.getAddress() == "")
		{
			error = "地址为空";
			request.setAttribute("error", error);
			request.getRequestDispatcher("fail.jsp").forward(request,response);
			return;
		}
		user.setQQ(request.getParameter("QQ"));
		user.setTelephone(request.getParameter("Telephone"));
		if(user.getTelephone() == null || user.getTelephone() == "" || user.getTelephone().length() > 15)
		{
			error = "电话过长或为空";
			request.setAttribute("error", error);
			request.getRequestDispatcher("fail.jsp").forward(request,response);
			return;
		}
		Boolean flag = false;
		try {
			flag = DAOFactory.getIUserinfoDAOInstance().doCreateUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag)
		{
			request.getRequestDispatcher("StaffSearch").forward(request,response);
		}
		else
		{
			error = "编号已存在或编号不符合规范";
			request.setAttribute("error", error);
			request.getRequestDispatcher("fail.jsp").forward(request,response);
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
