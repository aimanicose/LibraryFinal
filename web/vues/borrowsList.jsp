<%@page import="java.util.List"%>
<%@page import="Models.Preter"%>
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
        <script src="<%=application.getContextPath() %>/vues/js/dataTable/datatables.min.js"></script>
        <script src="<%=application.getContextPath() %>/vues/js/dataTable/jquery.dataTables.bootstrap.min.js"></script>
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
                                <li><a class="menu-top-active" href="<s:url action="redirectBorrows" namespace="/vues" />">Borrows</a></li>
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
                            <table id="dynamic-table" class="table table-striped table-bordered table-hover display">
                                <thead>
                                    <tr> 
                                        <th class="center">Reference</th>
                                        <th>User Name</th>
                                        <th>Book's name</th>
                                        <th>Borrowing Date</th>
                                        <th>Bringing back Date</th>
                                        <th>Message</th>
                                        <th>Status</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                     <% 
                                            List<Preter> preterList = (List<Preter>)session.getAttribute("pretersList");
                                            Preter preter =null;
                                            if(preterList.size()>0)
                                            {
                                                for(int i=0;i<preterList.size();i++){
                                                preter = (Preter)preterList.get(i);
                                    %>
                                            <tr>
                                                <td class="center"><%=preter.getReference()%></td>
                                                <td><%=preter.getUser().getUserInformation().getUserFirstName()+ " " + preter.getUser().getUserInformation().getUserLastName() %></td>
                                                <td><%=preter.getBook().getBookName()%></td>
                                                <td><%=preter.getDateSortie()%></td>
                                                <td id="sortie<%=i%>"><%=preter.getDateEntree()%></td>
                                                <td><%=preter.getMessage()%></td>
                                                <td id="statut<%=i%>"><span class="label label-sm <% if(preter.getStatut().equals("IN")){%>label-success<%}else{%>label-warning<%}%>"><%=preter.getStatut()%></span></td>
                                                <td>
                                            <div class="hidden-sm hidden-xs action-buttons">
                                                <a id="editRow<%=i%>" class="green" onclick="edit_row(<%=i%>)">
                                                    <i class="ace-icon fa fa-pencil bigger-130"></i>
                                                </a>
                                                <a id="saveRow<%=i%>" class="orange col-md-1" style="display:none;" onclick="save_row(<%=i%>,<%=preter.getReference()%>)">
                                                    <i class="ace-icon fa fa-check bigger-130"></i>
                                                </a>
                                                <a id="cancelRow<%=i%>" class="red" style="display:none;" onclick="cancel_row(<%=i%>)">
                                                    <i class="ace-icon fa fa-times bigger-130"></i>
                                                </a>
                                            </div>
                                        </td>
                                    </tr>
                                    <%}       
                                    }
                                    %>
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
