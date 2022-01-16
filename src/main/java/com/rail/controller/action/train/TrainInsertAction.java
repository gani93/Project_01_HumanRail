package com.rail.controller.action.train;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.rail.controller.action.Action;
import com.rail.dao.TrainDAO;
import com.rail.dto.TrainVO;

public class TrainInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		TrainVO vo = new TrainVO();
		TrainDAO dao = new TrainDAO();
		vo.setTrain_sub(request.getParameter("Train_sub"));
		vo.setTrain_id(request.getParameter("Train_id"));
		vo.setTrain_member(Integer.parseInt(request.getParameter("Train_member")));
		vo.setTrain_start_time(Integer.parseInt(request.getParameter("Train_start_time")));
		vo.setTrain_end_time(Integer.parseInt(request.getParameter("Train_end_time")));
		vo.setTrain_start_place(request.getParameter("Train_start_place"));
		vo.setTrain_end_place(request.getParameter("Train_end_place"));
		vo.setTrain_form(Integer.parseInt(request.getParameter("Train_form")));
		vo.setTrain_date(request.getParameter("Train_date"));
		vo.setTrain_money(Integer.parseInt(request.getParameter("Train_money")));
		dao.insertTrain(vo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("RailServlet?command=TrainInsertOKForm");
		dispatcher.forward(request, response);
	}

}
