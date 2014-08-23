package servlet.report;

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

public class TypeProblem extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public TypeProblem() {
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
		List<String> typeName = new ArrayList<String>();
		List<Integer> count = new ArrayList<Integer>();
		List<EquipmentType> equipmentType = null;
		try {
			equipmentType = DAOFactory.getIEquipmentTypeDAOInstance().findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int length = equipmentType.size();
		for(int temp = 0;temp < length;temp ++)
		{
			String name = equipmentType.get(temp).getTypeName();
			int theCount = 0;
			try {
				theCount = DAOFactory.getProblemDAO().findByType(name).size();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			typeName.add(name);
			count.add(theCount);
		}
		request.setAttribute("typeName", typeName);
		request.setAttribute("count", count);
		request.getRequestDispatcher("typeProblem.jsp").forward(request, response);
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
