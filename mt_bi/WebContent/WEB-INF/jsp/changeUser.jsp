<%@ page language="java" import="java.util.*" pageEncoding="UTF8"%>
<%@ page import="com.cn.zk.access.bean.UserBean"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>/WEB-INF/">
    
    <title>用户修改信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" rev="stylesheet" href="../css/style.css" type="text/css" media="all" />
<script language="JavaScript" type="text/javascript">
function tishi()
{
  var a=confirm('数据库中保存有该人员基本信息，您可以修改或保留该信息。');
  if(a!=true)return false;
  window.open("冲突页.htm","","depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}

function check()
{
document.getElementById("aa").style.display="";
}

</script>
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
  </head>

<body class="ContentBody">
  <form action="" method="post" enctype="multipart/form-data" name="form" target="sypost" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >员工基本信息录入</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr><td align="left">
		<input type="button" name="Submit" value="保存" class="button" onclick="alert('保存成功！');"/>　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/>
		</td></tr>
				<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>用户信息修改</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					 
					  <tr>
					    <td nowrap align="right" width="15%">员工唯一编号:</td>
					    <td width="35%"><input name='txt3' type="password" class="text" style="width:154px" value="" />
				        <span class="red">*</span></td>
					    <td width="16%" align="right" nowrap="nowrap">密码:</td>
					    <td width="34%"><input class="text" name='datevalue2' style="width:154px" value=""></td>
					  </tr>
					    
					    
					  <tr>
					    <td nowrap="nowrap" align="right">真实姓名:</td>
					    <td><input class="text" name='datevalue21' style="width:154px" value=""/></td>
					    <td align="right">性别:</td>
					    <td><select name="select2" >
                            <option selected="selected">==请选择==</option>
                            <option>男</option>
                            <option>女</option>
                        </select></td>
					  </tr>
					  
					  
					  <tr>
					    <td align="right">出生日期:</td>
					    <td><input class="text" name='datevalue212' style="width:154px" value=""/></td>
					    <td align="right">身份证号码:</td>
					    <td><input class="text" name='datevalue21' style="width:154px" value=""/></td>
					  </tr>
					  <tr>
					    <td align="right">电子邮箱:</td>
					    <td><input class="text" name='datevalue2122' style="width:154px" value=""/></td>
					    <td align="right">电话号码:</td>
					    <td><input class="text" name='datevalue21' style="width:154px" value=""/></td>
					  </tr>
					  <tr>
					    <td align="right">居住地址:</td>
					    <td><input name="textfield" type="text" size="30" />                        </td>
					    <td align="right">职位:</td>
					    <td><select name="select3" >
                          <option  selected="selected">==请选择==</option>
                          <option>程序员</option>
                          <option>项目经理</option>
                          <option>经理</option>
                        </select></td>
					  </tr>
					  <tr>
					    <td align="right">员工类型:</td>
					    <td><select name="select" >
                            <option  selected="selected">==请选择==</option>
                            <option>实习</option>
                            <option>试用</option>
                            <option>正式员工</option>
                        </select></td>
					    <td align="right">银行名称:</td>
					    <td><input class="text" name='datevalue213' style="width:154px" value=""/></td>
					  </tr>
					  <tr>
					    <td align="right">银行账户:</td>
					    <td><input class="text" name='datevalue217' style="width:154px" value=""/></td>
					    <td align="right">基本工资:</td>
					    <td><input class="text" name='datevalue214' style="width:154px" value=""/></td>
					  </tr>
					  <tr>
					    <td align="right">奖金:</td>
					    <td><input class="text" name='datevalue216' style="width:154px" value=""/></td>
					    <td align="right">其它补助金:</td>
					    <td><input class="text" name='datevalue215' style="width:154px" value=""/></td>
					  </tr>
					  <tr>
					    <td align="right">入职时间:</td>
					    <td><input class="text" name='datevalue21' style="width:154px" value=""/></td>
					    <td align="right">&nbsp;</td>
					    <td>&nbsp;</td>
					  </tr>
					 
					  <tr>
					    <td align="right">描述:</td>
					    <td colspan="3"><textarea name="textarea" cols="100" rows="8"></textarea></td>
					    </tr>
					  </table>
			  <br />
				</fieldset>			</TD>
			
		</TR>
		

		
		
		
		</TABLE>
	
	
	 </td>
  </tr>
  
  
		
		
		
		<TR>
			<TD colspan="2" align="center" height="50px">
			<input type="button" name="Submit" value="保存" class="button" onclick="alert('保存成功！');"/>　
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/></TD>
		</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  </table>

</div>
</form>
</body>
</html>
