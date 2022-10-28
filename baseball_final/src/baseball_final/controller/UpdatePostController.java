package baseball_final.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import baseball_final.service.PostService;
import baseball_final.vo.Post;
import baseball_final.vo.Postpic;

public class UpdatePostController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String saveDirectory = (String)session.getAttribute("saveDirectory");
		// 이미지 저장경로 출력		System.out.println(saveDirectory);
		
		int maxPostSize = 1024 * 1024 * 5;
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		MultipartRequest multi = new MultipartRequest(request, saveDirectory, maxPostSize, "UTF-8", policy);
		
		PostService ps = PostService.getInstance();
		Post post = new Post();
		Postpic postpic = new Postpic();
		
		post.setPostnum(Integer.parseInt(multi.getParameter("postnum")));
		post.setPosttitle(multi.getParameter("posttitle"));
		post.setPostcontents(multi.getParameter("postcontents"));
		post.setPostcategory(multi.getParameter("postcategory"));
		ps.updatepost(post);
		
		int postnum = ps.getpostnum(post.getPosttitle());
		
		for(int i = 1; i < 4; i++) {
			if(multi.getFile("picture"+i) != null) {
				postpic.setPicture(multi.getFile("picture"+i).getName());
				postpic.setPicnum(Integer.parseInt(multi.getParameter("prepicnum"+i)));
				postpic.setPostnum(postnum);
				ps.updatepic(postpic);
				if(multi.getParameter("pic"+i) == null) {
					postpic.setPicture(multi.getFile("picture"+i).getName());
					postpic.setPostnum(postnum);
					ps.uploadpic(postpic);
				}
			}
			
		}
		response.sendRedirect("showpost.do?postnum=" + postnum);
	}
}
