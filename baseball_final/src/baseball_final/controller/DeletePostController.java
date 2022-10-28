package baseball_final.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseball_final.service.PostService;

public class DeletePostController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		PostService ps = PostService.getInstance();
		
		int postnum = Integer.parseInt(request.getParameter("postnum"));

		String team = ps.getpostteam(postnum);
		// 글에 해당하는 사진, 댓글도 함께 삭제하기 위함
		ps.deletereplybypostnum(postnum);
		ps.deletepostpic(postnum);
		ps.deletepost(postnum);

		HttpUtil.forward(request, response, "teamlist.do?team=" + team);

	}

}
