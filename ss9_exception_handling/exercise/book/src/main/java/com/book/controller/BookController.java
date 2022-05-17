package com.book.controller;

import com.book.model.Books;
import com.book.model.BorrowBooks;
import com.book.service.IBookService;
import com.book.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
public class BookController {

    @Autowired
    IBookService iBookService;


    @Autowired
    IBorrowService iBorrowService;

    @GetMapping({"/", "/book"})
    public String goHomeLibrary(Model model) {
        model.addAttribute("book", iBookService.findAll());
        return "home";
    }


    @GetMapping("/{id}/borrow")
    public String borrow(@PathVariable Integer id, Model model) {
        model.addAttribute("book", iBookService.findById(id));
        return "borrow";
    }

    @PostMapping("/borrowReturn")
    public String borrowBook(Books book, Model model,
                             RedirectAttributes redirectAttributes,
                             @RequestParam Integer id) {
        Books books = iBookService.findById(id);
        System.err.println(book);
        iBookService.save(books);

        BorrowBooks borrowBooks = new BorrowBooks();
        borrowBooks.setBook(book);
        iBorrowService.save(borrowBooks);
        model.addAttribute("bookSuccess", " mượn thành công ");
        return "redirect:/";
    }


    @PostMapping("/returnBook")
    public String returnBook(@RequestParam Long bookCode, RedirectAttributes redirectAttributes) {
        BorrowBooks borrowBooks = iBorrowService.findByBookCode(bookCode);

        iBookService.back(borrowBooks.getBook());
        iBorrowService.delete(bookCode);
        redirectAttributes.addFlashAttribute("success", "Bạn đã trả thành công!");
        return "redirect:/book";
    }


    @ExceptionHandler(Exception.class)
    public String errors() {
        return "errors";
    }



}
