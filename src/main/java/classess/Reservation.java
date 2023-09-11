package classess;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dbConnect.dbConnection;

public class Reservation {
    private List<Books> books;
    private Users user;
    private LocalDate DateEmprunt;
    private LocalDate DateReturn;
    private LocalDate DateFinal;

    public Reservation(List<Books> book, Users user, LocalDate dateEmprunt, LocalDate dateFinal) {
        this.books = book;
        this.user = user;
        DateEmprunt = dateEmprunt;
        DateReturn = dateFinal;
    }

    public Reservation() {
        this.books = new ArrayList<>();
    }

    public List<Books> getBook() {
        return books;
    }

    public void addBook(Books book) {
        books.add(book);
    }

    public Users getEmprunteur() {
        return user;
    }

    public void setEmprunteur(Users emprunteur) {
        this.user = emprunteur;
    }

    public LocalDate getDateReturn() {
        return DateReturn;
    }
    public LocalDate getDateFinal() {
        return DateFinal;
    }

    public void setDateReturn(LocalDate dateReturn) {
        DateReturn = dateReturn;
    }
    public void setDateFinal(LocalDate dateFinal) {
        DateFinal = dateFinal;
    }

    public LocalDate getDateEmprunt() {
        return DateEmprunt;
    }

    public void setDateEmprunt(LocalDate dateEmprunt) {
        DateEmprunt = dateEmprunt;
    }

    dbConnection db = new dbConnection();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Books book : books) {
            sb.append("Isbn Book :").append(book.getISBN()).append("\n");
            sb.append("Title Book :").append(book.getTitle()).append("\n");
        }
        sb.append("Cin User :").append(user.getCin()).append("\n");
        sb.append("Emprunteur :").append(user.getName());
        sb.append("DateEmprunt :").append(DateEmprunt).append("\n");
        sb.append("DateReteur :").append(DateReturn).append("\n");


        return sb.toString();
    }

    public void addReservation(Integer book_id, Integer user_id){
        String query ="INSERT INTO `reservation`(`user_id`, `book_id`, `date_initial`, `date_final`) VALUES (?,?,?,?)";
        try(PreparedStatement statement = db.getConnection().prepareStatement(query)){
            //for (Books book : books) {

                statement.setInt(1, user_id);
                statement.setInt(2, book_id);
                statement.setString(3, String.valueOf(DateEmprunt));
                statement.setString(4, String.valueOf(DateFinal));
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println(toString());
                }
            //}
        }catch (SQLException e){
            System.out.println( e.getMessage());
        }
    }

    public boolean VerifyBookEmp(Integer book_id,Integer user_id){
        String query = "SELECT * from book INNER JOIN reservation on book.id = reservation.book_id INNER JOIN users ON reservation.user_id = users.id where book.id=? and users.id=?";
        try(PreparedStatement statement = db.getConnection().prepareStatement(query)){
            statement.setInt(1,book_id);
            statement.setInt(2,user_id);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();

        }catch (Exception e){
            return false;
        }

    }
    public void updateStatus(String status,Integer book_id, Integer user_id){
       String query="UPDATE reservation set status=?, date_returned=? where book_id=? and user_id=?";
       try(PreparedStatement statement = db.getConnection().prepareStatement(query)){
           statement.setInt(1,Integer.parseInt(status));
           statement.setString(2, String.valueOf(LocalDate.now()));
           statement.setInt(3,book_id);
           statement.setInt(4,user_id);
           int rowCount = statement.executeUpdate();

           if (rowCount > 0) {
               System.out.println("Success change status.");
           } else {
               System.out.println("empty.");
           }
       }catch(SQLException e){
           System.err.println("Error: " + e.getMessage());
       }
    }

}