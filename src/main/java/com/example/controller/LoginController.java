package com.example.controller;
// Servlet의 기본 골격

import com.example.entity.BookDTO;
import com.example.entity.UserDTO;
import com.example.repository.BookMyBatisDAO;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

// http://localhost:8081/shopping/list -----> /WEB-INF/views/list.jsp
//@WebServlet("/list")
// JSON을 응답하는 컨트롤러 ? (RestController VS Controller)
public class LoginController implements  Controller{ // BookListController(Servet)--->POJO

    public String requestHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 회원 인증처리
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        // UserDTO
        UserDTO dto=new UserDTO();
        dto.setUsername(username);
        dto.setPassword(password);
        dto.setName("관리자");
        // DB연동
  /*   BookMyBatisDAO dao=new BookMyBatisDAO();
        UserDTO user=dao.userLogin(dto);
        if(user!=null){ // 회원인증성공
            HttpSession session=req.getSession();
            session.setAttribute("uservo", user); //  username, password, name, email, address
        }
        return "list";*/

        if(username.equals("admin") && password.equals("admin")){
           // 회원인증 성공 했다면 ? -> View(JSP)가 알아야 한다. : 객체바인딩(HttpSession)
            // JSESSIONID=100(32스트링으로 만들어진 고유한 값)
           HttpSession session=req.getSession();
           session.setAttribute("uservo", dto); // 세션을 만들고 객체를 바인딩 작업
       }
        return "redirect:list.do";  // --> list.jsp(인증여부 판단 로직)
    }
}
