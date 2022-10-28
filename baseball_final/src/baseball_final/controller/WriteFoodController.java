package baseball_final.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import baseball_final.service.FoodService;
import baseball_final.service.UserService;
import baseball_final.vo.Food;

public class WriteFoodController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		
		UserService us = UserService.getInstance();
		FoodService fs = FoodService.getInstance();
		Food food = new Food();
		
		String team = request.getParameter("team");
		
		food.setTeam(team);
		food.setWriter((String)session.getAttribute("sessionID"));
		food.setWriternick(us.usernickSearch((String)session.getAttribute("sessionID")));
		food.setCategory(request.getParameter("category"));
		food.setRestaurant(request.getParameter("restaurant"));
		food.setAddress(request.getParameter("address"));
		food.setOneline(request.getParameter("oneline"));
		food.setLat(Double.parseDouble(request.getParameter("lat")));
		food.setLng(Double.parseDouble(request.getParameter("lng")));
		
		fs.writefood(food);
		
		HttpUtil.forward(request, response, "foodsurroundmap.jsp?team=" + team);
	}

}
