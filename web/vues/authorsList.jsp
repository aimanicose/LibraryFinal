<%@page import="Models.Author"%>
<%@page import="java.util.List"%>
<%@page import="Models.Book"%>
<%@page import="com.google.gson.Gson"%>
<%@taglib uri="/struts-tags" prefix="s" %>
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
        <title>Authors List</title>
        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/bootstrap.min.css" >
        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/font-awesome.css" >
        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/style.css" >
        <link rel="stylesheet" href="<%=application.getContextPath() %>/vues/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />
        <script src="<%=application.getContextPath() %>/vues/js/jquery-3.2.1.min.js"></script>
        <script src="<%=application.getContextPath() %>/vues/js/bootstrap.min.js"></script>
        
        <script src="<%=application.getContextPath() %>/vues/js/dataTable/jquery.dataTables.min.js"></script>
        <script src="<%=application.getContextPath() %>/vues/js/dataTable/jquery.dataTables.bootstrap.min.js"></script>
        <link rel="stylesheet" href="<%=application.getContextPath() %>/vues/css/uikit.min.css" />
        <script src="<%=application.getContextPath() %>/vues/js/uikit.min.js"></script>
        
<style>
* {
  box-sizing: border-box;
}

#myInput {
  background-position: 10px 12px;
  background-repeat: no-repeat;
  width: 100%;
  font-size: 16px;
  padding: 12px 20px 12px 40px;
  border: 1px solid #ddd;
  margin-bottom: 12px;
  
}

.list .row {
    margin-top: -5px;
    column-gap: 0px;
}

.list .row :nth-of-type(odd) {
background-color: #f5f5f5;  
}


</style>
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
                                <li><a href="index.jsp">Dashboard</a></li>   
                                <li><a href="<s:url action="redirectBooks" namespace="/vues" />">Books</a></li>
                                <li><a href="borrowsList.jsp">Borrows</a></li>
                                <li><a href="<s:url action="authorsList" namespace="/vues" />">Authors</a></li>
                                <li><a href="usersList.jsp">Users</a></li>
                                <li><a href="forms.html">Shelfs</a></li>
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
                        <h4 class="page-head-line">Authors List</h4>
                    </div>
                </div>
                <div class="row">
                    
                    <input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names.." title="Type in a name">
                      
                    <ul id="myUL" class="uk-list list">  
                    <% 
                        List<Author> authorsList = (List<Author>)session.getAttribute("auhtorsList");
                        for(int i=0;i<authorsList.size();i=i+3){
                        Author author = (Author)authorsList.get(i);
                        Author author2 = (Author)authorsList.get(i+1);
                        Author author3 = (Author)authorsList.get(i+2);
                    %>
                    <div class="row">
                        <div class="col-md-4">
                            <li class="thumb selectable arrow light" style="margin-bottom:-5px;">
                                <a href=""><%=author.getAuthorFirstName() +" "+author.getAuthorLastName()%></a> 
                            </li>
                        </div>
                         <div class="col-md-4">
                            <li class="thumb selectable arrow light" style="margin-bottom:-5px;">
                                <a href=""><%=author2.getAuthorFirstName() +" "+author.getAuthorLastName()%></a> 
                            </li>
                        </div>
                         <div class="col-md-4">
                            <li class="thumb selectable arrow light" style="margin-bottom:-5px;">
                                <a href=""><%=author3.getAuthorFirstName() +" "+author.getAuthorLastName()%></a> 
                            </li>
                        </div>
                    </div>
                        
                    <%}
                    %>
                    </ul>
                    
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
        <script src="<%=application.getContextPath() %>/vues/js/authorsScript.js"></script>
    </body>
</html>
