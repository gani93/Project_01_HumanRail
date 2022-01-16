package com.rail.controller.action.reservation;

import java.io.IOException;
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

public class ReservationFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String url = "Reservation/reservationForm3.jsp";
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO) session.getAttribute("loginUser");
		int seq = Integer.parseInt(request.getParameter("seq"));
		TrainDAO Tdao = new TrainDAO();
		ReservationDAO Rdao = new ReservationDAO();
		if (user == null) {
			url = "RailServlet?command=login_form";
		} else {
			//List<ReservationVO> Rvo = Rdao.AllListReservation(seq,1);
			List<String> Rvo = Rdao.AllListseat(seq,1);
			TrainVO Tvo = Tdao.getTrain(seq);
			request.setAttribute("getTrain", Tvo);
			request.setAttribute("getReservation", Rvo);
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
