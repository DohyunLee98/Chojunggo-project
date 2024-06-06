package board.service;

public class BoardContent {

	private int boardNum;
	private String content;
	private String productCondition;
	private int deliveryFee;

	public BoardContent(int boardNum, String content, String productCondition, int deliveryFee) {
		super();
		this.boardNum = boardNum;
		this.content = content;
		this.productCondition = productCondition;
		this.deliveryFee = deliveryFee;
	}

	public int getBoardNum() {
		return boardNum;
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
