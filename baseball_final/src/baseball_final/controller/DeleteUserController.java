package baseball_final.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import baseball_final.service.PostService;
import baseball_final.service.UserService;

public class DeleteUserController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String sessionID = (String)session.getAttribute("sessionID");
		UserService us = UserService.getInstance();
		PostService ps = PostService.getInstance();
		
		ps.deletereplybyid(sessionID);
		ps.deletepostbyid(sessionID);
		us.deleteuser(sessionID);
		
		HttpUtil.forward(request, response, "/logout.do");
	}

}
