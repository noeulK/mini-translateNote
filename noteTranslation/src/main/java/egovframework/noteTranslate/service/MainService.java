package egovframework.noteTranslate.service;

import java.sql.SQLException;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface MainService {

	public EgovMap selectMain()throws SQLException;
}
