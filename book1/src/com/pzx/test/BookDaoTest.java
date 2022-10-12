package com.pzx.test;

import com.pzx.dao.BookDao;
import com.pzx.dao.impl.BookDaoImpl;
import com.pzx.pojo.Book;
import com.pzx.pojo.Page;
import com.pzx.service.BookService;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;


public class BookDaoTest {

    private BookDao bookDao=new BookDaoImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"如何征服富婆","pzx",new BigDecimal(999),1100000,0,null));

    }

    @Test
    public void deleteBookById() {

    }

    @Test
    public void updateBook() {

    }

    @Test
    public void queryBookById() {
        System.out.println( bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookDao.queryBooks()) {
            System.out.println(queryBook);
        }
    }

    @Test
    public void queryForPageTotalCount(){
        System.out.println(bookDao.queryForPageTotalCount());
    }
    @Test
    public void queryForPageItems(){
        for (Book book : bookDao.queryForPageItems(8, Page.PAGE_SIZE)) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCountByPrice(){
        System.out.println(bookDao.queryForPageTotalCountByPrice(10,50));
    }
    @Test
    public void queryForPageItemsByPrice(){
        for (Book book : bookDao.queryForPageItemsByPrice(0, Page.PAGE_SIZE,10,50)) {
            System.out.println(book);
        }
    }

}