package egovframework.noteTranslate.dto;

import java.util.Date;

public class VocaVO {
	private int note_id;
	private String note_title;
	private int total_cnt;
	private int memorize_cnt;
	private Date note_update_date;
	private String note_update_date_str; 
	
	private int voca_id;
	private String voca_word;
	private String voca_meaning;
	private String reg_writer;
	private String memorize_yn;
	public int getNote_id() {
		return note_id;
	}
	public void setNote_id(int note_id) {
		this.note_id = note_id;
	}
	public String getNote_title() {
		return note_title;
	}
	public void setNote_title(String note_title) {
		this.note_title = note_title;
	}
	public int getTotal_cnt() {
		return total_cnt;
	}
	public void setTotal_cnt(int total_cnt) {
		this.total_cnt = total_cnt;
	}
	public int getMemorize_cnt() {
		return memorize_cnt;
	}
	public void setMemorize_cnt(int memorize_cnt) {
		this.memorize_cnt = memorize_cnt;
	}
	public Date getNote_update_date() {
		return note_update_date;
	}
	public void setNote_update_date(Date note_update_date) {
		this.note_update_date = note_update_date;
	}
	public String getNote_update_date_str() {
		return note_update_date_str;
	}
	public void setNote_update_date_str(String note_update_date_str) {
		this.note_update_date_str = note_update_date_str;
	}
	public int getVoca_id() {
		return voca_id;
	}
	public void setVoca_id(int voca_id) {
		this.voca_id = voca_id;
	}
	public String getVoca_word() {
		return voca_word;
	}
	public void setVoca_word(String voca_word) {
		this.voca_word = voca_word;
	}
	public String getVoca_meaning() {
		return voca_meaning;
	}
	public void setVoca_meaning(String voca_meaning) {
		this.voca_meaning = voca_meaning;
	}
	public String getReg_writer() {
		return reg_writer;
	}
	public void setReg_writer(String reg_writer) {
		this.reg_writer = reg_writer;
	}
	public String getMemorize_yn() {
		return memorize_yn;
	}
	public void setMemorize_yn(String memorize_yn) {
		this.memorize_yn = memorize_yn;
	}
	@Override
	public String toString() {
		return "VocaVO [note_id=" + note_id + ", note_title=" + note_title + ", total_cnt=" + total_cnt
				+ ", memorize_cnt=" + memorize_cnt + ", note_update_date=" + note_update_date
				+ ", note_update_date_str=" + note_update_date_str + ", voca_id=" + voca_id + ", voca_word=" + voca_word
				+ ", voca_meaning=" + voca_meaning + ", reg_writer=" + reg_writer + ", memorize_yn=" + memorize_yn
				+ "]";
	}
	
	
	
}
