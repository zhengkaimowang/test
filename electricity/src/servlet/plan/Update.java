package servlet.plan;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zhuoyue.factory.DAOFactory;
import zhuoyue.vo.Equipment;
import zhuoyue.vo.PlanProject;

public class Update extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public Update() {
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
		String date = "";
		Calendar c = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		date = df.format(c.getTime());
		List<PlanProject> list = null;
		try {
			list = DAOFactory.getPlanProjectDAO().findNotEnd(date);
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
		List<String> state = new ArrayList<String>();
		for(int temp = 0;temp<length;temp++)
		{
			List<Equipment> equipment = null;
			try {
				equipment = DAOFactory.getEquipmentDAO().findBySubPro(list.get(temp).getSubProjectName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int tempForState = 0;tempForState<equipment.size();tempForState++)
			{
				Equipment theEquipment = equipment.get(tempForState);
				int count = 0;
				try {
					count = DAOFactory.getIRecordDAOInstance().getCount(new Integer(theEquipment.getTypecode()));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String theState = null;
				try {
					theState = String.valueOf(DAOFactory.getIRecordDAOInstance().findByDateAndCode(new Integer(theEquipment.getTypecode()), count, date, theEquipment.getCode()).getState());
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				state.add(theState);
			}
			list2.add(equipment);
		}
		StringBuffer update = new StringBuffer();
		for(int temp = 0;temp < state.size();temp ++)
		{
			update.append(state.get(temp));
		}
		PrintWriter result = response.getWriter();
		result.print(update);
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

