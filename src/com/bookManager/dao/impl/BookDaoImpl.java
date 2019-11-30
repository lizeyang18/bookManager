package com.bookManager.dao.impl;

import com.bookManager.dao.BookDao;
import com.bookManager.domain.Book;
import com.bookManager.utils.C3P0Util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizeyang on 2019/11/22.
 */
public class BookDaoImpl implements BookDao {
    /**
     * 查询所有书籍
     *
     * @return List<Book>
     */
    @Override
    public List<Book> findAllBooks() {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        try {
            return qr.query("select * from books", new BeanListHandler<Book>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 添加书籍
     *
     * @param book
     */
    @Override
    public void addBook(Book book) {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        try {
            qr.update("insert into books values(?,?,?,?,?,?,?)", book.getId(), book.getName(), book.getPrice(), book.getPnum(), book.getCategory(), book.getDescription(),book.getImg_url());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查找书籍
     *
     * @param id
     * @return
     */
    @Override
    public Book findBookById(String id) {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        try {
            return qr.query("select * from books where id = ?", new BeanHandler<Book>(Book.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateBook(Book book) {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        try {
            qr.update("update books set name = ? ,price = ?,pnum = ?,category = ?,description = ?,img_url = ? where id = ?", book.getName(), book.getPrice(), book.getPnum(), book.getCategory(), book.getDescription(),book.getImg_url(), book.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delBook(String id) {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        try {
            qr.update("delete from books where id=?", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delAllBooks(String[] ids) {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        Object[][] params = new Object[ids.length][];
        for (int i = 0; i < params.length; i++) {
            params[i] = new Object[]{ids[i]};
        }
        try {
            qr.batch("delete from books where id = ?", params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> searchBooks(String id, String category, String name, String minprice, String maxprice) {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        String sql = "select * from books where 1=1";
        List list = new ArrayList();
        if (!"".equals(id.trim())) {
            sql += " and id like ?";
            list.add("%" + id.trim() + "%");
        }
        if (!"".equals(category.trim())) {
            sql += " and category=?";
            list.add(category.trim());
        }
        if (!"".equals(name.trim())) {
            sql += " and name like ?";
            list.add("%" + name.trim() + "%");
        }
        if (!"".equals(minprice.trim())) {
            sql += " and price>?";
            list.add(minprice.trim());
        }
        if (!"".equals(maxprice.trim())) {
            sql += " and price<?";
            list.add(maxprice.trim());
        }
        try {
            return qr.query(sql, new BeanListHandler<Book>(Book.class), list.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int count() {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        try {
            long l = (Long) qr.query("select count(*) from books", new ScalarHandler(1));
            return (int) l;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Book> findBooks(int currentPage, int pageSize) {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        try {
            return qr.query("select * from books limit ?,?", new BeanListHandler<Book>(Book.class), (currentPage - 1) * pageSize, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Object> searchBookByName(String name) {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        try {
            return qr.query("select name from books where name like ?", new ColumnListHandler(), "%" + name + "%");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
