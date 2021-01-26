package pl.coderslab.users;

import pl.coderslab.utils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/edit")
public class Edit extends HttpServlet {

    private static final String MODYFICATE_USER_QUERY = "UPDATE users SET  username = ?, email = ?, password = ? WHERE id = ?;";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        System.out.println(id);
        String name = request.getParameter("userDao");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement prepStm = conn.prepareStatement(MODYFICATE_USER_QUERY);
            prepStm.setString(4, id);
            prepStm.setString(1, name);
            prepStm.setString(2, email);
            prepStm.setString(3, password);
            prepStm.executeUpdate();
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/users/edit.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("userDao", UserDao.read(id));
        getServletContext().getRequestDispatcher("/users/edit.jsp").forward(request, response);

    }

    public static void main(String[] args) {

    }
}
