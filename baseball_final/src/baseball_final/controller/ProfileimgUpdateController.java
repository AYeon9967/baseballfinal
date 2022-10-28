package baseball_final.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import baseball_final.service.UserService;
import baseball_final.vo.User;

public class ProfileimgUpdateController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String saveDirectory = (String)session.getAttribute("saveDirectory");
		// 이미지 저장경로 출력		System.out.println(saveDirectory);
		
		int maxPostSize = 1024 * 1024 * 5;
		FileRenamePolicy policy = new DefaultFileRenamePolicy();
		MultipartRequest multi = new MultipartRequest(request, saveDirectory, maxPostSize, "UTF-8", policy);
		
		UserService s = UserService.getInstance();
		User user = new User();
		
		if(multi.getFile("profileimg") != null) {
			user.setProfileimg(multi.getFile("profileimg").getName());
		} else {
			user.setProfileimg(multi.getParameter("preprofileimg"));
		}
		
		user.setUserid((String)session.getAttribute("sessionID"));

		s.profileimgupdate(user);
		
		//HttpUtil.forward(request, response, "mypage.do");
		response.sendRedirect("profileimg.jsp");
	}

}
