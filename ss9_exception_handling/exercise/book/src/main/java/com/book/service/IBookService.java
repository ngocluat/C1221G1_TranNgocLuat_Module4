package com.book.service;

import com.book.model.Books;

import java.util.List;

public interface IBookService {

    List<Books> findAll();


    void save(Books book);

    Books findById(Integer id);

    void giveBookBack(Books book);

    void remove(Long id);

    void back(Books book);
}
