/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dell
 */
public class main extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
    
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        //response.sendRedirect("index.html");
//        try (PrintWriter out = response.getWriter()) {
//            String e = request.getParameter("email");
//            String p = request.getParameter("psw");
//            String pr = request.getParameter("psw-r");
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn;
//            conn=DriverManager.getConnection("jdbc:mysql://localhost/sign?useSSL=false","root","Rahulchd@123");
//            //PreparedStatement stat=conn.prepareStatement("insert into location values(?)");
//            PreparedStatement stat=null;
//            stat=conn.prepareStatement("select *from s");
////            String sql=;
//            //stat.setString(1,loc);
//            stat.setString(1,e);
//            stat.setString(2,p);
//            stat.setString(3,pr);
//            int count=stat.executeUpdate();
//            out.println("welcome "+e);
//
//if(count!=0)
//{
////    out.println("<script>");
////    out.println("<alert>successful</alert>");
////    //out.println("location=");
////    out.println("</script>");
//    response.sendRedirect("admin.html");
//}
//else
//            out.println("failed");
//            //System.out.println(loc);
//            //ResultSet rs=stat.executeQuery("inaert into location values(loc)");
//        }
//
//        catch(Exception e)
//                {
//                    System.out.println(e);
//                }
            
        }
    }