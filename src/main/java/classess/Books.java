package classess;
public class Books{
    private Integer ISBN;
    private String Title;
    private String Author;
    private String Status;
    private int QntTotal;
    private int QntEmprunt;
    private int QntPerdus;

    public Books(int ISBN, String title, String author, String status, int qntTotal, int qntEmprunt , int qntPerdus) {
        this.ISBN = ISBN;
        Title = title;
        Author = author;
        Status = status;
        QntTotal = qntTotal;
        QntEmprunt = qntEmprunt;
        QntPerdus = qntPerdus;
    }
    public Integer getISBN() {
        return ISBN;
    }

    public void setISBN(Integer ISBN) {
        this.ISBN = ISBN;
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

    public void setQntTotal(int qntTotal) {
        QntTotal = qntTotal;
    }

    public int getQntPerd() {
        return QntPerdus;
    }

    public void display(String status){}



    public Books search(String author, String title){
        
    }

    public void edit(String isbn){

    }

    public void filter(String Query){}

    public void delete(String isbn){}

    public void add(){}

}