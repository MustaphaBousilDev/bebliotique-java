import classess.Listss;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Listss list = new Listss();
        list.ListMenu();
        String choix;
        do {
            System.out.println("Choose : ");
            choix = in.nextLine();
            list.HelloWithSwitchOption(choix);
        }while (!choix.equals("10"));

    }
}