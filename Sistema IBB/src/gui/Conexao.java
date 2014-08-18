package gui;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexao {
	
	public static Connection conexao() {

		Connection conn = null;
		
		try {
			String userName = "root";
			String password = "";
			String url = "jdbc:mysql://localhost:3306/betel-bauru";
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			conn = DriverManager.getConnection(url, userName, password);

		} catch (Exception e) {
			System.err.println("Não foi possível estabelecer conexão com o BD");
			JOptionPane.showMessageDialog(null, e, "alert",
					JOptionPane.ERROR_MESSAGE);
		}
		return conn;
	}
}