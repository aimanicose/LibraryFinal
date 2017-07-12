<%@page import="Models.UserInformation"%>
<%@page import="java.util.List"%>
<%@page import="com.google.gson.Gson"%><%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Users List</title>
        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/bootstrap.min.css" >
        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/font-awesome.css" >
        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/style.css" >
        <script src="<%=application.getContextPath() %>/vues/js/jquery-3.2.1.min.js"></script>
        <script src="<%=application.getContextPath() %>/vues/js/bootstrap.min.js"></script>
         <%
          response.setHeader("Cache-Control","no-cache");
          response.setHeader("Cache-Control","no-store");
          response.setHeader("Pragma","no-cache");
          response.setDateHeader ("Expires", 0);

          if(session.getAttribute("userSession")==null){
            response.sendRedirect("login.jsp");
          }
        %>
    </head>
    <body>
        <header>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <strong>Email: </strong>support@onlinelibrary.com
                        &nbsp;&nbsp;
                        <strong>Support: </strong>+212 5 00 00 00
                    </div>
                </div>
            </div>
        </header>
        <!-- HEADER END-->
       <div class="navbar navbar-inverse set-radius-zero">
            <div class="container">
                <div class="navbar-header">
                    <div class="welcome-div col-md-7">
                        <img src="<%=application.getContextPath() %>/vues/img/logo.png" style="height:100px;"/>
                    </div>
                    <div class="welcome-div col-md-4">
                        <h2 class="page-head-welcome"><%=session.getAttribute("userSession")%></h2>
                    </div>
                </div>
            </div>
        </div>
        <!-- LOGO HEADER END-->
        <section class="menu-section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="navbar-collapse collapse ">
                            <ul id="menu-top" class="nav navbar-nav navbar-right">
                                <li><a  href="index.jsp">Dashboard</a></li>   
                                <li><a href="<s:url action="redirectBooks" namespace="/vues" />">Books</a></li>
                                <li><a href="<s:url action="redirectBorrows" namespace="/vues" />">Borrows</a></li>
                                <li><a href="<s:url action="authorsList" namespace="/vues" />">Authors</a></li>
                                <li><a class="menu-top-active" href="usersList.jsp">Users</a></li>
                                <li><a href="<s:url action="usersList" namespace="/vues" />">Shelfs</a></li>
                                <li><a href="<s:url action="logout" namespace="/vues" />">Log Out</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- MENU SECTION END-->
        <div id="container" class="content-wrapper">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h4 class="page-head-line">Users List</h4>
                    </div>
                </div>
                <div class="panel-body">
                    <div class="table-container">
                        <table class="table-users table" border="0">
                            <thead>
                                <tr>
                                    <th></th>
                                    <th>ID</th>
                                    <th>First Name/Last Name</th>
                                    <th>Email</th>
                                    <th>Birth Date</th>
                                    <th>Address</th>
                                </tr> 
                            </thead>
                            <tbody>
                                <% 
                                    List<UserInformation> usersList =null;
                                    UserInformation user=null;
                                    if(session.getAttribute("usersList")!=null)
                                    {
                                        usersList = (List<UserInformation>)session.getAttribute("usersList");
                                        for(int i=0;i<usersList.size();i++){
                                        user = (UserInformation)usersList.get(i);
                                %>
                                <tr>
                                    <td width="10" align="center">
                                        <div style="font-size: 15px;line-height: 1.5em;">
                                            <span class="fa-stack fa-lg">
                                                <i class="fa fa-circle fa-stack-2x"></i>
                                                <i class="fa fa-user fa-stack-1x fa-inverse"></i>
                                            </span>    
                                        </div>
                                    </td>
                                    <td style="line-height: 40px;">
                                        <%=user.getUserID()%>
                                    </td>
                                    <td style="line-height: 40px;">
                                       <%=user.getUserFirstName() + " "+ user.getUserLastName()%>
                                    </td>
                                    <td style="line-height: 40px;">
                                          <%=user.getUserEmail()%> <i class="fa fa-envelope"></i>
                                    </td>
                                    <td style="line-height: 40px;">
                                          <%=user.getUserBirthDate()%>
                                    </td>
                                    <td style="line-height: 40px;">
                                         <%=user.getUserAddress()%>
                                    </td>
                                </tr>
                                <%}}
                                %>
                            </tbody>
                        </table>
                    </div>
                </div>  
            </div>
        </div>
        <!-- CONTENT-WRAPPER SECTION END-->
        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        &copy; 2017 The OnlineLibrary | 62 Street 2 Maarif Casablanca Morocco</a>
                    </div>
                </div>
            </div>
        </footer>
    </body>
</html>
