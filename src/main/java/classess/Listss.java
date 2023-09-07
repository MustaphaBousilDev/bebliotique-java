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
                    2 _ Exit
            """
        );
    }

    public Listss() {
    }

    public void HelloWithSwitchOption(String option){
        Books book = new Books();

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



            //case "8" -> System.out.println("Retourner un livre");

            default -> {
            }
        }

    }




}
