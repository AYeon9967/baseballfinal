package baseball_final.service;

import java.util.List;

import baseball_final.dao.FoodDao;
import baseball_final.vo.Food;

public class FoodService {
	
	private static FoodService service = new FoodService();
	private FoodService() {		}
	
	private FoodDao dao = FoodDao.getInstance();
	
	public static FoodService getInstance() {
		return service;
	}
	
	public List<Food> foodlist(String team) {
		return dao.foodlist(team);
	}

	public void writefood(Food food) {
		dao.writefood(food);
	}

	public void deletefood(String foodnum) {
		dao.deletefood(foodnum);
	}
	
}
