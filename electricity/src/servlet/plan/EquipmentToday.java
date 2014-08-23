package servlet.plan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhuoyue.factory.DAOFactory;

public class EquipmentToday extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public EquipmentToday() {
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

		int tb = Integer.parseInt(request.getParameter("typecode"));
		int count = 0;
		List<String> parameter = null;
		try {
			count = DAOFactory.getIRecordDAOInstance().getCount(tb);
			parameter = DAOFactory.getIRecordDAOInstance().getParameterName(tb, count);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int plancode = Integer.parseInt(request.getParameter("plancode"));
		String code = request.getParameter("code");
		try {
			request.setAttribute("record", DAOFactory.getIRecordDAOInstance().findByPlanAndCode(tb, count, plancode, code));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.getRequestDispatcher("fail.jsp").forward(request, response);
		}
		request.setAttribute("parameter",parameter);
		request.getRequestDispatcher("parameterInfo.jsp").forward(request, response);
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
