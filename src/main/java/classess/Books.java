package classess;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dbConnect.dbConnection;
import java.util.*;
public class Books{
    dbConnection db = new dbConnection();
    Scanner in = new Scanner(System.in);
    private String ISBN;
    private Integer Id;
    private String Title;
    private String Author;
    private String Status;
    private Integer QntTotal;
    private Integer QntEmprunt;
    private Integer QntPerdus;

    public Books() {

    }
    public String getISBN() {
        return ISBN;
    }
    public Integer getId() {
        return Id;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    public void setId(Integer id) {
        this.Id =id;
    }
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getQntTotal() {
        return QntTotal;
    }

    public int getQntEmp() {
        return QntEmprunt;
    }
    public void setQntEmp(int qntPerdus) {
        QntPerdus = qntPerdus;
    }

    public void setQntTotal(int qntTotal) {
        QntTotal = qntTotal;
    }

    public int getQntPerd() {
        return QntPerdus;
    }
    public void setQntPerd(int qntPerdus) {
        QntPerdus=qntPerdus;
    }

    public void display(){
        String query = "SELECT * FROM book where status='enable'";
        try (PreparedStatement statement = db.getConnection().prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.println("|                                                   Info                                            |");
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.println("| Isbn             | Title             | Author     | Status     | QntTotal  |  QntEmprunt  |  QntPerdus  |");
            System.out.println("----------------------------------------------------------------------------------------------------------");
            while (resultSet.next()) {
                String Isbn = resultSet.getString("Isbn");
                String Title = resultSet.getString("Title");
                String Author = resultSet.getString("Author");
                String Status = resultSet.getString("Status");
                int QntTotal = resultSet.getInt("QntTotal");
                int QntEmprunt = resultSet.getInt("QntEmprunt");
                int QntPerdus = resultSet.getInt("QntPerdus");
                System.out.println(String.format("| %-16s | %-16s | %-10s | %-10s | %-8d | %-10d | %-9d |",Isbn ,Title, Author,Status,QntTotal , QntEmprunt , QntPerdus));
            }
            System.out.println("-----------------------------------------------------------------------------------------------------");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void search(String title,String author){
        String query = "SELECT * FROM book WHERE title LIKE ? OR author LIKE ?";


        try (PreparedStatement statement = db.getConnection().prepareStatement(query)) {
            statement.setString(1, title );
            statement.setString(2, author);
            ResultSet resultSet = statement.executeQuery();
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.println("|                                               Info Book                                     |");
            System.out.println("-----------------------------------------------------------------------------------------------------");
            System.out.println("| Isbn             |Title            | Author    | Status     | QntTotal | QntEmprunt | QntPerdus  |");
            System.out.println("-----------------------------------------------------------------------------------------------------");
            while (resultSet.next()) {
                String Isbn = resultSet.getString("isbn");
                String Title = resultSet.getString("title");
                String Author = resultSet.getString("author");
                String Status = resultSet.getString("status");
                Integer QntTotal = resultSet.getInt("qntTotal");
                Integer QntEmprunt = resultSet.getInt("qntEmprunt");
                Integer QntPerdus = resultSet.getInt("qntPerdus");
                System.out.println(String.format("| %-16s | %-16s | %-10s | %-10s | %-8d | %-10d | %-9d |",Isbn ,Title, Author,Status,QntTotal , QntEmprunt , QntPerdus));
            }
            System.out.println("-----------------------------------------------------------------------------------------------------");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void edit(String isbn){
        String Title;
        String Author;
        String QntTotal;
        String QntEmprunt;
        String QntPerdus;

        do {

        } while (!isValidString(isbn));

        do {
            System.out.println("new Titre : ");
            Title = in.nextLine();
        } while (!isValidString(Title));

        do {
            System.out.println("new Author : ");
            Author = in.nextLine();
        } while (!isValidString(Author));



        do {
            System.out.println("new QntTotal : ");
            QntTotal = in.nextLine();
        } while (!isValidInteger(QntTotal));

        do {
            System.out.println("new QntEmprunt : ");
            QntEmprunt = in.nextLine();
        } while (!isValidInteger(QntEmprunt));

        do {
            System.out.println("new QntPerdus : ");
            QntPerdus = in.nextLine();
        } while (!isValidInteger(QntPerdus));

        String query = "UPDATE book SET title = ?, author = ?,qntTotal = ?,qntEmprunt = ?,qntPerdus = ? WHERE isbn = ?";

        try (PreparedStatement statement = db.getConnection().prepareStatement(query)) {


            statement.setString(1, Title);
            statement.setString(2, Author);
            statement.setString(3, QntTotal);
            statement.setString(4, QntEmprunt);
            statement.setString(5, QntPerdus);
            statement.setString(6, isbn);


            int rowCount = statement.executeUpdate();

            if (rowCount > 0) {
                System.out.println("Success modify book.");
            } else {
                System.out.println("empty.");
            }


        } catch (SQLException e) {

            System.err.println("Error: " + e.getMessage());
        }
    }

    public void filter(String Query){}

    public void delete(){
        String isbn;
        do {
            System.out.println("set isbn : ");
            isbn = in.nextLine();
        } while (!isValidString(isbn));

        String query = "DELETE FROM `book` WHERE Isbn = ?";
        try (PreparedStatement statement = db.getConnection().prepareStatement(query)){
            statement.setString(1, isbn);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("success deleted");
            } else {
                System.out.println("nothing");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void add(){
        String Isbn;
        String Title;
        String Author;
        String QntTotal;
        String QntEmprunt;
        String QntPerdus;
        String Status;

        do {
            System.out.println("Isbn : ");
            Isbn = in.nextLine();
            setISBN(Isbn);
        } while (!isValidInteger(Isbn));

        do {
            System.out.println("Title : ");
            Title = in.nextLine();
            setTitle(Title);
        } while (!isValidString(Title));

        do {
            System.out.println("Author : ");
            Author = in.nextLine();
            setAuthor(Author);
        } while (!isValidString(Author));


        do {
            System.out.println("QntTotal : ");
            QntTotal = in.nextLine();
        } while (!isValidString(QntTotal));

        do {
            System.out.println("QntEmprunt : ");
            QntEmprunt = in.nextLine();
        } while (!isValidInteger(QntEmprunt));

        do {
            System.out.println("QntPerdus : ");
            QntPerdus = in.nextLine();
        } while (!isValidInteger(QntPerdus));

        String query = "INSERT INTO `book`(`Isbn`, `Title`, `author`, `qntTotal`, `qntEmprunt`, `qntPerdus`) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement statement = db.getConnection().prepareStatement(query)){
            statement.setString(1, Isbn );
            statement.setString(2, getTitle());
            statement.setString(3, getAuthor());
            statement.setInt(4, Integer.parseInt(QntTotal));
            statement.setInt(5, Integer.parseInt(QntEmprunt));
            statement.setInt(6, Integer.parseInt(QntPerdus));


            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("success");
            } else {
                System.out.println("add book");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean CheckBook(Integer id_book){
        String query = "SELECT * from book where id=?";
        try(PreparedStatement statement = db.getConnection().prepareStatement(query)){
            statement.setInt(1,id_book);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                setId(resultSet.getInt("id"));
                setISBN(resultSet.getString("isbn"));
                setTitle(resultSet.getString("Title"));
                setAuthor(resultSet.getString("author"));
                setStatus(resultSet.getString("status"));
                setQntTotal(resultSet.getInt("qntTotal"));
                setQntEmp(resultSet.getInt("qntEmprunt"));
                setQntPerd(resultSet.getInt("qntPerdus"));
                return true;
            } else {
                return false; // No matching book found
            }

        }catch (Exception e){
            e.getMessage();
            return false;
        }
    }
    public static  boolean  isValidString(String input){
        String regex = "^[a-zA-Z]+$";
        if(input.matches(regex)) {
            return true;
        }
        return !input.isEmpty();
    }
    public static boolean isValidInteger(String input){
        try {
            // Attempt to parse the input string as an integer
            Integer.parseInt(input);
            // If parsing is successful, return true
            return true;
        } catch (NumberFormatException e) {
            // If an exception is thrown, return false
            return false;
        }
    }

    public void totalBookEnable(){
        String query="select title,qntTotal - qntEmprunt -qntPerdus as QtyEnable from book where status='enable'";
        try (PreparedStatement statement = db.getConnection().prepareStatement(query)){
            //statement.setString(1,getTitre());
            ResultSet resultSet = statement.executeQuery();
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("|                               Statis                                  |");
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("| Title        |   QntEnable  |");
            System.out.println("-------------------------------------------------------------------------");

            while (resultSet.next()) {
                String Title = resultSet.getString("title");
                Integer QntEnable = resultSet.getInt("QtyEnable");
                System.out.println(String.format("| %-16s | %-9d |", Title, QntEnable));
            }
            System.out.println("-------------------------------------------------------------------------");

        }catch (SQLException e){
            e.getMessage();
        }

    }
    public void totalBookLost(){
        String query="select title,qntPerdus as QtyLost from book";
        try (PreparedStatement statement = db.getConnection().prepareStatement(query)){
            //statement.setString(1,getTitre());
            ResultSet resultSet = statement.executeQuery();
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("|                               Statis                                  |");
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("| Title        |   QntLost  |");
            System.out.println("-------------------------------------------------------------------------");

            while (resultSet.next()) {
                String Title = resultSet.getString("title");
                Integer QntLost = resultSet.getInt("QtyLost");
                System.out.println(String.format("| %-16s | %-9d |", Title, QntLost));
            }
            System.out.println("-------------------------------------------------------------------------");

        }catch (SQLException e){
            e.getMessage();
        }
    }
    public void totalBookReserve(){
        String query="select title,qntEmprunt as QtyEmp from book";
        try (PreparedStatement statement = db.getConnection().prepareStatement(query)){
            //statement.setString(1,getTitre());
            ResultSet resultSet = statement.executeQuery();
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("|                               Statis                                  |");
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("| Title        |   QntEmpr  |");
            System.out.println("-------------------------------------------------------------------------");

            while (resultSet.next()) {
                String Title = resultSet.getString("title");
                Integer QntEmp= resultSet.getInt("QtyEmp");
                System.out.println(String.format("| %-16s | %-9d |", Title, QntEmp));
            }
            System.out.println("-------------------------------------------------------------------------");

        }catch (SQLException e){
            e.getMessage();
        }
    }
}