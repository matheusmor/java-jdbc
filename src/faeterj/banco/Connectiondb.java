package faeterj.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectiondb {
	private static Connection conexao;
	
	public static Connection createConnection() throws SQLException {
		if(conexao ==null) {
		String url ="jdbc:postgresql://134.209.243.185:5432/grupob";
		String user ="grupob";
		String password ="grupob";
		conexao=DriverManager.getConnection(url,user,password);
		}
		return conexao;
	}

}
