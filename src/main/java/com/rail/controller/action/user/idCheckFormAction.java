package com.rail.controller.action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rail.controller.action.Action;
import com.rail.dao.MemberDAO;

public class idCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/member/id_check.jsp"; // 아이디 중복 체크 페이지
		String id = request.getParameter("id");
		MemberDAO memberDAO = MemberDAO.getInstance();
		int result = memberDAO.confirmID(id); // 아이디 중복체크

		request.setAttribute("result", result);
		request.setAttribute("id", id);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
