package egovframework.noteTranslate.service;

import java.sql.SQLException;

import egovframework.noteTranslate.dto.AskVO;
import egovframework.noteTranslate.dto.NoteVO;
import egovframework.noteTranslate.dto.VocaVO;

public interface NoteService {

	public int saveDraft(NoteVO note)throws SQLException;

	public int askSentence(AskVO param)throws SQLException;

	public int saveVoca(VocaVO voca)throws SQLException;
}
