<%@page import="com.sds.icto.guestbook.vo.guestbookvo"%>
<%@page import="com.sds.icto.guestbook.dao.guestbookdao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	//삭제

	request.setCharacterEncoding("utf-8");
	//메시지 등록
	int no = Integer.parseInt(request.getParameter("no"));
	String password = request.getParameter("password");

	guestbookvo vo = new guestbookvo();
	vo.setNo(no);
	vo.setPassword(password);

	guestbookdao dao = new guestbookdao();
	dao.delete(vo);
	response.sendRedirect("/guestbook");
%>