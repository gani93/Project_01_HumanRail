package com.rail.controller.action.user;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rail.dto.MemberVO;
import com.rail.controller.action.Action;
import com.rail.dao.MemberDAO;

public class showPwdFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "member/find_pwd.jsp"; // 비밀번호 찾기 페이지로 이동

		int result = 0;
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		MemberDAO mdao = MemberDAO.getInstance();
		// 아이디 이름으로 회원정보 있는지 먼저 판단
		MemberVO mvo = mdao.findPwd(id, name);
		// 아이디, 이름과 일치하는 회원이 있는지 확인
		if (mvo != null) {
			result = 1; // 회원있음
			System.out.println(result);
			String email = mvo.getEmail();
			request.setAttribute("email", email);
		} else {
			result = 0; // 회원없음
			System.out.println(result);
		}
		request.setAttribute("result", result);
		request.setAttribute("id", id); // 아이디값 저장
		request.setAttribute("name", name); // 비번값 저장
		request.getRequestDispatcher(url).forward(request, response);
	}
}
