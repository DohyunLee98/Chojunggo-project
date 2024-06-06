package board.model;

import java.util.List;

import board.service.Writer;

public class WriteRequest {

	private Writer writer;
	private String title;
	private String content;
	private List<String> imgNames;

	public WriteRequest(Writer writer, String title, String content, List<String> imgNames) {
		super();
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.imgNames = imgNames;
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

}
