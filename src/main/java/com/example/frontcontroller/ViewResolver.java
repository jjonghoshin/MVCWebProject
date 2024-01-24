package com.example.frontcontroller;

public class ViewResolver {
    public static String makeView(String view){ // list
        return "/WEB-INF/views/"+view+".jsp";
    }
}
