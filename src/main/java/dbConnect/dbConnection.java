package classess;
import java.sql.*;

public class dbConnection {
    public static void main (String[] args) {
        String url="jdbc:mysql://localhost:3306/jdbcdemo";
        String username="root";
        String password="";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection=DriverManager.getConnection(url,username,password);
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from users");
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+ resultSet.getString(3));
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
