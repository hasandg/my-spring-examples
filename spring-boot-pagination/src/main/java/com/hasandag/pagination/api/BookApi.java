package com.hasandag.pagination.api;

import com.hasandag.pagination.model.Book;
import com.hasandag.pagination.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookApi {

    private final BookRepository bookRepository;

    //unnecessary other methods are better
    @GetMapping
    public Page<Book> pagination( @RequestParam Integer page, @RequestParam Integer pageSize){
        Pageable pageable = PageRequest.of(page, pageSize);

        return bookRepository.findAll(pageable);
    }

    @GetMapping("/p")
    public Page<Book> pagination(Pageable pageable){
        return bookRepository.findAll(pageable);
    }

    //Best solution for performance because not searching all records and not getting record count
    //Only needed part is getting
    @GetMapping("/slice")
    public Slice<Book> slice(Pageable pageable){
        return bookRepository.findAll(pageable);
    }
}
