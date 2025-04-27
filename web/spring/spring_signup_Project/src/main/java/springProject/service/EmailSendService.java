package springProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailSendService {
	@Autowired
	JavaMailSender mailSender;
	public void send(String _fromEmail, String _toEmail 
					,String _subject , String _contents) {
		MimeMessage msg = mailSender.createMimeMessage();
		try {
			msg.setHeader("content-Type", "text/html; charset=UTF-8");
			msg.setContent(_contents, "text/html; charset=UTF-8"); // 내용
			msg.setSubject(_subject, "UTF-8"); // 제목
			msg.setFrom(new InternetAddress("soongmoostudent@gmail.com")); // 보내는 사람:고정
			msg.setRecipient(MimeMessage.RecipientType.TO
							, new InternetAddress(_toEmail));	// 받는 사람
			mailSender.send(msg);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
