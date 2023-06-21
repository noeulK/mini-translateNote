package egovframework.noteTranslate.service.impl;

import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.noteTranslate.dao.CommonDAO;
import egovframework.noteTranslate.service.MainService;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("mainService")
public class MainServiceImpl implements MainService{

	@Resource(name="commonDAO")
	private CommonDAO commonDAO;
	
	@Override
	public EgovMap selectMain() throws SQLException {
		return commonDAO.selectOne("mainMapper.select");
	}
}
