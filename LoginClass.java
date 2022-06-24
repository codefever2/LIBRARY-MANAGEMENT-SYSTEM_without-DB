import java.util.*;

public class LoginClass {
    Scanner sc = new Scanner(System.in);
    public void hardCodeOnHashMap() {
        //Hardcoding done
        AdminClass.adminClassHashMap.put("A1", new AdminClass("NandhaKumar", "N@1995k", 9600192437L, "A1"));
        AdminClass.adminClassHashMap.put("A2", new AdminClass("Karthikeyan", "K@1994n", 9790849259L, "A2"));
        UserClass.userClassHashMap.put("U1", new UserClass("Kaviya", 9791198505L, "J@1996s","U1"));
        UserClass.userClassHashMap.put("U2", new UserClass("Praveen", 8807878718L, "P@1995p","U2"));
    }
    public  void welcomeMessage()
    {
        System.out.println("""
                Enter
                1.User
                2.Admin
                3.To exit the application
                """);
        int userOrAdminChoice = sc.nextInt();
        switch (userOrAdminChoice) {
            case 1 -> new UserClass().getUserOrAdminDetailsAtEntry();
            case 2 -> new AdminClass().getUserOrAdminDetailsAtEntry();
            case 3 -> System.out.println("Exiting the application.....");
            default -> {
                System.out.println("Wrong choice is chosen ,please try again");
                welcomeMessage();
            }
        }
    }

}
