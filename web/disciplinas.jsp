<%-- 
    Document   : disciplinas
    Created on : 04/10/2020, 09:23:13
    Author     : Victo
--%>

<%@page import="avaliacao.Disciplina"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Exception err = null;
    
    try{
        
        if(request.getParameter("alt")!= null){
            int index = Integer.parseInt(request.getParameter("index"));
            int nota = Integer.parseInt(request.getParameter("nota"));
            
            if(nota >= 0 && nota <= 10){
                Disciplina.update(nota, index);
                response.sendRedirect(request.getRequestURI());
            } else {
                out.println("<script>alert('Digite uma nota entre 0 e 10')</script>");
            }
        }
        if(request.getParameter("insert")!= null){
            String nome = request.getParameter("nome");
            String ementa = request.getParameter("ementa");
            int ciclo = Integer.parseInt(request.getParameter("ciclo"));
            
            Disciplina.insert(nome, ementa, ciclo);
            response.sendRedirect(request.getRequestURI());
        }
        if(request.getParameter("delete")!= null){
            int index = Integer.parseInt(request.getParameter("index"));
            
            Disciplina.delete(index);
            response.sendRedirect(request.getRequestURI());
            
        }
    } catch(Exception ex){
        err = ex;
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
        <form>
            <input type="text" placeholder="Nome da disciplina" name="nome">
            <input type="text" placeholder="Ementa" name="ementa">
            <input type="text" placeholder="Ciclo" name="ciclo">
            <input type="submit" name="insert" value="Inserir">
        </form>
        <table border="1">
            <tr>
                <th>Nome</th>
                <th>Ementa</th>
                <th>Ciclo</th>
                <th>Nota</th>
                <th>Definir nota</th>
                <th>Excluir</th>
            </tr>
            <%for(int i=0; i<Disciplina.getList().size(); i++){%>
                <% Disciplina disciplina = Disciplina.getList().get(i); %>
                <tr>
                    <td><%= disciplina.getNome() %></td>
                    <td><%= disciplina.getEmenta() %></td>
                    <td><%= disciplina.getCiclo()%></td>
                    <td><%= disciplina.getNota() %></td>
                    <td>
                        <form>
                            <input type="number" name="nota" min="0" max="10" />
                            <input type="submit" name="alt" value="Alterar"/>
                            <input type="hidden" name="index" value="<%= disciplina.getId() %>"/>
                        </form>
                    </td>
                    <td>
                        <form>
                            <input type="submit" name="delete" value="Deletar"/>
                            <input type="hidden" name="index" value="<%= disciplina.getId() %>"/>
                        </form>
                    </td>
                </tr>
            <%}%>
        </table>
    </body>
</html>
