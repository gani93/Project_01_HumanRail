package com.rail.controller.action.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rail.controller.action.Action;
import com.rail.dao.NoticeDAO;

public class NoticeDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		NoticeDAO noticeDAO = NoticeDAO.getInstance(); 
		String seq = request.getParameter("seq"); 
		noticeDAO.deleteNotice(seq);
		
		response.sendRedirect("RailServlet?command=noticelist");
	}
}
