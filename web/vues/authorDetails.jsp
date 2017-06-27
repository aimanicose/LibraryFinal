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
        <link href="<%=application.getContextPath() %>/vues/css/bootstrap-directional-buttons.min.css" rel="stylesheet">
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
        <% 
            Author detailedAuthor = (Author)session.getAttribute("detailedAuthor");
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
                                <li><a class="menu-top-active" href="<s:url action="authorsList" namespace="/vues" />">Authors</a></li>
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
                    <a type="button" class="btn btn-danger btn-arrow-left" style="margin-left: 30px" href="authorsList.jsp">Authors List</a>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <h4 class="page-head-line">Author's Details</h4>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-3">
                         <img src="<%=application.getContextPath() %>/vues/img/bookCovers/<%=detailedAuthor.getAuthorImageID()%>.png" alt="/vues/img/authorsPictures/placeholder.png" class="img-thumbnail">
                    </div>
                    <div class="col-md-9">
                        
                    </div>
                </div>
                <div class="row">
                    <div class="tabbable">
                        <ul class="nav nav-tabs" id="myTab">
                            <li class="active">
                                <a data-toggle="tab" href="#home">
                                    <i class="green ace-icon fa  fa-book bigger-120"></i>
                                    Bio
                                </a>
                            </li>

                            <li>
                                <a data-toggle="tab" href="#messages">
                                    <i class="green ace-icon fa  fa-comment bigger-120"></i>
                                    Books
                                </a>
                            </li>
                        </ul>

                        <div class="tab-content">
                            <div id="home" class="tab-pane fade in active">
                                    <p>Raw denim you probably haven't heard of them jean shorts Austin.</p>
                            </div>

                            <div id="messages" class="tab-pane fade">
                                    <p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid.</p>
                            </div>
                        </div>
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
        <script src="<%=application.getContextPath() %>/vues/js/authorsScript.js"></script>
    </body>
</html>
