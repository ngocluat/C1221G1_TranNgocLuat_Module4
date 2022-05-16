package com.book.model;

import javax.persistence.*;

@Entity
@Table(name = "borrow_book")
public class BorrowBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Long bookCode;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Books book;


    public BorrowBooks() {
    }

    public BorrowBooks(Integer id, Long bookCode, Books book) {
        this.id = id;
        this.bookCode = bookCode;
        this.book = book;
    }

    public BorrowBooks(Long bookCode, Books book) {

        this.bookCode = bookCode;
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getBookCode() {
        return bookCode;
    }

    public void setBookCode(Long bookCode) {
        this.bookCode = bookCode;
    }

    public Books getBook() {
        return book;
    }

    public void setBook(Books book) {
        this.book = book;
    }
}
