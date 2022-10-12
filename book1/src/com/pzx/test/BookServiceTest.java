package com.pzx.test;

import com.pzx.pojo.Book;
import com.pzx.pojo.Page;
import com.pzx.service.BookService;
import com.pzx.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BookServiceTest {
    private BookService bookService=new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"冰与火之歌","马丁",new BigDecimal(99),10000,43,null));

    }

    @Test
    public void deleteBookById() {

    }

    @Test
    public void updateBook() {

    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(21));
    }

    @Test
    public void queryBooks() {

    }
    @Test
    public void queryForPageTotalCount() {

    }

    @Test
    public void queryForPageItems() {

    }
    @Test
    public void page(){
        System.out.println(bookService.page(1,Page.PAGE_SIZE));
    }
    @Test
    public void pageByPrice(){
        System.out.println(bookService.pageByPrice(1,Page.PAGE_SIZE,10,50));
    }
}