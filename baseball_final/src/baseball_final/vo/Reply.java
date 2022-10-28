package baseball_final.vo;

public class Reply {

	private int replynum;
	private String userid;
	private String replycontents;
	private String uploaddate;
	private int postnum;
	
	public Reply() {	}
	
	public Reply(int replynum, String userid, String replycontents, String uploaddate, int postnum) {
		this.replynum = replynum;
		this.userid = userid;
		this.replycontents = replycontents;
		this.uploaddate = uploaddate;
		this.postnum = postnum;
	}
	
	public int getReplynum() {
		return replynum;
	}
	public void setReplynum(int replynum) {
		this.replynum = replynum;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getReplycontents() {
		return replycontents;
	}
	public void setReplycontents(String replycontents) {
		this.replycontents = replycontents;
	}
	public String getUploaddate() {
		return uploaddate;
	}
	public void setUploaddate(String uploaddate) {
		this.uploaddate = uploaddate;
	}
	public int getPostnum() {
		return postnum;
	}
	public void setPostnum(int postnum) {
		this.postnum = postnum;
	}
	
}
