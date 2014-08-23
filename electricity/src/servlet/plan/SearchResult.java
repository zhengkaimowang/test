package servlet.plan;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhuoyue.factory.DAOFactory;
import zhuoyue.vo.Equipment;
import zhuoyue.vo.PlanProject;
import zhuoyue.vo.Project;

public class SearchResult extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SearchResult() {
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
		String date = request.getParameter("date");
		if((date == null)||("".equals(date)))
		{
//			Calendar c = Calendar.getInstance();
//			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//			date = df.format(c.getTime());
			date = "2014-03-19";
		}
		request.setAttribute("today", date);
		List<PlanProject> list = null;
		try {
			list = DAOFactory.getPlanProjectDAO().findByDate(date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int length = list.size();
		Map<String,List<PlanProject>> root = new LinkedHashMap<String, List<PlanProject>>();
		List<PlanProject> subRoot = new ArrayList<PlanProject>();
		String node = "";
		for(int temp = 0; temp < length;temp ++)
		{
			String tempNode = "";
			try {
				tempNode = DAOFactory.getProjectDAO().findProjectByCode(DAOFactory.getProjectDAO().findProjectByCode(list.get(temp).getSubProjectCode()).getSuperCode()).getName();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(tempNode.equals(node))
			{
				subRoot.add(list.get(temp));
			}
			else
			{
				if(temp != 0)
				{
					root.put(node, subRoot);
					subRoot = new ArrayList<PlanProject>();
					subRoot.add(list.get(temp));
				}
				else
				{
					subRoot.add(list.get(temp));
				}
				node = tempNode;
			}
		}
		root.put(node, subRoot);
		List<List<Equipment>> list2 = new ArrayList<List<Equipment>>();
		for(int temp = 0;temp<length;temp++)
		{
			List<Equipment> equipment = null;
			try {
				equipment = DAOFactory.getEquipmentDAO().findBySubPro(list.get(temp).getSubProjectName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list2.add(equipment);
		}
		request.setAttribute("project", root);
		request.setAttribute("equipment", list2);
		request.getRequestDispatcher("result.jsp").forward(request, response);
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
