package egovframework.noteTranslate.dto;

import java.util.Date;

public class NoteVO {


	private int note_id;
	private String note_title;
	private String note_content;
	private String note_baked_content;
	private Date note_reg_date;
	private Date note_update_date;
	private String note_writer;
	
	private String note_reg_date_str;
	private String note_update_date_str;
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
	public String getNote_content() {
		return note_content;
	}
	public void setNote_content(String note_content) {
		this.note_content = note_content;
	}
	public String getNote_baked_content() {
		return note_baked_content;
	}
	public void setNote_baked_content(String note_baked_content) {
		this.note_baked_content = note_baked_content;
	}
	public Date getNote_reg_date() {
		return note_reg_date;
	}
	public void setNote_reg_date(Date note_reg_date) {
		this.note_reg_date = note_reg_date;
	}
	public Date getNote_update_date() {
		return note_update_date;
	}
	public void setNote_update_date(Date note_update_date) {
		this.note_update_date = note_update_date;
	}
	public String getNote_writer() {
		return note_writer;
	}
	public void setNote_writer(String note_writer) {
		this.note_writer = note_writer;
	}
	public String getNote_reg_date_str() {
		return note_reg_date_str;
	}
	public void setNote_reg_date_str(String note_reg_date_str) {
		this.note_reg_date_str = note_reg_date_str;
	}
	public String getNote_update_date_str() {
		return note_update_date_str;
	}
	public void setNote_update_date_str(String note_update_date_str) {
		this.note_update_date_str = note_update_date_str;
	}
	@Override
	public String toString() {
		return "NoteVO [note_id=" + note_id + ", note_title=" + note_title + ", note_content=" + note_content
				+ ", note_baked_content=" + note_baked_content + ", note_reg_date=" + note_reg_date
				+ ", note_update_date=" + note_update_date + ", note_writer=" + note_writer + ", note_reg_date_str="
				+ note_reg_date_str + ", note_update_date_str=" + note_update_date_str + "]";
	}
	
	
}
