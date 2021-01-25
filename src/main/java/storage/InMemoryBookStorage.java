package storage;

import model.Author;
import model.Book;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBookStorage {

    private static List<Book> books = new ArrayList<>();
    private static List<Author> authors = new ArrayList<>();

    private static InMemoryBookStorage inMemoryBookStorage;

    public static InMemoryBookStorage getInstance() {
        if (inMemoryBookStorage == null){
            inMemoryBookStorage = new InMemoryBookStorage();
            return inMemoryBookStorage;
        }
        return inMemoryBookStorage;
    }

    {
        Author gena = new Author(1, "Gena", "1999");
        Author vasya = new Author(2, "Vasya", "2000");
        Book firstBook = new Book(1, "FirstBook", "2005", 22, gena);
        Book secondBook = new Book(2, "SecondBook", "2006", 23, vasya);
        Book thirdBook = new Book(3, "ThirdBook", "2007", 24, gena);
        gena.addBook(firstBook);
        gena.addBook(thirdBook);
        vasya.addBook(secondBook);
        authors.add(gena);
        authors.add(vasya);
        books.add(firstBook);
        books.add(secondBook);
        books.add(thirdBook);
    }

    public List<Book> getAll() {
        return new ArrayList<>(books);
    }

    public Book getById(int id){
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public List<Author> getAuthors() {
        return new ArrayList<>(authors);
    }

    public Author getByIdAuthor(int id) {
        for (Author author : authors) {
            if(author.getId() == id) {
                return author;
            }
        }
        return null;
    }
}
