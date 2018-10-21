package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexaoBD.ConnetionFactory;
import modelBean.Faixa;

public class FaixaDAO {
	private Connection con = null;
	
	public boolean insertFaixaDAO(Faixa faixa) {
		con=ConnetionFactory.getConnection();
		
		PreparedStatement stmt = null;
		
		String sql="INSERT INTO faixa (Numero_Faixa, idMusica, idCD) VALUES ";
		
		try {
			stmt=con.prepareStatement(sql);
			stmt.setInt(1, faixa.getIdNumeroFaixa());
			stmt.setInt(2, faixa.getIdMusica());
			stmt.setInt(3, faixa.getIdCd());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Erro ao inserir faixa");
			System.out.println(e);
			return false;
		}finally {
			ConnetionFactory.closeConnection(con,stmt);
		}
}
	
	
	
	
}
