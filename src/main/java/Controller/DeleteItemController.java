package Controller;

import Dao.ItemDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/deleteItem")
public class DeleteItemController extends HttpServlet  {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int iid = Integer.parseInt(req.getParameter("id"));

        ItemDao itemDao = new ItemDao();
        itemDao.deleteItem(iid);
        resp.sendRedirect("toItem");
    }
}
