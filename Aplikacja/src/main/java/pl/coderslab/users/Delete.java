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

@WebServlet("/delete")
public class Delete extends HttpServlet {
    private static final String DELETE_USER_QUERY = "DELETE FROM users WHERE id=?;";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        UserDao.removeAtList(id);
        try (Connection conn = DbUtil.getConnection()) {
            String id = request.getParameter("id");
            PreparedStatement stat = conn.prepareStatement(DELETE_USER_QUERY);
            stat.setString(1, id);
            stat.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/list").forward(request, response);
    }
}
