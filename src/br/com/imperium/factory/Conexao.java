package br.com.imperium.factory;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

/**
 * CLASSE CONEX�O DO PACOTE BR.COM.IMPERIUM.MODELO.PRINCIPAL
 * 
 * @author JOAO DE SOUZA NETO
 *
 * */
public class Conexao {


	private static final String URL = "jdbc:mysql://localhost/imperium";
	private static final String USUARIO = "root";
	private static final String SENHA = "89835019";

	/**
	 * MET�DO PARA ABRIR CONEX�O NO BANCO DE DADOS
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
					"(ERRO 0001) - (MODELO CONEX�O)\n"
							+ "(CONTRATE O PROGRAMADOR"
							+ " DO SISTEMA)", "CONEX�O",
					JOptionPane.ERROR_MESSAGE);

		}
		return con;

	}

	/**
	 * MET�DO PARA FECHAR CONEX�O NO BANCO DE DADOS
	 * 
	 * @author JOAO DE SOUZA NETO
	 *
	 * */
	public static void FecharConexao(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"(ERRO 0002) - (MODELO CONEX�O)\n"
							+ "(CONTRATE O PROGRAMADOR DO SISTEMA)", "CONEX�O",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
