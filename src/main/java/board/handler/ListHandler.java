package board.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.ListPage;
import board.service.ListService;
import mvc.command.CommandHandler;

public class ListHandler implements CommandHandler{

    private ListService listService = new ListService();
    @Override
    public String process(HttpServletRequest req, HttpServletResponse res)  {
        String pageNoVal = req.getParameter("pageNo");
        String category = req.getParameter("category");
        System.out.println(category);
        int pageNo = 1;
        if (pageNoVal != null) {
            pageNo = Integer.parseInt(pageNoVal);
        }
        ListPage listPage = listService.getListPage(pageNo, category);

        req.setAttribute("boardPage", listPage);
        return "/WEB-INF/view/list.jsp";
    }
}
