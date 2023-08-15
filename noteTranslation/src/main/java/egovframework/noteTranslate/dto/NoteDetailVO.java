package egovframework.noteTranslate.dto;

public class NoteDetailVO {
	private int note_id;
	private int phrase_no;
	private String original;
	private String translated_version;
	
	public int getNote_id() {
		return note_id;
	}
	public void setNote_id(int note_id) {
		this.note_id = note_id;
	}
	public int getPhrase_no() {
		return phrase_no;
	}
	public void setPhrase_no(int phrase_no) {
		this.phrase_no = phrase_no;
	}
	public String getOriginal() {
		return original;
	}
	public void setOriginal(String original) {
		this.original = original;
	}
	public String getTranslated_version() {
		return translated_version;
	}
	public void setTranslated_version(String translated_version) {
		this.translated_version = translated_version;
	}
	@Override
	public String toString() {
		return "NoteDetailVO [note_id=" + note_id + ", phrase_no=" + phrase_no + ", original=" + original
				+ ", translated_version=" + translated_version + "]";
	}
	
	
}
