<%@ page contentType="text/html;charset=GBK"%>	
<%@ page import = "java.util.*,tubiao.*,zhuoyue.vo.*,org.jfree.chart.JFreeChart,org.jfree.chart.ChartFactory,org.jfree.chart.servlet.ServletUtilities"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>厂商对比</title>
</head>
<style type="text/css">
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
	background:url(../../images/6.jpg) no-repeat;
	background-size: cover; 
	-moz-background-size: cover;
}
.month{
	margin-top:20px;
	text-align:center;}
.STYLE1 {
	color: #e1e2e3;
	font-size: 12px;
}
.top_css{
	background: url(../../images/report.png) no-repeat;
	background-size: cover; 
	-moz-background-size: cover;
	height:55px;
	padding-top:20px;
	padding-left:40px;
	}
a{
	text-decoration:none;}
.top_css a:link {
    color:#FFF;
    }
.top_css a:visited {
    color:#FFF;
    }
.radio{
	width:80px;
	height:25px;
	background:#436A91;
	line-height:25px;
	text-align:center;}
</style>
<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="../../images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1">统计分析 >> 厂商对比</span></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
 </table>
<div>
<div class="top_css">
<div class="radio"><a href="EnterpriseExcel">导出报表</a></div>
</div>
<%
	List<String> enterprise = (List<String>)request.getAttribute("enterprise");
	List<Integer> times = (List<Integer>)request.getAttribute("times");
	session.setAttribute("enterprise",enterprise);
  	session.setAttribute("times",times);
%>
<%
//访问量统计时间线
BaoBiao yb = new BaoBiao();
JFreeChart chart1 = yb.getZhu(enterprise,times);
String filename1 = ServletUtilities.saveChartAsPNG(chart1, 800, 300, null, session);
String graphURL1 = request.getContextPath() + "/DisplayChart?filename=" + filename1;
%>
<div class="month"><img src="<%= graphURL1 %>"width=800 height=300 border=0 usemap="#<%= filename1 %>"></div>
</div>
</body>
</html>
