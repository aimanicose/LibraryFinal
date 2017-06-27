<%@page import="Models.Book"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/bootstrap.min.css" >
<link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/font-awesome.css" >
<link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/vues/css/style.css" >
<script src="<%=application.getContextPath() %>/vues/js/jquery-3.2.1.min.js"></script>
<script src="<%=application.getContextPath() %>/vues/js/bootstrap.min.js"></script>
<script src="<%=application.getContextPath() %>/vues/js/bookDetailsScript.js"></script>
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
    Book detailedBook = (Book)session.getAttribute("detailedBook");
%>
<form name="form-update" action="updateBook.action">
    <div class="modal-header defaultColor">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title"><strong><%=detailedBook.getBookName()%></strong></h4>
    </div>

    <div class="modal-body">

        <div class="col-md-4"> 
            <img src="<%=application.getContextPath() %>/vues/img/bookCovers/<%=detailedBook.getBookImageId()%>.png" alt="Book Cover" class="img-thumbnail">
            <div id="editBookButtons" class="">
                <a id="updateBook" onclick="updateBook()" class="btn btn-block btn-success"><span class="glyphicon glyphicon-edit"></span> Edit Book</a>
                <a id="deleteBook" onclick="deleteBook(<%=detailedBook.getBookID()%>)" class="btn btn-block btn-danger"><span class="glyphicon glyphicon-trash"></span> Delete Book</a>
            </div>
        </div>

        <table class="pull-right col-md-8" style="font-size: 15px">
            <tbody>
                <tr>
                    <td class="col-md-3"><strong>Author :</strong></td>
                    <td id="firstName" class="col-md-9"><%=detailedBook.getBookAuthor().getAuthorFirstName() + " " + detailedBook.getBookAuthor().getAuthorLastName()%></td>
                </tr>
                <tr>
                    <td class="col-md-3"><strong>Editor :</strong></td>
                    <td id="editor" class="col-md-9"><%=detailedBook.getBookEditor().getEditorName()%></td>
                </tr>
                <tr>
                    <td class="col-md-3"><strong>Genre :</strong></td>
                    <td id="genre" class="col-md-9"><%=detailedBook.getBookGenre().getGenreName()%></td>
                </tr>
                <tr>
                    <td class="col-md-3"><strong>Language :</strong></td>
                    <td id="language" class="col-md-9"><%=detailedBook.getBookLanguage()%></td>
                </tr>
                <tr>
                    <td class="col-md-3"><strong>Publication :</strong></td>
                    <td id="date" class="col-md-9"><%=detailedBook.getBookPublicationDate()%></td>
                </tr>
                <tr>
                    <td class="col-md-3"><strong>Price :</strong></td>
                    <td id="price" class="col-md-9"><%=detailedBook.getBookPrice()%> MAD</td>
                </tr>
                <tr>
                    <td class="col-md-3"><strong>Reference :</strong></td>
                    <td id="reference" class="col-md-9"><%=detailedBook.getBookReferance()%></td>
                </tr>
                <tr>
                    <td class="col-md-3"><strong>Summary :</strong></td>
                    <td id="summary" class="col-md-9"><%=detailedBook.getBookSummary()%></td>
                </tr>
            </tbody>
        </table>


        <div class="clearfix"></div>

        <p class="open_info hide">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.</p>
    </div>

    <div class="modal-footer defaultColor">
        <div id="closeButton" class="">
            <button id="closeModalButton" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
        <div id="validateBookButtons" class="hide">
            <button type="submit" class="btn btn-primary btn-success"><span class="glyphicon glyphicon-ok"></span> Validate</button>
            <a class="btn btn-primary btn-danger" onclick="cancelUpdate()"><span class="glyphicon glyphicon-remove"></span> Cancel</a>
        </div>
    </div>
</form>
<%
%>

