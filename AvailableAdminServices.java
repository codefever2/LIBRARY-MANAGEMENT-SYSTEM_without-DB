import java.util.*;
public class AvailableAdminServices extends AvailableUserServices
{
    Scanner sc = new Scanner(System.in);
    public void servicesAvailableToAdmin()
    {
        boolean loopElement = true;
        while(loopElement)
        {
            System.out.println("""
                    Enter any of the below services
                    1.To add books to the list
                    2.To remove books from the list
                    3.To view all user details
                    4.To view particular user details
                    5.To view users with pending late fee
                    6.Make entry if user borrows a book(s)
                    7.Make entry if user paying late fee
                    8.Make entry if user returning a book(s)
                    9.To register/add a new user
                    10.To view all books in the system
                    11.To view only currently available books
                    12.To view particular language books
                    13.To view particular author books
                    14.To view books based on book name
                    15.To view a availability based on book ID
                    16.To remove user from the database
                    17.To exit the application
                """);
            switch (sc.nextInt()) {
                case 1 -> addBooksToHashMap();
                case 2 -> removeBooksFromHashMap();
                case 3 -> viewAllUserDetails();
                case 4 -> viewParticularUserDetails();
                case 5 -> viewPendingFeeUsers();
                case 6 -> helpUserBorrowingABook();
                case 7 -> helpUserPayLateFee();
                case 8 -> helpUserReturningABook();
                case 9 ->new UserClass().newUserRegistration();
                case 10->new AvailableUserServices().viewAllTheBooks();
                case 11->new AvailableUserServices().viewOnlyAvailableBooksToBorrow();
                case 12->new AvailableUserServices().viewParticularLanguageBooks();
                case 13->new AvailableUserServices().viewParticularAuthorBooks();
                case 14->new AvailableUserServices().viewParticularBooksBasedOnName();
                case 15->new AvailableUserServices().viewIfABookIsAvailableToBorrowOrNOtBasedOnId();
                case 16->removeUserFromDatabase();
                case 17 -> {
                    loopElement = false;
                    System.out.println("Exiting the application");
                }
                default -> {
                    System.out.println("wrong option is entered..returning main service menu");
                    servicesAvailableToAdmin();
                }
            }
        }
    }

    public void addBooksToHashMap()
    {
        System.out.println("Enter the number of books to add :");
        int noOfBooksToAdd = sc.nextInt();
        for(int i=0;i<noOfBooksToAdd;i++)
        {
            Scanner sc1 = new Scanner(System.in).useDelimiter("\n");
            System.out.println("Enter the book name :");
            String bookName ="";
            bookName+=sc1.next();
            //int bookId, String bookName, int bookEdition, String bookAuthorName, BooksClass.LANGUAGE
            //bookLanguage, BooksClass.CATEGORY bookCategory
            System.out.println("Enter the BookID,BookEdition,BookAuthorName,BookLanguage,Book Category in respective order :");
            BooksClass.allBooksHashMap.put((++(BooksClass.ID)),new BooksClass(BooksClass.getID(),bookName,sc.nextInt(),sc.next(), BooksClass.LANGUAGE.valueOf(sc.next()), BooksClass.CATEGORY.valueOf(sc.next())));
        }
        System.out.println("Book added successfully");
    }
    public void removeBooksFromHashMap()
    {
        System.out.println("Enter the number of books to remove from the list :");
        int noOfBooksToRemove = sc.nextInt();
        for(int i=0;i<noOfBooksToRemove;i++)
        {
            System.out.println("Enter the BookID:");
            BooksClass.allBooksHashMap.remove(sc.nextInt());
        }
        System.out.println("Books removed successfully");
    }
    public void viewParticularUserDetails()
    {
        System.out.println("Enter the number of users to view:");
        int noOfUsersToView= sc.nextInt();

        for(int j=0;j<noOfUsersToView;j++)
        {
           int  dummyTemp =0 ;
            System.out.println("Enter the USER ID:");
            String s = sc.next();
            for(String i : UserClass.userClassHashMap.keySet())
            {
                if(s.equals(i)) {
                    dummyTemp =1 ;
                    System.out.println("User Name : " + UserClass.userClassHashMap.get(i).getUserName());
                    System.out.println("User ID : " + UserClass.userClassHashMap.get(i).getUserLibraryId());
                    System.out.println("Mobile Number : " + UserClass.userClassHashMap.get(i).getUserMobileNumber());
                    System.out.println("Number of books borrowed by user : " + UserClass.userClassHashMap.get(i).getUserBooksBorrowedCount());
                    System.out.println("Late Fee to be paid by user " + UserClass.userClassHashMap.get(i).getUserLateFee());
                    if(UserClass.userClassHashMap.get(i).getUserBooksBorrowedCount()>0)
                    {
                        System.out.println("The books borrowed are :");
                        List<String> dummyList = UserClass.userClassHashMap.get(i).getUserBorrowedBooksName();
                        for(int z=0;z< dummyList.size();z++)
                        {
                            System.out.println(dummyList.get(z));
                        }
                    }
                    break;
                }
            }
            if(dummyTemp==0)
            {
                System.out.println("User ID entered is not registered");
            }

        }
    }
    public void viewAllUserDetails()
    {
        for(String i : UserClass.userClassHashMap.keySet())
        {
            System.out.println("User Name : " + UserClass.userClassHashMap.get(i).getUserName());
            System.out.println("User ID : " + UserClass.userClassHashMap.get(i).getUserLibraryId());
            System.out.println("Mobile Number : " + UserClass.userClassHashMap.get(i).getUserMobileNumber());
            System.out.println("Number of books borrowed by user : " + UserClass.userClassHashMap.get(i).getUserBooksBorrowedCount());
            System.out.println("Late Fee to be paid by user " + UserClass.userClassHashMap.get(i).getUserLateFee());
            if(UserClass.userClassHashMap.get(i).getUserBooksBorrowedCount()>0)
            {
                System.out.println("The books borrowed are :");
                List<String> dummyList = UserClass.userClassHashMap.get(i).getUserBorrowedBooksName();
                for(int j=0;j< dummyList.size();j++)
                {
                    System.out.println(dummyList.get(j));
                }
            }
        }
    }
    public void viewPendingFeeUsers()
    {
        System.out.println("**************************************");
        System.out.println("LIST OF USERS WITH PENDING LATE FEE ");
        System.out.println("**************************************");
        int dummyTemp=0;
        for(String i : UserClass.userClassHashMap.keySet())
        {
            if(UserClass.userClassHashMap.get(i).getUserLateFee() != 0)
            {
                dummyTemp=1;
                System.out.println("User ID : " + UserClass.userClassHashMap.get(i).getUserLibraryId());
                System.out.println("User Name : " + UserClass.userClassHashMap.get(i).getUserName());
                System.out.println("Late fee : "+UserClass.userClassHashMap.get(i).getUserLateFee());
                System.out.println("Totals books not returned by user");
            }
        }
        if(dummyTemp==0)
        {
            System.out.println("No search result found");
        }
    }
    public void helpUserBorrowingABook()
    {
        System.out.println("Enter the book ID :");
        int bookIDEnteredByAdmin=sc.nextInt();
        int idTemp=0;
        int userTemp=0;
        int pos =0;
        for(int i : BooksClass.allBooksHashMap.keySet())
        {
            if(BooksClass.allBooksHashMap.get(i).getBookId() == bookIDEnteredByAdmin)
            {
                if(BooksClass.allBooksHashMap.get(i).isBookAvailability())
                {
                    pos = i;
                    System.out.println("Book ID :" + bookIDEnteredByAdmin + "is available to borrow");
                    idTemp=1;
                    break;
                }
            }
        }
        if(idTemp==0)
        {
            System.out.println("Book ID :" + bookIDEnteredByAdmin + "is not available to borrow..please try again");
        }
        else
        {
            System.out.println("Enter the user Library ID who wants to borrow the book : ");
            String userIdEnteredByAdmin=sc.next();
            for(String s : UserClass.userClassHashMap.keySet())
            {
                if(UserClass.userClassHashMap.get(s).getUserLibraryId().equals(userIdEnteredByAdmin))
                {
                    userTemp=1;

                    if(UserClass.userClassHashMap.get(s).getUserBooksBorrowedCount()<3)
                    {
                        if(UserClass.userClassHashMap.get(s).getUserLateFee() == 0)
                        {
                            BooksClass.allBooksHashMap.get(pos).setBookAvailability(false);
                            UserClass.userClassHashMap.get(s).setUserBooksBorrowedCount(UserClass.userClassHashMap.get(s).getUserBooksBorrowedCount() + 1);
                            UserClass.userClassHashMap.get(s).setUserBorrowedBooksName(BooksClass.allBooksHashMap.get(pos).getBookName());
                            System.out.println("The provided Book ID : " + bookIDEnteredByAdmin + "is allocated for user ID : " + userIdEnteredByAdmin);
                        }
                        else
                        {
                            System.out.println("User must pay the late pay before borrowing a new book : "+ UserClass.userClassHashMap.get(s).getUserLateFee());
                        }
                    }
                    else
                    {
                        System.out.println("user ID : "+userIdEnteredByAdmin+" has the crossed the maximum borrowing limit of 3");
                    }
                    break;
                }
            }
            if(userTemp==0)
            {
                System.out.println("user ID : "+userIdEnteredByAdmin+"is not registered in the system");
            }
        }
    }
    public void helpUserPayLateFee()
    {
        System.out.println("Enter the user ID :");
        String userIdEnteredByUser = sc.next();
        System.out.println("If user has paid the late fee , press 1");
        if (sc.nextInt() == 1)
        {
            System.out.println("Payment update done successfully");
            UserClass.userClassHashMap.get(userIdEnteredByUser).setUserLateFee(0d);
        } else
        {
            System.out.println("Wrong option entered please try again");
        }
    }
    public void helpUserReturningABook()
    {
        System.out.println("Enter the user ID :");
        String userIdEnteredByUser = sc.next();
        System.out.println("enter how many books a user wants to return : ");
        int noOfBooksUserWantsToReturn = sc.nextInt();

        for(int i=0;i<noOfBooksUserWantsToReturn;i++)
        {
            System.out.println("Enter the book name and book ID to return  respectively: ");
            UserClass.userClassHashMap.get(userIdEnteredByUser).removeUserBooksBorrowed(sc.next());
            UserClass.userClassHashMap.get(userIdEnteredByUser).setUserBooksBorrowedCount(UserClass.userClassHashMap.get(userIdEnteredByUser).getUserBooksBorrowedCount()-1);
            BooksClass.allBooksHashMap.get(sc.nextInt()).setBookAvailability(true);
        }
        System.out.println("Book returning done successfully");
    }
    public void removeUserFromDatabase()
    {
        System.out.println("Enter the user ID :");
        String userIdEnteredByAdminToRemove = sc.next();
        UserClass.userClassHashMap.remove(userIdEnteredByAdminToRemove);
        System.out.println("User ID :"+ userIdEnteredByAdminToRemove + "is deleted permanently from database");
    }
}
