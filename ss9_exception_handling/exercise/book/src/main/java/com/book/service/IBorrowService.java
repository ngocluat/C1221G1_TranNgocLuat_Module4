package com.book.service;

import com.book.model.BorrowBooks;

import java.util.List;
import java.util.Optional;

public interface IBorrowService {

    BorrowBooks findById(Integer id);

    List<BorrowBooks> findAll();

    List<BorrowBooks> seachingBorrowBooks(String name);

    void save(BorrowBooks booksBorrow);

    BorrowBooks findById(int id);

    void update(int id, BorrowBooks customer);

    void remove(int id);

    void delete(Integer id);
}
