package com.archimedis;

import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mohan
 */
@WebServlet(urlPatterns = "/profile")
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 2, // 2 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class Profile extends HttpServlet{
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.getRequestDispatcher("Profile.jsp").forward(req, resp);
        
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        System.out.println("ENTRY");
        
        HttpSession session = req.getSession();
        String Id = (String) session.getAttribute("UUID");
        
        
        
        
        System.out.println(Id);
        
        Part filePart = req.getPart("file");
        String fileName =  filePart.getSubmittedFileName();

        System.out.println(fileName);
        filePart.write("D:\\Spring\\task\\Images\\"+Id+".jpg");
//        for(Part part:req.getParts()){
//            
//            part.write("D:\\Spring\\task\\Images\\"+Id+".JPG");
//            System.out.println("inside the loop");
//            
//        }
        resp.getWriter().print("File Upload Successfully");

        System.out.println("EXIT");
        req.getRequestDispatcher("Home.jsp").forward(req, resp);

    }
}
