package classess;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
public class Listss {
    public void ListMenu(){
        System.out.println("""
                -#####################################
                                 List     \s
                -#####################################
                        1 _ Add Books\s
                        2 _ Search Books\\s
                        3 _ delete Books\\s
                        4 _ modify Books\\s
                        5 _ display Books\\s
                        6 _ reservations\\s
                        7 - return book \\s
                        8 - statistiques \\s
                        0 _ Exit
                """
        );
    }

    public Listss() {
    }

    public void HelloWithSwitchOption(String option){
        Books book = new Books();
        Users user = new Users();
        Reservation reservation= new Reservation();

        Scanner in = new Scanner(System.in);

        switch (option) {
            case "1" -> {
                System.out.println("Add book");
                book.add();
            }
            case "2" -> {
                System.out.println("""
                        1- search by Author :
                        2- search by title :
                        """);
                String your_chooce = in.nextLine();
                switch (your_chooce) {
                    case "1" -> {
                        System.out.println("By Author :");
                        String author = in.nextLine();
                        book.setAuthor(author);
                        book.setTitle("");
                        book.search(book.getTitle(), book.getAuthor());
                    }
                    case "2" -> {
                        System.out.println("By Title :");
                        String titre = in.nextLine();
                        book.setAuthor("");
                        book.setTitle(titre);
                        book.search(book.getTitle(), book.getAuthor());
                    }
                    case "3" -> {
                        System.out.println("delete book");
                        book.delete();
                    }
                    default -> System.out.println("Choix non valide");
                }
            }
            case "3" -> {
                System.out.println("Delete book");
                book.delete();
            }
            case "4" -> {
                String isbn;
                System.out.println("Modify : ");
                do {
                    System.out.println("Input ISBN : ");
                    isbn = in.nextLine();

                    if (!isbn.isEmpty()) {
                        book.setISBN(isbn);
                        book.edit(book.getISBN());
                    } else {
                        System.out.println("ISBN Does not exists.");
                    }

                } while (isbn.isEmpty());
            }
            case "5" -> {
                book.display();
            }
            case "6" -> {
                System.out.println("Reservy the Book");
                String id_book;
                String id_user;
                String NameEmp;
                do {
                    System.out.println("Input Id of the book : ");
                    id_book = in.nextLine();
                    if(book.CheckBook(Integer.parseInt(id_book))){
                        //System.out.println(livre);
                        do {
                            System.out.println("Donner ID Customer : ");
                            id_user = in.nextLine();
                            if(user.VerifierUser(Integer.parseInt(id_user))){
                                user.setId(Integer.parseInt(id_user));
                            }
                            else {
                                user.setId(Integer.parseInt(id_user));
                                do {
                                    System.out.println("Input name User : ");
                                    NameEmp = in.nextLine();
                                    user.setName(NameEmp);

                                } while (NameEmp.isEmpty());


                            }
                        } while (id_user.isEmpty());

                        LocalDate dateEmprunt = LocalDate.now();
                        LocalDate dateFinal = dateEmprunt.plusDays(20);

                        //reservation.addBook(book);
                        reservation.setEmprunteur(user);
                        reservation.setDateEmprunt(dateEmprunt);
                        reservation.setDateFinal(dateFinal);
                        //user.Add_user();
                        System.out.println(dateEmprunt);
                        System.out.println(dateFinal);
                        reservation.addReservation(Integer.parseInt(id_book),Integer.parseInt(id_user));

                    }else {
                        System.out.println("Unknow this book");
                    }

                } while (id_book.isEmpty());
            }
            case "7" -> {
                String id_book;
                String id_user;
                do {
                    System.out.println("id of the book : ");
                    id_book = in.nextLine();
                    if (book.CheckBook((Integer.parseInt(id_book)))) {
                        do{
                            System.out.println("id of user : ");
                            id_user = in.nextLine();
                        }while (id_user.isEmpty());

                        if(reservation.VerifyBookEmp(Integer.parseInt(id_book),Integer.parseInt(id_user))){
                            reservation.updateStatus("1",Integer.parseInt(id_book),Integer.parseInt(id_user));
                        }else {
                            System.out.println("book is not reserve");
                        }
                    }else {
                        System.out.println("uknow book");
                    }
                }while (id_book.isEmpty());
            }
            case "8" -> {
                System.out.println("total books enable");
                book.totalBookEnable();
                System.out.println("total books lost");
                book.totalBookLost();
                System.out.println("total book reservéé");
                book.totalBookReserve();

            }



            //case "8" -> System.out.println("Retourner un livre");

            default -> {
            }
        }

    }




}
