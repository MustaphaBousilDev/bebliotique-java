package classess;
public class Users{
    private String Cin;
    private String Name;

    public Users(String cin, String name) {
        Cin = cin;
        Name = name;
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

}
