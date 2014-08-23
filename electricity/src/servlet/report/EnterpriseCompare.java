package servlet.report;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhuoyue.factory.DAOFactory;
import zhuoyue.vo.Equipment;
import zhuoyue.vo.Problem;

public class EnterpriseCompare extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public EnterpriseCompare() {
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
		List<Problem> list = null;
		try {
			list = DAOFactory.getProblemDAO().findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int length = list.size();
		Map<String,Integer> result =new HashMap<String, Integer>();
		for(int temp = 0;temp < length;temp ++)
		{
			String code = list.get(temp).getEquipmentcode();
			Equipment equipment = null;
			try {
				equipment = DAOFactory.getEquipmentDAO().findByCode(code);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String key = equipment.getProducer();
			if(result.isEmpty())
			{ 
				result.put(key, 1);
			}
			else
			{
				Map<String,Integer> copy =new HashMap<String, Integer>(result);
				Set<Map.Entry<String, Integer>> set = copy.entrySet();
				Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
				int changeTimes = 0;
				while(iterator.hasNext())
				{
					Map.Entry<String, Integer> map = iterator.next();
					String theKey = map.getKey();
					if(theKey.equals(key))
					{
						int times = map.getValue()+1;
						result.remove(theKey);
						result.put(theKey, times);
						changeTimes = 1;
					}
				}
				if(changeTimes != 1)
				{
					result.put(key, 1);
				}
			}
		}
		List<String> enterprise = new ArrayList<String>();
		List<Integer> times = new ArrayList<Integer>();
		Set<Map.Entry<String, Integer>> set = result.entrySet();
		Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
		while(iterator.hasNext())
		{
			Map.Entry<String, Integer> map = iterator.next();
			enterprise.add(map.getKey());
			times.add(map.getValue());
		}
		request.setAttribute("enterprise", enterprise);
		request.setAttribute("times", times);
		request.getRequestDispatcher("enterprise.jsp").forward(request, response);
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
