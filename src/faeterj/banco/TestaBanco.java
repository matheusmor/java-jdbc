package faeterj.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestaBanco {

	public static void main(String[] args) throws SQLException {
		Connection conexao =Connectiondb.createConnection();

		String sql =("SELECT * FROM \"public\".\"aluno\";");
		PreparedStatement  ps = conexao.prepareStatement(sql);
		ps.execute();
		
		ResultSet resultado = ps.getResultSet();

		while(resultado.next()) {
			System.out.println("aluno id: "+resultado.getInt(1)+" "+resultado.getString(2));
		}
	
	}

	public static Connection createConnection() throws SQLException {
		String url ="jdbc:postgresql://134.209.243.185:5432/grupob";
		String user ="grupob";
		String password ="grupob";
		Connection conexao = null;
		conexao=DriverManager.getConnection(url,user,password);
		return conexao;
	}

}
