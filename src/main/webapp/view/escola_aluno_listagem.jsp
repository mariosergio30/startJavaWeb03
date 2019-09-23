<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<head>

<link rel="stylesheet" type="text/css" href="../../css/styles.css">
<link rel="stylesheet" type="text/css" href="../../css/exemplo_table.css">
<script charset="UTF-8" src="../../js/aprendendo.js"></script>
<title>Aprendendo Java WEB MVC</title>

</head>


<body>

<h2>Relatório de Alunos</h2>

<table>
  <tr>
    <th>Matricula</th>
    <th>Nome</th>
    <th>Sexo</th>
    <th>Idade</th>
    <th>Escolaridade</th>
  </tr>
  <c:forEach var="aluno" items="${listaAlunos}" >  <!-- atributo Lista de Objetos -->
  <tr>
     <td> <a href="consulta?matricula=${aluno.matricula}">${aluno.matricula}</a></td>
     <td> <c:out value="${aluno.nome}"/> </td>
     <td>${aluno.sexo}</td>
     <td>${aluno.idade}</td>
     <td>${aluno.escolaridade}</td>
  </tr>     
  </c:forEach>


</table>

</body>

</html>