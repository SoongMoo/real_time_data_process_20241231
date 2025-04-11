package boardSpringProject.command;

import lombok.Data;

@Data
public class BoardCommand {
	int boardNum;
	String boardWriter;
	String boardSubject;
	String boardContent;
}
