package com.bookManager.dao;

import com.bookManager.domain.Book;

import java.util.List;

/**
 * Created by lizeyang on 2019/11/22.
 */
public interface BookDao {
    /**
     * 查询所有书籍
     *
     * @return
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
     * 更新书籍（修改书籍信息）
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
     * 删除所有选中的书籍
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
     * 查询数据库中书本共有多少条数据
     *
     * @return
     */
    public int count();

    /**
     * 根据当前页和每页固定多少书本查询数据库书本
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    public List<Book> findBooks(int currentPage, int pageSize);
}
