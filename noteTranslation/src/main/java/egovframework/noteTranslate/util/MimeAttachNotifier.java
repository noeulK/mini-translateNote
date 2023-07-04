package egovframework.noteTranslate.util;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MimeAttachNotifier{
	
	//private Logger logger = LoggerFactory.getLogger(this.getClass());
	private JavaMailSender mailSender;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public void sendMail(String email, String subject, String text){
		MimeMessage message = mailSender.createMimeMessage();
		
		MimeMessageHelper messageHelper = null;
		try {
			messageHelper = new MimeMessageHelper(message, true, "utf-8");
		
		
			messageHelper.setTo(new InternetAddress(email));
			
			messageHelper.setFrom("jerrycock88@gmail.com","Note of Translation");
			
			messageHelper.setSubject(subject);
			
			messageHelper.setText(text, true);
			mailSender.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
