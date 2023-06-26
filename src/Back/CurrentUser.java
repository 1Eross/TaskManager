package Back;

public class CurrentUser {
    private static int id = -1;
    private static String login;

    public static void setId(int input){
        id = input;
    }
    public static void setLogin(String input){
        login = input;
    }
    public static int getId(){
        return id;
    }
    public static String getLogin(){
        return login;
    }
}
