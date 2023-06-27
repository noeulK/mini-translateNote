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

}
