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

public class TrainSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "TrainPage/trainList.jsp";
		
		TrainVO vo = new TrainVO();
		TrainDAO trainDAO = new TrainDAO();
		
		List<TrainVO> TrainList = null;
		String train_start_place = request.getParameter("Train_start_place");
		String train_end_place = request.getParameter("Train_end_place");
		String train_date = request.getParameter("Train_date");
		
		if (train_start_place.equals("total") && train_end_place.equals("total")&&train_date.equals("")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c1 = Calendar.getInstance();
			String strToday = sdf.format(c1.getTime()); //이거!
			System.out.println(strToday);
			TrainList = trainDAO.getTrainList(strToday);
			
		}else if(train_start_place.equals("total") && train_end_place.equals("total")&& !train_date.equals("")) {
			TrainList = trainDAO.getTrainListDate(train_date);
		}else {
			vo.setTrain_start_place(train_start_place);
			vo.setTrain_end_place(train_end_place);
			vo.setTrain_date(train_date);
			TrainList = trainDAO.searchTrainList(vo);

		}
		request.setAttribute("TrainList", TrainList);
		request.getRequestDispatcher(url).forward(request, response);

	}

}
