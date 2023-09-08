package classess;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import dbConnect.dbConnection;

public class EmprunteurBook {
    private List<Books> books;
    private Users user;
    private LocalDate DateEmprunt;
    private LocalDate DateReturn;
    private LocalDate DateFinal;

    public EmprunteurBook(List<Books> book, Users user, LocalDate dateEmprunt, LocalDate dateFinal) {
        this.books = book;
        this.user = user;
        DateEmprunt = dateEmprunt;
        DateReturn = dateFinal;
    }

    public EmprunteurBook(){
        this.books = new ArrayList<>();
    }

    public List<Books> getBook() {
        return books;
    }

    public void addBook(Books book) {
        book.add(book);
    }

    public Users getEmprunteur() {
        return user;
    }

    public void setEmprunteur(Users emprunteur) {
        this.user = emprunteur;
    }

    public LocalDate getDateEmprunt() {
        return DateEmprunt;
    }

    public void setDateEmprunt(LocalDate dateEmprunt) {
        DateEmprunt = dateEmprunt;
    }


}