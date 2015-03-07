<%@ page language="java" import="java.util.*" pageEncoding="utf8"%>
  <%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
System.out.println(basePath);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <frameset rows="59,*" cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="top" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" title="topFrame" />
	<frameset cols="213,*" frameborder="no" border="0" framespacing="0">
    <frame src="left" name="leftFrame" scrolling="no" noresize="noresize" id="leftFrame" title="leftFrame" />
    <frame src="main" name="mainFrame" id="mainFrame" title="mainFrame" />
  </frameset>
</frameset>
  <body>
  </body>
</html>
