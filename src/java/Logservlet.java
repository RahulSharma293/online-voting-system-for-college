import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
public class Logservlet extends HttpServlet {

    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
        try{
            String id = request.getParameter("id");
            String pass = request.getParameter("psw");
            
            PrintWriter out = response.getWriter();
            
            String myurl="jdbc:mysql://localhost/sign";
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/addcandidate?useSSL=false","root","Rahulchd@123");
            
                Statement st=conn.createStatement();
                String query1="select * from s where id='"+id+"' and p='"+pass+"';";
                ResultSet rs=st.executeQuery(query1);
                //System.out.println(query1);
                
                
            if(rs.next())
            {    
               HttpSession session = request.getSession();
                //System.out.println("heloo.....");
               session.setAttribute("i",id);
               
               response.sendRedirect("student.html");
            }
            
            else 
            {
                 
                out.println("<script type=\"text/javascript\">");
                out.print("alert('User or password incorrect');");
                out.println("location='login2.html';");
                out.println("</script>");
                 
            
            }
            conn.close();
}
            catch(Exception e)
            {
                System.out.println(e);
//                System.err.println("got an exception");
//                System.err.println(e.getMessage());
            }
   
        
    }


}
