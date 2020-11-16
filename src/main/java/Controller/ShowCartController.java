package Controller;

import Dao.CartDao;
import Entity.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/toCart")
public class ShowCartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CartDao cartDao = new CartDao();
        List<Object> trans = cartDao.getTrans();

        req.setAttribute("trans",trans);
        req.getRequestDispatcher("showCart.jsp").forward(req, resp);
    }
}
