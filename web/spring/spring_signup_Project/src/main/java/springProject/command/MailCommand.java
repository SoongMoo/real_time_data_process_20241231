package springProject.command;

import lombok.Data;

@Data
public class MailCommand {
	String fromEmail;
	String toEmail;
	String subject;
	String contents;
}
