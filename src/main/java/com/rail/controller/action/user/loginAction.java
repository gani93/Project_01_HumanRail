package com.rail.controller.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rail.dto.MemberVO;
import com.rail.controller.action.Action;
import com.rail.dao.MemberDAO;

public class loginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "member/login.jsp"; // 아이디 비번 불일치시 로그인 페이지에

		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String pwd = request.getParameter("password");
		String email = request.getParameter("email");

		MemberDAO mdao = MemberDAO.getInstance();
		MemberVO mvo = mdao.getMember(id);
		MemberVO kakaoMvo = mdao.getkakaoMember(email);
		if (kakaoMvo != null) {
			session.setAttribute("loginUser", kakaoMvo);
			session.setAttribute("id", kakaoMvo.getId());
			url = "index.jsp";
		} else {
			request.setAttribute("message", "<b>아이디가 잘못 입력 되었습니다.<br>아이디를 정확히 입력해 주세요.</<b>");
		}
		if (mvo != null) {
			if (mvo.getKakao() == 1) {
				request.setAttribute("message", "<b>카카오로그인 유저입니다<br> 카카오로 로그인해주세요</b>");
			} else {
				if (pwd.equals(mvo.getPassword())) {
					System.out.println("로그인 성공");
					session.setAttribute("loginUser", mvo);
					session.setAttribute("id", id);
					url = "index.jsp"; // 아이디 비번 일치시 메인 페이지로 이동
				} else {
					System.out.println("로그인실패");
					request.setAttribute("message", "<b>비밀번호가 잘못 입력 되었습니다.<br> 비밀번호를 정확히 입력해 주세요.</b>");
				}
			}
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
