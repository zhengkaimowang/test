package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhuoyue.dbc.DatabaseConnection;
import zhuoyue.factory.DAOFactory;
import zhuoyue.vo.Dept;

public class DeptUpdate extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DeptUpdate() {
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
			boolean flag = false;
			Dept dept = new Dept();
			request.setCharacterEncoding("GBK");
			dept.setDeptcode(request.getParameter("deptcode"));
			dept.setDeptname(request.getParameter("deptname"));
			dept.setAddress(request.getParameter("address"));
			dept.setPhone(request.getParameter("phone"));
			dept.setLegalman(request.getParameter("legalman"));
			try {
				flag = DAOFactory.getDeptDAO().doUpdate(dept);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (flag){
				request.getRequestDispatcher("AllDept").forward(request,response);
			}
			else{
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
			throws ServletException, IOException {

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
