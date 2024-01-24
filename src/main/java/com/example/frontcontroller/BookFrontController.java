package com.example.frontcontroller;
// Servlet의 기본 골격

import com.example.controller.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// http://localhost:8081/shopping/list -----> /WEB-INF/views/template.jsp
@WebServlet("*.do")
public class BookFrontController extends HttpServlet { // FrontController
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          System.out.println("모든 요청을 받아서 처리하는 프론트 컨트롤러이다.");
          // 1. 클라이언트의 요청을 분석하는 작업  /list, /delete, /update, /register ?
          String reqPath=req.getRequestURI();
          //System.out.println(reqPath); // /shopping/list
          String cpath=req.getContextPath();
         // System.out.println(cpath); // /shopping
          String command=reqPath.substring(cpath.length());
          System.out.println(command); //  /list, /delete
        // 2. 요청에따른 분기 작업 -> /list(명령, 핸들) -> 핸들러매핑(HandlerMapping)
        //BookMyBatisDAO dao=new BookMyBatisDAO();
        String nextView=null;
        Controller controller=null;
        HandlerMapping mapping=new HandlerMapping();
        controller=mapping.getController(command);
        nextView=controller.requestHandler(req, resp);
        //3. view의 경로를 froward or redirect 결정?
        if(controller!=null) {
            if (nextView != null) {
                if (nextView.indexOf(":") == -1) {
                    RequestDispatcher rd = req.getRequestDispatcher(ViewResolver.makeView(nextView));
                    rd.forward(req, resp);
                } else {
                    resp.sendRedirect(nextView.split(":")[1]); // redirect:list -> /shopping/list
                }//if
            }//if
        }//if
    }
}
