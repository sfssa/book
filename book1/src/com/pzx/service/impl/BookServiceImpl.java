package com.pzx.service.impl;

import com.pzx.dao.BookDao;
import com.pzx.dao.impl.BookDaoImpl;
import com.pzx.pojo.Book;
import com.pzx.pojo.Page;
import com.pzx.service.BookService;

import java.util.List;

/**
 * @author panzhixin
 * @date 2022/10/3
 * @description
 */

public class BookServiceImpl implements BookService {
    private BookDao bookDao=new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page =new Page<Book>();

        page.setPageSize(pageSize);
        Integer pageTotalCount=bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        Integer pageTotal=pageTotalCount/pageSize;
        if(pageTotalCount%pageSize>0){
            pageTotal+=1;
        }
        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);
        int begin=(page.getPageNo()-1)*pageSize;
        List<Book> items=bookDao.queryForPageItems(begin,pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page =new Page<Book>();

        page.setPageSize(pageSize);
        Integer pageTotalCount=bookDao.queryForPageTotalCountByPrice(min,max);
        page.setPageTotalCount(pageTotalCount);
        Integer pageTotal=pageTotalCount/pageSize;
        if(pageTotalCount%pageSize>0){
            pageTotal+=1;
        }
        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);
        int begin=(page.getPageNo()-1)*pageSize;
        List<Book> items=bookDao.queryForPageItemsByPrice(begin,pageSize,min,max);
        page.setItems(items);
        return page;
    }
}