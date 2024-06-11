package board.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.model.WriteRequest;
import board.service.WriteService;
import board.service.Writer;
import mvc.command.CommandHandler;

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
		uploadPath = "C:/project/work/group-project/src/main/webapp/image/uploadedImages";
		
		Writer writer = (Writer) request.getSession(false).getAttribute("login"); // multi로 받아야하는지 확인??
		MultipartRequest multi = new MultipartRequest(request, uploadPath, 5 * 1024 * 1024, "UTF-8",
				new DefaultFileRenamePolicy()); //이미지 저장

		WriteRequest writeRequest = toWriteRequest(multi, writer); // 매개변수를 객체로
		
		int boardNum = writeService.insertContent(writeRequest);
		request.setAttribute("boardNum", boardNum);
		
		return "/WEB-INF/view/list.jsp";
	}
	
	private WriteRequest toWriteRequest(MultipartRequest multi, Writer writer) throws Exception{
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		int price = Integer.parseInt(multi.getParameter("price"));
		String productCondition = multi.getParameter("productCondition");
		String category = multi.getParameter("category");
		int deliveryFee = Integer.parseInt(multi.getParameter("deliveryFee"));
		String location = multi.getParameter("location");
		List<String> imageList = writeService.uploadImages(multi, writer, uploadPath);
		
		WriteRequest writeRequest = new 
				WriteRequest(writer, title, content, imageList, price, productCondition, category, deliveryFee, location);
		return writeRequest;
	}
}
