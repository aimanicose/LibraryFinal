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
        <title>The Online Library</title>
        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/bootstrap.css" >
        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/font-awesome.css" >
        <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/style.css" >
        <script src="<%=application.getContextPath() %>/vues/js/jquery-1.11.1.js"></script>
        <script src="<%=application.getContextPath() %>/vues/js/bootstrap.js"></script>
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
        <!-- LOGO HEADER END-->
            
        <!-- MENU SECTION END-->
        <div class="content-wrapper">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h4 class="page-head-line">Please Login To Enter </h4>
                            
                    </div>
                        
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <form name="form-login" action="vues/authentication.action" method="post">
                            <hr />
                            <h4>Login with <strong>your Library Account  :</strong></h4>
                            <br />
                            <label>Enter Email ID : </label>
                            <input required name="bean.login" key="user.login" type="text" Class="form-control" oninvalid="this.setCustomValidity('Please enter your username')" oninput="setCustomValidity('')"/>
                            <label>Enter Password :  </label>
                            <input required name="bean.password" key="user.password" type="password" Class="form-control" oninvalid="this.setCustomValidity('Please enter your password')" oninput="setCustomValidity('')"/>
                            <hr />
                            <button type="submit" class="btn btn-info">
                                <span class="glyphicon glyphicon-user"></span> Log Me In
                            </button>
                        </form>
                    </div>
                    <div class="col-md-6">
                        <br />  <br />  <br />
                        <div class="row">
                            <div class="col-md-offset-1">
                                <h4>If you want to<strong> Subscribe </strong> please click on the button below</h4>
                            </div>
                        </div>
                            
                        <div class="row">
                            <div class="col-md-2 col-md-offset-5">
                                <a href="<%=application.getContextPath() %>/vues/signup.jsp"><i class="fa fa-user-plus login-icon" style="background-color: #ca1827"></i></a>
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