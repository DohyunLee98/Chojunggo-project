package board.handler;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.model.WriteRequest;
import board.service.WriteService;
import mvc.command.CommandHandler;
import user.auth.service.User2;

public class WriteHandler implements CommandHandler {

	WriteService writeService;
	String uploadPath;

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod().equalsIgnoreCase("get")) {
			return "/WEB-INF/view/write.jsp";
		} else if (request.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		writeService = new WriteService();
		uploadPath = "C:\\project\\work\\chojunggo5\\src\\main\\webapp\\image\\uploadedImages";
		Map<String, Boolean> errors = new HashMap<>();
		request.setAttribute("errors", errors);

		User2 writer = (User2) request.getSession(false).getAttribute("login"); // multi로 받아야하는지 확인??
		MultipartRequest multi = new MultipartRequest(request, uploadPath, 5 * 1024 * 1024, "UTF-8",
				new DefaultFileRenamePolicy()); // 이미지 저장
		WriteRequest writeRequest = toWriteRequest(multi, writer, errors); // 매개변수를 객체로
		if (writeRequest == null) {
			return "/WEB-INF/view/write.jsp";
		}
		int boardNum = writeService.insertContent(writeRequest);
		request.setAttribute("boardNum", boardNum);

		return "/success.do";
	}

	private WriteRequest toWriteRequest(MultipartRequest multi, User2 writer, Map<String, Boolean> errors)
			throws Exception {
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		String price = multi.getParameter("price");
		String productCondition = multi.getParameter("productCondition");
		String category = multi.getParameter("category");
		int deliveryFee = 0;
		if (multi.getParameter("deliveryFee") == null || multi.getParameter("deliveryFee").length() == 0) {
			deliveryFee = 0;
		} else {
			deliveryFee = Integer.parseInt(multi.getParameter("deliveryFee"));
		}
		
		String location = multi.getParameter("h_area1") + " "+ multi.getParameter("h_area2");
		List<String> imageList = writeService.uploadImages(multi, writer, uploadPath);
		if (title == null || title.length() == 0) {
			errors.put("title", true);
		}
		if (content == null || content.length() == 0) {
			errors.put("content", true);
		}
		if (price == null || price.length() == 0 || price.isEmpty()) {
			errors.put("price", true);
		}
		if (productCondition == null || productCondition.length() == 0) {
			errors.put("productConditon", true);
		}
		if (category.equals("----설정안함----")) {
			errors.put("category", true);
		}
		if (location.equals("----설정안함----")) {
			errors.put("location", true);
		}

		if (!errors.isEmpty()) {
			return null;
		}

		WriteRequest writeRequest = new WriteRequest(writer, title, content, imageList, Integer.parseInt(multi.getParameter("price")),
				productCondition, category, deliveryFee, location);
		return writeRequest;
	}
}
