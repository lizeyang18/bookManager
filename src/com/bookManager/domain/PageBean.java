package com.bookManager.domain;

import java.util.List;

/**
 * Created by lizeyang on 2019/11/25.
 * function:分页
 */
public class PageBean {
    private int currentPage;
    private int totalPage;
    private int count;
    private List<Book> books;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
