package servlet.report;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import other.GetExcel;
import zhuoyue.vo.Project;

public class WeekExcel extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public WeekExcel() {
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

		HttpSession session = request.getSession();
		List<List<Integer>>list = (List<List<Integer>>)session.getAttribute("result");
		List<Project> project = (List<Project>)session.getAttribute("project");
		GetExcel getExcel = new GetExcel();
		List<String> week = new ArrayList<String>();
		for(int temp = 1;temp < 8;temp ++)
		{
			week.add("��"+temp+"��");
		}
		for(int temp = 0;temp < project.size();temp ++)
		{
			getExcel.addExcel(week, list.get(temp), project.get(temp).getName());
		}
		try {
			getExcel.getExcel();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path;
		path = "http://localhost/WebRoot/report.xls";
		response.sendRedirect(path);
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
