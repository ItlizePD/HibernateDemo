package Controller;

import Dao.CartDao;
import Dao.ItemDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteCart")
public class DeleteCartController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int iid = Integer.parseInt(req.getParameter("iid"));
        int uid = Integer.parseInt(req.getParameter("uid"));

        CartDao cartDao = new CartDao();
        cartDao.deleteTran(iid,uid);
        resp.sendRedirect("toCart");
    }
}
