package egovframework.noteTranslate.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Map;

import egovframework.noteTranslate.dto.MemberVO;

public interface LoginService {

	public MemberVO loginMember(MemberVO member) throws SQLException, NoSuchAlgorithmException;

	public String checkAccount(MemberVO member) throws SQLException;

	public String checkDuplicatedNickname(MemberVO member) throws SQLException;

	public int signUpMember(MemberVO member) throws SQLException, NoSuchAlgorithmException;
	
	public int signUpMemberBySNS(MemberVO member) throws SQLException;

	public MemberVO getMember(MemberVO member) throws SQLException;

	public int modifyPassword(MemberVO member) throws SQLException, NoSuchAlgorithmException;

	public Map<String, String> figureoutResponse(String apiURL) throws SQLException, MalformedURLException, IOException;
}
