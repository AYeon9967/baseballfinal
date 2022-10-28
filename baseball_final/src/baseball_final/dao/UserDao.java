package baseball_final.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import baseball_final.vo.User;

public class UserDao {
	
	private static UserDao dao = new UserDao();
	
	private UserDao() {}
	
	public static UserDao getInstance() { return dao; }

	public Connection connect() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/baseballfinal?characterEncoding-UTF-8&serverTimezone=UTC";
		String id = "root";
		String pwd = "hello1248";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pwd);
		} catch(Exception e) { System.out.println("MDAO: connect " + e); }
		return conn;
	}
	
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if(pstmt != null) {
			try { pstmt.close();
			} catch(Exception e) { System.out.println("Pstmt close error " + e); }
		}
		if(conn != null) {
			try { conn.close();
			} catch(Exception e) { System.out.println("Conn close error " + e); }
		}
		if(rs != null) {
			try { rs.close();
			} catch(Exception e) { System.out.println("Rs close error " + e); }
		}
	}

	public void join(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into user values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
			pstmt.setString(1, user.getProfileimg());
			pstmt.setString(2, user.getUserid());
			pstmt.setString(3, user.getUserpw());
			pstmt.setString(4, user.getName());
			pstmt.setString(5, user.getNickname());
			pstmt.setString(6, user.getGender());
			pstmt.setString(7, user.getBirthday());
			pstmt.setString(8, user.getPhone());
			pstmt.setString(9, user.getEmail());
			pstmt.setString(10, user.getFavorite());
			pstmt.executeUpdate();
		} catch(Exception e) { System.out.println("Join error " + e);
		} finally { close(conn, pstmt, null); }
	}
	
	public int joinidcheck(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 1; // 아이디 사용 가능 = 1
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from user where userid=?;");
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = 0; // 결과가 있으면 아이디 사용 불가 = 0
			}
		} catch(Exception e) { System.out.println("idCheck error " + e);
		} finally { close(conn, pstmt, rs); }
		
		return result;
	}

	public boolean login(String id, String pwd) {
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from user where userid=? and userpw=?;");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = true; // 검색이 된다면 로그인 성공
			} else {
				result = false;
			}
		} catch(Exception e) { System.out.println("Login error " + e);
		} finally { close(conn, pstmt, rs); }	
		
		return result;
	}
	
	public boolean adminlogin(String id, String pwd) {
		boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from admin where id=? and pw=?;");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = true; // 검색이 된다면 로그인 성공
			} else {
				result = false;
			}
		} catch(Exception e) { System.out.println("adminlogin error " + e);
		} finally { close(conn, pstmt, rs); }	
		
		return result;
	}
	
	public String usernickSearch(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String findnick = null;
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select nickname from user where userid=?;");
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				findnick = rs.getString(1);
			}
		} catch(Exception e) { System.out.print("unickSearch error " + e);
		} finally { close(conn, pstmt, rs); }
		
		return findnick;
	}
	
	public String userpicSearch(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String findpic = null;
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select profileimg from user where userid=?;");
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				findpic = rs.getString(1);
			}
		} catch(Exception e) { System.out.print("userpicSearch error " + e);
		} finally { close(conn, pstmt, rs); }
		
		return findpic;
	}

	public String useridSearch(String name, String gender, String email, String phone) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String findid = null;
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select userid from user where name=? and gender=? and phone=? and email=?;");
			pstmt.setString(1, name);
			pstmt.setString(2, gender);
			pstmt.setString(3, phone);
			pstmt.setString(4, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				findid = rs.getString(1);
			}
		} catch(Exception e) { System.out.print("uidSearch error " + e);
		} finally { close(conn, pstmt, rs); }
		
		return findid;
	}

	public String userpwSearch(String userid, String name, String gender, String email, String phone) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String findpw = null;
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select userpw from user where userid=? and name=? and gender=? and phone=? and email=?;");
			pstmt.setString(1, userid);
			pstmt.setString(2, name);
			pstmt.setString(3, gender);
			pstmt.setString(4, phone);
			pstmt.setString(5, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				findpw = rs.getString(1);
			}
		} catch(Exception e) { System.out.print("upwSearch error " + e);
		} finally { close(conn, pstmt, rs); }
		
		return findpw;
	}

	public void changepw(String userid, String previouspw, String userpwchange) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("update user set userpw=? where userid=? and userpw=?;");
			pstmt.setString(1, userpwchange);
			pstmt.setString(2, userid);
			pstmt.setString(3, previouspw);
			pstmt.executeUpdate();
		} catch(Exception e) { System.out.print("changepw error " + e);
		} finally { close(conn, pstmt, null); }
	}

	public User userSearch(String sessionID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from user where userid=?;");
			pstmt.setString(1, sessionID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setProfileimg(rs.getString(1));
				user.setUserid(rs.getString(2));
				user.setUserpw(rs.getString(3));
				user.setName(rs.getString(4));
				user.setNickname(rs.getString(5));
				user.setGender(rs.getString(6));
				user.setBirthday(rs.getString(7));
				user.setPhone(rs.getString(8));
				user.setEmail(rs.getString(9));
				user.setFavorite(rs.getString(10));
			}
		} catch(Exception e) { System.out.println("uSearch error " + e);
		} finally { close(conn, pstmt, rs); }
		
		return user;
	}

	public void userupdate(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("update user set userpw=?, name=?, nickname=?, gender=?, birthday=?, phone=?, email=?, favorite=? where userid=?;");
			pstmt.setString(9, user.getUserid());
			pstmt.setString(1, user.getUserpw());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getNickname());
			pstmt.setString(4, user.getGender());
			pstmt.setString(5, user.getBirthday());
			pstmt.setString(6, user.getPhone());
			pstmt.setString(7, user.getEmail());
			pstmt.setString(8, user.getFavorite());
			//System.out.println(pstmt);
			pstmt.executeUpdate();
		} catch(Exception e) { System.out.println("uUpdate error " + e);
		} finally { close(conn, pstmt, null); }
	}

	public void profileimgupdate(User user) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("update user set profileimg=? where userid=?;");
			pstmt.setString(2, user.getUserid());
			pstmt.setString(1, user.getProfileimg());
			pstmt.executeUpdate();
		} catch(Exception e) { System.out.println("profileimgUpdate error " + e);
		} finally { close(conn, pstmt, null); }
	}

	public String useridsearchbynick(String keyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String userid = null;
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select userid from user where nickname like ?;");
			pstmt.setString(1, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				userid = rs.getString(1);
			}
		} catch(Exception e) { System.out.print("useridsearchbynick error " + e);
		} finally { close(conn, pstmt, rs); }
		
		return userid;
	}

	public void deleteuser(String sessionID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("delete from user where userid=?;");
			pstmt.setString(1, sessionID);
			pstmt.executeUpdate();
		} catch(Exception e) { System.out.println("deleteuser error " + e);
		} finally { close(conn, pstmt, null); }
	}
}