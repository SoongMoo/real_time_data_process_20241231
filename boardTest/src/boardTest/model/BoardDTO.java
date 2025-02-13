package boardTest.model;

import java.util.Date;

import lombok.Data;

@Data // alt+shift+s  r
public class BoardDTO {  // BoardVO
	   Integer boardNum;
	   String userId;
	   String boardName;
	   String boardSubject;
	   String boardContent;
	   Date boardDate;
	   Integer readCount;
}
