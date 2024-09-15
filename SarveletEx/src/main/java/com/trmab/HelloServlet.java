package com.trmab;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
//    purpose is to greet user to use it we have to extend http servlet for response and request
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        //now here we will get request and response
        System.out.print("In Service");
        //now lets return
//        res.getWriter().println("Hello WORLD");
        //this will be printed on the pag
        //now lets write it like
        PrintWriter out = res.getWriter();
        //so now i can use out again and again
        out.println("Hello World");
//        but we have to tell that bro its an txt/html type
        res.setContentType("text/html");
        out.println("<h1>Hello World</h1>");
    }
}
