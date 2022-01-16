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

public class updateInfoAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "member/updateinfo_ok.jsp"; // 회원정보 수정 완료 페이지로 이동

		String id = null;
		String name = null;
		String password = null;
		String email = null;
		String birth = null;
		String phone = null;

		MemberVO mvo = new MemberVO();
		mvo.setId(request.getParameter("id"));
		mvo.setName(request.getParameter("name"));
		mvo.setPassword(request.getParameter("password"));
		mvo.setEmail(request.getParameter("email"));
		mvo.setBirth(request.getParameter("birth"));
		mvo.setPhone(request.getParameter("phone"));

		MemberDAO mdao = MemberDAO.getInstance();
		mdao.updateMember(mvo); // 회원정보 변경

		if (mvo != null) {
			name = mvo.getName();
			password = mvo.getPassword();
			email = mvo.getEmail();
			birth = mvo.getBirth();
			phone = mvo.getPhone();

			request.setAttribute("name", name);
			request.setAttribute("id", id);
			request.setAttribute("password", password);
			request.setAttribute("email", email);
			request.setAttribute("birth", birth);
			request.setAttribute("phone", phone);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
