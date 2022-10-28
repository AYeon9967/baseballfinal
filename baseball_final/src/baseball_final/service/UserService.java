package baseball_final.service;

import baseball_final.dao.UserDao;

import baseball_final.vo.User;

public class UserService {

	private static UserService service = new UserService();
	private UserService() {		}
	
	private UserDao dao = UserDao.getInstance();
	
	public static UserService getInstance() {
		return service;
	}
	
	public void join(User user) {
		dao.join(user);
	}

	public boolean login(String id, String pwd) {
		return dao.login(id, pwd);
	}
	
	public boolean adminlogin(String id, String pwd) {
		return dao.adminlogin(id, pwd);
	}

	public int joinidcheck(String userid) {
		return dao.joinidcheck(userid);
	}
	
	public String usernickSearch(String userid) {
		return dao.usernickSearch(userid);
	}
	
	public String userpicSearch(String userid) {
		return dao.userpicSearch(userid);
	}

	public String useridSearch(String name, String gender, String email, String phone) {
		return dao.useridSearch(name, gender, email, phone);
	}

	public String userpwSearch(String userid, String name, String gender, String email, String phone) {
		return dao.userpwSearch(userid, name, gender, email, phone);
	}

	public void changepw(String userid, String previouspw, String userpwchange) {
		dao.changepw(userid, previouspw, userpwchange);
	}

	public User userSearch(String sessionID) {
		return dao.userSearch(sessionID);
	}

	public void userupdate(User user) {
		dao.userupdate(user);		
	}

	public void profileimgupdate(User user) {
		dao.profileimgupdate(user);
	}

	public String useridsearchbynick(String keyword) {
		return dao.useridsearchbynick(keyword);
	}

	public void deleteuser(String sessionID) {
		dao.deleteuser(sessionID);
	}

}
