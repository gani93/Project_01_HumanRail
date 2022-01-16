package com.rail.controller.action.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rail.controller.action.Action;
import com.rail.dao.NoticeDAO;
import com.rail.dto.NoticeVO;

public class NoticeUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
       String url = "notice/noticeUpdate.jsp";
		
        NoticeDAO noticeDAO = NoticeDAO.getInstance(); 
        String seq = request.getParameter("seq"); 
        NoticeVO noticeVO = noticeDAO.selectOneNoticeBySeq(seq);
	    request.setAttribute("noticeVO", noticeVO); 
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
