package Controller;

import Dao.ItemDao;
import Entity.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/addItem")
public class AddItemController extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String iname = req.getParameter("itemName");
        Item item = new Item();
        item.setIname(iname);

        ItemDao itemDao = new ItemDao();
        itemDao.createItem(item);
        resp.sendRedirect("toItem");
    }
}
