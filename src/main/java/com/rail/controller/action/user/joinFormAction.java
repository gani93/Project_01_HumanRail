package com.rail.controller.action.user;

import java.io.IOException;
import java.lang.reflect.Member;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.rail.controller.action.Action;
import com.rail.dao.MemberDAO;
import com.rail.dto.MemberVO;

public class joinFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/join.jsp"; // 회원가입 페이지로 이동
		String email = request.getParameter("email");
		MemberDAO mdao = new MemberDAO();
		MemberVO mVo = mdao.getkakaoMember(email);
		if (mVo != null) {
			url = "RailServlet?command=login&email=" + email;
		} else {
			url = "member/join.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
