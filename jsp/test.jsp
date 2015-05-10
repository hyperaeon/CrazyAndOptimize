<%@page import="java.util.Date"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page contentType="text/html; charset=GBK" language="java"
	errorPage=""%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
	"http://www.w3.org/TR/xhtml/DTD/xhtml1-transitional.dtd">
<%
	final String TEST_JNDI = "testName";
	Context ctx = new InitialContext();
	Date date = new Date();
	ctx.rebind(TEST_JNDI, date);
	out.println("<h3>JNDI°ó¶¨³É¹¦£¡</h3>");
%>