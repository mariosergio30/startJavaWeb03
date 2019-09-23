<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>

<head>

<link rel="stylesheet" type="text/css" href="../../css/styles.css">
<script charset="UTF-8" src="../../js/aprendendo.js"></script>
<title>Cadastro do Aluno</title>

</head>

<body>

<h1>Dados do Aluno</h1>

<div>
<sform:form action="../aluno/salvar" modelAttribute="aluno" method="post">
  

  <b>Nome:</b><br>
  <sform:input path="nome" value="${aluno.nome}" />
  <br><br>
  
  <b>Matrícula:</b><br>
  <sform:input path="matricula" value="${aluno.matricula}" /><br><br> 
  
  <b>CPF:</b><br>
  <sform:input path="cpf" value="${aluno.cpf}" /><br><br>
     
  <b>Idade:</b><br>
  <sform:input path="idade" value="${aluno.idade}" /><br><br>
 
  <b>Sexo:</b><br>    
  <sform:radiobutton path="sexo" value="M" checked="true" />Masculino<br>
  <sform:radiobutton  path="sexo" value="F" />Feminino  
    
  <br><br>
  
  <b>Escolaridade:</b><br>
  <sform:select path="escolaridade">
    <option value="FUNDAMENTAL">Fundamental</option>
    <option value="MEDIO">Médio</option>
    <option value="SUPERIOR">Superior</option>    
  </sform:select>
  
  <br><br>
  <input type="submit" value="Confirmar">
  
</sform:form> 

</div>



</body>

</html>