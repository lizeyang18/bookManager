package com.bookManager.web.servlet;

import com.bookManager.domain.Book;
import com.bookManager.service.BookService;
import com.bookManager.service.impl.BookServiceImpl;
import com.bookManager.utils.UUIDUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by lizeyang on 2019/11/22.
 * function：添加书本
 */
public class AddBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(factory);
        sfu.setHeaderEncoding("UTF-8");

        List<FileItem> fileItems = new ArrayList<>(0);

        /*获取数据*/
        Map<String, String[]> map = new HashMap<>();
        try {
            fileItems = sfu.parseRequest(request);
            for (FileItem item : fileItems) {
                /*普通文本域*/
                if (item.isFormField()) {
                    String name = item.getFieldName();
                    String value = item.getString("UTF-8");
                    map.put(name, new String[]{value});
                } else {    //上传文件域
                    InputStream inputStream = item.getInputStream();
                    String filename = item.getName();
                    String extension = FilenameUtils.getExtension(filename);  //获取文件拓展名
                    if (!("jsp".equals(extension) || ("exe").equals(extension))) {
                        /*创建上传文件目录*/
                        File storeDirectory = new File(this.getServletContext().getRealPath("/upload"));
                        if (!storeDirectory.exists()) {
                            storeDirectory.mkdirs();
                        }
                        /*处理文件名*/
                        if (filename != null) {
                            filename = FilenameUtils.getName(filename);
                        }

                        String childDirectory = makeChildDirectory(storeDirectory);
                        /*防止上传的文件重名*/
                        filename = childDirectory + File.separator + filename;
                        item.write(new File(storeDirectory, filename));
                        /*删除临时文件*/
                        item.delete();
                    }
                    map.put(item.getFieldName(), new String[]{filename});
                }
            }

            /*数据处理*/
            Book book = new Book();
            BeanUtils.populate(book, map);
            book.setId(UUIDUtil.getUUID());

            BookService bs = new BookServiceImpl();
            bs.addBook(book);

            /*分发转向*/
            request.getRequestDispatcher("BookListServlet").forward(request, response);
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


       /* request.setCharacterEncoding("UTF-8");
        *//*获取参数*//*
        Book book = new Book();
        try {
            BeanUtils.populate(book, request.getParameterMap());
            book.setId(UUIDUtil.getUUID());
        } catch (Exception e) {
            e.printStackTrace();
        }
        *//*处理数据*//*
        BookService bs = new BookServiceImpl();
        bs.addBook(book);
        *//*请求分发*//*
        request.getRequestDispatcher("BookListServlet").forward(request, response);*/
    }

    private String makeChildDirectory(File storeDirectory) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dataDirectory = sdf.format(new Date());    //创建目录
        File file = new File(storeDirectory, dataDirectory);
        if (!file.exists()) {
            file.mkdirs();
        }
        return dataDirectory;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
