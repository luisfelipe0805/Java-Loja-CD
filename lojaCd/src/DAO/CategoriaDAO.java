package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexaoBD.ConnetionFactory;
import modelBean.CategoriaCD;

public class CategoriaDAO {
	private Connection con = null;

	public CategoriaDAO() {
	
	}
	
	
	public boolean insertCategoria(CategoriaCD categoria) {
		con=ConnetionFactory.getConnection();
		
		PreparedStatement stmt = null;
		
		String sql="INSERT Into cd_Categoria (menor_preco,mairo_preco ) values (?,?)";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setFloat(1, categoria.getMenorPreco());
			stmt.setFloat(2, categoria.getMaiorPreco());
			
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Erro ao inserir categoria");
			System.out.println(e);
			return false;
		}finally {
			ConnetionFactory.closeConnection(con,stmt);
		}
}
	
	
	
}
