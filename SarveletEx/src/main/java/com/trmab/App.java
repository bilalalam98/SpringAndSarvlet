package com.trmab;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws LifecycleException {
        System.out.println( "Hello World!" );
        //now to start the server
        Tomcat tomcat = new Tomcat();
        //bydefault the tomcat make it runs on 8080 and we dont have to write below line but lets
        //know how will you change you port number if you needed to
        tomcat.setPort(8080);
//        tomcat.start();
//        //now we have to keep it running and dont stop
//        tomcat.getServer().await();
        //now its running but not able to handle request even tomcat running servlet but
        //now we have to map it like we write localhost:8080/cart so we go to that perticular cart controller
        //so now we have to map it now one way is that i make an web.xml where we provide rul and servlet
        //now we have annoation way so we will provide @WebServlet("/hello") it will be
        // placed at the top of HelloServlet but this whole approach is for external tomcat
        //as we are using embeded tomcat we have to do configuration for it
        Context context = tomcat.addContext("", null);
        Tomcat.addServlet(context,"HelloServlet", new HelloServlet());
        //now mapping
        context.addServletMappingDecoded("/hello", "HelloServlet");
        tomcat.start();
        tomcat.getServer().await();
    }
}
