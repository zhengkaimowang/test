<%@ page contentType="text/html" pageEncoding="GBK"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>��ҳ</title>
<style type="text/css">
<!--
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
}
.STYLE1 {
	color: #e1e2e3;
	font-size: 12px;
}
.STYLE6 {color: #000000; font-size: 12; }
.STYLE8{
		background:#436b92;
		text-align:center;
		color:#FFF;
		font-family: "����";
		height:20px;
		text-align:center;
		font-size:18px;}
.STYLE9{
		height:22px;
		text-align:center;
		font-family: "����";
		background:#436b92;
		text-align:left;
		color:#FFF;
		background:url(../images/lan.png); background-repeat:no-repeat;
		font-size:18px;}
.STYLE10 {color: #000000; font-size: 12px; }
.STYLE19 {
	color: #344b50;
	font-size: 12px;
}
.STYLE21 {
	font-size: 12px;
	color: #3b6375;
}
.STYLE22 {
	border-radius:5px;
	border: solid 1px #68A8E8;
}
 a:link {
    color:#000;
    text-decoration:none;
    }
    a:visited {
    color:#000;
    text-decoration:none;
    }
    a:hover {
    color:#000;
    text-decoration:none;
    }
    a:active {
    color:#000;
    text-decoration:none;
    }
.textarea{
	color:#3D4A50;
	background:#E1ECEE;
	resize: none;
	border:0;
	font-size:14px;
	font-family:"����";}
ul li{
	margin:4px;
	list-style-type:none;
	overflow:hidden;
	text-overflow:ellipsis;
	white-space:nowrap;
	}
-->
</style>
</head>

<body>
<%
  if(request.getParameter("error")!=null){
	  if(request.getParameter("error").equals("error"))
	  {
%>
<script language="javascript">
	alert("��Ȩ�޲���");
</script>
<%
	  }
  }
%>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" height="480">
  <tr>
    <td height="26"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="../images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1"> ��ҳ</span></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="456"><table width="100%" border="0" cellpadding="0" cellspacing="1">
    <tr>
        <td width="22%" height="455" align="center" valign="top">
        <table>
        <tr>
          <td width="240" height="236" valign="top">
            <table border="0" cellpadding="0" cellspacing="0" >
                <tr>
                    <td width="257" height="228" align="center" valign="top" bgcolor="#E1ECEE"><div class="STYLE8" style="margin-bottom:10px">��ҵ���</div>
                    <textarea cols="30" rows="9" class="textarea" readonly="readonly" >   ��˾��Ϊ��ϵ������Դ��ȫ�͹��񾭼������Ĺ�����Ҫ�Ǹ���ҵ���Խ������Ӫ����Ϊ����ҵ�񣬳е��ű��ϸ���ȫ�������á�����ࡢ�ɳ����ĵ�����Ӧ�Ļ���ʹ������Ӫ���򸲸�ȫ��26��ʡ����������ֱϽ�У������ǹ��������88%�������˿ڳ���11���ˣ���˾�ù���������186���ˡ���˾�ڷ��ɱ������������������Ĵ����ǵȹ��Һ͵�����չҵ��</textarea>
                    </td>
                </tr>
            </table></td>
            </tr>
            <tr>
            <td height="205">
            <table border="0" cellpadding="0" cellspacing="0" >
                <tr>
                    <td width="260" height="205" align="center" valign="top" bgcolor="#E1ECEE"><div class="STYLE8" style="margin-bottom:10px">������</div> <textarea cols="30" rows="8" class="textarea" readonly="readonly">   "�������"����ָ�ذ���ᡢ������ᡢ�ر���������������Ρ���˾��ַ�չ��˾�����������������Ŀ�꣬�Թ�˾�ķ�չʵ��Ա���ɳ����ͻ����⡢�������ģ��ٽ����÷�չ������г����˾��Ա��������ṫ�棬������ṫ�£�����������÷��У�������˾���š���ȡ�����š��������ҵ����</textarea></td>
                </tr>
                </table></td>
          	</tr>
          </table>
        </td>
        <td width="50%" align="center" valign="top">
        <table height="455" border="0" cellpadding="0" cellspacing="2">
        	<tr>
            	<td width="590" height="135" valign="top">
                <div class="STYLE9">&nbsp;�ƻ��ܽ�</div>
                <ul>
                	<li><a href="#"><img src="../images/dian.png" />&nbsp;2014��4��23�ռƻ��ܽ�</a>............................<a href="#">���������</a></li>
                    <li><a href="#"><img src="../images/dian.png" />&nbsp;2014��3��4�ռƻ��ܽ�</a>.............................<a href="#">���������</a></li>
                    <li><a href="#"><img src="../images/dian.png" />&nbsp;2013��11��22�ռƻ��ܽ�</a>...........................<a href="#">���������</a></li>
                  </ul>
                <div style="text-align:right;"><a href="#">����&nbsp;&nbsp;</a></div>
                </td>
            </tr>
            <tr>
            	<td height="141" valign="top">
                <div class="STYLE9">&nbsp;��ȫ�</div>
                <ul>
                	<li><a href="#"><img src="../images/dian.png" />&nbsp;2014��4��23�հ�ȫ�</a>............................<a href="#">���������</a></li>
                    <li><a href="#"><img src="../images/dian.png" />&nbsp;2014��3��4�հ�ȫ�</a>.............................<a href="#">���������</a></li>
                    <li><a href="#"><img src="../images/dian.png" />&nbsp;2013��11��22�հ�ȫ�</a>...........................<a href="#">���������</a></li>
                </ul>
                <div style="text-align:right;"><a href="#">����&nbsp;&nbsp;</a></div>
                </td>
            </tr>
            <tr>
            	<td height="149" valign="top">
                <div class="STYLE9">&nbsp;������ѵ</div>
                <ul>
                	<li><a href="#"><img src="../images/dian.png" />&nbsp;2014��4��23�ռ�����ѵ</a>............................<a href="#">���������</a></li>
                    <li><a href="#"><img src="../images/dian.png" />&nbsp;2014��3��4�ռ�����ѵ</a>.............................<a href="#">���������</a></li>
                    <li><a href="#"><img src="../images/dian.png" />&nbsp;2013��11��22�ռ�����ѵ</a>...........................<a href="#">���������</a></li>
                </ul>
                <div style="text-align:right;"><a href="#">����&nbsp;&nbsp;</a></div>
                </td>
            </tr>
        </table>
        </td>
        <td width="28%" align="center" valign="top">
        <table>
        	<tr>
            	<td width="328" height="242" valign="top">
                <div style="width:320px;height:240px; margin:0 3px;">
                	<div class="STYLE8">��ҵͼƬ</div>
                    <div style="height:200px; margin:10px 10px;"><script src="../js/picture.js" type="text/javascript"></script> </div>
                </div>
                </td>
            </tr>
            <tr>
            	<td height="190" align="center" valign="top">
                <div style="width:320px;height:190px; margin:0 3px; background:#E1ECEE;">
                <div class="STYLE8" style="margin-bottom:10px;">ר�ü�¼</div>
                <textarea cols="39" rows="7" class="textarea" readonly="readonly">  2014-03-12:��ɽ1�� ������ ĸ����Ϊ��
  2014-03-23:��ɳ1�� ���豸�� ����������
  2014-03-28:��ɳ1�� ���豸�� SF6��·��������
  2014-04-12:��ɽ1�� ���豸�� ��ն�·��������
  2014-04-15:��ɽ1�� ������ ���뿪��������
                </textarea>
                </div></td>
            </tr>
        </table>
        </td>
    </tr>
    </table></td>
  </tr>
</table>
</body>
</html>
