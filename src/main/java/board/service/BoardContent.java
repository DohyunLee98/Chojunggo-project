package board.service;

public class BoardContent {

	private int boardNum;
	private String id;
	private String content;
	private String productCondition;
	private int deliveryFee;

	public BoardContent(int boardNum, String id, String content, String productCondition, int deliveryFee) {
		this.boardNum = boardNum;
		this.id = id;
		this.content = content;
		this.productCondition = productCondition;
		this.deliveryFee = deliveryFee;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public String getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public String getProductCondition() {
		return productCondition;
	}

	public int getDeliveryFee() {
		return deliveryFee;
	}

}
