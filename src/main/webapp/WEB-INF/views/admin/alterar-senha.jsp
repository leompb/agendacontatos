<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>

<meta charset="ISO-8859-1">

<title>Alterar Senha</title>

<!-- link para os arquivos de extensão .CSS -->
<link rel="stylesheet" href="../resources/css/bootstrap.min.css"
	type="text/css" />

<!-- estilos para a validação -->
<style>
label.error {
	color: #d9534f;
}

input.error {
	border: 2px solid #d9534f;
}
</style>

</head>
<body>

	<!-- barra de menu superior do sistema -->
	<jsp:include page="/WEB-INF/views/components/navbar.jsp"></jsp:include>

	<div class="container mt-4">

		<h3>Alterar Senha</h3>
		<p>Preencha os campos para modificar sua senha de acesso.</p>
		<hr />

		<form id="form_senha" action="atualizar-senha" method="post">

			<div class="row mb-3">
				<div class="col-md-4">
					<label>Informe a nova senha:</label> <input type="password"
						name="novasenha" id="novasenha" class="form-control" />
				</div>
				<div class="col-md-4">
					<label>Confirme a nova senha:</label> <input type="password"
						name="novasenhaconfirmacao" class="form-control" />
				</div>
			</div>

			<div class="row mb-3">
				<div class="col-md-12">
					<input type="submit" value="Salvar nova senha"
						class="btn btn-primary" />
				</div>
			</div>

		</form>

		<div class="text-success">
			<strong>${mensagem_sucesso}</strong>
		</div>

		<div class="text-danger">
			<strong>${mensagem_erro}</strong>
		</div>

	</div>

	<!-- link para os arquivos de extensão JS -->
	<script src="../resources/js/bootstrap.bundle.min.js"
		type="text/javascript"></script>

	<script src="../resources/js/jquery-3.6.1.min.js"
		type="text/javascript"></script>
	<script src="../resources/js/jquery.validate.min.js"
		type="text/javascript"></script>
	<script src="../resources/js/additional-methods.min.js"
		type="text/javascript"></script>
	<script src="../resources/js/messages_pt_BR.min.js"
		type="text/javascript"></script>

	<script>
		//função para inicialização do JQuery
		$(document).ready(function() {

			//configurando a validação do formulário
			$("#form_senha").validate({
				rules : {
					"novasenha" : {
						required : true,
						minlength : 8,
						maxlength : 20
					},
					"novasenhaconfirmacao" : {
						required : true,
						equalTo : "#novasenha"
					},
				}
			});
		});
	</script>

</body>
</html>


