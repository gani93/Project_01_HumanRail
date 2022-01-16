package com.rail.controller.action.train;

import java.io.IOException;
import com.rail.controller.action.Action;
import com.rail.dao.TrainDAO;
import com.rail.dto.TrainVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TrainGetFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "TrainPage/getTrainForm.jsp";
		int seq = Integer.parseInt(request.getParameter("seq"));
		TrainDAO dao = new TrainDAO();
		TrainVO vo = dao.getTrain(seq);
		request.setAttribute("getTrain", vo);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
