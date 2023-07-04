package egovframework.noteTranslate.service.impl;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.noteTranslate.dao.CommonDAO;
import egovframework.noteTranslate.dto.MemberVO;
import egovframework.noteTranslate.service.LoginService;
import egovframework.noteTranslate.util.PasswordEncryption;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="commonDAO")
	private CommonDAO commonDAO;
	
	@Override
	public MemberVO loginMember(MemberVO member) throws SQLException, NoSuchAlgorithmException {
		PasswordEncryption pwdEncypt = new PasswordEncryption();
		member.setPassword(pwdEncypt.encrypt(member.getPassword()));
		MemberVO memberInfo = new MemberVO();
		memberInfo = commonDAO.selectOne("loginMapper.selectMemberByAccount", member);
		logger.info("login account : "+memberInfo);
		if(memberInfo !=null && (memberInfo.getUse_yn()).equals("Y")) {
			commonDAO.update("loginMapper.updateLastLoginDate", member);
		}
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

	@Override
	public MemberVO getMember(MemberVO member) throws SQLException {
		MemberVO memberInfo = (MemberVO)commonDAO.selectByPk("loginMapper.selectMemberByEmail", member);
		logger.info(memberInfo+"");
		return memberInfo;
	}

}
