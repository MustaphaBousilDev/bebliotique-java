package classess;

import java.util.Date;

public class Reservation{
    private Books book;
    private Users user;
    private Date date_initial;
    private Date date_final;
    private Date date_returned;
    private int Quantity;
    private Boolean Status;

    public Reservations(Books book,Users user,Date date_initial, Date date_final, Date date_returned, int Quantity , boolean Status) {
        this.book=book;
        this.user=user;
        this.date_initial=date_initial;
        this.date_final=date_final;
        this.date_returned=date_returned;
        this.Quantity=Quantity;
        this.Status=Status;
    }
    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }


    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public void setDate_initial(Date date_initial){
        this.date_initial=date_initial;
    }

    public Date getDate_initial(Date date_final){
        return date_final;
    }

    public void setDate_final(Date date_final){
        this.date_final=date_final;
    }

    public Date getDate_final(){
        return date_final;
    }









}