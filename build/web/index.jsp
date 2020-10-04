<%-- 
    Document   : index
    Created on : 04/10/2020, 08:52:33
    Author     : Victor
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="avaliacao.Disciplina"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Disciplina> disciplina = (ArrayList) application.getAttribute("disciplina");
    if(disciplina == null){
        disciplina = new ArrayList<>();
        disciplina.add(new Disciplina("Banco de Dados","Conceitos de Base de Dados. Modelos conceituais de informações.",4));
        disciplina.add(new Disciplina("Engenharia de Software III","Conceitos, evolução e importância de arquitetura de software.",4));
        disciplina.add(new Disciplina("Programação Orientada a Objetos","Conceitos e evolução da tecnologia de orientação a objetos.",4));
        disciplina.add(new Disciplina("Linguagem de Programação IV","Comandos de linguagens usadas na construção e estruturação de sites.",4));
        disciplina.add(new Disciplina("Sistemas Operacionais II","Apresentação de um sistema operacional específico utilizado em ambiente corporativo.",4));
        disciplina.add(new Disciplina("Inglês IV","Consolidação da compreensão e produção oral e escrita por meio da integração.",4));
        disciplina.add(new Disciplina("Metodologia da Pesquisa Científico-Tecnológica","O Papel da ciência e da tecnologia. Tipos de conhecimento. Método e técnica.",4));
        application.setAttribute("disciplina", disciplina);
    }
%>
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
        <p>Quantidade de disciplinas: <%= Disciplina.getList(disciplina).size() %></p>
    </body>
</html>
