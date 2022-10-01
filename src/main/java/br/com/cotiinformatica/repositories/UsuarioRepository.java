package br.com.cotiinformatica.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.factories.ConnectionFactory;

public class UsuarioRepository {

	// método para inserir um usuário no banco de dados:
	public void create(Usuario usuario) throws Exception {

		Connection connection = ConnectionFactory.createConnection();

		PreparedStatement statement = connection
				.prepareStatement("INSERT INTO USUARIO(NOME, EMAIL,SENHA) VALUES(?,?,md5(?))");
		statement.setString(1, usuario.getNome());
		statement.setString(2, usuario.getEmail());
		statement.setString(3, usuario.getSenha());
		statement.execute();

		connection.close();
	}

	public void update(Integer idUsuario, String novaSenha) throws Exception {

		Connection connection = ConnectionFactory.createConnection();

		PreparedStatement statement = connection
				.prepareStatement("UPDATE USUARIO SET SENHA = MD5(?) WHERE IDUSUARIO = ?");

		statement.setString(1, novaSenha);
		statement.setInt(2, idUsuario);
		statement.execute();

		connection.close();
	}

	public Usuario findByEmail(String email) throws Exception {

		Connection connection = ConnectionFactory.createConnection();

		PreparedStatement statement = connection.prepareStatement("SELECT * FROM USUARIO WHERE EMAIL = ?");

		statement.setString(1, email);
		ResultSet resultSet = statement.executeQuery();

		Usuario usuario = null;

		if (resultSet.next()) {

			usuario = new Usuario();

			usuario.setIdUsuario(resultSet.getInt("IDUSUARIO"));
			usuario.setNome(resultSet.getString("NOME"));
			usuario.setEmail(resultSet.getString("EMAIL"));
			usuario.setSenha(resultSet.getString("SENHA"));

		}

		connection.close();
		return usuario;
	}

	public Usuario findByEmailAndSenha(String email, String senha) throws Exception {

		Connection connection = ConnectionFactory.createConnection();

		PreparedStatement statement = connection
				.prepareStatement("SELECT * FROM USUARIO WHERE EMAIL = ? AND SENHA = md5(?)");

		statement.setString(1, email);
		statement.setString(2, senha);
		ResultSet resultSet = statement.executeQuery();

		Usuario usuario = null;

		if (resultSet.next()) {

			usuario = new Usuario();

			usuario.setIdUsuario(resultSet.getInt("IDUSUARIO"));
			usuario.setNome(resultSet.getString("NOME"));
			usuario.setEmail(resultSet.getString("EMAIL"));
			usuario.setSenha(resultSet.getString("SENHA"));

		}

		connection.close();
		return usuario;
	}

}
