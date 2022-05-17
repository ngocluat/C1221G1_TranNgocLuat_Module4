package com.book.service.impl;

import com.book.model.BorrowBooks;
import com.book.repository.IBorrowRepository;
import com.book.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowService implements IBorrowService {

    @Autowired
    IBorrowRepository iBorrowRepository;

    @Override
    public BorrowBooks findById(Integer id) {
        return iBorrowRepository.findById(id).get();
    }

    @Override
    public void save(BorrowBooks booksBorrow) {
        Long idRandom = (long) (Math.floor(Math.random() * 10000) + 99999);
        booksBorrow.setBookCode(idRandom);

        iBorrowRepository.save(booksBorrow);

    }


    @Override
    public List<BorrowBooks> findAll() {
        return null;
    }

    @Override
    public List<BorrowBooks> seachingBorrowBooks(String name) {
        return null;
    }


    @Override
    public BorrowBooks findById(int id) {
        return null;
    }

    @Override
    public void update(int id, BorrowBooks customer) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public void delete(Long code) {
        iBorrowRepository.deleteByBookCode(code);
    }

    @Override
    public BorrowBooks findByBookCode(Long bookCode) {
        return iBorrowRepository.findByBookCode(bookCode);
    }


}
