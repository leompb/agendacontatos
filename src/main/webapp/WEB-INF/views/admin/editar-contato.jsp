<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>

<meta charset="ISO-8859-1">

<title>Editar Contato</title>

<!-- link para os arquivos de extens�o .CSS -->
<link rel="stylesheet" href="../resources/css/bootstrap.min.css"
	type="text/css" />
	
<!-- estilos para a valida��o -->
<style>
	label.error { color: #d9534f; }
	input.error { border: 2px solid #d9534f; }
</style>

</head>
<body>

	<!-- barra de menu superior do sistema -->
	<jsp:include page="/WEB-INF/views/components/navbar.jsp"></jsp:include>

	<div class="container mt-4">

		<h3>Edi��o de Contato</h3>
		<p>Utilize os campos para alterar os dados do contato.</p>
		<hr />
		
		<form id="form_contato" action="executar-edicao-contato" method="post">
		
			<!-- campo oculto -->
			<input type="hidden" name="idcontato" value="${contato.idContato}"/>
		
			<div class="row mb-3">
				<div class="col-md-6">
					<label>Nome do Contato:</label>
					<input type="text" name="nome" class="form-control" value="${contato.nome}"/>
				</div>
				<div class="col-md-3">
					<label>Endere�o de email:</label>
					<input type="text" name="email" class="form-control" value="${contato.email}"/>
				</div>
				<div class="col-md-3">
					<label>Telefone:</label>
					<input type="text" name="telefone" id="telefone" class="form-control" value="${contato.telefone}"/>
				</div>
			</div>
			
			<div class="row mb-3">
				<div class="col-md-12">
					<input type="submit" value="Salvar altera��es" class="btn btn-primary"/>
					<a href="/projetoweb01/admin/consultar-contato" class="btn btn-secondary">
						Voltar para a consulta
					</a>
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

	<!-- link para os arquivos de extens�o JS -->
	<script src="../resources/js/bootstrap.bundle.min.js"
		type="text/javascript"></script>
		
	<script src="../resources/js/jquery-3.6.1.min.js" type="text/javascript"></script>
	<script src="../resources/js/jquery.validate.min.js" type="text/javascript"></script>
	<script src="../resources/js/additional-methods.min.js" type="text/javascript"></script>
	<script src="../resources/js/messages_pt_BR.min.js" type="text/javascript"></script>
	<script src="../resources/js/jquery.maskedinput.min.js" type="text/javascript"></script>
		
	<script>
		
		//fun��o para inicializa��o do JQuery
		$(document).ready(function() {
				
			//configurando a valida��o do formul�rio
			$("#form_contato").validate({
				rules: {
					"nome" : { required: true, minlength: 8, maxlength: 150 },
					"email" : { required: true, email : true },
					"telefone" : { required: true }
				}
			});
			
			//configurando as m�scaras dos campos
			$("#telefone").mask("(99) 99999-9999");
			
		});
		
	</script>

</body>
</html>


