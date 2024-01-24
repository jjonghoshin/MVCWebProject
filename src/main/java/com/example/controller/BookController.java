package com.example.controller;

import com.example.entity.BookDTO;
import com.example.repository.BookMyBatisDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookController{
     // 4개의 단위업무를 혼자서 처리....
    // /list.do -> BookListController
    // Spring WEB MVC
    // /list.do -> BookController ---> Method로 연결
    // /delete.do -> BookController ---> Method로 연결
    // /register.do -> BookController ---> Method로 연결
    // /registerPost.do -> BookController ---> Method로 연결
   // @RequestMapping("/list.do") // HandlerMapping 이 동작을 한다.
    public String list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BookMyBatisDAO dao=new BookMyBatisDAO();
        List<BookDTO> list=dao.bookList();
        req.setAttribute("list",list );

        return "list";
    }

   // @RequestMapping("/delete.do")
    public String delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int num=Integer.parseInt(req.getParameter("num")); // 5

        //BookDAO dao=new BookDAO();
        BookMyBatisDAO dao=new BookMyBatisDAO();
        int cnt=dao.bookDelete(num); // 저장 후에 -> 다시 리스트 보기로 이동 -> /list : redirect(리다이렉트)

        return "redirect:list.do"; // JSP(X) -> /WEB-INF/views//shopping/list.jsp
    }

}
