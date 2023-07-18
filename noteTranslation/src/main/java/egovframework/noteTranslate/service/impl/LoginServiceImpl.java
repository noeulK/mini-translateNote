package egovframework.noteTranslate.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.ReplaceOverride;
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
	public int signUpMemberBySNS(MemberVO member) throws SQLException{
		int res = commonDAO.update("insertMemberWithSNS", member);
		return res;
	}

	@Override
	public MemberVO getMember(MemberVO member) throws SQLException {
		logger.info("member vo : "+member);
		MemberVO memberInfo = (MemberVO)commonDAO.selectByPk("loginMapper.selectMemberByEmail", member);
		logger.info("get memeber :"+memberInfo+"");
		return memberInfo;
	}

	@Override
	public int modifyPassword(MemberVO member) throws SQLException, NoSuchAlgorithmException {
		PasswordEncryption pwdEncypt = new PasswordEncryption();
		member.setPassword(pwdEncypt.encrypt(member.getPassword()));
		int res = commonDAO.update("loginMapper.updatePasswordByEmail", member);
		return res;
		
	}

	@Override
	public Map<String, String> figureoutResponse(String apiURL) throws SQLException, IOException {
		Map<String, String> resMap = new HashMap<String, String>();
		String [] resArr;
		
		URL url = new URL(apiURL);
	    HttpURLConnection con = (HttpURLConnection)url.openConnection();
	    con.setRequestMethod("GET");
	    int responseCode = con.getResponseCode();
	    BufferedReader br;
	    if (responseCode == 200) { // 정상 호출
	      br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	    } else {  // 에러 발생
	      br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	    }
	    String inputLine;
	    StringBuilder res = new StringBuilder();
	    while ((inputLine = br.readLine()) != null) {
	      res.append(inputLine);
	    }
	    br.close();
	    if (responseCode == 200) {
	      String removeStr = res.toString().replaceAll("\"", "");
	      System.out.println("1 "+removeStr);
	      resArr = removeStr.substring(1, removeStr.toString().length() - 1).split(",");
	      System.out.println("2 "+Arrays.toString(resArr));
	      for(String pair : resArr) {
	    	  String [] parts = pair.split(":");
	    	  resMap.put(parts[0].trim(), parts[1].trim());
	      }
	    	
	    }
	    
		return resMap;
	}

}
