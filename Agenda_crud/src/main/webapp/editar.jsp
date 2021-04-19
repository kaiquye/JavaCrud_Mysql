<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
</head>
<body>
<h1>Editar Contato</h1>
<link rel="stylesheet" href="estilo.css">
<form name="frmContato" action="uptade">

		<table>
		<tr>
				<td><input type="text" name="id" class="Caixa3"  readonly value="<% out.print(request.getAttribute("idcon")); %>">
			<tr>
			<tr>
				<td><input type="text" name="nome" class="Caixa1" value="<% out.print(request.getAttribute("nome")); %>">
			<tr>
			<tr>
				<td><input type="text" name="fone" class="Caixa1" value="<% out.print(request.getAttribute("fone")); %>">
			<tr>
			<tr>
				<td><input type="text" name="email" class="Caixa1" value="<% out.print(request.getAttribute("email")); %>">
			<tr>
		</table>
		<input type="button" value="Editar" class="Botao1" class="Caixa1"
			onclick="validar()">

	</form>
	<script src="validador_js/validador.js"></script>
</body>
</html>