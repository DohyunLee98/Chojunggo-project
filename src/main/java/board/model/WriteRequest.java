package board.model;

import java.util.List;

import board.service.Writer;

public class WriteRequest {

	private Writer writer;
	private String title;
	private String content;
	private List<String> imgNames;
	private int price;
	private String productCondition;
	private String category;
	private int deliveryFee;
	private String location;

	public WriteRequest() {
	}

	public WriteRequest(Writer writer, String title, String content, List<String> imgNames, int price,
			String productCondition, String category, int deliveryFee, String location) {
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.imgNames = imgNames;
		this.price = price;
		this.productCondition = productCondition;
		this.category = category;
		this.deliveryFee = deliveryFee;
		this.location = location;
	}

	public Writer getWriter() {
		return writer;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public List<String> getImgNames() {
		return imgNames;
	}

	public void setImgNames(List<String> imgNames) {
		this.imgNames = imgNames;
	}

	public int getPrice() {
		return price;
	}

	public String getProductCondition() {
		return productCondition;
	}

	public String getCategory() {
		return category;
	}

	public int getDeliveryFee() {
		return deliveryFee;
	}

	public String getLocation() {
		return location;
	}

}
