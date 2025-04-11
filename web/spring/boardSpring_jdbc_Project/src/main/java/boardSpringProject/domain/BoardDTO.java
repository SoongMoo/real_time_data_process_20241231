package boardSpringProject.domain;

import lombok.Data;

@Data
public class BoardDTO {
	// table columns
	int boardNum;
	String boardWriter;
	String boardSubject;
	String boardContent;
}
