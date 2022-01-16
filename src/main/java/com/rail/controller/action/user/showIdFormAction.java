package com.rail.controller.action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rail.dto.MemberVO;
import com.rail.controller.action.Action;
import com.rail.dao.MemberDAO;
public class showIdFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url ="member/show_id.jsp"; //이름과 이메일 모두 일치시 아이디 찾아주는 페이지로 이동
		
		String name = request.getParameter("name"); 
		System.out.println(name);
		String email = request.getParameter("email");
		System.out.println(email);
		MemberDAO mdao = MemberDAO.getInstance();
		
		String id = mdao.findId(name,email);
	
		if(id != null) {
			System.out.println(id);
			System.out.println("아이디 찾기 성공");
			request.setAttribute("id",id);
		}else {
			url  ="member/find_id.jsp"; //불일치
			System.out.println("아이디 찾기 실패");
			request.setAttribute("message","계정정보를 확인할 수 없습니다.<br> 계정정보 확인 후 다시 시도해 주세요.");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
