package baseball_final.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import baseball_final.service.FoodService;

public class DeleteFoodController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String foodnum = request.getParameter("foodnum");
		String team = request.getParameter("team");
		
		FoodService fs = FoodService.getInstance();
		fs.deletefood(foodnum);

		HttpUtil.forward(request, response, "foodsurroundmap.jsp?team" + team);
		
	}

}
