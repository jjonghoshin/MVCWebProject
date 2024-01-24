package com.example.controller;
// Servlet의 기본 골격

import com.example.entity.BookDTO;
import com.example.repository.BookMyBatisDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// http://localhost:8081/shopping/main -----> /WEB-INF/views/template.jsp
//@WebServlet("/registerPost")   // <-- 클라이언트로부터 요청정보(title, price, name, page)가 넘어온다.
public class BookDeleteController implements Controller {

     public String requestHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

         int num=Integer.parseInt(req.getParameter("num")); // 5

        //BookDAO dao=new BookDAO();
        BookMyBatisDAO dao=new BookMyBatisDAO();
        int cnt=dao.bookDelete(num); // 저장 후에 -> 다시 리스트 보기로 이동 -> /list : redirect(리다이렉트)

         return "redirect:list.do"; // JSP(X) -> /WEB-INF/views//shopping/list.jsp
    }
}
