package baseball_final.dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import baseball_final.vo.Post;
import baseball_final.vo.Postpic;
import baseball_final.vo.Reply;

public class PostDao {
	
	private static PostDao dao = new PostDao();
	
	private PostDao() {}
	
	public static PostDao getInstance() { return dao; }

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

	public List<Post> postlist(String team) {
		Connection conn = connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Post> list = new ArrayList<>();
		
		try {
			String sql ="select * from post where team=? order by uploaddate asc;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, team);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Post post = new Post();
				post.setPostnum(rs.getInt("postnum"));
				post.setTeam(rs.getString("team"));
				post.setWriter(rs.getString("writer"));
				post.setWriternick(rs.getString("writernick"));
				post.setPosttitle(rs.getString("posttitle"));
				post.setPostcategory(rs.getString("postcategory"));
				post.setPostcontents(rs.getString("postcontents"));
				post.setUploaddate(rs.getString("uploaddate"));
				list.add(post);
			}
			
		} catch (Exception e) { System.out.print("postlist error " + e);
		} finally { close(conn, pstmt, rs);
		}
		return list;
	}
	
	public List<Post> postlistdesc(String team) {
		Connection conn = connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Post> list = new ArrayList<>();
		
		try {
			String sql ="select * from post where team=? order by uploaddate desc;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, team);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Post post = new Post();
				post.setPostnum(rs.getInt("postnum"));
				post.setTeam(rs.getString("team"));
				post.setWriter(rs.getString("writer"));
				post.setWriternick(rs.getString("writernick"));
				post.setPosttitle(rs.getString("posttitle"));
				post.setPostcategory(rs.getString("postcategory"));
				post.setPostcontents(rs.getString("postcontents"));
				post.setUploaddate(rs.getString("uploaddate"));
				list.add(post);
			}
			
		} catch (Exception e) { System.out.print("postlistdesc error " + e);
		} finally { close(conn, pstmt, rs);
		}
		return list;
	}
	
	public List<Post> mypagepostlist(String userid) {
		Connection conn = connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Post> list = new ArrayList<>();
		
		try {
			String sql ="select * from post where writer=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Post post = new Post();
				post.setPostnum(rs.getInt("postnum"));
				post.setTeam(rs.getString("team"));
				post.setPosttitle(rs.getString("posttitle"));
				post.setPostcategory(rs.getString("postcategory"));
				post.setUploaddate(rs.getString("uploaddate"));
				list.add(post);
			}
			
		} catch (Exception e) { System.out.print("mypagepostlist error " + e);
		} finally { close(conn, pstmt, rs);
		}
		return list;
	}
	
	public List<Reply> mypagereplylist(String userid) {
		Connection conn = connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Reply> list = new ArrayList<>();
		
		try {
			String sql ="select * from reply where userid=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Reply reply = new Reply();
				reply.setPostnum(rs.getInt("postnum"));
				reply.setReplynum(rs.getInt("replynum"));
				reply.setReplycontents(rs.getString("replycontents"));
				reply.setUploaddate(rs.getString("uploaddate"));
				list.add(reply);
			}
			
		} catch (Exception e) { System.out.print("mypagereplylist error " + e);
		} finally { close(conn, pstmt, rs);
		}
		return list;
	}

	public void writepost(Post post) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into post(team, writer, writernick, posttitle, postcategory, postcontents, uploaddate) values(?, ?, ?, ?, ?, ?, now());");
			pstmt.setString(1, post.getTeam());
			pstmt.setString(2, post.getWriter());
			pstmt.setString(3, post.getWriternick());
			pstmt.setString(4, post.getPosttitle());
			pstmt.setString(5, post.getPostcategory());
			pstmt.setString(6, post.getPostcontents());
			pstmt.executeUpdate();
		} catch(Exception e) { System.out.println("writepost error " + e);
		} finally { close(conn, pstmt, null); }
	}

	public int getpostnum(String posttitle) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int postnum = 0;
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select postnum from post where posttitle=?;");
			pstmt.setString(1, posttitle);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				postnum = rs.getInt(1);
			}
		} catch(Exception e) { System.out.println("getPN error " + e);
		} finally { close(conn, pstmt, rs); }
		
		return postnum;
	}
	
	public int getpostnum(int replynum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int postnum = 0;
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select postnum from reply where replynum=?;");
			pstmt.setInt(1, replynum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				postnum = rs.getInt(1);
			}
		} catch(Exception e) { System.out.println("getPN int error " + e);
		} finally { close(conn, pstmt, rs); }
		
		return postnum;
	}

	public void uploadpic(Postpic postpic) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into postpic(picture, postnum) values(?, ?);");
			pstmt.setString(1, postpic.getPicture());
			pstmt.setLong(2, postpic.getPostnum());
			pstmt.executeUpdate();
		} catch(Exception e) { System.out.println("uploadpic error " + e);
		} finally { close(conn, pstmt, null); }
	}

	public Post showpost(String postnum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Post post = new Post();
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select * from post where postnum=?;");
			pstmt.setString(1, postnum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				post.setPostnum(rs.getInt("postnum"));
				post.setPostcategory(rs.getString("postcategory"));
				post.setPosttitle(rs.getString("posttitle"));
				post.setPostcontents(rs.getString("postcontents"));
				post.setWriter(rs.getString("writer"));
				post.setWriternick(rs.getString("writernick"));
				post.setUploaddate(rs.getString("uploaddate"));
				post.setTeam(rs.getString("team"));
			}
		} catch(Exception e) { System.out.println("showpost error " + e);
		} finally { close(conn, pstmt, rs); }
		
		return post;
	}

	public List<Reply> showreply(int postnum) {
		Connection conn = connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Reply> list = new ArrayList<>();
		
		try {
			String sql ="select * from reply where postnum=? order by uploaddate asc;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postnum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Reply reply = new Reply();
				reply.setPostnum(rs.getInt("postnum"));
				reply.setReplynum(rs.getInt("replynum"));
				reply.setReplycontents(rs.getString("replycontents"));
				reply.setUploaddate(rs.getString("uploaddate"));
				reply.setUserid(rs.getString("userid"));
				list.add(reply);
			}
			
		} catch (Exception e) { System.out.print("showreply error " + e);
		} finally { close(conn, pstmt, rs);
		}
		
		return list;
	}

	public List<Postpic> showpicture(int postnum) {
		Connection conn = connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Postpic> list = new ArrayList<>();
		
		try {
			String sql ="select * from postpic where postnum=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postnum);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Postpic postpic = new Postpic();
				postpic.setPostnum(rs.getInt("postnum"));
				postpic.setPicnum(rs.getInt("picnum"));
				postpic.setPicture(rs.getString("picture"));
				list.add(postpic);
			}
			
		} catch (Exception e) { System.out.print("showpicture error " + e);
		} finally { close(conn, pstmt, rs);
		}
		
		return list;
	}

	public void writereply(Reply reply) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into reply(postnum, userid, replycontents, uploaddate) values(?, ?, ?, now());");
			pstmt.setInt(1, reply.getPostnum());
			pstmt.setString(2, reply.getUserid());
			pstmt.setString(3, reply.getReplycontents());
			pstmt.executeUpdate();
		} catch(Exception e) { System.out.println("writereply error " + e);
		} finally { close(conn, pstmt, null); }
	}

	public void deletereply(int replynum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("delete from reply where replynum=?;");
			pstmt.setInt(1, replynum);
			pstmt.executeUpdate();
		} catch(Exception e) { System.out.println("deletereply error " + e);
		} finally { close(conn, pstmt, null); }
	}

	public String getpostteam(int postnum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String postteam = null;
		
		try {
			conn = connect();
			pstmt = conn.prepareStatement("select team from post where postnum=?;");
			pstmt.setInt(1, postnum);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				postteam = rs.getString(1);
			}
		} catch(Exception e) { System.out.println("getPT int error " + e);
		} finally { close(conn, pstmt, rs); }
		
		return postteam;
	}

	public void deletepost(int postnum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("delete from post where postnum=?;");
			pstmt.setInt(1, postnum);
			pstmt.executeUpdate();
		} catch(Exception e) { System.out.println("deletepost error " + e);
		} finally { close(conn, pstmt, null); }
	}

	public void deletepostpic(int postnum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("delete from postpic where postnum=?;");
			pstmt.setInt(1, postnum);
			pstmt.executeUpdate();
		} catch(Exception e) { System.out.println("deletepostpic error " + e);
		} finally { close(conn, pstmt, null); }
	}

	public void deletereplybypostnum(int postnum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("delete from reply where postnum=?;");
			pstmt.setInt(1, postnum);
			pstmt.executeUpdate();
		} catch(Exception e) { System.out.println("deletereplybypostnum error " + e);
		} finally { close(conn, pstmt, null); }
	}

	public void updatepost(Post post) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			// "update user set profileimg=?, userpw=?, name=?, nickname=?, gender=?, birthday=?, phone=?, email=?, favorite=? where userid=?;"
			pstmt = conn.prepareStatement("update post set posttitle=?, postcategory=?, postcontents=? where postnum=?;");
			pstmt.setString(1, post.getPosttitle());
			pstmt.setString(2, post.getPostcategory());
			pstmt.setString(3, post.getPostcontents());
			pstmt.setInt(4, post.getPostnum());
			pstmt.executeUpdate();
		} catch(Exception e) { System.out.println("updatepost error " + e);
		} finally { close(conn, pstmt, null); }
	}

	public void updatepic(Postpic postpic) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("update postpic set picture=? where picnum=?;");
			pstmt.setString(1, postpic.getPicture());
			pstmt.setInt(2, postpic.getPicnum());
			pstmt.executeUpdate();
		} catch(Exception e) { System.out.println("updatepic error " + e);
		} finally { close(conn, pstmt, null); }
	}

	public String getstorage(String img) {
		String sString = null;
		if (!img.equals("defaultprofileimg.png")){
			sString = "storage";
		} else {
			sString = "resource/image";
		}
		return sString;
	}

	public List<Post> searchpostlist(String team, String searchthing, String keyword) {
		Connection conn = connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Post> list = new ArrayList<>();
		
		try {
			String sql ="select * from post where " + searchthing + " like ? and team=? order by uploaddate asc;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, team);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Post post = new Post();
				post.setPostnum(rs.getInt("postnum"));
				post.setTeam(rs.getString("team"));
				post.setWriter(rs.getString("writer"));
				post.setPosttitle(rs.getString("posttitle"));
				post.setPostcategory(rs.getString("postcategory"));
				post.setPostcontents(rs.getString("postcontents"));
				post.setUploaddate(rs.getString("uploaddate"));
				list.add(post);
			}
			
		} catch (Exception e) { System.out.print("searchpostlist error " + e);
		} finally { close(conn, pstmt, rs);
		}
		return list;
	}

	public List<Post> searchpostlistdesc(String team, String searchthing, String keyword) {
		Connection conn = connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Post> list = new ArrayList<>();
		
		try {
			String sql ="select * from post where " + searchthing + " like ? and team=? order by uploaddate desc;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, team);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Post post = new Post();
				post.setPostnum(rs.getInt("postnum"));
				post.setTeam(rs.getString("team"));
				post.setWriter(rs.getString("writer"));
				post.setPosttitle(rs.getString("posttitle"));
				post.setPostcategory(rs.getString("postcategory"));
				post.setPostcontents(rs.getString("postcontents"));
				post.setUploaddate(rs.getString("uploaddate"));
				list.add(post);
			}
			
		} catch (Exception e) { System.out.print("searchpostlistdesc error " + e);
		} finally { close(conn, pstmt, rs);
		}
		return list;
	}

	public void deletereplybyid(String sessionID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("delete from reply where userid=?;");
			pstmt.setString(1, sessionID);
			pstmt.executeUpdate();
		} catch(Exception e) { System.out.println("deletereplybyid error " + e);
		} finally { close(conn, pstmt, null); }
	}

	public void deletepostbyid(String sessionID) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("update post set writer='알수없음', writernick='알수없음' where writer=?;");
			pstmt.setString(1, sessionID);
			pstmt.executeUpdate();
		} catch(Exception e) { System.out.println("deletepostbyid error " + e);
		} finally { close(conn, pstmt, null); }
	}

}
