package Library;

import java.util.*;

public class Library {

    //list of book rekords
    private ArrayList<BookRecord> BookList=new ArrayList<BookRecord>();

    private static int LibraryBookCount =0;

    public ArrayList<BookRecord> getBookList() {
        return BookList;
    }

    //class storing data about the book
    class BookRecord{
         Book book;
         int Id;
         String lenderName;
         boolean isRented;


        public BookRecord(Book book) {
            this.book = book;
            Id = CountBook ();
            isRented = false;
            lenderName="";
        }
        public void rentBook(int Id, String Name){
            this.Id = Id;
            this.lenderName =Name;
            isRented = true;
        }

        @Override
        public String toString() {
            return  book.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof BookRecord)) return false;
            BookRecord that = (BookRecord) o;
            return isRented == that.isRented &&
                    book.equals(that.book) &&
                    Objects.equals(lenderName, that.lenderName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(book, lenderName, isRented);
        }
    }
    //default constructor
    public Library() {
    }

    //helper function used to create book id
    static int  CountBook () {
        return ++LibraryBookCount;
    }

    //add book
    public void addBook(Book book){

        BookRecord temp = new BookRecord(book);
        BookList.add(temp);
    }

    //remove book
    public void removeBook(int Id) {

        for (BookRecord record : BookList) {
                if( record.Id == Id && record.isRented == false ) {
                    BookList.remove(record);
                    break;
                }
        }
    }

    // LentBook
    public void lentBook(int Id, String lenderName){

        for (BookRecord record : BookList){
            if( record.Id == Id && record.isRented == false ) {
                record.rentBook(Id, lenderName);
                break;
            }
        }
    }
    //showing book details, aluming it supposed to be printed to console
    public void seeBookDetails(int ID){
        for (BookRecord record : BookList) {
            if( record.Id == ID )
                 System.out.println(record.toString() +
                         ", lenderName= '" + record.lenderName + '\'' +
                         ", isRented= " + record.isRented);
        }
    }
    //list all books in library
    public void listAll() {
        Map<BookRecord, Integer> bookcount = new HashMap<BookRecord, Integer>();

        for (BookRecord record : BookList) {
            Integer count = bookcount.get(record);
            if (record.isRented) continue;
            if (count == null) {
                bookcount.put(record, 1);
            } else {
                bookcount.put(record, count + 1);
            }
        }

        for (Map.Entry<BookRecord, Integer> entry : bookcount.entrySet()) {
            System.out.println("Book: "+entry.getKey() + " available to rent: " + entry.getValue());
        }

    }
    //search function, assuming it should return first book object
    public Book search(String title,String author, int year ){

        for (BookRecord record : BookList) {
                if (record.book.getTitle().equals(title) &&
                    record.book.getAuthor().equals(author)&&
                    record.book.getYear() == year)
                    return record.book;
        }
        return null;
    }

}
