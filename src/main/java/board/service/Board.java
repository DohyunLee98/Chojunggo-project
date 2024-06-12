package board.service;

import user.auth.service.User2;

public class Board {

	private Integer boardNum;
	private User2 writer;
	private String tradeStatus;

	public Board(Integer boardNum, User2 writer, String tradeStatus) {
		this.boardNum = boardNum;
		this.writer = writer;
		this.tradeStatus = tradeStatus;
	}

	public Integer getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(Integer boardNum) {
		this.boardNum = boardNum;
	}
	public User2 getUser2() {
		return writer;
	}

	public String getTradeStatus() {
		return tradeStatus;
	}
}
