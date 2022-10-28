package baseball_final.dao;

public class TeamDao {
	
	private static TeamDao dao = new TeamDao();
	
	private TeamDao() {}
	
	public static TeamDao getInstance() { return dao; }

	public String teamfullname(String team) {
		String fullname = null;
			switch(team) {
			    case "lg" :     	fullname = "엘지 트윈스(LG TWINS)";        break;
			    case "ssg" :     	fullname = "에스에스지 랜더스(SSG LANDERS)";        break;
			    case "samsung" :     	fullname = "삼성 라이온즈(SAMSUNG LIONS)";        break;
			    case "doosan" :     	fullname = "두산 베어스(DOOSAN BEARS)";        break;
			    case "kiwoom" :     	fullname = "키움 히어로즈(KIWOOM HEROS)";        break;
			    case "kt" :     	fullname = "케이티 위즈(KT WIZ)";        break;
			    case "kia" :     	fullname = "기아 타이거즈(KIA TIGERS)";        break;
			    case "nc" :     	fullname = "엔씨 다이노스(NC DINOS)";        break;
			    case "lotte" :     	fullname = "롯데 자이언츠(LOTTE GIANTS)";        break;
			    case "hanhwa" :     	fullname = "한화 이글스(HANHWA EAGLES)";        break;
			    default :     	fullname = "관심구단이 없습니다.";        break;
			}
		return fullname;
	}

	public String teampage(String team) {
		String teampage = null;
			switch(team) {
		    case "lg" :     	teampage = "'https://www.lgtwins.com/service/html.ncd?view=/pc_twins/twins_main/twins_main'";        break;
		    case "ssg" :     	teampage = "'http://www.ssglanders.com/main'";        break;
		    case "samsung" :     	teampage = "'https://www.samsunglions.com/index.asp'";        break;
		    case "doosan" :     	teampage = "'https://www.doosanbears.com/'";        break;
		    case "kiwoom" :     	teampage = "'https://www.heroesbaseball.co.kr/index.do'";        break;
		    case "kt" :     	teampage = "'https://www.ktwiz.co.kr/'";        break;
		    case "kia" :     	teampage = "'https://tigers.co.kr/'";        break;
		    case "nc" :     	teampage = "'https://www.ncdinos.com/'";        break;
		    case "lotte" :     	teampage = "'https://www.giantsclub.com/html/'";        break;
		    case "hanhwa" :     	teampage = "'https://www.hanwhaeagles.co.kr/index.do'";        break;
		    default :     	teampage = "#";        break;
			}
		return teampage;
	}

	public double getx(String team) {
		double x = 0;
			switch(team) {
		    case "lg" :     	x = 37.5122579;        break;
		    case "ssg" :     	x = 37.4367513;        break;
		    case "samsung" :     	x = 35.8410136;        break;
		    case "doosan" :     	x = 37.5122579;        break;
		    case "kiwoom" :     	x = 37.498182;        break;
		    case "kt" :     	x = 37.2997553;        break;
		    case "kia" :     	x = 35.1682592;        break;
		    case "nc" :     	x = 35.2225335;        break;
		    case "lotte" :     	x = 35.1940316;        break;
		    case "hanhwa" :     	x = 36.3172026;        break;
		    default :     	x = 0;        break;
			}
		return x;
	}
	
	public double gety(String team) {
		double y = 0;
			switch(team) {
		    case "lg" :     	y = 127.0719011;        break;
		    case "ssg" :     	y = 126.6933083;        break;
		    case "samsung" :     	y = 128.6819955;        break;
		    case "doosan" :     	y = 127.0719011;        break;
		    case "kiwoom" :     	y = 126.8670082;        break;
		    case "kt" :     	y = 127.0096685;        break;
		    case "kia" :     	y = 126.8884114;        break;
		    case "nc" :     	y = 128.5823895;        break;
		    case "lotte" :     	y = 129.0615183;        break;
		    case "hanhwa" :     	y = 127.4285703;        break;
		    default :     	y = 0;        break;
			}
		return y;
	}

	public String getstadium(String team) {
		String stadium = null;
			switch(team) {
		    case "lg" :     	stadium = "잠실종합운동장잠실야구장";        break;
		    case "ssg" :     	stadium = "인천SSG 랜더스필드";        break;
		    case "samsung" :     	stadium = "대구삼성라이온즈파크";        break;
		    case "doosan" :     	stadium = "잠실종합운동장잠실야구장";        break;
		    case "kiwoom" :     	stadium = "고척스카이돔";        break;
		    case "kt" :     	stadium = "수원KT위즈파크";        break;
		    case "kia" :     	stadium = "광주기아챔피언스필드";        break;
		    case "nc" :     	stadium = "창원NC파크";        break;
		    case "lotte" :     	stadium = "부산사직종합운동장사직야구장";        break;
		    case "hanhwa" :     	stadium = "한화생명이글스파크";        break;
		    default :     	stadium = "#";        break;
			}
		return stadium;
	}
	
	public String getroadadd(String team) {
		String roadadd = null;
			switch(team) {
		    case "lg" :     	roadadd = "서울 송파구 올림픽로 19-2 서울종합운동장";        break;
		    case "ssg" :     	roadadd = "인천 미추홀구 매소홀로 618";        break;
		    case "samsung" :     	roadadd = "대구 수성구 야구전설로 1 대구삼성라이온즈파크";        break;
		    case "doosan" :     	roadadd = "서울 송파구 올림픽로 19-2 서울종합운동장";        break;
		    case "kiwoom" :     	roadadd = "서울 구로구 경인로 430 고척스카이돔";        break;
		    case "kt" :     	roadadd = "경기 수원시 장안구 경수대로 893 수원종합운동장(주경기장)";        break;
		    case "kia" :     	roadadd = "광주 북구 서림로 10 무등종합경기장";        break;
		    case "nc" :     	roadadd = "경남 창원시 마산회원구 삼호로 63";        break;
		    case "lotte" :     	roadadd = "부산 동래구 사직로 45";        break;
		    case "hanhwa" :     	roadadd = "대전 중구 대종로 373";        break;
		    default :     	roadadd = "#";        break;
			}
		return roadadd;
	}
	
	public String getadd(String team) {
		String add = null;
			switch(team) {
		    case "lg" :     	add = "잠실동 10-1";        break;
		    case "ssg" :     	add = "문학동 482";        break;
		    case "samsung" :     	add = "연호동 648";        break;
		    case "doosan" :     	add = "잠실동 10-1";        break;
		    case "kiwoom" :     	add = "고척동 66-2";        break;
		    case "kt" :     	add = "조원동 775";        break;
		    case "kia" :     	add = "임동 316 광주기아챔피언스필드";        break;
		    case "nc" :     	add = "양덕동 477";        break;
		    case "lotte" :     	add = "사직동 930";        break;
		    case "hanhwa" :     	add = "부사동 209-1";        break;
		    default :     	add = "#";        break;
			}
		return add;
	}

}
