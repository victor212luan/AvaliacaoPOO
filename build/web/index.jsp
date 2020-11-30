<%-- 
    Document   : index
    Created on : 04/10/2020, 08:52:33
    Author     : Victor
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="avaliacao.Disciplina"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/menu.jspf" %>
        <h1>Página Inicial</h1>
        <p>Nome: Victor Luã Lorena de Menezes</p>
        <p>RA: 1290481913035</p>
        <p>Quantidade de disciplinas: <%= Disciplina.getList().size() %></p>
    </body>
</html>
