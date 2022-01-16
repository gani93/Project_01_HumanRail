package com.rail.controller.action.reservation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rail.controller.action.Action;

public class ReservationDeletOKFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "Reservation/reservationDeleteOKForm.jsp";
		response.sendRedirect(url);
	}

}
