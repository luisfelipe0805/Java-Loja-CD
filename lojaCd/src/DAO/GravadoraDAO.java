package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaoBD.ConnetionFactory;
import modelBean.Gravadora;


public class GravadoraDAO {
	
	Connection con=null;
	public GravadoraDAO() {
		con=null;
	}

	public boolean insertGravadora (int id,Gravadora gravadora){
		con = ConnetionFactory.getConnection();
		PreparedStatement stmt = null;
		String sql=" INSERT INTO gravadora ( NomeGravadora, Endereco, Telefone, Contato, URL) VALUES(  ?, ?, ?, ?, ?)";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, gravadora.getNomeGravadora());
			stmt.setString(2,gravadora.getEndereco());
			stmt.setString(3,gravadora.getTelefone());
			stmt.setString(4,gravadora.getContato());
			stmt.setString(5,gravadora.getUrl());
			stmt.executeUpdate();
			System.out.println("Gravadora cadastrada com sucesso");
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}finally {
			ConnetionFactory.closeConnection(con, stmt);
		}
	}
	
	public boolean updateGravador(int id,Gravadora gravadora) {
		con=ConnetionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql ="UPDATE gravadora SET NomeGravadora=?, Endereco=?, Telefone=?, Contato=?, URL=? Where idgravadora=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1,gravadora.getNomeGravadora());
			stmt.setString(2,gravadora.getEndereco());
			stmt.setString(3,gravadora.getTelefone());
			stmt.setString(4,gravadora.getContato());
			stmt.setString(5,gravadora.getUrl());
			stmt.setInt(6, id);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Erro ao atulualizar GRAVADORA");
			System.err.println(e);
			return false;
		}finally {
			ConnetionFactory.closeConnection(con, stmt);
		}
	}
	
	public boolean deleteGravadora(int id) {
		con=ConnetionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql ="DELETE FROM gravadora  Where idgravadora=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("Gravadora deletado com sucesso");
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}finally {
			ConnetionFactory.closeConnection(con, stmt);
		}
	}
	
	public Gravadora selectGravadora(int id) {
		con=ConnetionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs=null;
		
		String sql ="Select * from gravadora where idgravadora=? ";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setLong(1, id);
			rs=stmt.executeQuery();
			
			Gravadora gravadora = new Gravadora();
			while (rs.next()) {
				gravadora.setNomeGravadora(rs.getString("nomegravadora"));
				gravadora.setContato(rs.getString("contato"));
				gravadora.setEndereco(rs.getString("endereco"));
				gravadora.setTelefone(rs.getString("telefone"));
				gravadora.setUrl(rs.getString("url"));
				gravadora.setIdGravador(rs.getInt("idgravadora"));
			}
			return gravadora;
		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}finally {
			ConnetionFactory.closeConnection(con, stmt,rs);
		}
	}
	
	public List<Gravadora> selectListaGravadora() {
		List<Gravadora> listaGravadora= new ArrayList<>();
		
		con=ConnetionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs=null;
		
		String sql ="Select * from cd ";
		try {
			stmt=con.prepareStatement(sql);
			rs=stmt.executeQuery();
			
			
			while (rs.next()) {
				Gravadora gravadora = new Gravadora();
				gravadora.setNomeGravadora(rs.getString("nomegravadora"));
				gravadora.setContato(rs.getString("contato"));
				gravadora.setEndereco(rs.getString("endereco"));
				gravadora.setTelefone(rs.getString("telefone"));
				gravadora.setUrl(rs.getString("url"));
				gravadora.setIdGravador(rs.getInt("idgravadora"));
				listaGravadora.add(gravadora);
			}
			return listaGravadora;
		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}finally {
			ConnetionFactory.closeConnection(con, stmt,rs);
		}
	}
	
	
	
	
	
	
}
