package br.com.imperium.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.imperium.dao.FornecedorDAO;
import br.com.imperium.vision.create.CadastrarFornecedor;
import br.com.imperium.vision.create.CadastrarRamoEmpresarial;
import br.com.imperium.vision.read.ConsultarFornecedor;
import br.com.imperium.vision.update.AtualizarFornecedor;

/**
 * CLASSE CONTROLEFORNECEDOR DO PACOTE BR.COM.IMPERIUM.CONTROLE.CADASTROS
 * 
 * @author JOAO DE SOUZA NETO
 *
 * */

public class ControleFornecedor implements ActionListener {

	/*
	 * EVENTO ACTION LISTENER - MET�DO ACTION PERFORMED
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * INST�NCIA DO FORNECEDOR
		 */
		FornecedorDAO dao = new FornecedorDAO();

		/*
		 * BOT�O FECHAR TELA DE CADASTRAR FORNECEDOR
		 */
		if (e.getSource() == CadastrarFornecedor.jbFechar) {
			CadastrarFornecedor.tela.dispose();
		}
		/*
		 * BOT�O CADSATRAR FORNECEDOR TELA DE CADASTRAR FORNECEDOR
		 */
		else if (e.getSource() == CadastrarFornecedor.jbCadastrarFornecedor) {
			dao.BotaoCadastrarFornecedor();
		}
		/*
		 * BOT�O NEW TELA DE CADASTRAR FORNECEDOR
		 */
		else if (e.getSource() == CadastrarFornecedor.jbNovoRamoEmpresarial) {
			CadastrarRamoEmpresarial objeto = new CadastrarRamoEmpresarial();
			objeto.setVisible(true);
		}

		/*
		 * BOT�O FECHAR TELA DE CADASTRAR RAMO EMRPESARIAL
		 */
		else if (e.getSource() == CadastrarRamoEmpresarial.jbFechar) {
			CadastrarRamoEmpresarial.tela.dispose();
		}
		/*
		 * BOT�O ADD TELA DE CADASTRAR RAMO EMPRESARIAL
		 */
		else if (e.getSource() == CadastrarRamoEmpresarial.jbOkRamoEmpresarial) {
			FornecedorDAO forne = new FornecedorDAO();
			forne.BotaoCadastrarRamoEmpreresarial();

		} else

		/*
		 * BOT�O FECHAR TELA DE ATUALIZAR FORNECEDOR
		 */
		if (e.getSource() == AtualizarFornecedor.jbFechar) {
			AtualizarFornecedor.tela.dispose();

		}
		/*
		 * BOT�O ATUALIZAR FORNECEDOR TELA DE ATUALIZAR FORNECEDOR
		 */
		else if (e.getSource() == AtualizarFornecedor.jbAtualizarFornecedor) {
			dao.AcaoDoBotaoAlterarFornecedor();
		}
		/*
		 * CLIQUE DO BOT�O OK TELA DE ATUALIZAR FORNECEDOR
		 */

		else if (e.getSource() == AtualizarFornecedor.jbOk) {
			dao.AcaoDoBotaoOkFornecedor();
		}
		/*
		 * CLIQUE DO BOT�O NEW TELA DE ATUALIZAR FORNECEDOR
		 */
		else if (e.getSource() == AtualizarFornecedor.jbNovoRamoEmpresarial) {
			CadastrarRamoEmpresarial objeto = new CadastrarRamoEmpresarial();
			objeto.setVisible(true);
		}

		/*
		 * CLIQUE DO BOT�O FECHAR TELA DE CONSULTAR FORNECEDOR
		 */
		else if (e.getSource() == ConsultarFornecedor.jbFechar) {
			ConsultarFornecedor.jftela.dispose();
		}
		/*
		 * CLIQUE DO BOT�O ADD FORNECEDOR TELA DE CONSULTAR FORNECEDOR
		 */
		else if (e.getSource() == ConsultarFornecedor.jbAddNovo) {
			CadastrarFornecedor objeto = new CadastrarFornecedor();
			objeto.setVisible(true);

		}

		/*
		 * CLIQUE DO BOT�O DELETAR TELA DE CONSULTAR FORNECEDOR
		 */
		else if (e.getSource() == ConsultarFornecedor.jbDeletarItem) {
			dao.AcaodoBotaoDeletarFornecedor();

		}
		/*
		 * CLIQUE DO BOT�O GERAR FICHA TELA DE COSNULTAR FORNECEDOR
		 */
		else if (e.getSource() == ConsultarFornecedor.jbGerarFicha) {
			dao.RelatorioFicha();

		}
		/*
		 * CLIQUE DO BOT�O ATUALIZAR TELA DE CONSULTAR FORNECEDOR
		 */
		else if (e.getSource() == ConsultarFornecedor.jbAtualizar) {
			String codigo = ConsultarFornecedor.jtfCampoCodigoDeletar.getText();
			if (codigo.equals("")) {
				AtualizarFornecedor objeto = new AtualizarFornecedor();
				objeto.setVisible(true);

			} else {
				AtualizarFornecedor objeto = new AtualizarFornecedor();
				AtualizarFornecedor.jtfCampoCodigo.setText(codigo);
				dao.AcaoDoBotaoOkFornecedor();
				objeto.setVisible(true);
			}
		}
	}
}
