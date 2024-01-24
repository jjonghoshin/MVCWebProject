package com.example.controller;
// Servlet의 기본 골격

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// http://localhost:8081/shopping/main -----> /WEB-INF/views/template.jsp
 //@WebServlet("/register")
public class BookRegisterController implements Controller{

    public String requestHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/views/register.jsp");
            //rd.forward(req, resp);
        return "register";
    }
}
