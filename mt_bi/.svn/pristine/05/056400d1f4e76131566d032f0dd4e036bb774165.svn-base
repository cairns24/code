<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
<%@ page import="com.cn.zk.access.bean.ModuleBean"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	System.out.println(basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>/WEB-INF">

<title>mt后台管理系统</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
	color: #3791cf;
}
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<link href="user2/css/bg.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function save1(){

	 
	var account=document.getElementById("account");
	if(account.value ==""){
		alert("帐号不能为空");
		return false;
	}
	
	var mm=document.getElementById("password");
	if(mm.value ==""){
		alert("密码不能为空");
		return false;
	}
	
	
	var checkmm=document.getElementById("checkmm");
	
	if(checkmm.value == ""){
		
		alert("确认密码不能为空");
		return false;
	}
	
	if(mm.value!=checkmm.value){
		alert("密码和确认密码必须相同！");
		return false;
	}
	
	var r=document.getElementsByName("modules");
	 var b = false;
	 for(var i = 0;i<r.length;i++){
		 if(r[i].checked){
			 b = true;
		 }
	 }
	 if(b == false){
		 alert("请至少选择一种该用户拥有的模块");
		 return false;
	 }
	 
	var fom=document.getElementById("form1");
	fom.action="<%=basePath %>access_addUser.action";
	fom.submit();
}


function resetform(){
	document.getElementById("form1").reset();
}
</script>


</head>
<body>
<div id="page1" data-role="page">
<form id="form1" name="form1" action="" method="post" onsubmit="return Validator.Validate(this,1)">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="45" valign="top"><img src="../user2/images/register_03.gif" width="45" height="386" /></td>
    <td width="623" valign="top"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td><img src="../user2/images/register_04.gif" width="623" height="135" /></td>
      </tr>
    </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td background="../user2/images/register_28.gif">
            <table width="100%" height="158" border="0" cellpadding="0" cellspacing="0">
              <tr>
                <td align="center"><table width="272" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="123" height="25" align="left"><img src="../user2/images/register_10.gif" width="79" height="17" /></td>
                    <td width="268" align="left"><label>
                      <input name="account" id="account" type="text" dataType="Limit" require="true" msg="用户名不能为空"  />
                    </label>
                    	<label for="account" class></label>
                    </td>
                  </tr>
                  <tr>
                    <td height="25" align="left"><img src="../user2/images/register_13.gif" width="79" height="18" /></td>
                    <td align="left"><input  name="userName" id="userName" type="text" dataType="Limit" require="true" msg="用户姓名不能为空"  /></td>
                  </tr>
                  <tr>
                    <td height="25" align="left"><img src="../user2/images/register_15.gif" width="79" height="17" /></td>
                    <td align="left"><input name="password" id="password" size="25" type="password" dataType="Limit" require="true" msg="密码不能为空"  /></td>
                  </tr>
                  <tr>
                    <td height="25" align="left"><img src="../user2/images/register_17.gif" width="76" height="19" /></td>
                    <td align="left"><input name="checkmm" id="checkmm" size="25" type="password" dataType="Limit" require="true" msg="确认密码不能为空" /></td>
                  </tr>
                </table></td>
                <td width="232" align="right" valign="top"><img src="../user2/images/register_08.gif" width="232" height="172" /></td>
                </tr>
            </table>
                    <table width="623" height="41" border="0" cellpadding="0" cellspacing="0">
                      <tr align="center">
			<td width="201">&nbsp;</td>
                        <td width="107"><input onClick="javascript:save1();" type="image" src="../user2/images/register_22.gif" width="82" height="23"  /></td>
                        <td width="62"><input onclick="resetform();" type="image" src="../user2/images/rr_24.gif" width="62" height="23"></td>
			<td width="201">&nbsp;</td>
                      </tr>
                    </table>
                    <table border="0" cellpadding="0" cellspacing="0">
                      	
                      	<%
                      		List<ModuleBean> list = (List<ModuleBean>)session.getAttribute("accessModules");
                      		for(ModuleBean mb : list){
                      	%>		
                      			
                      			
                       <tr align="center">
                        <td align="right" width="160"><input type="checkbox" name="modules" id="modules" value="<%=mb.getId()%>"></input></td>
                        <td align="left"><%=mb.getName() %></td>
					  </tr>
					  
					  
                      		<%}%>
                      		
                    </table>
                    
          </td>
        </tr>
      </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="9"><img src="../user2/images/register_31.gif" width="9" height="44" /></td>
          <td background="../user2/images/register_32.gif">&nbsp;</td>
          <td width="11"><img src="../user2/images/register_34.gif" width="11" height="44" /></td>
        </tr>
      </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td>&nbsp;</td>
        </tr>
      </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td>&nbsp;</td>
        </tr>
      </table></td>
    <td class="bg">&nbsp;</td>
  </tr>
</table>
</form>
<iframe id="ifr" name="ifr" style="display:none" ></iframe>
</div>
</body>
</html>
