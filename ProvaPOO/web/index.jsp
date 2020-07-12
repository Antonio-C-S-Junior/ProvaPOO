<%-- 
    Document   : index
    Created on : 10/07/2020, 08:17:11
    Author     : 56235
--%>

<%@page import="db.Disciplina"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prova POO - Disciplinas</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <h1>Disciplinas</h1>
        <h4>Clique para mais detalhes de cada disciplina</h4>
        <ul >    
            <% for(int i = 1; i <= 7;i++){%>
            <li ><a href="DetalhesDisciplina.jsp?id=<%=i%>" ><%= db.Disciplina.getSg(i) + " - " + db.Disciplina.getNm(i)%></a></li>
            <%}%>
        </ul>
    </body>
</html>
