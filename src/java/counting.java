import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author RAHUL SHARMA :p
 */
@WebServlet(name = "counting", urlPatterns = {"/counting"})
public class counting extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/addcandidate?useSSL=false&allowPublicKeyRetrieval=true", "root", "Rahulchd@123");
            String f_name = req.getParameter("f_name");
            int id = Integer.parseInt(req.getParameter("id"));
            Statement st = conn.createStatement();
//            String Email = req.getParameter("one");
            boolean flag = false;
            String query = "SELECT * FROM s WHERE id = ?;";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next())
            {
                String vote = rs.getString(5);
                if(vote.equals("none"))
                {
                    String query2 = "UPDATE s SET vote = ? WHERE id = ?;";
                    PreparedStatement pstmt2 = conn.prepareStatement(query2);
                    pstmt2.setString(1, f_name);
                    pstmt2.setInt(2, id);
                    if(pstmt2.executeUpdate() > 0)
                    {
                        String query3 = "UPDATE cand SET votecounts = votecounts+1 WHERE fname = ?;";
                        PreparedStatement pstmt3 = conn.prepareStatement(query3);
                        pstmt3.setString(1, f_name);
                        if(pstmt3.executeUpdate() > 0)
                            flag = true;
                    }
                }
            }
//            String checkQuery1 = "SELECT fname FROM cand;";
//            String query = "UPDATE s SET vote = '" + f_name + "' WHERE id = '" + id + "';";
//            String checkQuery = "UPDATE cand SET votecounts = votecounts+1 WHERE fname = '"+f_name+"';";
//            ResultSet rs = st.executeQuery(checkQuery1);
            
//            List<String> ids = new ArrayList<>();
//            while(rs.next()) {
//                ids.add(rs.getString(1));
//            }
            PrintWriter out = res.getWriter();
            if(flag == true)
            {
                out.println("<script>");
                out.println("alert('Vote successfull');");
                
            }
            else
            {
                out.println("<script>");
                out.println("alert('Could not vote');");
            }
            out.println("location = 'votecount';");
            out.println("</script>");
//            HttpSession hs = req.getSession(false);
//            if (hs == null) {
//                res.sendRedirect("login.html");
//                return;
//            }
//            String sessionEmail = (String) hs.getAttribute("id");
//            if (sessionEmail == null) {
//                res.sendRedirect("login.html");
//            } else {
//                if (ids.contains(sessionEmail)) {
//                    System.out.println("Already voted");
//                    req.setAttribute("cannotVote", true);
//                    req.getRequestDispatcher("/student.html").forward(req, res);
//                    return;
//                }
//            }
//            System.out.println("break point");
//            String query = " update election set votecounts=votecounts+1 where email=(?);";
//            PreparedStatement ss = conn.prepareStatement(query);
//            ss.setString(1, Email);
//            int check = ss.executeUpdate();
//            if (check != 0) {
//                st.execute("INSERT INTO cand values ('"+Email+"', '"+sessionEmail+"')");
//                req.setAttribute("cannotVote", false);
//                //st.close();
//                //conn.commit();
//               req.getRequestDispatcher("/voteus.jsp").forward(req, res);
//            } else {
//                req.getRequestDispatcher("/voteus.jsp").forward(req, res);
//
//            }
        } catch (Exception ex) {
            Logger.getLogger(counting.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static class DBConnection {

        private static Connection getConnection() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public DBConnection() {
        }
    }
}
