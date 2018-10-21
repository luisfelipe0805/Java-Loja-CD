package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaoBD.ConnetionFactory;
import modelBean.CD;

public class CdDAO {
	
	private Connection con = null;

	public CdDAO() {
		
	}
	
	public boolean insertCD(CD cd) {
		con=ConnetionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql="INSERT INTO cd (CD_Indicado, idGravadora, Nome_CD, Preco_Venda, Dt_Lancamento) VALUES (?,?,?,?,?)";
//		String sql="INSERT INTO CD (nome_cd, idGravadora) VALUES (?,?)";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setInt(1, cd.getCdIndicado());
			stmt.setInt(2, cd.getIdGravadora());
			stmt.setString(3, cd.getNomeCD());
			stmt.setFloat(4, cd.getPrecoVenda());
			stmt.setDate(5,(Date) cd.getDtLancamento());
			stmt.executeUpdate();
			System.out.println("CD cadastrado com sucesso");
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}finally {
			ConnetionFactory.closeConnection(con, stmt);
		}
		
		
	
	}
	
	public boolean updateCD(int id,CD cdNew) {
		con=ConnetionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql ="UPDATE CD SET CD_Indicado=?, idGravadora=?, Nome_CD=?, Preco_Venda=?, Dt_Lancamento=? Where idCD=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setInt(1, cdNew.getCdIndicado());
			stmt.setInt(2, cdNew.getIdGravadora());
			stmt.setString(3, cdNew.getNomeCD());
			stmt.setFloat(4, cdNew.getPrecoVenda());
			stmt.setDate(5,(Date) cdNew.getDtLancamento());
			stmt.setInt(6, id);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Erro ao atulualizar cd");
			System.err.println(e);
			return false;
		}finally {
			ConnetionFactory.closeConnection(con, stmt);
		}
	}
	
	
	public boolean deleteCD(int id) {
		con=ConnetionFactory.getConnection();
		PreparedStatement stmt = null;
		
		String sql ="DELETE FROM CD  Where idCD=?";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println("Cd deletado com sucesso");
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		}finally {
			ConnetionFactory.closeConnection(con, stmt);
		}
	}
	
	
	public CD selectCD(int id) {
		con=ConnetionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs=null;
		
		String sql ="Select * from cd where idcd=? ";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setLong(1, id);
			rs=stmt.executeQuery();
			
			CD cd = new CD();
			while (rs.next()) {
				
				cd.setIdcd(rs.getInt("idcd"));
				cd.setCdIndicado(rs.getInt("cd_indicado"));
				cd.setIdGravadora(rs.getInt("idgravadora"));
				cd.setNomeCD(rs.getString("nome_cd"));
				cd.setDtLancamento(rs.getDate("dt_lancamento"));
			}
			return cd;
		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}finally {
			ConnetionFactory.closeConnection(con, stmt,rs);
		}
		
	}
	
	public List<CD> selectListaCD() {
		List<CD> listaCD= new ArrayList<>();
		
		con=ConnetionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs=null;
		
		String sql ="Select * from cd ";
		try {
			stmt=con.prepareStatement(sql);
			rs=stmt.executeQuery();
			
			
			while (rs.next()) {
				CD cd = new CD();
				cd.setIdcd(rs.getInt("idcd"));
				cd.setCdIndicado(rs.getInt("cd_indicado"));
				cd.setIdGravadora(rs.getInt("idgravadora"));
				cd.setNomeCD(rs.getString("nome_cd"));
				cd.setDtLancamento(rs.getDate("dt_lancamento"));
				listaCD.add(cd);
			}
			return listaCD;
		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}finally {
			ConnetionFactory.closeConnection(con, stmt,rs);
		}
	}
	
	
	
	
	
}
