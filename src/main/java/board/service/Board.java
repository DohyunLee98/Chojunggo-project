package board.service;

public class Board {

	private Integer boardNum;
	private Writer writer;
	private String title;
	private String tradeStatus;

	public Board(Integer boardNum, Writer writer, String title, String tradeStatus) {
		this.boardNum = boardNum;
		this.writer = writer;
		this.title = title;
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

	public String getTitle() {
		return title;
	}

	public String getTradeStatus() {
		return tradeStatus;
	}
}
