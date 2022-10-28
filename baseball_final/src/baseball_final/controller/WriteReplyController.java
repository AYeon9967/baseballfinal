package baseball_final.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import baseball_final.service.PostService;
import baseball_final.vo.Reply;

public class WriteReplyController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		PostService ps = PostService.getInstance();
		Reply reply = new Reply();
		
		//String postwriter = request.getParameter("postwriter"); // 추후 댓글 작성자 표시용
		int postnum = Integer.parseInt(request.getParameter("postnum"));
		
		reply.setUserid((String)session.getAttribute("sessionID"));
		reply.setPostnum(postnum);
		reply.setReplycontents(request.getParameter("replycontents"));
		
		ps.writereply(reply);
		
		HttpUtil.forward(request, response, "showpost.do?postnum=" + postnum);
	}

}
