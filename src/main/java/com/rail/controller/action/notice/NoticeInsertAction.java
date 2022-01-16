package com.rail.controller.action.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rail.controller.action.Action;
import com.rail.dao.NoticeDAO;
import com.rail.dto.NoticeVO;

public class NoticeInsertAction  implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 NoticeDAO noticeDAO = NoticeDAO.getInstance(); 
		 NoticeVO noticeVO= new NoticeVO(); 
        
		 noticeVO.setTitle(request.getParameter("title"));
		 noticeVO.setWriter(request.getParameter("writer"));
		 noticeVO.setContent(request.getParameter("content"));
		 noticeDAO.insertNotice(noticeVO);
		 
		 response.sendRedirect("RailServlet?command=noticelist");
    }
}