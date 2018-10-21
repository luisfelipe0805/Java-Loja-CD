package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaoBD.ConnetionFactory;
import modelBean.Autor;


public class AutorDAO {
	private Connection con = null;

	public AutorDAO() {
		
	}
	
	
	public boolean insertAutorDAO(Autor autor) {
		con=ConnetionFactory.getConnection();
		
		PreparedStatement stmt = null;
		
		String sql="INSERT Into AUTOR ( nome_autor) values (?)";
		
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, autor.getNomeAutor());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Erro ao inserir autor");
			System.out.println(e);
			return false;
		}finally {
			ConnetionFactory.closeConnection(con,stmt);
		}
}
	
	public boolean updateAutor(Autor autor,int id) {
		con=ConnetionFactory.getConnection();
		PreparedStatement stmt = null;
		String sql="UPDATE autor set nome_autor=? WHERE idautor=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, autor.getNomeAutor());
			stmt.setInt(2, id);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}finally {
			ConnetionFactory.closeConnection(con, stmt);
		}
		
	}
	
	public boolean deleteAutor(int id) {
		con=ConnetionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql ="DELETE FROM AUTOR  Where idautor=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("Autor deletado com sucesso");
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}finally {
			ConnetionFactory.closeConnection(con, stmt);
		}
	}
	
	public Autor selectAutor(int id) {
		con=ConnetionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs=null;
		
		String sql ="Select * from autor where idautor=? ";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setLong(1, id);
			rs=stmt.executeQuery();
			
			Autor autor = new Autor();
			while (rs.next()) {
				
				autor.setIdAutor(rs.getInt("idautor"));
				autor.setNomeAutor(rs.getString("nome_autor"));
			}
			return autor;
		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}finally {
			ConnetionFactory.closeConnection(con, stmt,rs);
		}
		
	}
	
	
	public List<Autor> selectListaAutor() {
		List<Autor> listaAutor= new ArrayList<>();
		
		con=ConnetionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs=null;
		
		String sql ="Select * from autor ";
		try {
			stmt=con.prepareStatement(sql);
			rs=stmt.executeQuery();
			
			
			while (rs.next()) {
				Autor autor = new Autor();
				autor.setIdAutor(rs.getInt("idautor"));
				autor.setNomeAutor(rs.getString("nome_autor"));
				listaAutor.add(autor);
			}
			return listaAutor;
		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}finally {
			ConnetionFactory.closeConnection(con, stmt,rs);
		}
	}
	
	
}
