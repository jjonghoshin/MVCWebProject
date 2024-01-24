package com.example.frontcontroller;

import com.example.controller.*;

import java.util.HashMap;

public class HandlerMapping {
     private HashMap<String , Controller> mapping;
     public HandlerMapping(){
         mapping=new HashMap<String , Controller>();
         initMapping();
     }
     private void initMapping(){
          // 요청 ---> POJO
         // XML 파일, properties 파일
         mapping.put("/list.do", new BookListController());
         mapping.put("/register.do", new BookRegisterController());
         mapping.put("/registerPost.do", new BookRegisterPostController());
         mapping.put("/ajaxList.do", new BookAjaxListController());
         mapping.put("/login.do", new LoginController());
         mapping.put("/logout.do", new LogoutController());
         mapping.put("/delete.do", new BookDeleteController());
     }
     public Controller getController(String key){ // /list.do ?
         return mapping.get(key);
    }
}
