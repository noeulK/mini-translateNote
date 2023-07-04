package egovframework.noteTranslate.service;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import egovframework.noteTranslate.dto.MemberVO;

public interface LoginService {

	public MemberVO loginMember(MemberVO member) throws SQLException, NoSuchAlgorithmException;

	public String checkAccount(MemberVO member) throws SQLException;

	public String checkDuplicatedNickname(MemberVO member) throws SQLException;

	public int signUpMember(MemberVO member) throws SQLException, NoSuchAlgorithmException;

	public MemberVO getMember(MemberVO member) throws SQLException;
}
