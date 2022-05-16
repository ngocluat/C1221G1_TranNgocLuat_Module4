package com.book.repository;

import com.book.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Books, Integer> {
}
