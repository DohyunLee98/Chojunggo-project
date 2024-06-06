package board.service;

public class Board {

	private int boardNum;
	private Writer writer;
	private String title;
	private String tradeStatus;

	public Board(int boardNum, Writer writer, String title, String tradeStatus) {
		super();
		this.boardNum = boardNum;
		this.writer = writer;
		this.title = title;
		this.tradeStatus = tradeStatus;
	}

	public int getBoardNum() {
		return boardNum;
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
