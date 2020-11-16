package Controller;


import Dao.ItemDao;
import Entity.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/toItem")
public class ShowItemController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ItemDao itemDao = new ItemDao();
        List<Item> items = itemDao.getItems();

        req.setAttribute("items",items);
        req.getRequestDispatcher("showItems.jsp").forward(req, resp);
    }
}
