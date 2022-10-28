package baseball_final.vo;

public class Post {
	
	private int postnum;
	private String team;
	private String writer;
	private String writernick;
	private String posttitle;
	private String postcategory;
	private String postcontents;
	private String uploaddate;
	
	public Post() {	}

	@Override
	public String toString() {
		return "Post [postnum=" + postnum + ", team=" + team + ", writer=" + writer + ", writernick=" + writernick
				+ ", posttitle=" + posttitle + ", postcategory=" + postcategory + ", postcontents=" + postcontents
				+ ", uploaddate=" + uploaddate + "]";
	}

	public Post(int postnum, String team, String writer, String writernick, String posttitle, String postcategory, String postcontents, String uploaddate) {
		this.postnum = postnum;
		this.team = team;
		this.writer = writer;
		this.writernick = writernick;
		this.posttitle = posttitle;
		this.postcategory = postcategory;
		this.postcontents = postcontents;
		this.uploaddate = uploaddate;
	}

	public int getPostnum() {
		return postnum;
	}

	public void setPostnum(int postnum) {
		this.postnum = postnum;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getWriternick() {
		return writernick;
	}

	public void setWriternick(String writernick) {
		this.writernick = writernick;
	}

	public String getPosttitle() {
		return posttitle;
	}

	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}

	public String getPostcategory() {
		return postcategory;
	}

	public void setPostcategory(String postcategory) {
		this.postcategory = postcategory;
	}

	public String getPostcontents() {
		return postcontents;
	}

	public void setPostcontents(String postcontents) {
		this.postcontents = postcontents;
	}

	public String getUploaddate() {
		return uploaddate;
	}

	public void setUploaddate(String uploaddate) {
		this.uploaddate = uploaddate;
	}

}
