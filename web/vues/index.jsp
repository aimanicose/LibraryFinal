<%@page import="Models.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>User Dashboard</title>
        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/font-awesome.css" />
        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/style.css" >
        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/bootstrap-datepicker.min.css" />    
        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/typehead.css" />   
        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/jquery-ui.css" /> 
        <script src="<%=application.getContextPath() %>/vues/js/jquery-3.2.1.min.js"></script>
        <script src="<%=application.getContextPath() %>/vues/js/bootstrap.js"></script>
        <script src="<%=application.getContextPath() %>/vues/js/jquery-ui.js"></script>
        <script src="<%=application.getContextPath() %>/vues/js/bootstrap-datepicker.min.js"></script>
        <script src="<%=application.getContextPath() %>/vues/js/indexScript.js"></script>
        <script src="<%=application.getContextPath() %>/vues/js/dataScript.js"></script>
       
       
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
                                <li><a class="menu-top-active" href="index.jsp">Dashboard</a></li>
                                <li><a href="<s:url action="redirectBooks" namespace="/vues" />">Books</a></li>
                                <li><a href="<s:url action="redirectBorrows" namespace="/vues" />">Borrows</a></li>
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
        <div class="content-wrapper">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h4 class="page-head-line">Dashboard</h4>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-3 col-sm-3 col-xs-6">
                        <div class="dashboard-div-wrapper bk-clr-one">
                            <a href="<s:url action="redirectBooks" namespace="/vues" />">
                                <i  class="fa fa-book dashboard-div-icon" ></i>
                            </a>
                            <h3 id="booksInStore">0<h3/>
                                <h5>Books in store</h5>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-3 col-xs-6">
                        <div class="dashboard-div-wrapper bk-clr-two">
                            <a href="#">
                                <i  class="fa fa-edit dashboard-div-icon" ></i>
                            </a>
                            <h3 id="booksOutStore">0<h3/>
                                <h5>Books out of store</h5>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-3 col-xs-6">
                        <div class="dashboard-div-wrapper bk-clr-three">
                            <a href="#">
                                <i  class="fa fa-cogs dashboard-div-icon" ></i>
                            </a>
                            <h3>&nbs<h3/>
                                <h5>Manage Store </h5>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-3 col-xs-6">
                        <div class="dashboard-div-wrapper bk-clr-four">
                            <a href="#">
                                <i  class="fa fa-bell-o dashboard-div-icon"></i>
                            </a>
                            <h3>10<h3/>
                                <h5>Notifications</h5>
                        </div>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-md-6">
                        <div class="Compose-Message">               
                            <div class="panel panel-success">
                                <div class="panel-heading">
                                    Fast Book Allocation
                                </div>
                                <form name="form-login" action="vues/bookAllocation.action">
                                <div class="panel-body">
                                    <row>
                                        <label>User ID : </label>
                                    </row>
                                    <row>
                                        <input type="text" class="form-control" name="borrowUser.userID"/>
                                    </row>
                                    <row>
                                        <label>Book Name :  </label>
                                        <button class="add_field_button btn btn-link">
                                            <span class="glyphicon glyphicon-plus"></span>More than 1 book
                                        </button>
                                    </row>
                                    <row>
                                        <div class="input_fields_wrap">
                                            <div><input id="book1" class="typeahead form-control ui-autocomplete-input" autocomplete="new-password" type="text" name="borrowBookList[1].bookName"></div>
                                        </div>
                                    </row>
                                    <row>
                                        <label>Borrowing Date :  </label>
                                    </row>
                                    <row>
                                        <div class="input-group date">
                                            <input id="datepicker" type="text" class="form-control"  name="borrowDate">
                                            <div class="input-group-addon">
                                                  <i class="ace-icon fa fa-calendar"></i>
                                            </div>
                                        </div> 
                                    </row>
                                    <row>
                                        <label>Enter Message : </label>  
                                    </row>
                                    <row>
                                        <textarea rows="6" class="form-control" name="borrowSumary"></textarea>
                                    </row>
                                    <hr />
                                    <button type="submit" href="#" class="btn btn-warning"><span class="glyphicon glyphicon-paperclip"></span> Allocate Book </button>&nbsp;
                                </div>
                                <div class="panel-footer text-muted" style="font-size: 12px;">
                                    *To cancel or edit any operation please refer to the borrows page
                                </div>
                                </form>
                            </div>
                        </div>  
                    </div>
                    <div class="col-md-6">
                        <div class="notice-board">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Active  Notice Panel 
                                    <div class="pull-right" >
                                        <div class="dropdown">
                                            <button class="btn btn-success dropdown-toggle btn-xs" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
                                                <span class="glyphicon glyphicon-cog"></span>
                                                <span class="caret"></span>
                                            </button>
                                            <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
                                                <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Refresh</a></li>
                                                <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Logout</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <div class="panel-body">
                                    
                                    <ul >
                                        
                                        <li>
                                            <a href="#">
                                                <span class="glyphicon glyphicon-align-left text-success" ></span> 
                                                Lorem ipsum dolor sit amet ipsum dolor sit amet
                                                <span class="label label-warning" > Just now </span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <span class="glyphicon glyphicon-info-sign text-danger" ></span>  
                                                Lorem ipsum dolor sit amet ipsum dolor sit amet
                                                <span class="label label-info" > 2 min chat</span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <span class="glyphicon glyphicon-comment  text-warning" ></span>  
                                                Lorem ipsum dolor sit amet ipsum dolor sit amet
                                                <span class="label label-success" >GO ! </span>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#">
                                                <span class="glyphicon glyphicon-edit  text-danger" ></span>  
                                                Lorem ipsum dolor sit amet ipsum dolor sit amet
                                                <span class="label label-success" >Let's have it </span>
                                            </a>
                                        </li>
                                        </a>
                                        </li>
                                    </ul>
                                </div>
                                <div class="panel-footer">
                                    <a href="#" class="btn btn-default btn-block"> <i class="glyphicon glyphicon-repeat"></i> Just A Small Footer Button</a>
                                </div>
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
    </body>
</html>
