package baseball_final.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseball_final.service.PostService;
import baseball_final.vo.Post;

public class GoUpdatePostController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String postnum = request.getParameter("postnum");
		
		PostService ps = PostService.getInstance();
		Post post = ps.showpost(postnum);
		
		request.setAttribute("post", post);

		HttpUtil.forward(request, response, "/updatepost.jsp");
	}

}
