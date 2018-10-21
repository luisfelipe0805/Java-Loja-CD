package conexaoBD;


import java.sql.*;

public class ConnetionFactory {
	
	private static String drive ="org.postgresql.Driver";
	private static String url= "jdbc:postgresql://localhost:5432/loja_cds";
	private static String user="postgres";
	private static String password="oobj.postgres";

	public static Connection getConnection() {
		 try {
			 Class.forName(drive);
			 return DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			System.out.println("Falha de conexao ");
			return null;
		}
		
	 }
	 
	public static void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println("Erro e fechar conexao");
			}
		}
	}
	 
	public static void closeConnection(Connection con, PreparedStatement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				System.err.println("Erro e fechar conexao");
			}
		}
		closeConnection(con);
	}
	
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				System.err.println("Erro e fechar conexao");
			}
		}
		closeConnection(con,stmt);
	}
	
	
	
}
