package Library;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibraryTest {

    Book book;
    Book book2;
    Book book3;
    Book book4;
    Book book5;
    Book book6;

    Library Lib= new Library();

    @BeforeEach
    void setUp() {
        book = new Book("Hobbit","Tolkien",1916);
        book2 = new Book("Metro 2033","Dmitry Glukhovsky",2002);
        book3 = new Book("Metro 2033","Dmitry Glukhovsky",2002);
        book4 = new Book("Thinking in Java","Bruce Eckel",2012);
        book5 = new Book("Hobbit","Tolkien",1916);
        book6 = new Book("Hobbit","Tolkien",1916);

        Lib.addBook(book);
        Lib.addBook(book2);
        Lib.addBook(book3);
        Lib.addBook(book4);
        Lib.addBook(book5);
        Lib.addBook(book6);

    }


    @Test
    void testaddBook() {
        assertEquals(6,Lib.getBookList().size());
    }

    @Test
    void testlistAll() {

    }

    @Test
    void testsearch() {

        assertEquals(book2,Lib.search("Metro 2033","Dmitry Glukhovsky",2002), "return object ");

    }

}
