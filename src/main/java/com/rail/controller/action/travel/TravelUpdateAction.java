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

public class TravelUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 TravelDAO travelDAO = TravelDAO.getInstance(); 
		 TravelVO travelVO= new TravelVO(); 
		 
		 request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			
			System.out.println(request.getParameter("poster"));
			
			ServletContext context = request.getSession().getServletContext();
			String path = context.getRealPath("images");
			String encType = "UTF-8";
			int sizeLimit = 20 * 1024 * 1024;
			
			MultipartRequest multi = new MultipartRequest(request, path, sizeLimit,
					encType, new DefaultFileRenamePolicy());
       
		 travelVO.setTitle(request.getParameter("title"));
		 travelVO.setWriter(request.getParameter("writer"));
		 travelVO.setContent(request.getParameter("content"));
		 travelVO.setPictureUrl(request.getParameter("pictureUrl"));
		 travelVO.setSeq(Integer.parseInt(request.getParameter("seq")));
		 travelDAO.updateTravel(travelVO);
		 
		 response.sendRedirect("RailServlet?command=travellist");
	}
}
