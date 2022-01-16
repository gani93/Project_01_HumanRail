package com.rail.controller.action.travel;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rail.controller.action.Action;
import com.rail.dao.TravelDAO;
import com.rail.dto.TravelVO;

public class TravelUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
       String url = "travel/travelUpdate.jsp";
		
       TravelDAO travelDAO = TravelDAO.getInstance(); 
        String seq = request.getParameter("seq"); 
        TravelVO travelVO = travelDAO.selectOneTravelBySeq(seq);
	    request.setAttribute("travelVO", travelVO); 
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
