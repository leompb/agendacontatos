<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>

<meta charset="UTF-8">

<title>Acessar Conta</title>

<!-- link para os arquivos de extensão .CSS -->
<link rel="stylesheet" href="../resources/css/bootstrap.min.css"
	type="text/css" />

</head>
<body>

	<!-- Barra de menu superior do sistema -->
	<jsp:include page="/WEB-INF/views/components/navbar.jsp"></jsp:include>

	<div class="container mt-4">
	
		<h3>Seja bem vindo a agenda de contatos</h3>
		<hr />
		
		<!-- 
		<p>
			Nome do usuário: <strong>${usuario_auth.nome}</strong>
		</p>
		
		<p>
			Email de acesso: <strong>${usuario_auth.email}</strong>
		</p>
		-->
	</div>

	<!-- link para os arquivos de extensão JS -->
	<script src="../resources/js/bootstrap.bundle.min.js"
		type="text/javascript"></script>

</body>
</html>


