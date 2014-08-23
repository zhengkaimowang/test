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

public class ProjectForWeek extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ProjectForWeek() {
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
		String week = request.getParameter("week");
		String date = "";
		int iYear = 0;
		int iMonth = 0;
		int iDate = 0;
		int iWeek = 0;
		if((year == null)||("".equals(year)))
		{
			Calendar c = Calendar.getInstance();
			iDate = c.getActualMinimum(Calendar.DAY_OF_WEEK_IN_MONTH);
			SimpleDateFormat df = new SimpleDateFormat("yyyy");
			year = df.format(c.getTime());
			df = new SimpleDateFormat("MM");
			month = df.format(c.getTime());
			iWeek = c.get(Calendar.WEEK_OF_MONTH);
			week = String.valueOf(iWeek);
		}
		iYear = new Integer(year);
		iMonth = new Integer(month);
		if((year == null)||("".equals(year)))
		{
			;
		}
		else
		{
			iWeek = new Integer(week);
			Calendar c = Calendar.getInstance();
			c.set(Calendar.MONTH,iMonth-1);
			c.set(Calendar.YEAR, iYear);
			c.set(Calendar.DAY_OF_WEEK_IN_MONTH, iWeek);
			iDate = c.get(Calendar.DATE);
		}
		int[] monDays = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if ( ( (iYear) % 4 == 0 && (iYear) % 100 != 0) ||(iYear) % 400 == 0) 
		{
		        monDays[1]++;
		}
		int dateCount = monDays[iMonth-1];
		List<Project> list = null;
		try {
			list = DAOFactory.getProjectDAO().findProject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int length = list.size();
		for(int temp = 0;temp < length;temp ++)
		{
			List<Integer> project = new ArrayList<Integer>();
			for(int tempDay = 0;tempDay < 7;tempDay ++)
			{
				int count = 0;
				String name = list.get(temp).getName();
				List<Equipment> equipment = null;
				try {
					equipment = DAOFactory.getEquipmentDAO().findByProject(name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int tempE = 0;tempE<equipment.size();tempE++)
				{
					int increase = 0;
					if((iDate+tempDay)>dateCount)
					{
						if(iMonth>8)
						{
							date = year+"-"+String.valueOf(iMonth+1)+"-0"+String.valueOf(iDate+tempDay-dateCount);
						}
						else
						{
							date = year+"-0"+String.valueOf(iMonth+1)+"-0"+String.valueOf(iDate+tempDay-dateCount);
						}
					}
					else if(((iDate+tempDay)<=dateCount)&&((iDate+tempDay)>9))
					{
						date = year+"-"+month+"-"+String.valueOf(iDate+tempDay);
					}
					else
					{
						date = year+"-"+month+"-0"+String.valueOf(iDate+tempDay);
					}
					try {
						increase = DAOFactory.getProblemDAO().findRecordByCodeAndDate(equipment.get(tempE).getCode(),date);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					count += increase;
				}
				project.add(count);
			}
			result.add(project);
		}
		request.setAttribute("result", result);
		request.setAttribute("project", list);
		request.setAttribute("year",year);
		request.setAttribute("month",month);
		request.setAttribute("week", week);
		request.getRequestDispatcher("week.jsp").forward(request, response);
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
