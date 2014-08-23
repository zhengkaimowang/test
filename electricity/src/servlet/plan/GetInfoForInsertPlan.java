package servlet.plan;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhuoyue.factory.DAOFactory;
import zhuoyue.vo.Userinfo;

public class GetInfoForInsertPlan extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GetInfoForInsertPlan() {
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
		String supercode = request.getParameter("supercode");
		String projectName = request.getParameter("projectName");
		request.setAttribute("projectName", projectName);
		request.setAttribute("superCode", supercode);
		try {
			request.setAttribute("all", DAOFactory.getProjectDAO().findSubProject(supercode));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Userinfo> list = null;
		try {
			list = DAOFactory.getIUserinfoDAOInstance().findByKeyWord("µÁ¡¶≤ø");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("user", list);
		request.getRequestDispatcher("InsertPlan.jsp").forward(request, response);
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
