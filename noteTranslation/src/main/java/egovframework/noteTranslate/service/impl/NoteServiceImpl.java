package egovframework.noteTranslate.service.impl;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.noteTranslate.dao.CommonDAO;
import egovframework.noteTranslate.dto.AskVO;
import egovframework.noteTranslate.dto.NoteVO;
import egovframework.noteTranslate.dto.VocaVO;
import egovframework.noteTranslate.service.NoteService;

@Service("noteService")
public class NoteServiceImpl implements NoteService{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="commonDAO")
	private CommonDAO commonDAO;
	
	@Override
	public int saveDraft(NoteVO note) throws SQLException {
		logger.info("service save draft");
		commonDAO.insert("noteMapper.insertNoteDraft", note);
		int note_id = (int) commonDAO.selectByPk("noteMapper.selectNoteIdBymember", note);
		logger.info("no : "+note_id);
		return note_id;
	}

	@Override
	public int askSentence(AskVO param) throws SQLException {
		int res = commonDAO.update("noteMapper.insertAskBoard", param);
		return res;
	}

	@Override
	public int saveVoca(VocaVO voca){
		logger.info("1");
		int res = 0;
		try {
			
			res = commonDAO.update("noteMapper.insertVoca", voca);
		}catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		logger.info("res :"+res);
		return res;
	}

}
