package com.bookManager.service;

import com.bookManager.domain.Book;
import com.bookManager.domain.PageBean;

import java.util.List;

/**
 * Created by lizeyang on 2019/11/22.
 */
public interface BookService {
    /**
     * 查询所有书籍
     *
     * @return List<Book>
     */
    public List<Book> findAllBooks();

    /**
     * 添加书籍
     */
    public void addBook(Book book);

    /**
     * 查找书籍
     *
     * @param id
     * @return
     */
    public Book findBookById(String id);

    /**
     * 更新书籍（修改书籍）
     *
     * @param book
     */
    public void updateBook(Book book);

    /**
     * 删除一本书
     *
     * @param id
     */
    public void delBook(String id);


    /**
     * 删除所有选中的书
     *
     * @param ids
     */
    public void delAllBooks(String[] ids);

    /**
     * 根据条件查询书籍
     *
     * @param id
     * @param category
     * @param name
     * @param minprice
     * @param maxprice
     * @return
     */
    public List<Book> searchBooks(String id, String category, String name, String minprice, String maxprice);

    /**
     * 查询分页对应的书本信息
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    public PageBean findBooksPage(int currentPage, int pageSize);

    /**
     * ajax模糊查询
     * @param name
     * @return
     */
    public List<Object> searchBookByName(String name);

}
