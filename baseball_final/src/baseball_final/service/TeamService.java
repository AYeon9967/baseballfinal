package baseball_final.service;

import baseball_final.dao.TeamDao;

public class TeamService {

	private static TeamService service = new TeamService();
	private TeamService() {		}
	
	private TeamDao dao = TeamDao.getInstance();
	
	public static TeamService getInstance() {
		return service;
	}
	
	public String teamfullname(String team) {
		return dao.teamfullname(team);
	}
	
	public String teampage(String team) {
		return dao.teampage(team);
	}
	
	public double getx(String team) {
		return dao.getx(team);
	}
	
	public double gety(String team) {
		return dao.gety(team);
	}
	
	public String getstadium(String team) {
		return dao.getstadium(team);
	}
	
	public String getroadadd(String team) {
		return dao.getroadadd(team);
	}
	
	public String getadd(String team) {
		return dao.getadd(team);
	}
	
}
