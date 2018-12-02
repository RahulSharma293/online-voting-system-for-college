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
 * @author Rahul
 */
 public class addcandidate extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
    
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       response.sendRedirect("admin.html");
        try (PrintWriter out = response.getWriter()) {
            String f = request.getParameter("f_name");
            String l = request.getParameter("l_name");
            String y = request.getParameter("yr");
            String fu = request.getParameter("f_upload");
            String s = request.getParameter("subject");
            System.out.println(f+" "+" "+l);
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn;
            conn=DriverManager.getConnection("jdbc:mysql://localhost/addcandidate?useSSL=false","root","Rahulchd@123");
            //PreparedStatement stat=conn.prepareStatement("insert into location values(?)");
            PreparedStatement stat=null;
            stat=conn.prepareStatement("insert into cand values(?,?,?,?,?,?)");
//            String sql=;
            //stat.setString(1,loc);
            stat.setString(1,f);
            stat.setString(2,l);
            stat.setString(3,y);
            stat.setString(4,fu);
            stat.setString(5,s);
            stat.setInt(6, 0);
            int count=stat.executeUpdate();
            if(count==1)
            {
                out.println("successful");
            }
            else
            {
                out.println("not successful");
            }
        }
 catch(Exception e)
                {
                    System.out.println(e);
                }
            
        }
    }

