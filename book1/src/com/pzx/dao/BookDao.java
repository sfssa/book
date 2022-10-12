package com.pzx.dao;

import com.pzx.pojo.Book;

import java.util.List;

/**
 * @author: gfk
 * @create: 2022/10/3
 * @Description:
 * @FileName: BookDao
 * @History:
 */
public interface BookDao {
    public int addBook(Book book);
    public int deleteBookById(Integer id);
    public int updateBook(Book book);
    public Book queryBookById(Integer id);
    public List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
