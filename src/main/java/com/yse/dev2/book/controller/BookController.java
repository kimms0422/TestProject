package com.yse.dev2.book.controller;

import com.yse.dev2.book.dto.BookCreateDTO;
import com.yse.dev2.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // 이것이 Controller 인것을 알려 주는 annotation
public class BookController {


    /*
    * Controller 에서 서비스 클래스를 사용하기 위하여 의존성 주입
    * */
    @Autowired
    private BookService bookService;

    @GetMapping("/book/create")
    public String create(){
        return "book/create";
    }


    /* PostMapping : 데이터를 생성할 때 사용하는 메소드
    *  ※ Post 메소드로 요청이 될때만 실행
    * */
    @PostMapping("/book/create")
    public String insert(BookCreateDTO bookCreateDTO){
        Integer bookId = this.bookService.insert(bookCreateDTO);
        return String.format("redirect:/book/read/%s" , bookId);
    }

}
