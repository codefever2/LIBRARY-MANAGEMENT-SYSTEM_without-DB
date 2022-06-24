import java.util.*;
public class AvailableUserServices
{
    BooksClass booksClassObj = new BooksClass();
    UserClass userClassObj = new UserClass();
    Scanner sc = new Scanner(System.in).useDelimiter("\n");;
    public void servicesAvailableToUser(String userId)
    {
        boolean loopElement = true;
        while(loopElement)
        {
            System.out.println("""
                    Enter any of the below services
                    1.To view all the books in the list
                    2.To view only currently available books
                    3.To view particular language books
                    4.To view particular author details
                    5.To view books based on book name
                    6.To view a book availability based on BOOK ID
                    7.To view the late fee If any
                    8.To exit the application
                    """);
            switch (sc.nextInt()) {
                case 1 -> viewAllTheBooks();
                case 2 -> viewOnlyAvailableBooksToBorrow();
                case 3 -> viewParticularLanguageBooks();
                case 4 -> viewParticularAuthorBooks();
                case 5 -> viewParticularBooksBasedOnName();
                case 6 -> viewIfABookIsAvailableToBorrowOrNOtBasedOnId();
                case 7 -> viewLateFeeIfAny(userId);
                case 8 -> {
                    loopElement = false;
                    System.out.println("Exiting the application");
                }
                default -> {
                    System.out.println("wrong option is entered..returning main service menu");
                    servicesAvailableToUser(userId);
                }
            }
        }
    }
    public void viewAllTheBooks()
    {
        for(int i : BooksClass.allBooksHashMap.keySet() )
        {
            System.out.println(BooksClass.allBooksHashMap.get(i).getBookId()+"  "+BooksClass.allBooksHashMap.get(i).getBookName()+" "+BooksClass.allBooksHashMap.get(i).getBookAuthorName()+" "+booksClassObj.allBooksHashMap.get(i).getBookLanguage()+" "+booksClassObj.allBooksHashMap.get(i).getBookEdition());
        }
    }
    public void viewOnlyAvailableBooksToBorrow()
    {
        for(int i : BooksClass.allBooksHashMap.keySet() )
        {
            if (BooksClass.allBooksHashMap.get(i).isBookAvailability())
            {
                System.out.println(BooksClass.allBooksHashMap.get(i).getBookId() + "  " + BooksClass.allBooksHashMap.get(i).getBookName() + " " + BooksClass.allBooksHashMap.get(i).getBookAuthorName() + " " + booksClassObj.allBooksHashMap.get(i).getBookLanguage() + " " + booksClassObj.allBooksHashMap.get(i).getBookEdition());
            }
        }
    }
    public void viewParticularLanguageBooks()
    {
        System.out.println("ENTER THE LANGUAGE TO VIEW LANGUAGE_SPECIFIC BOOKS : "+"\n"+"1. ENGLISH"+"\n"+"2. TAMIL"+"\n"+"3. HINDI");
        String langChosenByUser="";
        switch(sc.nextInt())
        {
            case 1:
                langChosenByUser="ENGLISH";
                break;
            case 2:
                langChosenByUser="TAMIL";
                break;
            case 3:
                langChosenByUser="HINDI";
                break;
            default:
                System.out.println("wrong option is chosen..Kindly try again");
                viewParticularLanguageBooks();
        }
        for(int i : BooksClass.allBooksHashMap.keySet() )
        {
            if (BooksClass.allBooksHashMap.get(i).getBookLanguage() == BooksClass.LANGUAGE.valueOf(langChosenByUser))
            {
                System.out.println(BooksClass.allBooksHashMap.get(i).getBookId() + "  " + BooksClass.allBooksHashMap.get(i).getBookName() + " " + BooksClass.allBooksHashMap.get(i).getBookAuthorName() + " " + booksClassObj.allBooksHashMap.get(i).getBookLanguage() + " " + booksClassObj.allBooksHashMap.get(i).getBookEdition());
            }
        }
    }
    public void viewParticularAuthorBooks()
    {

        System.out.println("ENTER THE AUTHOR NAME TO VIEW AUTHOR SPECIFIC BOOKS : ");
        String authorChosenByUser=sc.next();
        int dummyTemp =0;
        for(int i : BooksClass.allBooksHashMap.keySet() )
        {
            if (Objects.equals(BooksClass.allBooksHashMap.get(i).getBookAuthorName(), authorChosenByUser))
            {
                dummyTemp=1;
                System.out.println(BooksClass.allBooksHashMap.get(i).getBookId() + "  " + BooksClass.allBooksHashMap.get(i).getBookName() + " " + BooksClass.allBooksHashMap.get(i).getBookAuthorName() + " " + booksClassObj.allBooksHashMap.get(i).getBookLanguage() + " " + booksClassObj.allBooksHashMap.get(i).getBookEdition());
            }
        }
        if(dummyTemp==0)
        {
            System.out.println("No search result found");
        }
    }
    public void viewParticularBooksBasedOnName()
    {
        System.out.println("ENTER THE BOOK NAME TO VIEW AUTHOR SPECIFIC BOOKS : ");
        String bookNameChosenByUser=sc.next();
        int dummyTemp=0;
        for(int i : BooksClass.allBooksHashMap.keySet() )
        {
            if(Objects.equals(BooksClass.allBooksHashMap.get(i).getBookName(), bookNameChosenByUser))
            {
                dummyTemp =1 ;
                System.out.println(BooksClass.allBooksHashMap.get(i).getBookId() + "  " + BooksClass.allBooksHashMap.get(i).getBookName() + " " + BooksClass.allBooksHashMap.get(i).getBookAuthorName() + " " + booksClassObj.allBooksHashMap.get(i).getBookLanguage() + " " + booksClassObj.allBooksHashMap.get(i).getBookEdition());
            }
        }
        if(dummyTemp==0)
        {
            System.out.println("THE BOOK NAME ENTERED IS NOT FOUND IN THE BOOK LIST.....KINDLY TRY AGAIN");
        }
    }
    public void viewIfABookIsAvailableToBorrowOrNOtBasedOnId()
    {
            System.out.println("Enter the respective book ID : ");
            int bookIdChosenByUser=sc.nextInt();

        for(int i : BooksClass.allBooksHashMap.keySet() )
        {
            if(BooksClass.allBooksHashMap.get(i).getBookId() == bookIdChosenByUser)
            {
                if(BooksClass.allBooksHashMap.get(i).isBookAvailability())
                {
                    System.out.println("Book ID :" + bookIdChosenByUser + "is available to borrow");
                }
                else
                {
                    System.out.println("Book ID :" + bookIdChosenByUser + "is unavailable to borrow");
                }
                break;
             }
        }
    }
    public void viewLateFeeIfAny(String userId1)
    {

        for(String s : UserClass.userClassHashMap.keySet())
        {
            if(s.equals(userId1))
            {
                System.out.println("Late fee  yet to be paid is : " + UserClass.userClassHashMap.get(userId1).getUserLateFee());
            }
        }
    }

}
