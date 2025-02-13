package boardTest.view;

import java.util.Scanner;

import boardTest.model.BoardDTO;

public class BoardWriteView {
	public BoardDTO execute() {
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력하세요");
		String userId = sc.nextLine();
		System.out.println("글쓴이를 입력하세요.");
		String boardName = sc.nextLine();
		System.out.println("제목을 입력하세요.");
		String boardSubject = sc.nextLine();
		System.out.println("내용을 입력하세요.");
		String boardContent = sc.nextLine();
		BoardDTO dto = new BoardDTO();
		dto.setBoardContent(boardContent);
		dto.setBoardName(boardName);
		dto.setBoardSubject(boardSubject);
		dto.setUserId(userId);
		return dto;
	}
}
