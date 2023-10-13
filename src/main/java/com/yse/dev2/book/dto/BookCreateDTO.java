package com.yse.dev2.book.dto;


import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;


/* DTO 란 : 값을 담는 Container 객체
*  책의 제목과 가격을 입력 했을때 서버로 전달한 값들을 담는 역할
* */
@Getter
@Setter
public class BookCreateDTO {

    @NonNull
    private String title;

    @NonNull
    private Integer price;
}
