package baseball_final.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import baseball_final.service.UserService;
import baseball_final.vo.User;

public class UserUpdateController implements Controller {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		User user = new User();
		
		HttpSession session = request.getSession();
		user.setUserid((String)session.getAttribute("sessionID"));
		user.setUserpw(request.getParameter("userpw"));
		user.setName(request.getParameter("name"));
		user.setNickname(request.getParameter("nickname"));
		user.setGender(request.getParameter("gender"));
		user.setEmail(request.getParameter("email"));
		user.setPhone(request.getParameter("phone"));
		user.setBirthday(request.getParameter("year") + "." + request.getParameter("month") + "." + request.getParameter("day"));
		user.setFavorite(request.getParameter("favorite"));
		
		UserService us = UserService.getInstance();
		us.userupdate(user);

		HttpUtil.forward(request, response, "/mypage.do");
	}

}
