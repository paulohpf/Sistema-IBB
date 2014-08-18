package gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.commons.net.ftp.FTPClient;

public class FuncoesSQL {

	public static void inserePost(String title, String conteudo, String data) {

		Connection conn = Conexao.conexao();

		String sql = "INSERT into wp_posts (post_author,post_date,post_date_gmt,post_content"
				+ ",post_title,post_excerpt,comment_status,ping_status,to_ping,pinged,post_content_filtered)"
				+ "values (?,?,?,?,?,?,?,?,?,?)";

		try {

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, "1");
			stmt.setString(2, data);
			stmt.setString(3, data);
			stmt.setString(4, conteudo);
			stmt.setString(5, title);
			stmt.setString(6, "");
			stmt.setString(7, "open");
			stmt.setString(8, "open");
			stmt.setString(9, "");
			stmt.setString(10, "");
			stmt.setString(11, "");

			stmt.execute();

			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void atualizaBoletim(File arquivo) throws SocketException {

		FTPClient ftp = new FTPClient();

		try {
			ftp.connect("127.0.0.1");

			ftp.login("betel324", "210866pf");

			FileInputStream arqEnviar = new FileInputStream(
					arquivo.getAbsoluteFile());
			
			ftp.storeFile(arquivo.getName(), arqEnviar);

//			if (ftp.storeFile(arquivo.getName(), arqEnviar)) {
//				System.out.println("Arquivo armazenado com sucesso!");
//			} else{
//				System.out.println("Erro ao armazenar o arquivo.");
//			}
			
			ftp.logout();

			ftp.disconnect();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}