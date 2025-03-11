package jspBoardMVCProject.model;

public class BoardDTO { // 첫번째 단어 부터 첫글자를 대문자로 하자.
	int boardNum;
	String boardName;
	String boardSubject;
	String boardContent;
	// alt+shift+s   r
	                               //           낙타표기법을 사용.
	public String getBoardName() { // 이름만들기 : 변수와 함수명은 두번째단어 첫글자는 대문자로 하자.
		return boardName;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public String getBoardSubject() {
		return boardSubject;
	}
	public void setBoardSubject(String boardSubject) {
		this.boardSubject = boardSubject;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	
	
}
