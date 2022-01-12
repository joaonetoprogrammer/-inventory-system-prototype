package br.com.imperium.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.imperium.dao.AdministradorDAO;
import br.com.imperium.vision.start.TelaDeLogin;

public class ControleAdministrador implements ActionListener {

	AdministradorDAO admin = new AdministradorDAO();

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == TelaDeLogin.jbEntrar) {
			admin.Metodo_Botao_Entrar();
		} else if (e.getSource() == TelaDeLogin.jbSair) {
			TelaDeLogin.jfTela.dispose();
		}
	}
}
