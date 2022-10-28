package baseball_final.vo;

public class Postpic {

	private int picnum;
	private String picture;
	private int postnum;
	
	public Postpic() {	}
	
	public Postpic(int picnum, String picture, int postnum) {
		this.picnum = picnum;
		this.picture = picture;
		this.postnum = postnum;
	}

	public int getPicnum() {
		return picnum;
	}

	public void setPicnum(int picnum) {
		this.picnum = picnum;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getPostnum() {
		return postnum;
	}

	public void setPostnum(int postnum) {
		this.postnum = postnum;
	}
	
}
