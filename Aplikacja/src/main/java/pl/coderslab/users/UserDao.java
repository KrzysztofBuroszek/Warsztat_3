package pl.coderslab.users;

import pl.coderslab.utils.DbUtil;

import java.sql.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private static final String ALL_USERS_QUERY = "SELECT *FROM users;";

    private static final String CREATE_USER_QUERY = "INSERT INTO users (email, username, password) VALUES (?, ?, ?);";

    private static final String READ_USER_QUERY = "SELECT * FROM users WHERE id = ?";

    private static final String MODYFICATE_USER_QUERY = "UPDATE users SET  username = ?, email = ?, password = ? WHERE id = ?;";

    private static final String DELETE_USER_QUERY = "DELETE FROM users WHERE id=?;";

    private static List<User> users = new ArrayList<>();


    public static List<User> allUsers() {
        users.clear();
        try (Connection conn = DbUtil.getConnection();
             Statement stat = conn.createStatement()) {
            ResultSet rs = stat.executeQuery(ALL_USERS_QUERY);
            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String userName = rs.getString("userName");
                User user = new User(id, userName, email);
                users.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        for (Object user : users) {
            System.out.println(user);
        }
        return users;
    }

    public static User read(String userId) {
//        User user = new User();
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(READ_USER_QUERY);
            stat.setString(1, userId);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String email = rs.getString("email");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                System.out.println(id + " " + email + " " + userName + " " + password);
                User userDao = new User(id, email, userName, password);
                return userDao;
            }
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
//        read(4);
        allUsers();
    }

    public static Object calendar() {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();
        Month nameMonth = date.getMonth();

        date = date.minusDays(today - 1);
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();

        System.out.println(date.getMonth() + " " + date.getYear());
        System.out.println(" PN,WT,ŚR,CZ,PT,SO,ND");
        for (int i = 1; i < value; i++) {
            System.out.print("   ");
        }
        while (date.getMonthValue() == month) {
            if (date.getDayOfMonth() != today) {
                System.out.printf("%3d", date.getDayOfMonth());
            } else {
                System.out.printf("%3d" + "*", date.getDayOfMonth());
            }
            date = date.plusDays(1);

            if (date.getDayOfWeek().getValue() == 1)
                System.out.println();
        }
        if (date.getDayOfWeek().getValue() != 1)
            System.out.println();
        System.out.println();
        return null;
    }

    public static LocalDate date() {
        return LocalDate.now();
    }

    public static void removeAtList(String id) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement stat = conn.prepareStatement(DELETE_USER_QUERY);
            stat.setString(1, id);
            stat.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void update(String id) {
//        try (Connection conn = DbUtil.getConnection()) {
//            PreparedStatement prepStm = conn.prepareStatement(MODYFICATE_USER_QUERY);
//
//            System.out.println("ID TO MODYFICATION");
//            prepStm.setInt(4, );
//            System.out.println("NEW NAME");
//            prepStm.setString(1, ());
//            System.out.println("NEW EMAIL");
//            prepStm.setString(2, ());
//            System.out.println("NEW PASSWORD");
//            prepStm.setString(3, );
//            prepStm.executeUpdate();
//        } catch (
//                SQLException throwables) {
//            throwables.printStackTrace();
//        }
    }




}
