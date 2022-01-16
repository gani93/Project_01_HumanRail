package com.rail.controller.action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.rail.controller.action.Action;
public class loginFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "/member/login.jsp"; //로그인 폼 페이지로 이동
		request.getRequestDispatcher(url).forward(request, response);
	}

}
