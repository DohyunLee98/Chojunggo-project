package board.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.ListPage;
import board.service.SearchService;
import mvc.command.CommandHandler;

public class SearchHandler implements CommandHandler{

    private SearchService searchService = new SearchService();
    @Override
    public String process(HttpServletRequest req, HttpServletResponse res)  {
        String pageNoVal = req.getParameter("pageNo");
        String searchWord = req.getParameter("searchWord");  
        
        int pageNo = 1;
        if (pageNoVal != null) {
            pageNo = Integer.parseInt(pageNoVal);
        }
        ListPage listPage = searchService.getListPage(pageNo,searchWord);
        req.setAttribute("boardPage", listPage);
        return "/WEB-INF/view/list.jsp";
    }
}