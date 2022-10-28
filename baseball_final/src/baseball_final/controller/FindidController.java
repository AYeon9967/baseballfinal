package baseball_final.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseball_final.service.UserService;

public class FindidController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		UserService s = UserService.getInstance();
		String findid = s.useridSearch(name, gender, email, phone);
		
		if(findid == null) {
			request.setAttribute("findidresult", "입력하신 정보와 일치하는 아이디가 없습니다. 다시 확인해주세요");
		} else {
			request.setAttribute("findidresult", "회원님의 아이디는 <b>" + findid + "</b> 입니다.");
		}
		
		HttpUtil.forward(request, response, "/Result/findidResult.jsp");

	}

}
