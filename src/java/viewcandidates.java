/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import student.vote;

import com.oracle.jrockit.jfr.DataType;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static jdk.nashorn.internal.runtime.Debug.id;
import static org.omg.CORBA.AnySeqHelper.id;
import static org.omg.CORBA.ShortSeqHelper.id;

/**
 *
 * @author Rahul
 */
public class viewcandidates extends HttpServlet {

     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
         ArrayList<vote> dlist = new ArrayList<vote>();
      
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/addcandidate?useSSL=false&allowPublicKeyRetrieval=true", "root", "Rahulchd@123");
             HttpSession session = request.getSession();
            //String var = (String) session.getAttribute("username");
            PreparedStatement pst = conn.prepareStatement("Select * from cand");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
             vote d = new vote();
               d.f_name=rs.getString(1);
               d.l_name=rs.getString(2);
               d.yr=rs.getString(3);
               d.img=rs.getBytes(4);
               d.subject=rs.getString(5);
               dlist.add(d);
             }
            request.setAttribute("cand",dlist);
    //conn.close();
    RequestDispatcher rd=request.getRequestDispatcher("vc.jsp");
    rd.forward(request,response);
            } 
        catch (Exception e) {
            e.printStackTrace();
        }
     }
}
