package com.rail.controller.action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rail.controller.action.Action;
import com.rail.dao.MemberDAO;
import com.rail.dto.MemberVO;

public class updateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url ="member/updateinfoform.jsp"; //회원정보 수정 페이지로 이동
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");

		MemberVO mvo = new MemberVO();
		MemberDAO mdao = MemberDAO.getInstance();
		//회원정보 가져오기
		mvo = mdao.getMember(id);
	
		String name = mvo.getName();
		String email = mvo.getEmail();
		String birth = mvo.getBirth();
		String phone = mvo.getPhone();
		
		request.setAttribute("name", name);
		request.setAttribute("id", id);
		request.setAttribute("email", email);
		request.setAttribute("birth", birth);
		request.setAttribute("phone", phone);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
