package baseball_final.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseball_final.service.UserService;

public class JoinIdcheckController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		UserService s = UserService.getInstance();
		String userid = request.getParameter("id");
		
		int check = s.joinidcheck(userid);
		
		request.setAttribute("idcheck", check);
		
		HttpUtil.forward(request, response, "/joinidcheck.jsp");

	}

}
