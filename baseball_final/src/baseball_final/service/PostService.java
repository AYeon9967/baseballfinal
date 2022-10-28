package baseball_final.service;

import java.util.List;


import baseball_final.dao.PostDao;
import baseball_final.vo.Post;
import baseball_final.vo.Postpic;
import baseball_final.vo.Reply;
public class PostService {

	private static PostService service = new PostService();
	private PostService() {		}
	
	private PostDao dao = PostDao.getInstance();
	
	public static PostService getInstance() {
		return service;
	}
	
	public List<Post> postlist(String team) {
		return dao.postlist(team);
	}
	
	public List<Post> postlistdesc(String team) {
		return dao.postlistdesc(team);
	}
	
	public List<Post> searchpostlist(String team, String searchthing, String keyword) {
		return dao.searchpostlist(team, searchthing, keyword);
	}
	
	public List<Post> searchpostlistdesc(String team, String searchthing, String keyword) {
		return dao.searchpostlistdesc(team, searchthing, keyword);
	}
	
	public List<Post> mypagepostlist(String userid) {
		return dao.mypagepostlist(userid);
	}
	
	public List<Reply> mypagereplylist(String userid) {
		return dao.mypagereplylist(userid);
	}

	public void writepost(Post post) {
		dao.writepost(post);
	}

	public int getpostnum(String posttitle) {
		return dao.getpostnum(posttitle);
	}
	
	public int getpostnum(int replynum) {
		return dao.getpostnum(replynum);
	}

	public void uploadpic(Postpic postpic) {
		dao.uploadpic(postpic);
	}

	public Post showpost(String postnum) {
		return dao.showpost(postnum);
	}
	
	public List<Reply> showreply(int postnum) {
		return dao.showreply(postnum);
	}
	
	public List<Postpic> showpicture(int postnum) {
		return dao.showpicture(postnum);
	}

	public void writereply(Reply reply) {
		dao.writereply(reply);
	}

	public void deletereply(int replynum) {
		dao.deletereply(replynum);
	}

	public String getpostteam(int postnum) {
		return dao.getpostteam(postnum);
	}

	public void deletepost(int postnum) {
		dao.deletepost(postnum);		
	}
	
	public void deletepostbyid(String sessionID) {
		dao.deletepostbyid(sessionID);
	}

	public void deletepostpic(int postnum) {
		dao.deletepostpic(postnum);
	}

	public void deletereplybypostnum(int postnum) {
		dao.deletereplybypostnum(postnum);
	}
	
	public void deletereplybyid(String sessionID) {
		dao.deletereplybyid(sessionID);
	}

	public void updatepost(Post post) {
		dao.updatepost(post);
	}

	public void updatepic(Postpic postpic) {
		dao.updatepic(postpic);
	}
	
	public String getstorage(String img) {
		return dao.getstorage(img);
	}
	
}
