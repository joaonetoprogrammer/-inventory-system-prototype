package br.com.imperium.util;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ModeloMensagem {

	public void MensagemModeloInformation(String descricao) {
		JOptionPane.showMessageDialog(null, descricao, "IMPERIUM C.E.V 1.0",
				JOptionPane.INFORMATION_MESSAGE, new ImageIcon(
						"res/confirmar.png"));
	}

	public void MensagemModeloError(String descricao) {
		JOptionPane.showMessageDialog(null, descricao, "IMPERIUM C.E.V 1.0",
				JOptionPane.ERROR_MESSAGE);
	}

	public void MensagemModeloWarning(String descricao) {
		JOptionPane.showMessageDialog(null, descricao, "IMPERIUM C.E.V 1.0",
				JOptionPane.WARNING_MESSAGE);
	}

}
