package com.rail.controller.action.notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rail.controller.action.Action;
import com.rail.dao.NoticeDAO;
import com.rail.dto.MemberVO;
import com.rail.dto.NoticeVO;

public class NoticeListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "notice/noticeList.jsp";
		
		//get admin num
		HttpSession session =  request.getSession();
        MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");

		NoticeDAO noticeDAO = NoticeDAO.getInstance(); 
		ArrayList<NoticeVO> noticeList = new ArrayList<NoticeVO>();
		
        //SEARCH START
        String searchCondition = request.getParameter("searchCondition");
        String searchKeyword = request.getParameter("searchKeyword");
        if(searchCondition == null) searchCondition = "TITLE";
		if(searchKeyword == null) searchKeyword = "";
		request.setAttribute("searchCondition", searchCondition);
   		request.setAttribute("searchKeyword", searchKeyword);
        //SEARCH END
   		
		//PAGING START
        int page = 1;	//basic now page 
		int limit = 10; //limit page

		String pageNum = request.getParameter("page") == null? "" : request.getParameter("page");
		if(!"".equals(pageNum)) {
			page = Integer.parseInt(request.getParameter("page"));
		}// now page
		
        int listcount = noticeDAO.getListCount(searchCondition, searchKeyword);//The total number of notice

   		int maxpage = (int)((double)listcount / limit + 0.95);//max page
   		
   		int startpage = (((int)((double)page / 10 + 0.9)) - 1) * 10 + 1; //start page
   		
   		int endpage = maxpage;
   		if(endpage > startpage + 10 - 1) endpage = startpage + 10 - 1;//end page
   		//PAGING END
   		request.setAttribute("page", page);		  		//now page
   		request.setAttribute("maxpage", maxpage); 		//max page
   		request.setAttribute("startpage", startpage); 	//start page
   		request.setAttribute("endpage", endpage);     	//end page 
   		request.setAttribute("listcount",listcount); //The total number of notice
        
        noticeList = noticeDAO.selectAllNotice(page, limit, searchCondition, searchKeyword);
        request.setAttribute("noticeList", noticeList);
        request.setAttribute("loginUser", loginUser);
        
        request.getRequestDispatcher(url).forward(request, response);
	}
}