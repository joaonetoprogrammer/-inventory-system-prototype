package br.com.imperium.factory;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

/**
 * CLASSE CONEXÃO DO PACOTE BR.COM.IMPERIUM.MODELO.PRINCIPAL
 * 
 * @author JOAO DE SOUZA NETO
 *
 * */
public class Conexao {


	private static final String URL = "jdbc:mysql://localhost/imperium";
	private static final String USUARIO = "root";
	private static final String SENHA = "89835019";

	/**
	 * METÓDO PARA ABRIR CONEXÃO NO BANCO DE DADOS
	 * 
	 * @author JOAO NETO
	 *
	 * */
	
	public static Connection abrirConexao() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, 
					USUARIO, SENHA);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"(ERRO 0001) - (MODELO CONEXÃO)\n"
							+ "(CONTRATE O PROGRAMADOR"
							+ " DO SISTEMA)", "CONEXÃO",
					JOptionPane.ERROR_MESSAGE);

		}
		return con;

	}

	/**
	 * METÓDO PARA FECHAR CONEXÃO NO BANCO DE DADOS
	 * 
	 * @author JOAO DE SOUZA NETO
	 *
	 * */
	public static void FecharConexao(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"(ERRO 0002) - (MODELO CONEXÃO)\n"
							+ "(CONTRATE O PROGRAMADOR DO SISTEMA)", "CONEXÃO",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
