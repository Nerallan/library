package by.grsu.budko.library.sql;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQL {

    private String tablesURL;
    private String user;
    private String pwd;
    private static final Logger LOGGER = LogManager.getLogger(SQL.class.getName());
    private static final String FATAL_MESSAGE = "Что-то пошло не так";

    public SQL(String tablesURL, String user, String pwd) {
        this.tablesURL = tablesURL;
        this.user = user;
        this.pwd = pwd;
    }

    public void changeLine(String query) {
        try (Connection con = DriverManager.getConnection(tablesURL, user, pwd);
             Statement stmt = con.createStatement()) {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            LOGGER.fatal(FATAL_MESSAGE, e);
        }
    }

    public List<String> getLines(String query, int count) {
        List<String> list = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(tablesURL, user, pwd);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i=1;i<=count;i++) {
                    stringBuilder.append(rs.getString(i));
                    stringBuilder.append(";");
                }
                list.add(stringBuilder.toString().trim());
            }

        } catch (SQLException e) {
            LOGGER.fatal(FATAL_MESSAGE, e);
        }
        return list;
    }


}
