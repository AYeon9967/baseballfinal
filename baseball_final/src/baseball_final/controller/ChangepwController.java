package baseball_final.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseball_final.service.UserService;

public class ChangepwController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String userid = request.getParameter("userid");
		String previouspw = request.getParameter("previouspw");
		String userpwchange = request.getParameter("userpwchange");
		
		UserService s = UserService.getInstance();
		s.changepw(userid, previouspw, userpwchange);
		
		HttpUtil.forward(request, response, "/Result/changepwResult.jsp");
	}

}
