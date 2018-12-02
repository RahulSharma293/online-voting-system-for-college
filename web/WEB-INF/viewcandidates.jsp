<%-- 
    Document   : DriverDetails
    Created on : 16 Nov, 2018, 11:03:54 AM
    Author     : ashmitbakshi
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="student.vote"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       
        <title>JSP Page</title>
        <style>
            body
            {
                background: #eceff1;
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
    </head>
    <body background="wall.jpeg">
        <%
            
            response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); //HTTP 1.1
            
            response.setHeader("Pragma", "no-cache");//HTTP 1.0s
            
            response.setHeader("Expires", "0");
            
            
            
            if(session.getAttribute("email")==null)
            {
                response.sendRedirect("viewcandidates.java");
            }
            ArrayList<vote> v=(ArrayList)request.getAttribute("driverlist");
            Iterator it = v.iterator();
            while(it.hasNext())
            {
                
                vote d =(vote)it.next();
            
        %>
        <header>
            <div class="navbar-fixed">
                <nav class="nav-wrapper blue-grey darken-3">
                    <div class="container">
                        <ul class="left hide-on-small-only">
                            <li><a class ="waves-effect waves-light tooltipped"  data-position="bottom" data-tooltip="Home" href="landingjsp.jsp">
                                    <i class="material-icons" style="font-size:35px;">arrow_back</i>
                                </a>
                            </li>
                        </ul>
                         
                    </div>
                </nav>
            </div>
        </header>
        <div class="container">
            <div class="row">
                <div class='col s12 m12 l12 '>
                    <table class=" white z-depth-4 centered  striped" style="border:1px solid black;">
                        <tbody>
                   
                            <h5 class="center-align" style="font-size:25px;">Driver Details 
                                <i class="fa fa-id-card-o" aria-hidden="true"></i>
                            </h5>
                    
                            <tr>
                        
                                <td class="flow-text"><strong>F_name </strong></td>
                                <td class="flow-text"><%=d.f_name%></td>
                        
                            </tr>
                            <tr>
                                <td class="flow-text"><strong>L_name </strong></td>
                                <td class="flow-text"><%=d.l_name%></td>
                        
                                </tr>
                                <tr>
                                    <td class="flow-text"><strong>year</strong></td></b>
                                    <td class="flow-text"><%=d.yr%></td>
                        
                                </tr>
                                <tr>
                                    <td class="flow-text"><strong>image</strong></td></b>
                                    <td class="flow-text"><%=d.img%></td>
                        
                                </tr>
                                <tr>
                                    <td class="flow-text"><strong>Subject</strong></td></b>
                                    <td class="flow-text"><%=d.subject%></td>
                        
                         </tr>
                  </tbody>
                        </table>
                    </div>
                </div>   
            </div>                    
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