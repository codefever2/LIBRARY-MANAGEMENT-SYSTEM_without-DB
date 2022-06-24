import java.util.HashMap;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("WELCOME TO LIBRARY MANAGEMENT SYSTEM");
        new BooksClass().manualHardCodingDone();
        LoginClass loginClassObj = new LoginClass();
        loginClassObj.hardCodeOnHashMap();
        loginClassObj.welcomeMessage();
    }
}