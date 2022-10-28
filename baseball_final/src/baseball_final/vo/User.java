package baseball_final.vo;

public class User {
	
	private String profileimg;
	private String userid;
	private String userpw;
	private String name;
	private String nickname;
	private String gender;
	private String birthday;
	private String phone;
	private String email;
	private String favorite;
	
	public User() {	}
	
	public User(String profileimg, String userid, String userpw, String name, String nickname, String gender, String birthday, String phone, String email, String favorite) {
		this.profileimg = profileimg;
		this.userid = userid;
		this.userpw = userpw;
		this.name = name;
		this.nickname = nickname;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.favorite = favorite;
	}
	
	public String getProfileimg() {
		return profileimg;
	}
	public void setProfileimg(String profileimg) {
		this.profileimg = profileimg;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFavorite() {
		return favorite;
	}
	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}

}
