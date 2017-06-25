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
        <title>Borrows List</title>
        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/bootstrap.min.css" >
        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/font-awesome.css" >
        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/style.css" >
        <script src="<%=application.getContextPath() %>/vues/js/jquery-3.2.1.min.js"></script>
        <script src="<%=application.getContextPath() %>/vues/js/bootstrap.min.js"></script>
        <script src="<%=application.getContextPath() %>/vues/js/script.js"></script>
         <%
        if(session.getAttribute("userSession")==null)
          {
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
                                <li><a href="booksList.jsp">Books</a></li>
                                <li><a class="menu-top-active" href="borrowsList.jsp">Borrows</a></li>
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
                        <h4 class="page-head-line">Brrows List</h4>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                       <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>Ref. No.</th>
                                        <th>Date</th>
                                        <th>Amount</th>
                                        <th>Status</th>
                                        <th>Delivery On </th>
                                        <th># #</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    
                                    <tr>
                                        <td># 2501</td>
                                        <td>01/22/2015 </td>
                                        <td>
                                            <label class="label label-info">300 USD </label>
                                        </td>
                                        <td>
                                            <label class="label label-success">Delivered</label></td>
                                        <td>01/25/2015</td>
                                        <td> <a href="#"  class="btn btn-xs btn-danger"  >View</a> </td>
                                    </tr>
                                    <tr>
                                        <td># 15091</td>
                                        <td>12/12/2014 </td>
                                        <td>
                                            <label class="label label-danger">7000 USD </label>
                                        </td>
                                        <td>
                                            <label class="label label-warning">Shipped</label></td>
                                        <td>N/A</td>
                                        <td> <a href="#"  class="btn btn-xs btn-success"  >View</a> </td>
                                    </tr>
                                    <tr>
                                        <td># 11291</td>
                                        <td>12/03/2014 </td>
                                        <td>
                                            <label class="label label-warning">7000 USD </label>
                                        </td>
                                        <td>
                                            <label class="label label-success">Delivered</label></td>
                                        <td>01/23/2015</td>
                                        <td> <a href="#"  class="btn btn-xs btn-primary"  >View</a> </td>
                                    </tr>
                                    <tr>
                                        <td># 1808</td>
                                        <td>11/10/2014 </td>
                                        <td>
                                            <label class="label label-success">2000 USD </label>
                                        </td>
                                        <td>
                                            <label class="label label-info">Returned</label></td>
                                        <td>N/A</td>
                                        <td> <a href="#"  class="btn btn-xs btn-danger"  >View</a> </td>
                                    </tr>
                                </tbody>
                            </table>
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
