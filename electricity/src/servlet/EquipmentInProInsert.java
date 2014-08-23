package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhuoyue.factory.DAOFactory;
import zhuoyue.vo.Equipment;

public class EquipmentInProInsert extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public EquipmentInProInsert() {
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
			throws ServletException, IOException {
		boolean flag = false;
		Equipment eq = new Equipment();
		eq.setCode(request.getParameter("code"));
		eq.setAddress(request.getParameter("address"));
		eq.setDate(request.getParameter("date"));
		eq.setProducer(request.getParameter("producer"));
		eq.setProject(request.getParameter("projectname"));
		eq.setSubproject(request.getParameter("subname"));
		eq.setTypecode(request.getParameter("typecode"));
		eq.setTypename(request.getParameter("typename"));
		try {
			flag = DAOFactory.getEquipmentDAO().doInsert(eq);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (flag){
			response.sendRedirect("AllEquipmentInPro?superName="+URLEncoder.encode(request.getParameter("projectname"),"GBK")+"&name="+URLEncoder.encode(request.getParameter("subname"),"GBK"));
		}
		else{
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
