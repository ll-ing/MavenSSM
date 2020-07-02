package com.ll.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ll.bean.User;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ll.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class LoginController {
    @Autowired
    private UserService us;

    @RequestMapping("login")
    public String login(HttpSession session, User user) throws ServletException, IOException {
        User u = us.login(user);
        if (u!=null) {
            session.setAttribute("user", u);
            return "main.jsp";
        }else {
            return "login.jsp";
        }


       /* if (u != null) {
            request.getRequestDispatcher("main.jsp").forward(request, response);

        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);

        }*/
    }

    @RequestMapping("insert")
    public String insert(User user) {
        int n = us.insert(user);
        if (n > 0) {
            return "chenggong.jsp";

        } else {
            return "insert.jsp";
        }
    }

    @RequestMapping("delete")
    public String delete(int id) {
        int n = us.delete(id);
        if (n > 0) {
            return "chenggong.jsp";
        } else {
            return "delete.jsp";
        }

    }

    @RequestMapping("selectUser")
    public void selectUser(HttpServletRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        List<User> list = us.selectUser(user);
        System.out.println(list);
        request.setAttribute("list", list);
        request.getRequestDispatcher("userlist.jsp").forward(request, response);
    }

    @RequestMapping("updateQueryOne")
    public void updateQueryOne(HttpServletRequest request, HttpServletResponse response, User user, Integer id) throws ServletException, IOException {
        User u = us.updateQueryOne(id);
        System.out.println(u);
        request.setAttribute("u", u);
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }

    @RequestMapping("update")
    public void update(HttpServletRequest request, HttpServletResponse response, User user) throws ServletException, IOException {
        int i = us.update(user);
        if (i > 0) {
            response.sendRedirect("selectUser");
        } else {
            request.getRequestDispatcher("update").forward(request, response);

        }
    }

    @RequestMapping("upload")
    public String upload(@RequestParam("file") MultipartFile[] files) {
        if (files.length > 0) {
            for (MultipartFile multipartFile : files) {
                if (multipartFile.getSize() > 0) {
                    String fileName = multipartFile.getOriginalFilename();
                    String path = "D://upload/" + fileName;
                    try {
                        multipartFile.transferTo(new File(path));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return "success.jsp";
    }

    @RequestMapping("download")
    public ResponseEntity<byte[]> downloadFile(String filename) throws Exception {
        //文件名(防止乱码)
        String newName = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
        //下载文件所处目录
        String path = "D://upload/";
        //文件下载地址
        File file = new File(path + newName);
        //请求报文头部信息
        HttpHeaders header = new HttpHeaders();
        //处理方式
        header.setContentDispositionFormData("attachment", newName);
        header.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                header, HttpStatus.OK);

        return entity;


    }
}


