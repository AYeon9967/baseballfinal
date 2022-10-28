package baseball_final.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import baseball_final.vo.Food;

public class FoodDao {
	
private static FoodDao dao = new FoodDao();
	
	private FoodDao() {}
	
	public static FoodDao getInstance() { return dao; }

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

	public List<Food> foodlist(String team) {
		Connection conn = connect();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Food> list = new ArrayList<>();
		
		try {
			String sql ="select * from food where team=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, team);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Food food = new Food();
				food.setFoodnum(rs.getInt("foodnum"));
				food.setTeam(rs.getString("team"));
				food.setCategory(rs.getString("category"));
				food.setRestaurant(rs.getString("restaurant"));
				food.setAddress(rs.getString("address"));
				food.setOneline(rs.getString("oneline"));
				food.setLat(rs.getDouble("lat"));
				food.setLng(rs.getDouble("lng"));
				food.setWriter(rs.getString("writer"));
				food.setWriternick(rs.getString("writernick"));
				list.add(food);
			}
			
		} catch (Exception e) { System.out.print("foodlist error " + e);
		} finally { close(conn, pstmt, rs);
		}
		return list;
	}

	public void writefood(Food food) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement(" insert into food(team, category, restaurant, address, oneline, lat, lng, writer, writernick) values(?, ?, ?, ?, ?, ?, ?, ?, ?);");
			pstmt.setString(1, food.getTeam());
			pstmt.setString(2, food.getCategory());
			pstmt.setString(3, food.getRestaurant());
			pstmt.setString(4, food.getAddress());
			pstmt.setString(5, food.getOneline());
			pstmt.setDouble(6, food.getLat());
			pstmt.setDouble(7, food.getLng());
			pstmt.setString(8, food.getWriter());
			pstmt.setString(9, food.getWriternick());
			pstmt.executeUpdate();
		} catch(Exception e) { System.out.println("writefood error " + e);
		} finally { close(conn, pstmt, null); }
	}

	public void deletefood(String foodnum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("delete from food where foodnum=?;");
			pstmt.setString(1, foodnum);
			pstmt.executeUpdate();
		} catch(Exception e) { System.out.println("deletefood error " + e);
		} finally { close(conn, pstmt, null); }
	}
	
}
