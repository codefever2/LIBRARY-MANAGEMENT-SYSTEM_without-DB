import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class BooksClass
{
    static int ID = 0;

    enum LANGUAGE {
        ENGLISH,
        TAMIL,
        HINDI
    }

    enum CATEGORY {
        CHILDREN,
        SCIENCE_FICTION,
        ROMANTIC_NOVEL
    }
    private int bookId;
    private String bookName;
    private int bookEdition;
    private String bookAuthorName;
    private LANGUAGE bookLanguage;
    private String issuedBorrowDate;
    private String dueDate;
    private CATEGORY bookCategory;
    private boolean bookAvailability=true;

    public boolean isBookAvailability()
    {
        return bookAvailability;
    }

    public void setBookAvailability(boolean bookAvailability) {
        this.bookAvailability = bookAvailability;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    private String UserId;
    static HashMap<Integer,BooksClass> allBooksHashMap = new LinkedHashMap<>();
   public void manualHardCodingDone()
    {
        allBooksHashMap.put(++ID,new BooksClass(ID,"Ponniyin Selvan",2,"K",LANGUAGE.TAMIL,CATEGORY.ROMANTIC_NOVEL));
        allBooksHashMap.put(++ID,new BooksClass(ID,"The Secret Place 2",1,"Dan Brown",LANGUAGE.ENGLISH,CATEGORY.ROMANTIC_NOVEL));
        allBooksHashMap.put(++ID,new BooksClass(ID,"The Secret Place",2,"Dan Brown",LANGUAGE.ENGLISH,CATEGORY.ROMANTIC_NOVEL));
   }
    BooksClass()
    {
    }
    public BooksClass(int bookId, String bookName, int bookEdition, String bookAuthorName, LANGUAGE bookLanguage, CATEGORY bookCategory)
    {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookEdition = bookEdition;
        this.bookAuthorName = bookAuthorName;
        this.bookLanguage = bookLanguage;
        this.bookCategory=bookCategory;
        this.bookAvailability=true;
    }
    public void setCategory(String bookCategory)
    {
        this.bookCategory=CATEGORY.valueOf(bookCategory);
    }

    public CATEGORY getCategory()
    {
        return bookCategory;
    }
    public void setLanguage(String bookLanguage)
    {
        this.bookLanguage=LANGUAGE.valueOf(bookLanguage);
    }

    public LANGUAGE getLanguage()
    {
        return bookLanguage;
    }

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        BooksClass.ID = ID;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookEdition() {
        return bookEdition;
    }

    public void setBookEdition(int bookEdition) {
        this.bookEdition = bookEdition;
    }

    public String getBookAuthorName() {
        return bookAuthorName;
    }

    public void setBookAuthorName(String bookAuthorName) {
        this.bookAuthorName = bookAuthorName;
    }

    public LANGUAGE getBookLanguage() {
        return bookLanguage;
    }

    public void setBookLanguage(LANGUAGE bookLanguage) {
        this.bookLanguage = bookLanguage;
    }

    public String getIssuedBorrowDate() {
        return issuedBorrowDate;
    }

    public void setIssuedBorrowDate(String issuedBorrowDate) {
        this.issuedBorrowDate = issuedBorrowDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

}

