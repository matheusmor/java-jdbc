package faeterj.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Aluno;


public class TestaBanco {
	



	public static  Object[][] getall() throws SQLException {
		Connection conexao = Connectiondb.createConnection();
		

		String sql =("SELECT * FROM \"public\".\"aluno\";");
		PreparedStatement  ps = conexao.prepareStatement(sql);
		ps.execute();
		
		ResultSet resultado = ps.getResultSet();
		ResultSetMetaData metaData = resultado.getMetaData();
		int numberOfColumns = metaData.getColumnCount();
		
		ArrayList<Aluno> aluno = new ArrayList<>();
		
		while(resultado.next()) {
		//for (int i=0;i<numberOfColumns;i++) {
			
				Aluno aluno1= new Aluno(resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getString(5));
				 
					
				
				System.out.println(aluno1);
				aluno.add(new Aluno(aluno1.getNome(),aluno1.getMatricula(),aluno1.getEmail(),aluno1.getTelefone()));
				
				System.out.println(aluno);
				
			//}
		}
		
		Object[][] objeto = new Object[aluno.size()][numberOfColumns];
		for(int i=0;i<aluno.size();i++) {
			for(int j=0;j<numberOfColumns-1;j++) {
				objeto[i][0]=aluno.get(i).getMatricula();
				objeto[i][1]=aluno.get(i).getNome();
				objeto[i][2]=aluno.get(i).getEmail();
				objeto[i][3]=aluno.get(i).getTelefone();
			}
		
		}
		System.out.println(objeto[1][1]+" "+objeto[0][1]+" "+objeto[2][1]+" "+objeto[3][1]);
		
		
		
		
		return  objeto;}
	
	
	public void getMatricula() throws SQLException {
		String sql =("SELECT \"matricula\" FROM \"public\".\"aluno\";");
		Connection conexao= Connectiondb.createConnection();
		PreparedStatement  ps = conexao.prepareStatement(sql);
		ps.execute();
		
		ResultSet resultado = ps.getResultSet();

		while(resultado.next()) {
			
		
	}
	}

	
	
		
	

}
