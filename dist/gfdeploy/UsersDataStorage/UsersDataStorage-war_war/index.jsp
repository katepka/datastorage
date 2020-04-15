<%-- 
    Document   : index
    Created on : 09.04.2020, 21:05:30
    Author     : mi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data Storage System</title>
    </head>
    <body bgcolor="DAD5D3">
        <h3>Please, put your data:</h3>
        
        <form action="Registrator" method="POST">
        <table border="0" width="50%">
            <tr>
                <td width="70%" height="50px" align="center">
                    <strong>Parameter name</strong>
                </td>
                <td align="center">
                    <strong>Parameter value (integer)</strong>
                </td>
            </tr>
            <tr>
                <td width="70%" height="50px" align="center">
                    <input type="text" name="name" value="" size="100%" />
                </td>
                <td align="center">
                    <input type="text" name="value" value="" size="100%" />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" name="save" />
                </td>
            </tr>
        </table>
        </form>
        
    </body>
</html>
