package egovframework.noteTranslate.service;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import egovframework.noteTranslate.dto.MemberVO;

public interface LoginService {

	public MemberVO loginMember(MemberVO member) throws SQLException, NoSuchAlgorithmException;
}
