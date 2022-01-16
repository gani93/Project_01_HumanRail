package com.rail.controller.action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.rail.controller.action.Action;
public class findPwdFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int result = -1;
		
		String url ="member/find_pwd.jsp";
		request.setAttribute("result", result);		
		request.getRequestDispatcher(url).forward(request, response);
	}
}
