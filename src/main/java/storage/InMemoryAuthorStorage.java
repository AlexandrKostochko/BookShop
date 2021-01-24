package storage;

import model.Author;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAuthorStorage {

    private static List<Author> authors = new ArrayList<>();
    private static InMemoryAuthorStorage inMemoryAuthorStorage;

    public static InMemoryAuthorStorage getInstance() {
        if (inMemoryAuthorStorage == null){
            inMemoryAuthorStorage = new InMemoryAuthorStorage();
            return inMemoryAuthorStorage;
        }
        return inMemoryAuthorStorage;
    }

    static {
        authors.add(new Author(1, "Vasya", "1999"));
        authors.add(new Author(2, "Gena", "eat"));
    }

    public List<Author> getAllAuthors() {
        return new ArrayList<>(authors);
    }

    public Author getById(int id) {
        for (Author author : authors) {
            if(author.getId() == id) {
                return author;
            }
        }
        return null;
    }

    public Author getByName(String name) {
        for (Author author : authors) {
            if (author.getName().equals(name)) {
                return author;
            }
        }
        return null;
    }
}
