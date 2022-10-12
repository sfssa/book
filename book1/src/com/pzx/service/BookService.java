package com.pzx.service;

import com.pzx.pojo.Book;
import com.pzx.pojo.Page;

import java.util.List;

/**
 * @author: gfk
 * @create: 2022/10/3
 * @Description:
 * @FileName: BookService
 * @History:
 */
public interface BookService {
    public void addBook(Book book);
    public void deleteBookById(Integer id);
    public void updateBook(Book book);
    public Book queryBookById(Integer id);
    public List<Book> queryBooks();
    public Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
