package board.service;

public class Board {

	private Integer boardNum;
	private Writer writer;
	private String tradeStatus;

	public Board(Integer boardNum, Writer writer, String tradeStatus) {
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
	public Writer getWriter() {
		return writer;
	}

	public String getTradeStatus() {
		return tradeStatus;
	}
}
