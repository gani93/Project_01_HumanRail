package com.rail.controller.action.travel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rail.controller.action.Action;
import com.rail.dao.TravelDAO;

public class TravelDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TravelDAO travelDAO = TravelDAO.getInstance(); 
		String seq = request.getParameter("seq"); 
		travelDAO.deleteTravel(seq);
		
		response.sendRedirect("RailServlet?command=travellist");
	}
}
