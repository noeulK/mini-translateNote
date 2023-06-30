package egovframework.noteTranslate.service.impl;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.noteTranslate.dao.CommonDAO;
import egovframework.noteTranslate.dto.MemberVO;
import egovframework.noteTranslate.service.LoginService;
import egovframework.noteTranslate.util.PasswordEncryption;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	
	@Resource(name="commonDAO")
	private CommonDAO commonDAO;
	
	@Override
	public MemberVO loginMember(MemberVO member) throws SQLException, NoSuchAlgorithmException {
		PasswordEncryption pwdEncypt = new PasswordEncryption();
		member.setPassword(pwdEncypt.encrypt(member.getPassword()));
		MemberVO memberInfo = commonDAO.selectOne("loginMapper.selectMemberByAccount", member);
		
		return memberInfo;
	}

	@Override
	public String checkAccount(MemberVO member) throws SQLException {
		String res =  "";
		res = (String)commonDAO.selectByPk("loginMapper.selectDuplicatedAccount", member);
		return res;
	}

	@Override
	public String checkDuplicatedNickname(MemberVO member) throws SQLException {
		String res = "";
		res = (String)commonDAO.selectByPk("loginMapper.selectDuplicatedNickname", member);
		return res;
	}

	@Override
	public int signUpMember(MemberVO member) throws SQLException, NoSuchAlgorithmException {
		PasswordEncryption pwdEncrypt = new PasswordEncryption();
		member.setPassword(pwdEncrypt.encrypt(member.getPassword()));
		int res = commonDAO.update("loginMapper.insertMember", member);
		return res;
	}

}
