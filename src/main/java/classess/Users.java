package classess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dbConnect.dbConnection;
public class Users{
    private String Cin;
    private String Name;
    private Integer Id;

    public Users() {
        //Cin = cin;
        //Name = name;
    }


    public String getCin() {
        return Cin;
    }

    public void setCin(String cin) {
        Cin = cin;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getId(){return Id;}

    public void setId(Integer id){
        Id=id;
    }

    dbConnection db = new dbConnection();
    public void Add_user(){
        String query = "INSERT INTO `users`(`cin`, `name`) VALUES (?,?)";
        try(PreparedStatement statement = db.getConnection().prepareStatement(query)){
            statement.setString(1,Cin);
            statement.setString(2,Name);
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Success Add User");
            }
        }catch (SQLException e){
            //msg
            //System.out.println(e.getMessage());
        }
    }

    public boolean VerifierUser(Integer id_user){
        String query = "SELECT * from users where id=?";
        try(PreparedStatement statement = db.getConnection().prepareStatement(query)){
            statement.setInt(1,id_user);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("eeeeeeee");
            if (resultSet.next()) {
                System.out.println("eeeeeeee inside");


                setCin(resultSet.getString("cin"));
                setName(resultSet.getString("name"));
                System.out.println(Cin);
                System.out.println(Name);
                return true;
            } else {
                return false;
            }

        }catch (Exception e){
            e.getMessage();
            return false;
        }
    }




}
