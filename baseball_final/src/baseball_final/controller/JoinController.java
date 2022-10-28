package baseball_final.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseball_final.service.UserService;
import baseball_final.vo.User;

public class JoinController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		UserService s = UserService.getInstance();
		User user = new User();
		
		user.setUserid(request.getParameter("userid"));
		user.setUserpw(request.getParameter("userpw"));
		user.setProfileimg("defaultprofileimg.png");
		user.setName(request.getParameter("name"));
		user.setNickname(request.getParameter("nickname"));
		user.setGender(request.getParameter("gender"));
		user.setBirthday(request.getParameter("year") + "." + request.getParameter("month") + "." + request.getParameter("day"));
		user.setPhone(request.getParameter("phone"));
		user.setEmail(request.getParameter("email"));
		user.setFavorite(request.getParameter("favorite"));

		s.join(user);
		
		HttpUtil.forward(request, response, "/Result/joinResult.jsp");
	}

}
