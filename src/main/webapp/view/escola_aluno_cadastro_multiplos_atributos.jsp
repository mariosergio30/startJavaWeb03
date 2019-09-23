<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<head>

<link rel="stylesheet" type="text/css" href="../css/styles.css">
<script charset="UTF-8" src="../js/aprendendo.js"></script>
<title>Cadastro do Aluno</title>

</head>

<body>


<h1>Dados do Aluno</h1>


<form action="alunosalvarTESTE" method="post">
  
  Nome:<br>
  <input type="text" name="nome" value="${aluno.nome}" />
  <br><br>
  
  Matrícula:<br>
  <input type="text" name="matricula" value="${aluno.matricula}" /><br><br> 
  
  CPF:<br>
  <input type="text" name="cpf" value="${aluno.cpf}" /><br><br>
     
  Idade:<br>
  <input type="number" name="idade" value="${aluno.idade}" /><br><br>
  
  Sexo:<br>    
  <input type="radio" name="sexo" value="M" checked />Masculino<br>
  <input type="radio" name="sexo" value="F" />Feminino  
    
  <br><br>
  
  Escolaridade:<br>
  <select name="escolaridade">
    <option value="FUNDAMENTAL">Fundamental</option>
    <option value="MEDIO">Médio</option>
    <option value="SUPERIOR">Superior</option>    
  </select>
  
  <br><br>
  
  <input type="checkbox" name="receber_email" value="S" checked>Deseja receber boletim por email ?</input>
  
  <br><br>
  <input type="submit" value="Confirmar">
  
</form> 


<br><button type="button" onclick="exibirMsg()">Exemplo Java Script</button>
</div>



</body>

</html>