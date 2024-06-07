package board.Handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.WriteService;
import board.service.Writer;
import mvc.command.CommandHandler;

public class WriteHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod().equalsIgnoreCase("get")) {
			return "/WEB-INF/view/upload.jsp";
		} else if (request.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception {
		WriteService writeService = new WriteService();
		Writer writer = (Writer) request.getSession(false).getAttribute("login");
		
		List<String> imageList = writeService.uploadImages(request, response, writer);

		
		return "/WEB-INF/view/showUploaded.jsp";
	}
}
