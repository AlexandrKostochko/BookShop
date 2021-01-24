package storage;

import model.Book;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBookStorage {

    private static List<Book> books = new ArrayList<>();

    private static InMemoryBookStorage inMemoryBookStorage;
    private final InMemoryAuthorStorage inMemoryAuthorStorage = new InMemoryAuthorStorage();

    public static InMemoryBookStorage getInstance() {
        if (inMemoryBookStorage == null){
            inMemoryBookStorage = new InMemoryBookStorage();
            return inMemoryBookStorage;
        }
        return inMemoryBookStorage;
    }

    {
        books.add(new Book(1, "BookOne", "FirstBook", 21, inMemoryAuthorStorage.getById(1)));
        books.add(new Book(2, "BookTwo", "SecondBook", 22, inMemoryAuthorStorage.getById(2)));
        books.add(new Book(3, "BookThree", "ThirdBook", 23, inMemoryAuthorStorage.getById(1)));
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
}
