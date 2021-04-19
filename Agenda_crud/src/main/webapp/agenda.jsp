<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="Model.JavaBeans"%>
<%@page import="java.util.ArrayList"%>

<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Agenda de Contatos</title>
<link rel="stylesheet" href="estilo.css">
</head>
<body>
	<h1>Agenda de Contatos</h1>
	 
	<table id="ttabela">
		<thead>
			<tr>
				<th>id</th>
				<th>Nome</th>
				<th>Fone</th>
				<th>E-mail</th>
				<th>Editar</th>
		</thead>
		<tbody>
			<%for (int i = 0; i < lista.size(); i++) {%>
			<tr>
				<td><%=lista.get(i).getIdcon()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getFone()%></td>
				<td><%=lista.get(i).getEmail()%></td>
				<td><a href="select?idcon=<%=lista.get(i).getIdcon() %>"
					class="Botao1">Editar</a>
					<a href="javascript: confirmar(<%=lista.get(i).getIdcon() %>)" class="Botao2">Excluir</a>
					</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<a href="cadastro.html" class="Botao1">Novo Contato</a>
	<script src="validador_js/confirmar.js"></script>
</body>
</html>