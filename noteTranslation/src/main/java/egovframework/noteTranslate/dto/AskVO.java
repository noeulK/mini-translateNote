package egovframework.noteTranslate.dto;

import java.util.Date;

public class AskVO {
	private int ask_no;
	private int note_id;
	private int paragraph_id;
	private String ask_comment;
	private Date ask_date;
	private String ask_phrase;
	public int getAsk_no() {
		return ask_no;
	}
	public void setAsk_no(int ask_no) {
		this.ask_no = ask_no;
	}
	public int getNote_id() {
		return note_id;
	}
	public void setNote_id(int note_id) {
		this.note_id = note_id;
	}
	public int getParagraph_id() {
		return paragraph_id;
	}
	public void setParagraph_id(int paragraph_id) {
		this.paragraph_id = paragraph_id;
	}
	public String getAsk_comment() {
		return ask_comment;
	}
	public void setAsk_comment(String ask_comment) {
		this.ask_comment = ask_comment;
	}
	public Date getAsk_date() {
		return ask_date;
	}
	public void setAsk_date(Date ask_date) {
		this.ask_date = ask_date;
	}
	public String getAsk_phrase() {
		return ask_phrase;
	}
	public void setAsk_phrase(String ask_phrase) {
		this.ask_phrase = ask_phrase;
	}
	@Override
	public String toString() {
		return "AskVO [ask_no=" + ask_no + ", note_id=" + note_id + ", paragraph_id=" + paragraph_id + ", ask_comment="
				+ ask_comment + ", ask_date=" + ask_date + ", ask_phrase=" + ask_phrase + "]";
	}
	
	
}
