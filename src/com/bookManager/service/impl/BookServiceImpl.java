package com.bookManager.service.impl;

import com.bookManager.dao.BookDao;
import com.bookManager.dao.impl.BookDaoImpl;
import com.bookManager.domain.Book;
import com.bookManager.domain.PageBean;
import com.bookManager.service.BookService;

import java.util.List;

/**
 * Created by lizeyang on 2019/11/22.
 */
public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();

    @Override
    public List<Book> findAllBooks() {
        return bookDao.findAllBooks();
    }

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public Book findBookById(String id) {
        return bookDao.findBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public void delBook(String id) {
        bookDao.delBook(id);
    }

    @Override
    public void delAllBooks(String[] ids) {
        bookDao.delAllBooks(ids);
    }

    @Override
    public List<Book> searchBooks(String id, String category, String name, String minprice, String maxprice) {
        return bookDao.searchBooks(id, category, name, minprice, maxprice);
    }

    @Override
    public PageBean findBooksPage(int currentPage, int pageSize) {
        int count = bookDao.count();
        int totalPage = (int) Math.ceil(count * 1.0 / pageSize);
        List<Book> books = bookDao.findBooks(currentPage, pageSize);

        PageBean pb = new PageBean();
        pb.setBooks(books);
        pb.setCount(count);
        pb.setCurrentPage(currentPage);
        pb.setTotalPage(totalPage);
        return pb;
    }

    @Override
    public List<Object> searchBookByName(String name) {
        return bookDao.searchBookByName(name);
    }
}
