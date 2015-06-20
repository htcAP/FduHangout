package edu.fudan.hangout.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Base64;
import java.util.UUID;

/**
 * Created by lifengshuang on 6/19/15.
 */

public class ImageUploadServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contextPath = getServletContext().getRealPath("/");
        String parentPath = contextPath.substring(0, contextPath.indexOf("fduhangout")) + "image/";
        System.out.println(contextPath);

        Reader reader = request.getReader();
        char[] buf = new char[1024];
        StringBuilder builder = new StringBuilder();
        int size;
        while ((size = reader.read(buf)) != -1) {
            builder.append(buf, 0, size);
        }
        String uuid = UUID.randomUUID().toString();
        String path = parentPath + uuid;
        System.out.println(path);
        //9
        int commaIndex = builder.indexOf(",");
        String s = builder.substring(commaIndex + 1, builder.length() - 2);
        System.out.println(s);
        byte[] data = Base64.getDecoder().decode(s);


        File file = new File(path);
        FileOutputStream outputStream = new FileOutputStream(file);
        outputStream.write(data);
        outputStream.close();

        PrintWriter printWriter = response.getWriter();
        printWriter.write("{\"error\":{\"message\":\"OK\",\"errNo\":0},\"url\":\"/static/" + uuid + "\"}");
    }

//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Reader reader = request.getReader();
//        char[] buf = new char[1024];
//        StringBuilder builder = new StringBuilder();
//        int size;
//        while ((size = reader.read(buf)) != -1) {
//            builder.append(buf, 0, size);
//        }
//        String type = builder.substring(builder.indexOf("/") + 1, builder.indexOf(";"));
////        System.out.println(type);
//        System.out.println(getServletContext().getRealPath("/"));
//
//        int commaIndex = builder.indexOf(",");//
//        byte[] data = Base64.getDecoder().decode(builder.substring(commaIndex + 1));
//        System.out.println(data.length);
//        String uuid = UUID.randomUUID().toString();
//        String path = uuid + "." + type;
//        File file = new File(path);
//        FileOutputStream outputStream = new FileOutputStream(file);
//        outputStream.write(data);
//        outputStream.close();
//        PrintWriter writer = response.getWriter();
//        writer.print("file/" + path);
////        response.addHeader("imageURL", path);
//    }

}
