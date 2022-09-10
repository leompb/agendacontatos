package br.com.cotiinformatica.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	// atributos:
	private final static String HOST = "jdbc:postgresql://localhost:5433/";
	private final static String USER = "postgres";
	private final static String PASS = "coti";
	private final static String DRIVER = "org.postgresql.Driver";

	// método para abrir e retornar uma conexão com o PostGreSQL:
	public static Connection createConnection() throws Exception {

		Class.forName(DRIVER);
		return DriverManager.getConnection(HOST, USER, PASS);
	}
}
