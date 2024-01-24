package com.example.controller;
// Servlet의 기본 골격

import com.example.entity.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// http://localhost:8081/shopping/list -----> /WEB-INF/views/list.jsp
//@WebServlet("/list")
// JSON을 응답하는 컨트롤러 ? (RestController VS Controller)
public class LogoutController implements  Controller{ // BookListController(Servet)--->POJO

    public String requestHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 로그아웃 처리
        HttpSession session=req.getSession();
        session.invalidate(); // 무효화
        return "redirect:list.do";  // --> list.jsp(인증여부 판단 로직)
    }
}
