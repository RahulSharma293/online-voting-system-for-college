<%-- 
    Document   : DriverDetails
    Created on : 16 Nov, 2018, 11:03:54 AM
    Author     : ashmitbakshi
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="student.results"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <title>JSP Page</title>
        <body background="r.jpeg"> 
        <style>
            
           * {box-sizing:border-box}
body {font-family: Verdana,sans-serif;}
 div.top {
  background: url(r.jpeg) repeat;
  border: 10px solid black;
}
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333333;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 20px;
    text-decoration: none;
}

li a:hover {
    background-color: #111111;
}
li img {
	display:block;
	padding: 6px;
}

            table,th, td 
            {
                padding: 15px;
                text-align: left;
                font-size: 20px !important;
                
                
            }
            table td 
            {
                border-left: 1px solid #000;
                border-right: 1px solid #000;
            }
            tr:hover {background-color:#cfd8dc;}
        </style>
    <body background="wall.jpeg">
     <ul>
   <li><a href="index.html"><img src="img.png"></a></li>
  <li><a href="index.html">Home</a></li>
<li><a href="about.html">About</a></li>
<li margin="right"><right><a href="index.html">Logout</a></right></li>
  </UL>
        <%
            
            response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); //HTTP 1.1
            
            response.setHeader("Pragma", "no-cache");//HTTP 1.0s
            
            response.setHeader("Expires", "0");
            
            
            
//            if(session.getAttribute("email")==null)
//            {
//                response.sendRedirect("viewcandidates.java");
//            }
            ArrayList<results> v=(ArrayList)request.getAttribute("cand");
            System.out.println("v.size()" + v.size());
            Iterator it = v.iterator();
            while(it.hasNext())
            {
                
                results d =(results)it.next();
            
        %>
       
                    <table style="border:1px solid black;">
                        <tbody>
                 <tr>
                        
                                <td ><strong>F_name </strong></td>
                                <td ><%=d.f_name%> <%=d.l_name%></td>
                        
                            </tr>
                            <tr>
                                <td ><strong>NO.of votes </strong></td>
                                <td ><%=d.votecounts%></td>
                        
                                </tr>
                                <tr>
                                    <td><strong>year</strong></td></b>
                                    <td><%=d.yr%></td>
                        
                                </tr>
                                <tr>
                                    <td ><strong>image</strong></td></b>
                                    <td ><%=d.img%></td>
                        
                                </tr>
                               
                  </tbody>
                        </table>
                                      
        <%
            }
        %>
          
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script>
              $(document).ready(function(){
                $('.tooltipped').tooltip();
                });
              $(document).ready(function(){
                $('.sidenav')
                    .sidenav()
                    .on('click tap', 'li a', () => {
                $('.sidenav').sidenav('close');
                    });
                });
        </script>      
                        
        <footer class="white-text blue-grey darken-4 " style="position: fixed;bottom:0px;left:0;width:100%;height:20px; font-size: 12px;">
           <div class="footer-copyright">
            <div class="container center-align">
                &copy; 2018 CHITKARA UNIVERSITY
            </div>
          </div>
        </footer>
    </body>
</html>