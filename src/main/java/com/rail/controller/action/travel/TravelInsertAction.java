package com.rail.controller.action.travel;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.rail.controller.action.Action;
import com.rail.dao.TravelDAO;
import com.rail.dto.TravelVO;

public class TravelInsertAction  implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		ServletContext context = request.getSession().getServletContext();
		String path = context.getRealPath("Image/travel");
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit,
				encType, new DefaultFileRenamePolicy());
		
		 TravelDAO travelDAO = TravelDAO.getInstance(); 
		 TravelVO travelVO= new TravelVO(); 
        
		 travelVO.setTitle(request.getParameter("title"));
		 travelVO.setWriter(request.getParameter("writer"));
		 travelVO.setContent(request.getParameter("content"));
		 travelVO.setPictureUrl(request.getParameter("pictureUrl"));
		 travelDAO.insertTravel(travelVO);
		 
		 response.sendRedirect("RailServlet?command=travellist");
    }
}