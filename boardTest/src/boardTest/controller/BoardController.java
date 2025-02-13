package boardTest.controller;

import java.util.List;

import boardTest.model.BoardDTO;
import boardTest.service.BoardListService;
import boardTest.service.BoardWriteService;
import boardTest.view.BoardListView;
import boardTest.view.BoardWriteView;

public class BoardController {
	BoardDTO dto;
	public void ex() {
		int num = 0 ;
		boolean run = true;
		while (run) {
			switch(num) {
			case 0 :
				BoardListService listService = new BoardListService();
				List<BoardDTO> list = listService.execute();
				BoardListView listView = new BoardListView();
				num = listView.execute(list);
				break;
			case 1:
				BoardWriteView action = new BoardWriteView();
				dto = action.execute();
				num = 4;
				break;
			case 3:
				System.out.println("프로그램이 종료되었습니다.");
				run = false; break;
			case 4: 
				BoardWriteService writeService = new BoardWriteService();
				writeService.execute(dto);
				num = 0;
				break;
			}
		}
	}
}
