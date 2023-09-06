package dbConnect;

import java.sql.*;

public class dbConnection {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/jdbcdemo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static Connection connection;

    public dbConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Charger le pilote JDBC
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

}