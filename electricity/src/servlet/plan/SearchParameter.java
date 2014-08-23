package servlet.plan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhuoyue.factory.DAOFactory;
import zhuoyue.vo.Record;

public class SearchParameter extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SearchParameter() {
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
		response.setContentType("text/html;charset=GBK");
		Record record = null;
		int name = new Integer(request.getParameter("name"));
		int count = 0;
		String typeName = request.getParameter("typeName");
		try {
			count = DAOFactory.getIRecordDAOInstance().getCount(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int planCode = new Integer(request.getParameter("planCode"));
		String code = request.getParameter("code");
		try {
			record = DAOFactory.getIRecordDAOInstance().findByPlanAndCode(name, count, planCode, code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("record", record);
		List<String> parameter = null;
		try {
			parameter = DAOFactory.getIRecordDAOInstance().getParameterName(name, count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		StringBuffer table = new StringBuffer();
		List<String> value = record.getParameter();
		table.append("<table width='100%' border='0' cellspacing='0' style='border:1px solid #F3F3F3;'>");
		table.append("<tr><th width='100%' colspan='2' align='center' height='28' valign='middle' style='font-size: 12px;'>"+typeName+"["+code+"]"+"</th></tr>");
		table.append("<tr><th width='100%' colspan='2' align='center' height='2' background='../../images/hengxian.jpg'>"+"</th></tr>");
		for(int length = 0;length < parameter.size();length ++)
		{
			String temp = "<tr><th width='97px' align='center' height='37' valign='middle' background='../../images/bq.png' style='font-size: 12px;'>"+parameter.get(length)+": </th><th align='left' height='28' valign='middle'  style='font-size: 12px;color: #666;font-family: \"ËÎÌå\";'>"+"&nbsp;&nbsp;&nbsp;&nbsp;"+value.get(length)+"</th></tr>";
			table.append("<tr><th width='100%' colspan='2' align='center' height='4'>"+"</th></tr>");
			table.append(temp);
		}
		table.append("<tr><th width='97px' align='right' height='28' valign='middle' style='font-size: 12px;'>±¸×¢: </th><td align='left'>"+"&nbsp;&nbsp;&nbsp;&nbsp;"+"<textarea readonly='readonly' cols='30' style='font-size: 12px;color: #666;font-family: \"ËÎÌå\";'>"+record.getRemark()+"</textarea></td></tr>");
		table.append("</table>");
		PrintWriter result = response.getWriter();
		result.print(table);
		//request.setAttribute("parameter", parameter);
		//request.getRequestDispatcher("searchRecord.jsp").forward(request, response);
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
