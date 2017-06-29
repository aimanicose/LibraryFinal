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
        <title>Sign UP</title>
        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/bootstrap.min.css" >
        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/font-awesome.css" >
        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/style.css" >
        <link href="<%=application.getContextPath() %>/vues/css/bootstrap-directional-buttons.min.css" rel="stylesheet">
        <script src="<%=application.getContextPath() %>/vues/js/jquery-3.2.1.min.js"></script>
        <script src="<%=application.getContextPath() %>/vues/js/bootstrap.min.js"></script>
        <script src="<%=application.getContextPath() %>/vues/js/booksScript.js"></script>
        
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
                        <h2 class="page-head-welcome">Welcome</h2>
                    </div>
                </div>
            </div>
        </div>
        <!-- MENU SECTION END-->
        <div id="container" class="content-wrapper">         
            <div class="container">
                <div class="row">
                    <a type="button" class="btn btn-danger btn-arrow-left" style="margin-left: 30px" href="login.jsp">Login</a>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <h4 class="page-head-line">Sign Up</h4>
                    </div>
                </div>

                <div class="col-md-10 col-md-offset-1">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            SignUp Form
                        </div>
                        <div class="panel-body">
                            <form name="form-create" action="addUser.action">
                                <div class="form-group">
                                    <label for="userlogin">Login</label>
                                    <input type="input" class="form-control" id="login" name="bean.login" placeholder="Enter Login" />
                                </div>
                                <div class="form-group">
                                    <label for="userpassword">Password</label>
                                    <input type="password" class="form-control" id="password" name="bean.password" placeholder="Enter Password" />
                                </div>
                                <div class="form-group">
                                    <label for="useraddress">UserAddress</label>
                                    <input type="text" class="form-control" id="address" name="beanui.userAddress" placeholder="Enter User Address" />
                                </div>
                                <div class="form-group">
                                    <label for="userbirthdate">UserBirthDate</label>
                                    <input type="text" class="form-control" id="birthDate" name="beanui.userBirthDate" placeholder="Enter User BirthDate" />
                                </div>
                                <div class="form-group">
                                    <label for="userEmail">UserEmail</label>
                                    <input type="text" class="form-control" id="useremail" name="beanui.userEmail" placeholder="Enter User Email" />
                                </div>
                                <div class="form-group">
                                    <label for="userFirstName">UserFirstName</label>
                                    <input type="text" class="form-control" id="FirstName" name="beanui.userFirstName" placeholder="Enter User First Name" />
                                </div>
                                <div class="form-group">
                                    <label for="userLastName">UserLastName</label>
                                    <input type="text" class="form-control" id="LastName" name="beanui.userLastName" placeholder="Enter User Last Name" />
                                </div>
                                <div class="form-group">
                                    <label for="profileName">ProfileName</label>
                                    <input type="text" class="form-control" id="profilename" name="beanp.profileName" placeholder="Enter Profile Name" />
                                </div>
                 
                                
                                <button type="submit" class="btn btn-default">Submit</button>
                            </form>
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
