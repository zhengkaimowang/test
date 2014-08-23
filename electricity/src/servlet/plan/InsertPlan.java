package servlet.plan;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.smartcardio.ResponseAPDU;
import javax.xml.ws.Response;

import zhuoyue.factory.DAOFactory;
import zhuoyue.vo.Equipment;
import zhuoyue.vo.PlanProject;
import zhuoyue.vo.Record;
import zhuoyue.vo.Userinfo;

public class InsertPlan extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public InsertPlan() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String []userCode = request.getParameterValues("userCode");
		String []startTime = request.getParameterValues("startTime");
		String []endTime = request.getParameterValues("endTime");
		String []projectCode = request.getParameterValues("projectCode");
		String []projectName = request.getParameterValues("projectName");
		String []projectType = request.getParameterValues("projectType");
		int length = userCode.length;
		PlanProject plan = new PlanProject();
		Boolean flag = false;
		List<Equipment> equipment = null;
		for(int temp = 0;temp<length;temp++)
		{
			if(projectType[temp].equals("ҹѲ"))
			{
				startTime[temp] = startTime[temp]+" 20:00:00";
				endTime[temp] = endTime[temp]+" 24:00:00";
				plan.setType("ҹѲ");
			}
			else
			{
				startTime[temp] = startTime[temp]+" 14:00:00";
				endTime[temp] = endTime[temp]+" 18:00:00";
				plan.setType("��Ѳ");
			}
		}
		for(int temp = 0;temp<length;temp++)
		{
			plan.setUserCode(userCode[temp]);
			Userinfo user = null;
			try {
				user = DAOFactory.getIUserinfoDAOInstance().findByCode(userCode[temp]);
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			plan.setUserName(user.getUserName());
			plan.setStartTime(startTime[temp]);
			plan.setEndTime(endTime[temp]);
			plan.setSubProjectCode(projectCode[temp]);
			plan.setSubProjectName(projectName[temp]);
			try {
				flag = DAOFactory.getPlanProjectDAO().doInsert(plan);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				equipment = DAOFactory.getEquipmentDAO().findBySubPro(plan.getSubProjectName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int lengthForEquipment = equipment.size();
			for(int temp2=0;temp2<lengthForEquipment;temp2++)
			{
				Equipment eq = equipment.get(temp2);
				int name =new Integer(eq.getTypecode());
				int count = 0;
				try {
					count = DAOFactory.getIRecordDAOInstance().getCount(name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				List<String> parameter = new ArrayList<String>();
				for(int temp3 = 0;temp3<(count-Record.COUNTBEHIND-Record.COUNTFFRONT);temp3++)
				{
					parameter.add("δѲ��");
				}
				int max = 0;
				try {
					max = DAOFactory.getIRecordDAOInstance().getMax(name)+1;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Record record = new Record();
				record.setId(max);
				record.setCode(eq.getCode());
				record.setDate(plan.getStartTime());
				record.setPlanCode(plan.getPlanCode());
				record.setRemark("δѲ�죡");
				record.setState(0);
				record.setUserCode(plan.getUserCode());
				record.setUserName(plan.getUserName());
				record.setParameter(parameter);
				try {
					flag = DAOFactory.getIRecordDAOInstance().doInsert(name, count, record);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(flag)
		{
			out.print("true");
		}
		else
		{
			out.print("false");
		}
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
