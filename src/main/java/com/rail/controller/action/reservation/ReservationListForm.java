package com.rail.controller.action.reservation;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rail.controller.action.Action;
import com.rail.dao.ReservationDAO;
import com.rail.dao.TrainDAO;
import com.rail.dto.MemberVO;
import com.rail.dto.ReservationVO;
import com.rail.dto.TrainVO;

public class ReservationListForm implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "Reservation/reservationListForm.jsp";
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO) session.getAttribute("loginUser");
		ReservationDAO reservationDAO = new ReservationDAO();
		TrainDAO trainDAO = new TrainDAO();
		List<TrainVO> Trainlist = new ArrayList<TrainVO>();
		TrainVO trainVO = new TrainVO();
		if (user == null) {
			url = "RailServlet?command=login_form";
		} else {
			List<ReservationVO> list =  reservationDAO.getListReservation(user.getId(),1);
			request.setAttribute("reservationList",list);
			for(int i = 0; i<list.size(); i++) {
				trainVO = trainDAO.getTrainListReservation(list.get(i));
				Trainlist.add(trainVO);
			}
			request.setAttribute("trainList", Trainlist);
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
