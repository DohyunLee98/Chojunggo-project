package board.service;

import java.util.List;

public class Photo {

	private int boardNum;
	private List<String> imageName;

	public Photo(int boardNum, List<String> imageName) {
		this.boardNum = boardNum;
		this.imageName = imageName;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public List<String> getImageName() {
		return imageName;
	}

	public void setImageName(List<String> imageName) {
		this.imageName = imageName;
	}

}
