<%@page import="java.util.List"%>
<%@page import="Models.Book"%>
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
        <title>Create Book</title>
        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/bootstrap.min.css" >
        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/font-awesome.css" >
        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/style.css" >
        <link href="<%=application.getContextPath() %>/vues/css/bootstrap-directional-buttons.min.css" rel="stylesheet">
        <script src="<%=application.getContextPath() %>/vues/js/jquery-3.2.1.min.js"></script>
        <script src="<%=application.getContextPath() %>/vues/js/bootstrap.min.js"></script>
        <script src="<%=application.getContextPath() %>/vues/js/booksScript.js"></script>
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
                                <li><a class="menu-top-active" href="<s:url action="redirectBooks" namespace="/vues" />">Books</a></li>
                                <li><a href="<s:url action="redirectBorrows" namespace="/vues" />">Borrows</a></li>
                                <li><a href="<s:url action="authorsList" namespace="/vues" />">Authors</a></li>
                                <li><a href="usersList.jsp">Users</a></li>
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
                    <a type="button" class="btn btn-danger btn-arrow-left" style="margin-left: 30px" href="booksList.jsp">Books List</a>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <h4 class="page-head-line">Create Book</h4>
                    </div>
                </div>

                <div class="col-md-10 col-md-offset-1">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Book Form
                        </div>
                        <div class="panel-body">
                            <form name="form-create" action="addBook.action" method="POST" enctype="multipart/form-data" >
                                <div class="form-group">
                                    <label for="bookName">Book's Name</label>
                                    <input type="input" class="form-control" id="bookName" name="beanBook.bookName" placeholder="Enter book name" />
                                </div>
                                <div class="form-group">
                                    <label for="bookLanguage">Book's Language</label>
                                    <input type="text" class="form-control" id="bookLanguage" name="beanBook.bookLanguage" placeholder="Enter book language" />
                                </div>
                                <div class="form-group">
                                    <label for="bookAuthor">Book's Author</label>
                                    <input type="text" class="form-control" id="bookAuthor" name="bookAuthor" placeholder="Enter book author" />
                                </div>
                                <div class="form-group">
                                    <label for="bookEditor">Book's Editor</label>
                                     <a id="addEditor" class="blue" style="cursor:pointer;" data-toggle="modal" data-target="#editorModal">
                                        (<i class="ace-icon fa fa-plus  bigger-130"></i>Add new editor)
                                    </a>
                                    <input type="text" class="form-control" id="bookEditor" name="bookEditor" placeholder="Enter book editor" />
                                </div>
                                <div class="form-group">
                                    <label for="bookGenre">Book's Genre</label> 
                                    <a id="addGenre" class="blue" style="cursor:pointer;" data-toggle="modal" data-target="#genreModal">
                                        (<i class="ace-icon fa fa-plus  bigger-130"></i>Add new genre)
                                    </a>
                                    <input type="text" class="form-control" id="bookGenre" name="bookGenre" placeholder="Enter book genre" />
                                </div>
                                <div class="form-group">
                                    <label for="bookPrice">Book's Price</label>
                                    <input type="text" class="form-control" id="bookPrice" name="beanBook.bookPrice" placeholder="Enter book price" />
                                </div>
                                <div class="form-group">
                                    <label for="bookPubliciation">Book's Publication Date</label>
                                    <input type="text" class="form-control" id="bookPubliciation" name="beanBook.bookPublicationDate" placeholder="Enter book publication date" />

                                </div>
                                <div class="form-group">
                                    <label for="booksInStore">Books In Store</label>
                                    <input type="text" class="form-control" id="booksInStore" name="beanBook.booksInStore" placeholder="Enter the number of books in store" />
                                </div>
                                 <div class="form-group">
                                    <label for="booksreference">Books Reference</label>
                                    <input type="text" class="form-control" id="booksreference" name="beanBook.bookReferance" placeholder="Enter book Reference" />
                                </div>
                                <div class="form-group">
                                    <label for="bookSumary">Book's Sumary</label>
                                    <textarea class="form-control" id="bookSumary" name="beanBook.bookSummary" rows="5" placeholder="Enter the book's sumary"></textarea>

                                  

                                </div>
                                <div class="form-group">
                                    <label for="bookImage">Book's Cover Image</label>
                                    <input type="file" id="bookImage" name="fileUpload" />
                                    <p class="help-block">Please make sure the cover is a 678*1083 png picture.</p>
                                </div>
                                <hr />
                                <button type="submit" class="btn btn-default">Submit</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="genreModal" role="dialog">
              <div class="modal-dialog">
                  <div class="modal-content">
                    <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal">&times;</button>
                      <h4 class="modal-title">Add New Genre</h4>
                    </div>
                    <div class="modal-body">
                      <div class="form-group">
                          <label for="genreId">Genre ID</label>
                          <input type="text" class="form-control" id="genreId" name="beanGenre.genreID" placeholder="Enter genre ID" />
                      </div>
                      <div class="form-group">
                          <label for="genreName">Genre Name</label>
                          <input type="text" class="form-control" id="genreName" name="beanGenre.genreName" placeholder="Enter genre name" />
                      </div>
                    </div>
                    <div class="modal-footer">
                      <button type="button" onclick="addGenre()" class="btn btn-success">Submit</button>
                      <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    </div>
                  </div>
              </div>
          </div>
       
        <div class="modal fade" id="editorModal" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                  <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Add New Editor</h4>
                  </div>
                  <div class="modal-body">
                    <div class="form-group">
                        <label for="editorId">Editor ID</label>
                        <input type="text" class="form-control" id="editorId" name="beanEditor.editorID" placeholder="Enter editor ID" />
                    </div>
                    <div class="form-group">
                        <label for="editorName">Editor Name</label>
                        <input type="text" class="form-control" id="editorName" name="beanEditor.editorName" placeholder="Enter editor name" />
                    </div>
                    <div class="form-group">
                        <label for="editorAddress">Editor Address</label>
                        <input type="text" class="form-control" id="editorAddress" name="beanEditor.editorAddress" placeholder="Enter editor address" />
                    </div>
                  </div>
                  <div class="modal-footer">
                    <button type="button" onclick="addEditor()" class="btn btn-success">Submit</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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
