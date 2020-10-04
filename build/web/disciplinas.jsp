<%-- 
    Document   : disciplinas
    Created on : 04/10/2020, 09:23:13
    Author     : Victo
--%>

<%@page import="avaliacao.Disciplina"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
    ArrayList<Disciplina> lstDisciplinas = Disciplina.getList((ArrayList)application.getAttribute("disciplina"));
    
    if(request.getParameter("alt")!= null){
        int index = Integer.parseInt(request.getParameter("index"));
        double nota = Double.parseDouble(request.getParameter("nota"));
        if(nota >= 0 && nota <= 10){
            lstDisciplinas.get(index).setNota(nota);
            response.sendRedirect(request.getRequestURI());
        } else {
            out.println("<script>alert('Digite uma nota entre 0 e 10')</script>");
        }
    }
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Minhas Disciplinas</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/menu.jspf" %>
        <h1>Minhas Disciplinas</h1>
        <table border="1">
            <tr>
                <th>Nome</th>
                <th>Ementa</th>
                <th>Nota</th>
                <th>(Re)definir nota</th>
            </tr>
            <%for(int i=0; i<lstDisciplinas.size(); i++){%>
                <% Disciplina disciplina = lstDisciplinas.get(i); %>
                <tr>
                    <td><%= disciplina.getNome() %></td>
                    <td><%= disciplina.getEmenta() %></td>
                    <td><%= disciplina.getNota() %></td>
                    <td>
                        <form>
                            <input type="text" name="nota" />
                            <input type="submit" name="alt" value="Alterar"/>
                            <input type="hidden" name="index" value="<%= i %>"/>
                        </form>
                    </td>
                </tr>
            <%}%>
        </table>
    </body>
</html>
