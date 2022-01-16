package com.rail.controller.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rail.controller.action.Action;
import com.rail.dao.MemberDAO;
import com.rail.dto.MemberVO;

public class sendEmailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String url = "member/login.jsp";
		String random = request.getParameter("message");
		String id = request.getParameter("id");
		String to_email = request.getParameter("to_email");

		System.out.println(random);
		System.out.println("id=" + id);

		MemberVO mvo = new MemberVO();
		MemberDAO mdao = MemberDAO.getInstance();
		// 회원정보 가져오기
		mvo = mdao.getMember(id);

		if (mvo != null) {
			String email = mvo.getEmail();
			request.setAttribute("email", email);

			if (email.equals(to_email)) {
				System.out.println("이메일 일치!");
			} else {
				System.out.println("이메일 불일치!");
			}
			mvo.setPassword(random);
			String passowrd = mvo.getPassword();
			System.out.println(passowrd);
			mdao.updatePassword(mvo); // 회원정보 변경
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
