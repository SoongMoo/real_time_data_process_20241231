package boardTest.view;

import java.util.List;
import java.util.Scanner;

import boardTest.model.BoardDTO;

public class BoardListView {
	public int execute(List<BoardDTO> list) {
		Scanner sc = new Scanner(System.in);
		System.out.println("게시글 리스트");
		System.out.println("번호 \t 글쓴이 \t 제목");
		for (BoardDTO dto : list) {
			System.out.println(dto.getBoardNum() + "\t" + dto.getBoardName() + "\t" 
							+ dto.getBoardSubject());
		}
		System.out.println("1. 글쓰기 | 2. 상세보기 | 3. 종료 ");
		int i = sc.nextInt();
		return i;
	}
}
