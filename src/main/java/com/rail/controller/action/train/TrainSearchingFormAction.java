package com.rail.controller.action.train;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import com.rail.controller.action.Action;
import com.rail.dao.TrainDAO;
import com.rail.dto.TrainVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TrainSearchingFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "TrainPage/searchingForm.jsp";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
		String strToday = sdf.format(c1.getTime());
		System.out.println(strToday);
		TrainDAO trainDAO = new TrainDAO();
		List<TrainVO> trainList = trainDAO.getTrainList(strToday);
		List<TrainVO> train_Start_List = trainDAO.getStartPlaceList();
		List<TrainVO> train_End_List = trainDAO.getEndPlaceList();
		if(trainList==null) {
			request.setAttribute("TrainList", null);
		}else {
			request.setAttribute("TrainList", trainList);
		}
		
		request.setAttribute("TrainStartPlace", train_Start_List);
		request.setAttribute("TrainEndPlace", train_End_List);

		request.getRequestDispatcher(url).forward(request, response);
	}

}
