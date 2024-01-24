package com.example.controller;
// Servlet의 기본 골격

import com.example.entity.BookDTO;
import com.example.repository.BookMyBatisDAO;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

// http://localhost:8081/shopping/list -----> /WEB-INF/views/list.jsp
//@WebServlet("/list")
// JSON을 응답하는 컨트롤러 ? (RestController VS Controller)
public class BookAjaxListController implements  Controller{ // BookListController(Servet)--->POJO

    public String requestHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BookMyBatisDAO dao=new BookMyBatisDAO();
        List<BookDTO> list=dao.bookList();
        req.setAttribute("list",list );
        //  List<BookDTO> -> JSON(String) : API
        // return "list"; // 이부분? ->
        //컨트롤러가 직접 View에게 데이터를 전달하면 된다.(HTML ?)
        Gson g=new Gson();
        String json=g.toJson(list);
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter out =resp.getWriter();
        out.println(json); // [ {          },{         }, {        } ]
        return null;
    }
}
