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
        <link rel="stylesheet" href="<%=application.getContextPath() %>/vues/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style">
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
                                <li><a href="<s:url action="redirectBorrows" namespace="/vues" />">Borrows</a></li>
                                <li><a class="menu-top-active" href="<s:url action="authorsList" namespace="/vues" />">Authors</a></li>
                                <li><a href="<s:url action="usersList" namespace="/vues" />">Users</a></li>
                                <li><a href="shelfs.jsp">Shelfs</a></li>
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
                         <img src="<%=application.getContextPath() %>/vues/img/authorsPictures/<%=detailedAuthor.getAuthorImageID()%>.jpg" alt="Author Image" class="img-thumbnail" style="max-width: 80%;">
                    </div>
                    <div class="col-md-9">
                        <div class="profile-user-info profile-user-info-striped">
                            <div class="profile-info-row">
                                <div class="profile-info-name">First Name :</div>
                                <div class="profile-info-value">
                                    <span class="editable" id="firstName"><%=detailedAuthor.getAuthorFirstName()%></span>
                                </div>
                            </div>

                            <div class="profile-info-row">
                                <div class="profile-info-name">Last Name :</div>
                                <div class="profile-info-value">
                                     <span class="editable" id="firstName"><%=detailedAuthor.getAuthorLastName()%></span>
                                 </div>
                            </div>

                           <div class="profile-info-row">
                                <div class="profile-info-name">Pen Name :</div>
                                <div class="profile-info-value">
                                     <span class="editable" id="penName"><%=detailedAuthor.getAuthorPenName()%></span>
                                 </div>
                            </div>

                            <div class="profile-info-row">
                                <div class="profile-info-name">Birth Date :</div>
                                <div class="profile-info-value">
                                    <span class="editable" id="birthDate"><%=detailedAuthor.getAuthorBirthDate()%></span>
                                </div>
                            </div>

                            <div class="profile-info-row">
                                <div class="profile-info-name">Nationality :</div>
                                <div class="profile-info-value">
                                    <span class="editable" id="nationality"><%=detailedAuthor.getAuthorNationality()%></span>
                                </div>
                            </div>

                            <div class="profile-info-row">
                                <div class="profile-info-name">Sexe :</div>
                                <div class="profile-info-value">
                                    <span class="editable" id="sexe"><%=detailedAuthor.getAuthorSexe()%></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                    
                <br/>
                
                <div class="row">
                    <div class="tabbable">
                        <ul class="nav nav-tabs" id="myTab">
                            <li class="active">
                                <a data-toggle="tab" href="#biography">
                                    <i class="green ace-icon fa  fa-book bigger-120"></i>
                                    Bio
                                </a>
                            </li>

                            <li>
                                <a data-toggle="tab" href="#books">
                                    <i class="green ace-icon fa  fa-comment bigger-120"></i>
                                    Books
                                </a>
                            </li>
                        </ul>

                        <div class="tab-content">
                            <div id="biography" class="tab-pane fade in active">
                                <br/>
                                <p><%=detailedAuthor.getAuthorBiography()%></p>
                            </div>

                            <div id="books" class="tab-pane fade">
                                <br/>
                                <div class="container">
                                    <div class="col-md-12">
                                        <div class="well">
                                            <div id="myCarousel" class="carousel slide">
                                                <div class="carousel-inner">
                                                        <% 
                                                            List<Book> authorBooks = detailedAuthor.getBookList();
                                                            long rows = (authorBooks.size() + 4 - 1) / 4;
                                                            int booksCounter = 0;
                                                            int rowsCounter = 0;
                                                            int index = 4;

                                                            for(int i=0;i<rows;i++){
                                                                if(i>0){
                                                        %>
                                                        <div class="item">
                                                        <%      }else{ %>  
                                                            <div class="item active">
                                                        <%      }%>
                                                                <div class="row">
                                                        <%
                                                                if(authorBooks.size()>index){
                                                                    rowsCounter = rowsCounter+4;
                                                                }else{
                                                                    rowsCounter = authorBooks.size();
                                                                }
                                                                  
                                                                for(int j=booksCounter;j<rowsCounter;j++){
                                                        %>
                                                                <div class="col-sm-3">
                                                                    <a href="<s:url action="bookDetails" namespace="/vues" />&bookId=<%=authorBooks.get(j).getBookID()%>" data-toggle="modal" data-target="#bookDetailsModal"  class="thumbnail">
                                                                        <img src="<%=application.getContextPath() %>/vues/img/bookCovers/<%=authorBooks.get(j).getBookImageId()%>.png" alt="Image" class="img-responsive">
                                                                    </a>
                                                                </div>
                                                        <% 
                                                                    booksCounter++;
                                                                }
                                                                index=index+4;
                                                        %>
                                                                </div>
                                                            </div>
                                                        <%  }
                                                        %>
                                                        </div>
                                                </div>
                                                <!--/carousel-inner--> 
                                                <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                                                    <i class="glyphicon glyphicon-chevron-left"></i>
                                                </a>

                                                <a class="right carousel-control" href="#myCarousel" data-slide="next">
                                                    <i class="glyphicon glyphicon-chevron-right"></i>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container">
                <div id="bookDetailsModal" class="modal fade" role="dialog">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        &copy; 2017 The OnlineLibrary | 62 Street 2 Maarif Casablanca Morocco</a>
                    </div>
                </div>
            </div>
        </footer>
        <script>
     $(document).ready(function() {
    $('#myCarousel').carousel({
	interval: 10000
	});
    
    $('#myCarousel').on('slid.bs.carousel', function() {
    	//alert("slid");
	});
    
    
});
        </script>
    </body>
</html>
