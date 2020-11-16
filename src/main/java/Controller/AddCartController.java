package Controller;

import Dao.CartDao;
import Dao.ItemDao;
import Dao.UserDao;
import Entity.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/addCart")
public class AddCartController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int iid = Integer.parseInt(req.getParameter("id"));
        int uid = new UserDao().getUser().getUid();
        LocalDate myObj = LocalDate.now();

        CartDao cartDao = new CartDao();
        cartDao.addCart(iid,uid,myObj.toString());
        resp.sendRedirect("toCart");
    }
}
