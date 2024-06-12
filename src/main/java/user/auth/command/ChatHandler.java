package user.auth.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import user.auth.service.ChatRoom;
import user.auth.service.ChatService;
import user.auth.service.User2;

public class ChatHandler implements CommandHandler {

	ChatService chatService = new ChatService();
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		String userId = ((User2) req.getSession().getAttribute("login")).getId(); 
		List<ChatRoom> chatRooms = showChatRoom(userId);
		req.setAttribute("chatList", chatRooms);
		return "/WEB-INF/view/chat.jsp";
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		String writerId = req.getParameter("writer");
		String title = req.getParameter("title");
		String userId = ((User2) req.getSession().getAttribute("login")).getId();
		
		chatService.makeChatRoom(writerId, userId, title);
		
		List<ChatRoom> chatRooms = showChatRoom(userId);
		req.setAttribute("chatList", chatRooms);
		return "/WEB-INF/view/chat.jsp";
	}

	private List<ChatRoom> showChatRoom(String userId) {
		return chatService.getChatRooms(userId);
	}
}
