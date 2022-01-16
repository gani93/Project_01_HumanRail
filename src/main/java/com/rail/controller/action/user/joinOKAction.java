package com.rail.controller.action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rail.dto.MemberVO;
import com.rail.controller.action.Action;
import com.rail.dao.MemberDAO;
public class joinOKAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String url = "member/join_ok.jsp"; //회원가입 완료 페이지로 이동
		String id = request.getParameter("id");
		String pwd = request.getParameter("password");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String email= request.getParameter("email");
		String phone = request.getParameter("phone");
		String kakao = request.getParameter("kakao");
		
		
		MemberVO mvo = new MemberVO();
		mvo.setId(id);
		mvo.setPassword(pwd);
		mvo.setName(name);
		mvo.setBirth(birth);
		mvo.setEmail(email);
		mvo.setPhone(phone);
		mvo.setKakao(Integer.parseInt(kakao));
		MemberDAO mdao = MemberDAO.getInstance();
		mdao.insertMember(mvo);
		MemberVO kakaoMvo = mdao.getkakaoMember(email);
		if(kakaoMvo!=null) {
			request.setAttribute("id",id);
			request.setAttribute("name",name);
			request.setAttribute("email",email);
			request.setAttribute("loginUser", kakaoMvo);
			request.setAttribute("kakao", 1);
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}else {
			request.setAttribute("id",id);
			request.setAttribute("name",name);
			request.setAttribute("email",email);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
		System.out.println("회원가입 성공");
		
		
	}

}
