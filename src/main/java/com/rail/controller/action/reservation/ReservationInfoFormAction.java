package com.rail.controller.action.reservation;

import java.io.IOException;


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

public class ReservationInfoFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "Reservation/reservationInfo.jsp";
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO) session.getAttribute("loginUser");
		ReservationDAO reservationDAO = new ReservationDAO();
		TrainDAO trainDAO = new TrainDAO();

		int seq = Integer.parseInt(request.getParameter("seq"));
		if (user == null) {
			url = "RailServlet?command=login_form";
		} else {
			ReservationVO reservationVO = reservationDAO.getReservation(user.getId(), seq);
			request.setAttribute("reservationVO",reservationVO);
			TrainVO trainVO = trainDAO.getTrain(reservationVO.getTrain_seq());
			request.setAttribute("trainVO", trainVO);
			
			
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
