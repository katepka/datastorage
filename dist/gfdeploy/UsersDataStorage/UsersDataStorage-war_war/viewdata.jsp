<%-- 
    Document   : viewdata
    Created on : 09.04.2020, 22:29:58
    Author     : mi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Data</title>
    </head>
    <body bgcolor="DAD5D3">
        <h4>View data from the storage: </h4>
        <table border="0" width="50%">
            <form action="ViewList" method="GET">
                <tr>
                    <td height="50px" width="35%">
                        <input type="radio" name="searchType" value="byname" />
                        Seach by parameter name
                    </td>
                    <td>
                        <input type="radio" name="searchType" value="byval" />
                        Seach values in an interval
                    </td>
                    <td>
                        <input type="radio" name="searchType" value="all" checked="checked" />
                        All parameters
                    </td>
                </tr>
                <tr>
                    <td  height="100px">
                        Input name's template for searching:<br><br>
                        <input type="text" name="nameTemplate" value=""/>
                    </td>
                    <td> 
                        Set an interval for values:<br><br>
                        from  
                        <input type="text" name="lowerBound" value=""/>  
                        to    
                        <input type="text" name="upperBound" value=""/>
                    </td>
                    <td align="right">
                        <input type="submit" value="Search!" name="search" />
                    
                    </td>
                </tr>
                <tr>
                    <td colspan="3" height="70px">
                        <form action="ViewList" method="GET">
                            <hr>
                            <strong>Add a new parameter: </strong>
                            <input type="submit" value="Input data" name="input" />

                        </form>
                    </td>

                </tr>
            </form>
            
        </table>

    </body>
</html>
