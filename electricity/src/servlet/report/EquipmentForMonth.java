package servlet.report;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhuoyue.factory.DAOFactory;
import zhuoyue.vo.Equipment;
import zhuoyue.vo.Project;

public class EquipmentForMonth extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public EquipmentForMonth() {
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
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String date = "";
		String subName = request.getParameter("subName");
		request.setAttribute("subName", subName);
		request.setAttribute("superName", request.getParameter("superName"));
		if((year == null) ||( "".equals(year)))
		{
			Calendar c = Calendar.getInstance();
			SimpleDateFormat df = new SimpleDateFormat("yyyy");
			year = df.format(c.getTime());
			df = new SimpleDateFormat("MM");
			month = df.format(c.getTime());
		}
		int iYear = new Integer(year);
		int iMonth = new Integer(month);
		int[] monDays = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if ( ( (iYear) % 4 == 0 && (iYear) % 100 != 0) ||(iYear) % 400 == 0) 
		{
		        monDays[1]++;
		}
		int iDate = monDays[iMonth-1];
		List<Equipment> list = null;
		try {
			list = DAOFactory.getEquipmentDAO().findBySubPro(subName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<List<String>> parameter = new ArrayList<List<String>>();
		int length = list.size();
		for(int temp = 0;temp < length;temp ++)
		{
			List<Integer> problem = new ArrayList<Integer>();
			List<String> theParameter = null;
			int name = 0;
			int count = 0;
			name = new Integer(list.get(temp).getTypecode());
			try {
				count = DAOFactory.getIRecordDAOInstance().getCount(name);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				theParameter = DAOFactory.getIRecordDAOInstance().getParameterName(name, count);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			parameter.add(theParameter);
			for(int tempP = 0;tempP<theParameter.size();tempP++)
			{
				int theCount = 0;
				for(int tempDay = 0;tempDay < iDate;tempDay ++)
				{
					int increase = 0;
					if(tempDay<9)
					{
						date = year+"-"+month+"-0"+String.valueOf(tempDay+1);
					}
					else
					{
						date = year+"-"+month+"-"+String.valueOf(tempDay+1);
					}
					try {
						increase = DAOFactory.getIRecordDAOInstance().findProblemByDateAndParameter(name, date, tempP+1);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					theCount += increase;
				}
				problem.add(theCount);
			}
			result.add(problem);
		}
		request.setAttribute("result", result);
		request.setAttribute("parameter", parameter);
		request.setAttribute("equipment", list);
		request.setAttribute("year",year);
		request.setAttribute("month",month);
		request.getRequestDispatcher("equipment.jsp").forward(request, response);
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
