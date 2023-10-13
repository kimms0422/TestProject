package com.yse.dev2.book.service;


import com.yse.dev2.book.dto.BookCreateDTO;
import com.yse.dev2.book.dto.BookReadResponseDTO;
import com.yse.dev2.book.entity.Book;
import com.yse.dev2.book.entity.BookRepository;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


/* Service class 란 : 실제로 Business 로직 흐름이 실행 되는 곳
 *
 * */
@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Integer insert(BookCreateDTO bookCreateDTO) {
        Book book = Book.builder()
                .title(bookCreateDTO.getTitle())
                .price(bookCreateDTO.getPrice())
                .build();

        this.bookRepository.save(book);
        return book.getBookId();
    }

    public BookReadResponseDTO read(Integer bookId) throws NoSuchElementException{
        Book book = this.bookRepository.findById(bookId).orElseThrow();
        BookReadResponseDTO bookReadResponseDTO = new BookReadResponseDTO();
        bookReadResponseDTO.fromBook(book);
        return bookReadResponseDTO;

    }
}
