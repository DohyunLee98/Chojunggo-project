package board.service;

import java.util.Date;

public class BoardDetail {

	private int boardNum;
	private String title;
	private int price;
	private int likesCNT;
	private String category;
	private String location;
	private Date createdDate;
	private String thumbName;

	public BoardDetail(int boardNum,String title, int price, int likesCNT, String category, String location, Date createdDate,
			String thumbName) {
		this.boardNum = boardNum;
		this.title = title;
		this.price = price;
		this.likesCNT = likesCNT;
		this.category = category;
		this.location = location;
		this.createdDate = createdDate;
		this.thumbName = thumbName;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public String getTitle() {
		return title;
	}

	public int getPrice() {
		return price;
	}

	public int getLikesCNT() {
		return likesCNT;
	}

	public String getCategory() {
		return category;
	}

	public String getLocation() {
		return location;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public String getThumbName() {
		return thumbName;
	}

}
