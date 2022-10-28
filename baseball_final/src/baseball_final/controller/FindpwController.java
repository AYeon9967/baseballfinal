package baseball_final.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseball_final.service.UserService;

public class FindpwController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String userid = request.getParameter("userid");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		String path = null;
		
		UserService s = UserService.getInstance();
		String findpw = s.userpwSearch(userid, name, gender, email, phone);
		
		if(findpw != null) {
			request.setAttribute("findpwresult", findpw);
			request.setAttribute("userid", userid);
			path = "/changepw.jsp";
		} else {
			request.setAttribute("findpwresult", "입력하신 정보와 일치하는 비밀번호가 없습니다. 다시 확인해주세요");
			path = "/Result/findpwResult.jsp";
		}
		
		HttpUtil.forward(request, response, path);
	}

}
