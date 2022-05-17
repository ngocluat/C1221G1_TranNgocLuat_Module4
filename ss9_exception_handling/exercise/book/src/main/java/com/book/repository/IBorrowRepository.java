package com.book.repository;

import com.book.model.BorrowBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBorrowRepository extends JpaRepository<BorrowBooks, Integer> {

//    @Query(value = "select * from book_manager.borrow_book where book_code =:code", nativeQuery = true)
    BorrowBooks findByBookCode( Long bookCode);

    void deleteByBookCode(Long bookCode);


}
