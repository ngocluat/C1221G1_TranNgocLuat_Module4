package com.book.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String bookName;
    private String describeBook;
    private Double price;

    private Integer quantity;

    @OneToMany(mappedBy = "book")
    List<BorrowBooks> borrowBooks;

    public Books() {
    }

    public Books(Integer id, String bookName, String describeBook, Double price, Integer quantity, List<BorrowBooks> borrowBooks) {
        this.id = id;
        this.bookName = bookName;
        this.describeBook = describeBook;
        this.price = price;
        this.quantity = quantity;
        this.borrowBooks = borrowBooks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getDescribeBook() {
        return describeBook;
    }

    public void setDescribeBook(String describeBook) {
        this.describeBook = describeBook;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }



    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<BorrowBooks> getBorrowBooks() {
        return borrowBooks;
    }

    public void setBorrowBooks(List<BorrowBooks> borrowBooks) {
        this.borrowBooks = borrowBooks;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", describeBook='" + describeBook + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", borrowBooks=" + borrowBooks +
                '}';
    }
}
