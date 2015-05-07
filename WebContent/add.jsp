

<%@page import="com.sds.icto.guestbook.vo.guestbookvo"%>
<%@page import="com.sds.icto.guestbook.dao.guestbookdao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	//메시지 등록
	String name = request.getParameter("name");
	String password = request.getParameter("pass");
	String message = request.getParameter("content");
	guestbookvo vo = new guestbookvo();
	vo.setName(name);
	vo.setPassword(password);
	vo.setMessage(message);
	guestbookdao dao = new guestbookdao();
	dao.insert(vo);
	response.sendRedirect("/guestbook/index.jsp");
	
%>

