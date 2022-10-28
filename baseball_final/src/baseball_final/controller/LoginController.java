package baseball_final.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import baseball_final.service.UserService;

public class LoginController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("userid");
		String pwd = request.getParameter("userpw");
		String authority = request.getParameter("authority");
		String path = null;
		boolean result = false;
		
		UserService s = UserService.getInstance();
		HttpSession session = request.getSession();
		
		if(authority.equals("user")) {
			result = s.login(id, pwd);
		} else if (authority.equals("admin")) {
			result = s.adminlogin(id, pwd);
		}
		
		if(result) {
			if(authority.equals("user")) {
				session.setAttribute("sessionID", id); // 세션 ID로 생성
			} else if (authority.equals("admin")) {
				session.setAttribute("sessionID", authority); // 세션 ID로 생성
			}			
			path = "/main.jsp";
		} else {
			request.setAttribute("loginerror", "아이디 혹은 비밀번호가 존재하지 않습니다.");
			path = "/login.jsp";
		}
		
		HttpUtil.forward(request, response, path);
	}
}
