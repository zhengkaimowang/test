package servlet.plan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhuoyue.factory.DAOFactory;
import zhuoyue.vo.PlanProject;
import zhuoyue.vo.Userinfo;

public class PlanSearch extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PlanSearch() {
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
		request.setAttribute("pageNow", request.getParameter("pageNow"));
		String date = request.getParameter("date");
		String userCode = request.getParameter("userCode");
		List<PlanProject> list = null;
		if(((userCode == null)||("".equals(userCode)))&&((date == null)||("".equals(date))))
		{
			try {
				list = DAOFactory.getPlanProjectDAO().findAll();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(((userCode != null)&&(!("".equals(userCode))))&&((date == null)||("".equals(date))))
		{
			try {
				list = DAOFactory.getPlanProjectDAO().findByPerson(userCode);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(((userCode == null)||("".equals(userCode)))&&((date != null)&&(!("".equals(date)))))
		{
			try {
				list = DAOFactory.getPlanProjectDAO().findByDate(date);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(((userCode != null)&&(!("".equals(userCode))))&&((date != null)&&(!("".equals(date)))))
		{
			try {
				list = DAOFactory.getPlanProjectDAO().findByDateAndPerson(date, userCode);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		List<Userinfo> user = null;
		try {
			user = DAOFactory.getIUserinfoDAOInstance().findByKeyWord("µÁ¡¶≤ø");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("user", user);
		request.setAttribute("plan", list);
		request.getRequestDispatcher("searchPlan.jsp").forward(request, response);
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
