package egovframework.noteTranslate.service;

import java.sql.SQLException;
import java.util.List;

import egovframework.noteTranslate.dto.MemberVO;
import egovframework.noteTranslate.dto.NoteVO;
import egovframework.noteTranslate.dto.VocaVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface MainService {

	

	public List<VocaVO> getVocaList(MemberVO member) throws SQLException;

	public List<NoteVO> getNoteList(MemberVO member) throws SQLException;
}
