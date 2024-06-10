package board.service;

public class AssembledBoard {

	private Board board;
	private BoardDetail boardDetail;
	private BoardContent boardContent;
	private Photo photo;

	public AssembledBoard(Board board, BoardDetail boardDetail, BoardContent boardContent, Photo photo) {
		super();
		this.board = board;
		this.boardDetail = boardDetail;
		this.boardContent = boardContent;
		this.photo = photo;
	}

	public Board getBoard() {
		return board;
	}

	public BoardDetail getBoardDetail() {
		return boardDetail;
	}

	public BoardContent getBoardContent() {
		return boardContent;
	}

	public Photo getPhoto() {
		return photo;
	}

}
