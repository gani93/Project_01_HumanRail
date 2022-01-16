package com.rail.controller.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rail.controller.action.Action;

public class logoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "RailServlet?command=index"; // 인덱스 페이지로 이동
		HttpSession session = request.getSession();

		if (session != null) {
			session.invalidate(); // 세션값 지움
			request.getRequestDispatcher(url).forward(request, response);
		}
	}

}
