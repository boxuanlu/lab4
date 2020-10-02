<%-- 
    Document   : viewnote
    Created on : Oct 2, 2020, 1:15:42 PM
    Author     : 843827
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>view Page</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1><br>
        <h2>View Note</h2>
        <p>Title: ${note.getTitle()}</p><br>
        <p>Contents: ${note.getContent()}</p><br>
        <a href="note?edit">Edit</a> 
    </body>
</html>
