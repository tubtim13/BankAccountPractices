<%-- 
    Document   : MyAccount
    Created on : 31-Oct-2018, 21:18:36
    Author     : Asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Account</title>
    </head>
    <body>
        <h1>My Account!</h1>
        <h3>
            Account Name : ${account.name} <br>
            Balance : ${account.balance}
        </h3>
        <h3>
            <a href="DepositServlet">Deposit</a>
        </h3>
         <h3>
            <a href="LogoutServlet">Logout</a>
        </h3>
    </body>
</html>
