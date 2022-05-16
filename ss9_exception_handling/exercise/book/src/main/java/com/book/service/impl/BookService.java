package com.book.service.impl;

import com.book.model.Books;
import com.book.repository.IBookRepository;
import com.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository iBookRepository;

    @Override
    public List<Books> findAll() {
        return iBookRepository.findAll();
    }


    @Override
    public Books findById(Integer id) {
        return iBookRepository.findById(id).get();
    }

    @Override
    public void giveBookBack(Books book) {
        if (book.getQuantity() > 0) {
            book.setQuantity(book.getQuantity() + 1);
        }

        iBookRepository.save(book);
    }

    @Override
    public void save(Books book) {

        if (book.getQuantity() > 0) {
            book.setQuantity(book.getQuantity() - 1);
        }

        iBookRepository.save(book);
    }


    @Override
    public void remove(Long id) {

    }

    @Override
    public void back(Books book) {
        book.setQuantity(book.getQuantity() + 1);
        iBookRepository.save(book);
    }
}
