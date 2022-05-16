package com.book.repository;

import com.book.model.BorrowBooks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowRepository  extends JpaRepository<BorrowBooks , Integer> {
}
