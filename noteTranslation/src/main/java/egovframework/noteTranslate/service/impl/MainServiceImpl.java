package egovframework.noteTranslate.service.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.noteTranslate.dao.CommonDAO;
import egovframework.noteTranslate.dto.MemberVO;
import egovframework.noteTranslate.dto.NoteVO;
import egovframework.noteTranslate.dto.VocaVO;
import egovframework.noteTranslate.service.MainService;

@Service("mainService")
public class MainServiceImpl implements MainService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource(name="commonDAO")
	private CommonDAO commonDAO;
	
	
	@Override
	public List<VocaVO> getVocaList(MemberVO member) throws SQLException {
		List<VocaVO> vocaList = commonDAO.selectList("mainMapper.selectVocaList", member);
		
		for(VocaVO voca : vocaList) {
			voca.setNote_update_date_str(changeDateFormat(voca.getNote_update_date()));
		}
		return vocaList;
	}

	@Override
	public List<NoteVO> getNoteList(MemberVO member) throws SQLException {
		List<NoteVO> noteList = commonDAO.selectList("mainMapper.selectNoteList", member);
		for(NoteVO note : noteList) {
			note.setNote_update_date_str(changeDateFormat(note.getNote_update_date()));
		}
		return noteList;
	}
	
	public String changeDateFormat(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일");
		String dateForm = "";
		try {
			
			dateForm = dateFormat.format(date);
		}catch(Exception e) {
			e.getStackTrace();
		}
		return dateForm;
	}
}
