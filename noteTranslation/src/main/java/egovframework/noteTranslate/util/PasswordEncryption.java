package egovframework.noteTranslate.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class PasswordEncryption {

	public String encrypt(String password) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(password.getBytes());
		
		return bytesToHex(md.digest());
		
	}
	
	private String bytesToHex(byte[] digestPw) {
		StringBuilder strBuilder = new StringBuilder();
		for(byte b : digestPw) {
			strBuilder.append(String.format("%02x", b));
		}
		return strBuilder.toString();
	}
}
