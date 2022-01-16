package com.rail.controller.action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rail.dto.MemberVO;
import com.rail.controller.action.Action;
import com.rail.dao.MemberDAO;

public class showPwd2Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = null;

		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String hint = request.getParameter("hint");
		String answer = request.getParameter("answer");

		MemberDAO mdao = MemberDAO.getInstance();
		MemberVO mvo = mdao.findPwd(id, name);
		String password = mvo.getPassword();
		String email = mvo.getEmail();
		System.out.println(password);

		System.out.println(hint);// 힌트
		System.out.println(answer); // 힌트답변

		if (mvo.getHint().equals(Integer.parseInt(hint)) && mvo.getAnswer().equals(answer)) {
			System.out.println("힌트와 답변 모두 일치");
			url = "member/show_pwd.jsp"; // 힌트답변 모두 일치시 비번찾아줌
			request.setAttribute("password", password);
			request.setAttribute("email", email);
		} else {
			System.out.println("힌트 답변 불일치");
			url = "member/find_pwd.jsp"; // 힌트답변 불일치
			request.setAttribute("message", "힌트의 질문과 답변이 일치하지 않습니다.");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
