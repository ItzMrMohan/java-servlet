package com.archimedis;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Date;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mohan
 */
@WebServlet(urlPatterns = "/newUser")
public class NewUser extends HttpServlet{
    
    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
        
        req.getRequestDispatcher("CreateuserForm.jsp").forward(req, res);
        
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
        
        
        // Generate uid for user
        
        UUID uid = UUID.randomUUID();
        
        
        String firstName = req.getParameter("fName");
        String lastName = req.getParameter("lName");
        String gender = req.getParameter("gender");
        String birthDate = req.getParameter("dob");
        String phoneNumber = req.getParameter("contactNumber");

        String mailId = req.getParameter("mail");
        String doorNo = req.getParameter("doorno");
        String street = req.getParameter("street");
        String villTown = req.getParameter("vill/town");
        String district = req.getParameter("district");
        String zipCode = req.getParameter("pincode");
        String pass1 = req.getParameter("password");
        String pass2 = req.getParameter("confirmpass");
        

        
        
        final String phonePattern ="^[0-9]{10}$";
        final String emailPattern= "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        final String doorPattern = "^[#.0-9a-zA-Z\\s,-]+$";
        final String addPattern = "^[\\.a-zA-Z,. ]*$";
        final String pinPattern ="^[1-9][0-9]{5}$";
        final String pattern = "(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}";
        String password = null;
        boolean Birth = false;
        boolean phonenum;
        boolean zipcode;
        boolean maill;
        boolean doorNum;
        boolean st;
        boolean vt;
        boolean dt;
        
        

        System.out.println(birthDate);

        String value = birthDate.replace("-", "/");
        System.out.println(value);
       
        try {
            
            // DOB Validation 
            String[] abc = value.split("/");
            int date = Integer.parseInt(abc[2]);
            int month = Integer.parseInt(abc[1]);
            int year = Integer.parseInt(abc[0]);
            
            LocalDate today = LocalDate.now();
            LocalDate dBirth = LocalDate.of(year, month, date);
            
            int period = Period.between(dBirth, today).getYears();
            System.out.println(period);
            
            if(period >= 18){
                Birth = true;
            }else{
                
                System.out.println("You are not eligible...Because you are not 18 plus");
                req.setAttribute("doberror", "You are not eligible...Because you are under 18");
                req.getRequestDispatcher("CreateuserForm.jsp").forward(req, res);
            }
            
            //PhoneNumber Validation
            
            phonenum= phoneNumber.matches(phonePattern);
            System.out.println(phonenum);
            if(!phonenum){
                System.out.println("Please enter the valid Phonenumber");
                req.setAttribute("phoneerror", "Please enter the valid PhoneNumber");
                req.getRequestDispatcher("CreateuserForm.jsp").forward(req, res);
            }
            
            // Email Validation
            
            
            maill = mailId.matches(emailPattern);
            
            if(!maill){
                System.out.println("Please enter the valid Mail Address");
                req.setAttribute("mailerror", "Please enter the valid MailAddress");
                req.getRequestDispatcher("CreateuserForm.jsp").forward(req, res);
            }
            
            
            // Doorno Validation
            
            doorNum = doorNo.matches(doorPattern);
            if(!doorNum){
                System.out.println("Please enter the valid Doorno");
                req.setAttribute("doorerror", "Please enter the valid Doorno");
                req.getRequestDispatcher("CreateuserForm.jsp").forward(req, res);
            }
            
            
            
            //Address 
            
            st = street.matches(addPattern);
            if(!st){
                
                System.out.println("Please enter the valid Street");
                req.setAttribute("sterror", "Please enter the valid Street");
                req.getRequestDispatcher("CreateuserForm.jsp").forward(req, res);
            }
            vt = villTown.matches(addPattern);
            if(!vt){
                
                System.out.println("Please enter the valid vt");
                req.setAttribute("vterror", "Please enter the valid Village/Town");
                req.getRequestDispatcher("CreateuserForm.jsp").forward(req, res);
            }
            dt = district.matches(addPattern);
            if(!dt){
                
                System.out.println("Please enter the valid District");
                req.setAttribute("dterror", "Please enter the valid District");
                req.getRequestDispatcher("CreateuserForm.jsp").forward(req, res);
            }
            
            
            //Pincode Validation
            
            
            zipcode = zipCode.matches(pinPattern);
            
            if(!zipcode){
                
                System.out.println("Please enter the valid Pincode Address");
                req.setAttribute("pinerror", "Please enter the valid Pincode Address");
                req.getRequestDispatcher("CreateuserForm.jsp").forward(req, res);
            }
            
            
            // Password Validation
            
            if(pass1.equals(pass2)){
                boolean cpass = pass1.matches(pattern) && pass2.matches(pattern);
                
                if(cpass){
                   
                    password= pass1;
                    System.out.println(password); 
                    
                }else{
                    
                    System.out.println("Your password should contains one symbol, one uppercase , minimum 8 characters and one Number");
                    req.setAttribute("passerror", "Your password should contains one symbol, one uppercase , minimum 8 characters and one Number");
                    
                }
            }else{
                
                System.out.println("Password and Confirm Passwors should be Different Please enter the Sameone");
                
            }
            
            
            
            // Existing User Validation
            String emailCheck = "select emailId from userDetails where emailId="+"'"+mailId+"'"+";";
            String validUser = Database.createSingleResult(emailCheck);
            
            System.out.println(validUser);
            
            if(validUser==""&& password !="" && Birth  && phonenum  &&
                    doorNum  && st  && dt  && vt  && zipcode  && maill){
                
                System.out.println("INSIDE");
                
                String valueInsert= "insert into userDetails (uid,firstName,lastName,gender,dateOfBirth,"
                    + "phoneNumber,emailId,doorNo,street,villtown,district,pincode,pass) values("+"'"+uid+"'"+","+"'"+firstName+"'"+ "," +"'"+lastName+"'"+ ","
                    +"'"+gender+"'"+ ","+"'"+value+"'"+"," +"'"+phoneNumber+"'"+ "," +"'"+mailId+"'"+ "," +"'"+doorNo+"'"+ "," +"'"+street+"'"+ "," +"'"+villTown+"'"+ ","
                    +"'"+district+"'"+ "," +"'"+zipCode+"'"+ "," +"'"+password+"'"+ ");";
                System.out.println(valueInsert);
                Database.postintoDB(valueInsert);
                
                req.setAttribute("success", "You successfully Create a account");
                req.getRequestDispatcher("Login.jsp").forward(req, res);
                
                
            }
            if(validUser!=null){
                
                req.setAttribute("errorMessage", "You Already have a account");
                req.getRequestDispatcher("Login.jsp").forward(req, res);
                
            }
            
            
            
        } catch (Exception e) {
            
        }
            
       
    }
   
}
