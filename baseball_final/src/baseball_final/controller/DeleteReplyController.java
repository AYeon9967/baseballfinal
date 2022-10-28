package baseball_final.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseball_final.service.PostService;

public class DeleteReplyController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		PostService ps = PostService.getInstance();
		
		int replynum = Integer.parseInt(request.getParameter("replynum"));

		int postnum = ps.getpostnum(replynum);
		ps.deletereply(replynum);

		HttpUtil.forward(request, response, "showpost.do?postnum=" + postnum);

	}

}
