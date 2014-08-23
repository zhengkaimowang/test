package servlet.plan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhuoyue.factory.DAOFactory;
import zhuoyue.vo.Equipment;
import zhuoyue.vo.Record;

public class AllEquipmentToday extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AllEquipmentToday() {
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

		List<Equipment> alle = null;
		List<Record> allr = new ArrayList<Record>();
		String subproject = request.getParameter("subproject");
		request.setAttribute("subproject", subproject);
		String plancode = request.getParameter("plancode");
		try {
			alle = DAOFactory.getEquipmentDAO().findBySubPro(subproject);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.getRequestDispatcher("").forward(request, response);
		}
		Iterator<Equipment> ite = alle.iterator();
		while (ite.hasNext()){
			Equipment eq = ite.next(); 
			Record re = new Record();
			int tb = Integer.parseInt(eq.getTypecode());
			int count = 0;
			try {
				count = DAOFactory.getIRecordDAOInstance().getCount(tb);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.getRequestDispatcher("fail.jsp").forward(request, response);
			}
			try {
				re = DAOFactory.getIRecordDAOInstance().findByPlanAndCode(tb, count, Integer.parseInt(plancode), eq.getCode());
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.getRequestDispatcher("fail.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				request.getRequestDispatcher("fail.jsp").forward(request, response);
			}
			allr.add(re);
		}
		request.setAttribute("plancode", plancode);
		request.setAttribute("alle", alle);
		request.setAttribute("allr", allr);
		request.getRequestDispatcher("search.jsp").forward(request, response);
		
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
