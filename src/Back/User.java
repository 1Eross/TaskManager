package Back;

public class User {
    private int id = -1;
    private String login;
    private String password;

    public void setLogin(String input) {
        login = input;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
