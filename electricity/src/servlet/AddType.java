package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhuoyue.factory.DAOFactory;
import zhuoyue.vo.EquipmentType;

public class AddType extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddType() {
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
		String name = request.getParameter("name");
		String describe = request.getParameter("describe");
		String max = String.valueOf(new Integer(request.getParameter("max"))+1);
		EquipmentType type = new EquipmentType();
		type.setTypeCode(max);
		type.setTypeName(name);
		type.setDescribe(describe);
		type.setTableName(new Integer(max));
		Boolean flag = false;
		try {
			flag = DAOFactory.getIEquipmentTypeDAOInstance().doCreate(type);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String []parameter = request.getParameterValues("parameter");
		String []standardArray = request.getParameterValues("standard");
		List<String>parameterName = new ArrayList();
		List<String>standard = new ArrayList();
		for(int i = 0;i<parameter.length;i++)
		{
			parameterName.add(parameter[i]);
		}
		for(int i = 0;i<parameter.length;i++)
		{
			standard.add(standardArray[i]);
		}
		try {
			flag = DAOFactory.getIRecordDAOInstance().doCreateTable(new Integer(max), parameterName, standard);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path = request.getParameter("path");
		if(flag = true)
		{
			request.getRequestDispatcher(path).forward(request, response);
		}
		else
		{
			String error = "创建类型失败";
			request.setAttribute("error", error);
			request.getRequestDispatcher("fail.jsp").forward(request, response);
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
