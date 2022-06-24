import java.util.*;
public class UserClass extends LibraryClass
{
    private String userName;
    private long userMobileNumber;
    private String userPassword;
    private int userBooksBorrowedCount;
    private double userLateFee;
    private String userLibraryId;

    private  int totalUserBaseCount = 2;

    public int getTotalUserBaseCount()
    {
        return totalUserBaseCount;
    }

    public void setTotalUserBaseCount(int totalUserBaseCount) {
        this.totalUserBaseCount = totalUserBaseCount;
    }

    private List<String> userBorrowedBooksName = new ArrayList<String>();
    static HashMap<String,UserClass> userClassHashMap = new LinkedHashMap<String,UserClass>();

    public void setUserBorrowedBooksName(String adminUserEntry)
    {
        userBorrowedBooksName.add(adminUserEntry);
    }
    public List<String> getUserBorrowedBooksName()
    {
        return userBorrowedBooksName;
    }

    public int getUserBooksBorrowedCount()
    {
        return userBooksBorrowedCount;
    }

    public void setUserBooksBorrowedCount(int userBooksBorrowedCount) {
        this.userBooksBorrowedCount = userBooksBorrowedCount;
    }


    public void removeUserBooksBorrowed(String bookName)
    {
        userBorrowedBooksName.remove(bookName);
    }
    Scanner sc = new Scanner(System.in);
    @Override
    public void getUserOrAdminDetailsAtEntry()
    {
            System.out.println("Welcome to User Login page ");
            System.out.println("Enter the Library ID :");
            String libraryIdInput = sc.next();
            System.out.println("Enter the password :");
            String libraryInputPassword = sc.next();
            if(!userClassHashMap.containsKey(libraryIdInput))
            {
                System.out.println("Library ID entered is wrong");

                class ViewLibraryId
                {
                    public void toViewLibraryId()
                    {
                        System.out.println("To know your LibraryID , choose 1"+"\n"+"To try entering libraryID and password again , choose 2");
                        switch (sc.nextInt()) {
                            case 1 :
                            {
                                System.out.println("Enter your mobile number");
                                long inputMobileNumber = sc.nextLong();
                                String userIdFoundOrNot = "";
                                for (String u : userClassHashMap.keySet()) {
                                    if (userClassHashMap.get(u).getUserMobileNumber() == inputMobileNumber) {
                                        userIdFoundOrNot = u;
                                        break;
                                    }
                                }
                                if (userIdFoundOrNot == "") {
                                    System.out.println("User mobile number is not registered");
                                    wrongOptionChosen();
                                } else {
                                    System.out.println("your registered library ID : " + userIdFoundOrNot);
                                }
                            }
                            case 2 : getUserOrAdminDetailsAtEntry();
                            default : {
                                System.out.println("Wrong choice is picked,kindly try again");
                                toViewLibraryId();
                            }
                        }
                    }
                    public void wrongOptionChosen()
                    {
                        System.out.println("choose 1 : To register " + "\n" + "choose 2 : To return to main menu");
                        switch (sc.nextInt()) {
                            case 1 -> newUserRegistration();
                            case 2 -> new LoginClass().welcomeMessage();
                            default -> {
                                System.out.println("wrong option choosen , try again");
                                wrongOptionChosen();
                            }
                        }
                    }
                }
                ViewLibraryId viewLibraryIdObj = new ViewLibraryId();
                viewLibraryIdObj.toViewLibraryId();
            }
            else if(!userClassHashMap.get(libraryIdInput).getUserPassword().equals(libraryInputPassword))
            {
                System.out.println("Password is incorrect");

                resetPasswordOptionSelection(libraryIdInput );
            }
            else
            {
                System.out.println("User logged in Successfully");
                new AvailableUserServices().servicesAvailableToUser(libraryIdInput);
            }

    }

    public void resetPasswordOptionSelection(String libraryIdInput )
    {
        System.out.println("press 1  - To reset password "+"\n"+"press 2 - To return to main menu");
        switch (sc.nextInt()) {
            case 1 -> resetPassword(libraryIdInput);
            case 2 -> new LoginClass().welcomeMessage();
            default -> System.out.println("wrong option selected , kindly try again");
        }
    }
    public void resetPassword(String libraryIdInput )
    {
        System.out.println("Enter the new password :");
        userClassHashMap.get(libraryIdInput).setUserPassword(sc.next());
        System.out.println("password changed successfully");
        new LoginClass().welcomeMessage();
    }
    public void newUserRegistration()
    {
        System.out.println("Enter the below details to register yourself ");
        System.out.println("Enter the name ,mobilenumber,password in respective order");
        String x = generateNewUserLibraryId();
        userClassHashMap.put(x,new UserClass(sc.next(),sc.nextLong(), sc.next(),x));
        System.out.println(userClassHashMap);
    }
    UserClass() {}
    UserClass(String userName, long userMobileNumber, String userPassword,String userLibraryId)
    {
        this.userName=userName;
        this.userMobileNumber=userMobileNumber;
        this.userPassword=userPassword;
        this.userBooksBorrowedCount=0;
        this.userLateFee=0;
        this.userLibraryId=userLibraryId;
    }

public String generateNewUserLibraryId()
{
   int dummyCount = getTotalUserBaseCount();
   System.out.println("dummy:"+dummyCount);
    String a = "U"+String.valueOf(++dummyCount);
    System.out.println(a);
    setTotalUserBaseCount(dummyCount);
    return a;
}
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getUserMobileNumber() {
        return userMobileNumber;
    }

    public void setUserMobileNumber(long userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public double getUserLateFee() {
        return userLateFee;
    }

    public void setUserLateFee(double userLateFee) {
        this.userLateFee = userLateFee;
    }

    public String getUserLibraryId() {
        return userLibraryId;
    }

    public void setUserLibraryId(String userLibraryId) {
        this.userLibraryId = userLibraryId;
    }
}
