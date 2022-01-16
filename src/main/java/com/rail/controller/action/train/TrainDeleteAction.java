package com.rail.controller.action.train;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rail.controller.action.Action;
import com.rail.dao.TrainDAO;
import com.rail.dto.TrainVO;

public class TrainDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int seq = Integer.parseInt(request.getParameter("seq"));
		TrainDAO dao = new TrainDAO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar c1 = Calendar.getInstance();
		String strToday = sdf.format(c1.getTime());
		dao.deleteTrain(seq);
		List<TrainVO> trainList = dao.getTrainList(strToday);
		request.setAttribute("TrainList", trainList);
		response.sendRedirect("TrainPage/trainList.jsp");
	}

}
