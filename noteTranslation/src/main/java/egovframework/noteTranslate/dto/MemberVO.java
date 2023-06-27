package egovframework.noteTranslate.dto;

import java.util.Date;

public class MemberVO {
	private int user_no;
	private String user_email;
	private String password;
	private String nickname;
	private Date last_login_date;
	private String use_yn;
	
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getLast_login_date() {
		return last_login_date;
	}
	public void setLast_login_date(Date last_login_date) {
		this.last_login_date = last_login_date;
	}
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	@Override
	public String toString() {
		return "MemberVO [user_no=" + user_no + ", user_email=" + user_email + ", password=" + password + ", nickname="
				+ nickname + ", last_login_date=" + last_login_date + ", use_yn=" + use_yn + "]";
	}
	
	
}
