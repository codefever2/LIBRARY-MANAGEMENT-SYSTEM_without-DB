import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class AdminClass extends LibraryClass
{
    private String adminName;
    private String adminPassword;
    private long adminMobileNumber;
    private String adminId;

   static HashMap<String, AdminClass> adminClassHashMap = new LinkedHashMap<String, AdminClass>();
    Scanner sc = new Scanner(System.in);
    @Override
    public void getUserOrAdminDetailsAtEntry()
    {
        System.out.println("Welcome to Admin Login page ");
        System.out.println("Enter the Library ID :");
        String adminIdInput = sc.next();
        System.out.println("Enter the password :");
        String adminInputPassword = sc.next();
        if(!adminClassHashMap.containsKey(adminIdInput))
        {
            System.out.println("Admin ID entered is wrong");

            class ViewLibraryId
            {
                public void toViewLibraryId()
                {
                    System.out.println("To know your LibraryID , choose 1"+"\n"+"To try entering libraryID and password again , choose 2");
                    switch (sc.nextInt()) {
                        case 1 : {
                            System.out.println("Enter your mobile number");
                            long inputAdminMobileNumber = sc.nextLong();
                            String adminIdFoundOrNot = "";
                            for (String u : adminClassHashMap.keySet()) {
                                if (adminClassHashMap.get(u).getAdminMobileNumber() == inputAdminMobileNumber) {
                                    adminIdFoundOrNot = u;
                                    break;
                                }
                            }
                            if (adminIdFoundOrNot == "") {
                                System.out.println("Admin mobile number is not registered,Kindly contact library Administration +91-9777345421");
                            }
                            else {
                                System.out.println("your registered library ID : " + adminIdFoundOrNot);

                            }
                        }
                        case 2 : {
                            getUserOrAdminDetailsAtEntry();
                        }
                        default : {
                            System.out.println("Wrong choice is picked,kindly try again");
                            toViewLibraryId();
                        }
                    }
                }
            }
            ViewLibraryId viewLibraryIdObj = new ViewLibraryId();
            viewLibraryIdObj.toViewLibraryId();
        }
        else if(!adminClassHashMap.get(adminIdInput).getAdminPassword().equals(adminInputPassword))
        {
            System.out.println("Password is incorrect");

            resetPasswordOptionSelection(adminIdInput );
        }
        else
        {
            System.out.println("Admin "+adminIdInput+"logged in successfully");
            new AvailableAdminServices().servicesAvailableToAdmin();
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
        adminClassHashMap.get(libraryIdInput).setAdminPassword(sc.next());
        System.out.println("password changed successfully");
        new LoginClass().welcomeMessage();
    }
    AdminClass()
    {}
    AdminClass(String adminName,String adminPassword,long adminMobileNumber,String adminId)
    {
        this.adminName=adminName;
        this.adminPassword=adminPassword;
        this.adminMobileNumber=adminMobileNumber;
        this.adminId=adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public long getAdminMobileNumber() {
        return adminMobileNumber;
    }

    public void setAdminMobileNumber(long adminMobileNumber) {
        this.adminMobileNumber = adminMobileNumber;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
}
