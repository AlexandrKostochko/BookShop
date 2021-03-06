package model;

public class Book {

    private int id;
    private String name;
    private String description;
    private double price;
    private Author author;

    public Book() {

    }

    public Book(String name, String description, double price, Author author) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.author = author;
    }

    public Book(int id, String name, String description, double price, Author author) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.author = author;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", author=" + author +
                '}';
    }
}
