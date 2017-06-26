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
        <link rel="stylesheet" href="<%=application.getContextPath() %>/vues/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />
        <script src="<%=application.getContextPath() %>/vues/js/jquery-1.11.1.js"></script>
        <script src="<%=application.getContextPath() %>/vues/js/bootstrap.min.js"></script>
         
        <script src="<%=application.getContextPath() %>/vues/js/dataTable/jquery.dataTables.min.js"></script>
        <script src="<%=application.getContextPath() %>/vues/js/dataTable/jquery.dataTables.bootstrap.min.js"></script>
        <script src="<%=application.getContextPath() %>/vues/js/dataTable/dataTables.buttons.min.js"></script>
        <script src="<%=application.getContextPath() %>/vues/js/dataTable/buttons.flash.min.js"></script>
        <script src="<%=application.getContextPath() %>/vues/js/dataTable/buttons.print.min.js"></script>
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
                    <div class="clearfix">
                        <div class="pull-right tableTools-container"></div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Books currently allocated and their holders
                        </div>
                        <div class="panel-body">
                            <table id="dynamic-table" class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th  class="center">Domain</th>
                                        <th>Price</th>
                                        <th class="hidden-480">Clicks</th>
                                        <th>
                                            <i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i>
                                            Update
                                        </th>
                                        <th class="hidden-480">Status</th>
                                        <th></th>
                                    </tr>
                                </thead>

                                <tbody>
                                    <tr>
                                        <td class="center">
                                            <a href="#">app.com</a>
                                        </td>
                                        <td>$45</td>
                                        <td class="hidden-480">3,330</td>
                                        <td>Feb 12</td>
                                        <td class="hidden-480">
                                            <span class="label label-sm label-warning">Expiring</span>
                                        </td>
                                        <td>
                                            <div class="hidden-sm hidden-xs action-buttons">
                                                    <a class="blue" href="#">
                                                            <i class="ace-icon fa fa-search-plus bigger-130"></i>
                                                    </a>

                                                    <a class="green" href="#">
                                                            <i class="ace-icon fa fa-pencil bigger-130"></i>
                                                    </a>

                                                    <a class="red" href="#">
                                                            <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                                    </a>
                                            </div>

                                            <div class="hidden-md hidden-lg">
                                                    <div class="inline pos-rel">
                                                            <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                                                    <i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
                                                            </button>

                                                            <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                                    <li>
                                                                            <a href="#" class="tooltip-info" data-rel="tooltip" title="View">
                                                                                    <span class="blue">
                                                                                            <i class="ace-icon fa fa-search-plus bigger-120"></i>
                                                                                    </span>
                                                                            </a>
                                                                    </li>

                                                                    <li>
                                                                            <a href="#" class="tooltip-success" data-rel="tooltip" title="Edit">
                                                                                    <span class="green">
                                                                                            <i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
                                                                                    </span>
                                                                            </a>
                                                                    </li>

                                                                    <li>
                                                                            <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
                                                                                    <span class="red">
                                                                                            <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                                                    </span>
                                                                            </a>
                                                                    </li>
                                                            </ul>
                                                    </div>
                                            </div>
                                        </td>
                                    </tr>

                                    <tr>
                                            <td class="center">
                                                    <a href="#">base.com</a>
                                            </td>
                                            <td>$35</td>
                                            <td class="hidden-480">2,595</td>
                                            <td>Feb 18</td>

                                            <td class="hidden-480">
                                                    <span class="label label-sm label-success">Registered</span>
                                            </td>

                                            <td>
                                                    <div class="hidden-sm hidden-xs action-buttons">
                                                            <a class="blue" href="#">
                                                                    <i class="ace-icon fa fa-search-plus bigger-130"></i>
                                                            </a>

                                                            <a class="green" href="#">
                                                                    <i class="ace-icon fa fa-pencil bigger-130"></i>
                                                            </a>

                                                            <a class="red" href="#">
                                                                    <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                                            </a>
                                                    </div>

                                                    <div class="hidden-md hidden-lg">
                                                            <div class="inline pos-rel">
                                                                    <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                                                            <i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
                                                                    </button>

                                                                    <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                                            <li>
                                                                                    <a href="#" class="tooltip-info" data-rel="tooltip" title="View">
                                                                                            <span class="blue">
                                                                                                    <i class="ace-icon fa fa-search-plus bigger-120"></i>
                                                                                            </span>
                                                                                    </a>
                                                                            </li>

                                                                            <li>
                                                                                    <a href="#" class="tooltip-success" data-rel="tooltip" title="Edit">
                                                                                            <span class="green">
                                                                                                    <i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
                                                                                            </span>
                                                                                    </a>
                                                                            </li>

                                                                            <li>
                                                                                    <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
                                                                                            <span class="red">
                                                                                                    <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                                                            </span>
                                                                                    </a>
                                                                            </li>
                                                                    </ul>
                                                            </div>
                                                    </div>
                                            </td>
                                    </tr>

                                    <tr>
                                            <td class="center">
                                                <a href="#">up.com</a>
                                            </td>
                                            <td>$95</td>
                                            <td class="hidden-480">8,520</td>
                                            <td>Feb 22</td>

                                            <td class="hidden-480">
                                                    <span class="label label-sm label-info arrowed arrowed-righ">Sold</span>
                                            </td>

                                            <td>
                                                    <div class="hidden-sm hidden-xs action-buttons">
                                                            <a class="blue" href="#">
                                                                    <i class="ace-icon fa fa-search-plus bigger-130"></i>
                                                            </a>

                                                            <a class="green" href="#">
                                                                    <i class="ace-icon fa fa-pencil bigger-130"></i>
                                                            </a>

                                                            <a class="red" href="#">
                                                                    <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                                            </a>
                                                    </div>

                                                    <div class="hidden-md hidden-lg">
                                                            <div class="inline pos-rel">
                                                                    <button class="btn btn-minier btn-yellow dropdown-toggle" data-toggle="dropdown" data-position="auto">
                                                                            <i class="ace-icon fa fa-caret-down icon-only bigger-120"></i>
                                                                    </button>

                                                                    <ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
                                                                            <li>
                                                                                    <a href="#" class="tooltip-info" data-rel="tooltip" title="View">
                                                                                            <span class="blue">
                                                                                                    <i class="ace-icon fa fa-search-plus bigger-120"></i>
                                                                                            </span>
                                                                                    </a>
                                                                            </li>

                                                                            <li>
                                                                                    <a href="#" class="tooltip-success" data-rel="tooltip" title="Edit">
                                                                                            <span class="green">
                                                                                                    <i class="ace-icon fa fa-pencil-square-o bigger-120"></i>
                                                                                            </span>
                                                                                    </a>
                                                                            </li>

                                                                            <li>
                                                                                    <a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
                                                                                            <span class="red">
                                                                                                    <i class="ace-icon fa fa-trash-o bigger-120"></i>
                                                                                            </span>
                                                                                    </a>
                                                                            </li>
                                                                    </ul>
                                                            </div>
                                                    </div>
                                            </td>
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
        <script src="<%=application.getContextPath() %>/vues/js/borrowScript.js"></script>
    </body>
</html>
