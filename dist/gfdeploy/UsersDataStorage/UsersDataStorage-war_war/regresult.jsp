<%-- 
    Document   : registrator
    Created on : 09.04.2020, 21:52:04
    Author     : mi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Save data</title>
    </head>
    <body bgcolor="DAD5D3">
        <div>
            <% String message = (String) request.getAttribute("message");
            if (message != null) {
                out.println(message);
            }
            %>
        </div>
        <br>
        <div>
            <form action="ViewList" method="GET">
                <input type="submit" value="View Data" name="view" />
            </form>
        </div>
    </body>
</html>
