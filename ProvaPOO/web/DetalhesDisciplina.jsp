<%-- 
    Document   : DetalhesDisciplina
    Created on : 10/07/2020, 22:03:28
    Author     : yBlackSpider
--%>

<%@page import="db.Disciplina"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String error = null;
    int id = -1;
    int nota = 0;
    try {
        id = Integer.parseInt(request.getParameter("id"));
        if (id != -1) {
        String sigla = request.getParameter("sgCurso");
        String nome = request.getParameter("nmCurso");
        String dia = request.getParameter("ddSemana");
        String qtAulas = request.getParameter("qtAulas");
        String hora = request.getParameter("hrAulas");
        nota = Integer.parseInt(request.getParameter("vlNotaCurso"));
        if (sigla.isEmpty()) error = "Sigla não pode ser nulo!";
        else if (nome.isEmpty()) error = "Nome da disciplina não pode ser nulo!";
        else if (dia.isEmpty()) error = "Dia da semana não pode ser nulo!";
        else if (qtAulas.isEmpty()) error = "Quatidade de aulas não pode ser nulo!";
        else if (hora.isEmpty()) error = "Horário da aula não pode ser nulo!";
        else if (nota<0 && nota>10) error = "Nota final não pode ser menor que 0 nem maior que 10!";
        else if(1 == 1)  {
            Disciplina.UpdateNota(id, nota);
            response.sendRedirect("index.jsp");
                    }
        }
    } catch (Exception ex) {

      error = "Índice invalido";
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prova POO - Detalhes</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/header.jspf" %>
        <h2>Detalhes da Disciplina</h2>
        <form method="post">
            
            Sigla:<br/>
            <input type="text" name="sgCurso" value="<%=Disciplina.getSg(id)%>" /><br/>
            Nome:<br/>
            <input type="text" name="nmCurso" value="<%=Disciplina.getNm(id)%>" /><br/>
            Dia da Semana:<br/>
            <input type="text" name="ddSemana" value="<%=Disciplina.getDdSemana(id)%>" /><br/>
            Quantidade de Aulas:<br/>
            <input type="num" name="qtAulas" value="<%=Disciplina.getQtAulas(id)%>" /><br/>
            Horário:<br/>
            <input type="text" name="hrAulas" value="<%=Disciplina.getHrAulas(id)%>" /><br/>
            Nota Final:<br/>
            <input type="num" name="vlNotaCurso" value="<%=Disciplina.getVlNota(id)%> "/><br/>
            <br/><br/>
            <input type="button" name="cancel" value="Cancelar" onclick="history.go(-1)"/>
            <input type="submit" name="setNota" value="Alterar Nota" />
        </form>
    </body>
</html>
