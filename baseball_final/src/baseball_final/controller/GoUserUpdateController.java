package baseball_final.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import baseball_final.service.UserService;
import baseball_final.vo.User;

public class GoUserUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String sessionID = (String)session.getAttribute("sessionID");
		
		UserService us = UserService.getInstance();
		User user = us.userSearch(sessionID);
		
		request.setAttribute("userinfo", user);

		HttpUtil.forward(request, response, "/userinfoupdate.jsp");
	}
}
