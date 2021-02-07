package Library;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    Book book;

    @BeforeEach
    void setUp() {
        book = new Book("Hobbit","Tolkien",1916);
    }

    @Test
    void testGetTitle() {
        assertEquals("Hobbit",book.getTitle());
    }


    @Test
    void testGetAuthor() {
        assertEquals("Tolkien",book.getAuthor());
    }

    @Test
    void testGetYear() {
        assertEquals(1916,book.getYear());
    }

    @Test
    void testToString() {
        assertEquals("Title='Hobbit', Author='Tolkien', Year=1916",book.toString());
    }
}