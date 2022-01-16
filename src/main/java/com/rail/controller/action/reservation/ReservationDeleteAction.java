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

public class ReservationDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "RailServlet?command=ReservationDeleteOKForm";
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO) session.getAttribute("loginUser");
		ReservationDAO reservationDAO = new ReservationDAO();
		TrainDAO trainDAO = new TrainDAO();
		int seq = Integer.parseInt(request.getParameter("seq"));
		ReservationVO vo = reservationDAO.getReservation(user.getId(), seq);

		reservationDAO.deleteReservation(seq);
		trainDAO.updateTrain(vo.getTrain_seq(), vo.getQuantity());
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
