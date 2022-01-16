package com.rail.controller.action.reservation;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rail.controller.action.Action;
import com.rail.dao.ReservationDAO;

import com.rail.dto.MemberVO;
import com.rail.dto.ReservationVO;


public class ReservationInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "RailServlet?command=ReservationListForm";
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO) session.getAttribute("loginUser");
		int trainSeq = Integer.parseInt(request.getParameter("seq"));
		String[] seatNum= request.getParameterValues("seat");
		
		if (user == null) {
			url = "RailServlet?command=login_form";
		} else {
			
			ReservationVO vo = new ReservationVO();
			vo.setSeat(Arrays.toString(seatNum));
			vo.setId(user.getId());
			vo.setQuantity(seatNum.length);
			vo.setTrain_seq(trainSeq);
			ReservationDAO dao = new ReservationDAO();
			dao.insertTrain(vo);
		}
		response.sendRedirect(url);
	}

}
