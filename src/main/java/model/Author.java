package model;

import java.util.ArrayList;
import java.util.List;

public class Author {

    private int id;
    private String name;
    private String description;
    private List<Book> books = new ArrayList<>();

    public Author() {

    }

    public Author(int id) {
        this.id = id;
    }

    public Author(String name) {
        this.name = name;
    }

    public Author(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addBook(Book book){
        if(!books.contains(book)){
            books.add(book);
        }
    }

    public List<Book> getBookList() {
        return new ArrayList<>(books);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
