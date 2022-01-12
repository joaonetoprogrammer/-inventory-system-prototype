package br.com.imperium.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import br.com.imperium.vision.read.ConsultarFornecedor;
import br.com.imperium.vision.read.ConsultarProduto;
import br.com.imperium.vision.start.MenuInicial;

/**
 * CLASSE CONTROLEMENUINICIAL DO PACOTE BR.COM.IMPERIUM.CONTROLE.PRINCIPAL
 * 
 * @author JOAO DE SOUZA NETO
 *
 * */
public class ControleMenuInicial implements ActionListener {

	/*
	 * EVENTO ACTION LISTENER - METÓDO ACTION PERFORMED
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		/*
		 * EVENTO DO CLIQUE DO BOTÃO FORNECEDOR
		 */
		if (e.getSource() == MenuInicial.jbFornecedor) {
			ConsultarFornecedor objeto = new ConsultarFornecedor();
			objeto.setVisible(true);
		}

		else

		/*
		 * EVENTO DO CLIQUE DO BOTÃO PRODUTO
		 */
		if (e.getSource() == MenuInicial.jbProduto) {
			ConsultarProduto objeto = new ConsultarProduto();
			objeto.setVisible(true);
		}

		/*
		 * EVENTO DO CLIQUE DO BOTÃO FINALIZAR
		 */
		else if (e.getSource() == MenuInicial.jbFinalizar) {
			System.exit(0);
		}

		/*
		 * EVENTO DO CLIQUE DO BOTÃO FECHAR
		 */
		else if (e.getSource() == MenuInicial.jbFechar) {
			System.exit(0);
		}
	}
}
