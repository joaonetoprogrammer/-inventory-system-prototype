package br.com.imperium.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.imperium.domain.Administrador;
import br.com.imperium.factory.Conexao;
import br.com.imperium.util.ModeloMensagem;
import br.com.imperium.vision.start.MenuInicial;
import br.com.imperium.vision.start.TelaDeLogin;

public class AdministradorDAO {
	
	/**** METODO DE LOGAR ****/
	public boolean Logar(String login, String senha, Connection con) {
		boolean resultado = false;

		try {
			String consulta = "select login,senha from administrador "
					+ "where login = '" + login + "' and senha = '" + senha
					+ "'";
			PreparedStatement ps = con.prepareStatement(consulta);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Administrador domain = new Administrador();
					domain.setLogin(rs.getString(1));
					domain.setSenha(rs.getString(2));
					resultado = true;
				}
			}

		} catch (SQLException e) {
			ModeloMensagem utilMensagem = new ModeloMensagem();
			utilMensagem.MensagemModeloError("(ERRO 0002) - (MODELO ADMINISTRADOR)\n"
					+ "RECOMENDAÇÕES: \n"
					+ "- CONSULTAR O MANUAL DO SISTEMA\n"
					+ "- CONTRATAR O PROGRAMADOR DO SISTEMA");
		}
		return resultado;
	}

	/****
	 * ACAO DO BOTAO ENTRAR TELA DE LOGIN
	 ****/
	public void Metodo_Botao_Entrar() {
		String login = TelaDeLogin.jtfUsuario.getText();
		@SuppressWarnings("deprecation")
		String senha = TelaDeLogin.jpssSenha.getText();
		if (login.equalsIgnoreCase("") || senha.equalsIgnoreCase("")) {
			ModeloMensagem utilMensagem = new ModeloMensagem();
			utilMensagem
			.MensagemModeloWarning("CAMPOS USUÁRIO E SENHA OBRIGATÓRIOS");


			TelaDeLogin.jtfUsuario.setText("");
			TelaDeLogin.jpssSenha.setText("");
		} else if (Logar(login, senha, Conexao.abrirConexao()) == true) {
			MenuInicial objeto = new MenuInicial();
			objeto.setVisible(true);
			TelaDeLogin.jfTela.dispose();
			Conexao.FecharConexao(Conexao.abrirConexao());
		}

		else if (Logar(login, senha, Conexao.abrirConexao()) == false) {
			ModeloMensagem utilMensagem = new ModeloMensagem();
			utilMensagem
			.MensagemModeloWarning("USUÁRIO OU SENHA INVÁLIDOS");
			TelaDeLogin.jtfUsuario.setText("");
			TelaDeLogin.jpssSenha.setText("");

		}
	}

	/**** METODO PARA ATUALIZAR A DATA E A HORA ****/
	public void AtualizarDataHora() {
		Date data = new Date();
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		MenuInicial.jlData.setText(date.format(data));
	}

}
