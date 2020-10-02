<%-- 
    Document   : editnote
    Created on : Oct 2, 2020, 1:15:56 PM
    Author     : 843827
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>edit Page</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1><br>
        <h2>Edit Note</h2>
        
        <form method ="post" action="note">
            <label for="title">Title:</label>
            <input id="title" type="text" name="title" value="" placeholder="This is the title:">
            <br>
            <label for="text">Contents:</label>
            <textarea id="text" rows="8" cols="20" name="content"  value="" placeholder="contents goes here:"></textarea><br>
            <input type="submit" value="save">
        </form>
        
    </body>
</html>
