package br.com.imperium.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


/**
 * CLASSE TESTAR ITEM DO PACOTE BR.COM.IMPERIUM.UTIL
 * 
 * @author JOAO DE SOUZA NETO
 *
 * */

public class ModeloTestarItem {
	
	/**
	 * METÓDO PARA TESTAR SE EXISTE ALGUM ITEM DIGITADO DE ACORDO COM A STRING
	 * SQL INFORMADA NA HORA DE CHAMAR O METÓDO NO BANCO DE DADOS, UTILIZADO EM VÁRIOS OUTROS
	 * METÓDOS
	 * 
	 * @author JOAO DE SOUZA NETO
	 *
	 * */
	public boolean TestarItemExistente(Connection con, String sql) {
		boolean resultado = false;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					resultado = true;
				}
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"(ERRO 0001) - (MODELO FORNECEDOR)\n"
							+ "(CONTRATE O PROGRAMADOR DO SISTEMA)",
					"FORNECEDOR", JOptionPane.ERROR_MESSAGE);
		}
		return resultado;
	}
	
}
