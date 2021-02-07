package Library;

import java.util.Objects;

public class Book {

    private String Title;
    private String Author;
    private int Year;

    public Book(String title, String author, int year) {
        Title = title;
        Author = author;
        Year = year;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public int getYear() {
        return Year;
    }

    @Override
    public String toString() {
        return  "Title='" + Title + '\'' +
                ", Author='" + Author + '\'' +
                ", Year=" + Year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return Year == book.Year &&
                Title.equals(book.Title) &&
                Author.equals(book.Author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Title, Author, Year);
    }
}
