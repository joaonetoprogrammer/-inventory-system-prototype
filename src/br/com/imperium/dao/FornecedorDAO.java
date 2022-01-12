package br.com.imperium.dao;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

import br.com.imperium.domain.Fornecedor;
import br.com.imperium.factory.Conexao;
import br.com.imperium.util.ModeloMensagem;
import br.com.imperium.util.ModeloTestarItem;
import br.com.imperium.vision.create.CadastrarFornecedor;
import br.com.imperium.vision.create.CadastrarRamoEmpresarial;
import br.com.imperium.vision.read.ConsultarFornecedor;
import br.com.imperium.vision.update.AtualizarFornecedor;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * CLASSE FORNECEDOR DO PACOTE BR.COM.IMPERIUM.MODELO.CADASTROS
 * 
 * @author JOAO DE SOUZA NETO
 *
 * */
public class FornecedorDAO {

	/**
	 * INSERÇÃO DE UM NOVO FORNECEDOR NO BANCO DE DADOS
	 * 
	 * @author JOAO DE SOUZA NETO
	 *
	 **/
	public void InserirFornecedor(Fornecedor domain, Connection con) {

		ModeloMensagem util = new ModeloMensagem();
		String sql = "insert into fornecedor values(0,?,?,?,?,?,?,?,?,?,"
				+ "?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, domain.getRazaoSocial());
			ps.setString(2, domain.getNomeFantasia());
			ps.setString(3, domain.getCpfCnpj());
			ps.setString(4, domain.getInscricaoEstadual());
			ps.setString(5, domain.getInscricaoMunicipal());
			ps.setString(6, domain.getRamoEmpresarial());
			ps.setString(7, domain.getStatus());
			ps.setString(8, domain.getCep());
			ps.setString(9, domain.getEndereco());
			ps.setString(10, domain.getNumero());
			ps.setString(11, domain.getComplemento());
			ps.setString(12, domain.getBairro());
			ps.setString(13, domain.getCidade());
			ps.setString(14, domain.getUf());
			ps.setString(15, domain.getPaís());
			ps.setString(16, domain.getContato());
			ps.setString(17, domain.getTelefone());
			ps.setString(18, domain.getCelular());
			ps.setString(19, domain.getFoneFax());
			ps.setString(20, domain.getEmail());
			ps.setString(21, domain.getDescricao());

			if (ps.executeUpdate() > 0) {
				util.MensagemModeloInformation("CADASTRO DE FORNECEDOR REALIZADO COM SUCESSO");

				Conexao.FecharConexao(Conexao.abrirConexao());
				CadastrarFornecedor.jtfCampoBairro.setText("");
				CadastrarFornecedor.jtfCampoCelular.setText("");
				CadastrarFornecedor.jtfCampoCidade.setText("");
				CadastrarFornecedor.jtfCampoComplemento.setText("");
				CadastrarFornecedor.jtfCampoContato.setText("");
				CadastrarFornecedor.jtfCampoCpfCnpj.setText("");
				CadastrarFornecedor.jtfCampoEmail.setText("");
				CadastrarFornecedor.jtfCampoEndereco.setText("");
				CadastrarFornecedor.jtfCampoFoneFax.setText("");
				CadastrarFornecedor.jtfCampoInscricaoEstadual.setText("");
				CadastrarFornecedor.jtfCampoInscricaoMunicipal.setText("");
				CadastrarFornecedor.jtfCampoNomeFantasia.setText("");
				CadastrarFornecedor.jtfCampoNomeRazaoSocial.setText("");
				CadastrarFornecedor.jtfCampoNumero.setText("");
				CadastrarFornecedor.jtfCampoPaís.setText("");
				CadastrarFornecedor.jtaCampoDescricao.setText("");
				CadastrarFornecedor.jtfCampoTelefone.setText("");
				CadastrarFornecedor.jcbComboRamoEmpresarial.setSelectedItem("");
				CadastrarFornecedor.jcbComboStatus.setSelectedItem("");
				CadastrarFornecedor.jcbComboUf.setSelectedItem("");
				CadastrarFornecedor.jftfCampoCep.setText("");

				CadastrarFornecedor.jlCpfCnpj.setForeground(Color.BLACK);
				CadastrarFornecedor.jlContato.setForeground(Color.BLACK);
				CadastrarFornecedor.jlNomeFantasia.setForeground(Color.BLACK);
				CadastrarFornecedor.jlRamoEmpresarial
						.setForeground(Color.BLACK);
				CadastrarFornecedor.jlStatus.setForeground(Color.BLACK);
				CadastrarFornecedor.jlCep.setForeground(Color.BLACK);

				CadastrarFornecedor.jtfCampoNomeRazaoSocial.requestFocus();
				CadastrarFornecedor.tela.dispose();
				try {
					AtualizaTable();

				} catch (java.lang.NullPointerException e) {

					util.MensagemModeloError("(ERRO 0001) - (MODELO FORNECEDOR)\n"
							+ "RECOMENDAÇÕES: \n"
							+ "- CONSULTAR O MANUAL DO SISTEMA\n"
							+ "- CONTRATAR O PROGRAMADOR DO SISTEMA");
				}

			} else {
				util.MensagemModeloError("(ERRO 0002) - (MODELO FORNECEDOR)\n"
						+ "RECOMENDAÇÕES: \n"
						+ "- CONSULTAR O MANUAL DO SISTEMA\n"
						+ "- CONTRATAR O PROGRAMADOR DO SISTEMA");
			}
		} catch (SQLException e) {
			CadastrarFornecedor.jlCpfCnpj.setForeground(Color.BLACK);
			CadastrarFornecedor.jlContato.setForeground(Color.BLACK);
			CadastrarFornecedor.jlNomeFantasia.setForeground(Color.BLACK);
			CadastrarFornecedor.jlRamoEmpresarial.setForeground(Color.BLACK);
			CadastrarFornecedor.jlStatus.setForeground(Color.BLACK);
			CadastrarFornecedor.jlCep.setForeground(Color.BLACK);

			util.MensagemModeloError("(ERRO 0003) - (MODELO FORNECEDOR)\n"
					+ "RECOMENDAÇÕES: \n" + "- CONSULTAR O MANUAL DO SISTEMA\n"
					+ "- CONTRATAR O PROGRAMADOR DO SISTEMA");
		}
	}

	/**
	 * FUNÇÃO DO BOTÃO CADASTRAR FORNECEDOR
	 * 
	 * @author JOAO DE SOUZA NETO
	 *
	 **/
	public void BotaoCadastrarFornecedor() {
		String razaoSocial = CadastrarFornecedor.jtfCampoNomeRazaoSocial
				.getText();
		String nomeFantasia = CadastrarFornecedor.jtfCampoNomeFantasia
				.getText();
		String cpfCnpj = CadastrarFornecedor.jtfCampoCpfCnpj.getText();
		String inscricaoEstadual = CadastrarFornecedor.jtfCampoInscricaoEstadual
				.getText();
		String inscricaoMunicipal = CadastrarFornecedor.jtfCampoInscricaoMunicipal
				.getText();
		String endereco = CadastrarFornecedor.jtfCampoEndereco.getText();
		String numero = CadastrarFornecedor.jtfCampoNumero.getText();
		String complemento = CadastrarFornecedor.jtfCampoComplemento.getText();
		String bairro = CadastrarFornecedor.jtfCampoBairro.getText();
		String cidade = CadastrarFornecedor.jtfCampoCidade.getText();
		String país = CadastrarFornecedor.jtfCampoPaís.getText();
		String telefone = CadastrarFornecedor.jtfCampoTelefone.getText();
		String celular = CadastrarFornecedor.jtfCampoCelular.getText();
		String cep = CadastrarFornecedor.jftfCampoCep.getText();
		String foneFax = CadastrarFornecedor.jtfCampoFoneFax.getText();
		String email = CadastrarFornecedor.jtfCampoEmail.getText();
		String descricao = CadastrarFornecedor.jtaCampoDescricao.getText();
		String contato = CadastrarFornecedor.jtfCampoContato.getText();
		String ramoEmpresarial = CadastrarFornecedor.jcbComboRamoEmpresarial
				.getSelectedItem().toString();
		String status = CadastrarFornecedor.jcbComboStatus.getSelectedItem()
				.toString();
		String uf = CadastrarFornecedor.jcbComboUf.getSelectedItem().toString();

		String sql = "select * from fornecedor where cpfCnpj like '" + cpfCnpj
				+ "'";

		ModeloTestarItem util = new ModeloTestarItem();
		ModeloMensagem utilMensagem = new ModeloMensagem();

		String cep1 = cep.substring(0, 1);
		String cep2 = cep.substring(1, 2);
		String cep3 = cep.substring(2, 3);
		String cep4 = cep.substring(3, 4);
		String cep5 = cep.substring(4, 5);
		String cep6 = cep.substring(6, 7);
		String cep7 = cep.substring(7, 8);
		String cep8 = cep.substring(8, 9);

		if (nomeFantasia.equals("")) {
			CadastrarFornecedor.jlNomeFantasia.setForeground(new Color(149, 2,
					5));
			CadastrarFornecedor.jlCpfCnpj.setForeground(Color.BLACK);
			CadastrarFornecedor.jlContato.setForeground(Color.BLACK);
			CadastrarFornecedor.jlRamoEmpresarial.setForeground(Color.BLACK);
			CadastrarFornecedor.jlStatus.setForeground(Color.BLACK);
			CadastrarFornecedor.jlCep.setForeground(Color.BLACK);
			CadastrarFornecedor.jtfCampoNomeFantasia.requestFocus();

			utilMensagem
					.MensagemModeloWarning("CAMPOS COM ASTERISCO SÃO OBRIGATÓRIOS");

		} else if (cpfCnpj.equals("")) {
			CadastrarFornecedor.jlCpfCnpj.setForeground(new Color(149, 2, 5));
			CadastrarFornecedor.jlNomeFantasia.setForeground(Color.BLACK);
			CadastrarFornecedor.jlContato.setForeground(Color.BLACK);
			CadastrarFornecedor.jlStatus.setForeground(Color.BLACK);
			CadastrarFornecedor.jlRamoEmpresarial.setForeground(Color.BLACK);
			CadastrarFornecedor.jlCep.setForeground(Color.BLACK);
			CadastrarFornecedor.jtfCampoCpfCnpj.requestFocus();

			utilMensagem
					.MensagemModeloWarning("CAMPOS COM ASTERISCO SÃO OBRIGATÓRIOS");

		} else if (ramoEmpresarial.equals("")) {
			CadastrarFornecedor.jlRamoEmpresarial.setForeground(new Color(149,
					2, 5));
			CadastrarFornecedor.jlCpfCnpj.setForeground(Color.BLACK);
			CadastrarFornecedor.jlContato.setForeground(Color.BLACK);
			CadastrarFornecedor.jlNomeFantasia.setForeground(Color.BLACK);
			CadastrarFornecedor.jlStatus.setForeground(Color.BLACK);
			CadastrarFornecedor.jlCep.setForeground(Color.BLACK);
			CadastrarFornecedor.jcbComboRamoEmpresarial.requestFocus();

			utilMensagem
					.MensagemModeloWarning("CAMPOS COM ASTERISCO SÃO OBRIGATÓRIOS");

		} else if (contato.equals("")) {
			CadastrarFornecedor.jlContato.setForeground(new Color(149, 2, 5));
			CadastrarFornecedor.jlCpfCnpj.setForeground(Color.BLACK);
			CadastrarFornecedor.jlNomeFantasia.setForeground(Color.BLACK);
			CadastrarFornecedor.jlRamoEmpresarial.setForeground(Color.BLACK);
			CadastrarFornecedor.jlStatus.setForeground(Color.BLACK);
			CadastrarFornecedor.jlCep.setForeground(Color.BLACK);
			CadastrarFornecedor.jtfCampoContato.requestFocus();

			utilMensagem
					.MensagemModeloWarning("CAMPOS COM ASTERISCO SÃO OBRIGATÓRIOS");

		} else if (status.equals("")) {
			CadastrarFornecedor.jlStatus.setForeground(new Color(149, 2, 5));
			CadastrarFornecedor.jlCpfCnpj.setForeground(Color.BLACK);
			CadastrarFornecedor.jlNomeFantasia.setForeground(Color.BLACK);
			CadastrarFornecedor.jlRamoEmpresarial.setForeground(Color.BLACK);
			CadastrarFornecedor.jlContato.setForeground(Color.BLACK);
			CadastrarFornecedor.jlCep.setForeground(Color.BLACK);
			CadastrarFornecedor.jcbComboStatus.requestFocus();

			utilMensagem
					.MensagemModeloWarning("CAMPOS COM ASTERISCO SÃO OBRIGATÓRIOS");

		} else if (CadastrarFornecedor.jftfCampoCep.getText().trim().length() > 1) {

			if (cep1.equals(" ") || cep2.equals(" ") || cep3.equals(" ")
					|| cep4.equals(" ") || cep5.equals(" ") || cep6.equals(" ")
					|| cep7.equals(" ") || cep8.equals(" ")) {
				CadastrarFornecedor.jlCpfCnpj.setForeground(Color.BLACK);
				CadastrarFornecedor.jlContato.setForeground(Color.BLACK);
				CadastrarFornecedor.jlNomeFantasia.setForeground(Color.BLACK);
				CadastrarFornecedor.jlRamoEmpresarial
						.setForeground(Color.BLACK);
				CadastrarFornecedor.jlStatus.setForeground(Color.BLACK);
				CadastrarFornecedor.jlCep.setForeground(new Color(149, 2, 5));
				CadastrarFornecedor.jftfCampoCep.requestFocus();

				utilMensagem
						.MensagemModeloWarning("CAMPO (CEP) COM PREENCHIMENTO INCOMPLETO");

			} else

			if (util.TestarItemExistente(Conexao.abrirConexao(), sql) == true) {

				utilMensagem
						.MensagemModeloWarning("FORNECEDOR COM MESMO CPF/CNPJ JÁ CADASTRADO NO SISTEMA");

				Conexao.FecharConexao(Conexao.abrirConexao());

			}

			else if (CadastrarFornecedor.jftfCampoCep.getText().trim().length() == 9) {
				Fornecedor domain = new Fornecedor();
				domain.setRamoEmpresarial(ramoEmpresarial);
				domain.setBairro(bairro);
				domain.setCelular(celular);
				domain.setCep(cep);
				domain.setCidade(cidade);
				domain.setComplemento(complemento);
				domain.setContato(contato);
				domain.setCpfCnpj(cpfCnpj);
				domain.setEmail(email);
				domain.setEndereco(endereco);
				domain.setFoneFax(foneFax);
				domain.setInscricaoEstadual(inscricaoEstadual);
				domain.setInscricaoMunicipal(inscricaoMunicipal);
				domain.setNomeFantasia(nomeFantasia);
				domain.setNumero(numero);
				domain.setPaís(país);
				domain.setRazaoSocial(razaoSocial);
				domain.setDescricao(descricao);
				domain.setStatus(status);
				domain.setTelefone(telefone);
				domain.setUf(uf);

				InserirFornecedor(domain, Conexao.abrirConexao());
				Conexao.FecharConexao(Conexao.abrirConexao());

			}

		} else

		if (util.TestarItemExistente(Conexao.abrirConexao(), sql) == true) {

			utilMensagem
					.MensagemModeloWarning("FORNECEDOR COM MESMO CPF/CNPJ JÁ CADASTRADO NO SISTEMA");

			Conexao.FecharConexao(Conexao.abrirConexao());

		} else {

			Fornecedor domain = new Fornecedor();
			domain.setRamoEmpresarial(ramoEmpresarial);
			domain.setBairro(bairro);
			domain.setCelular(celular);
			domain.setCep(cep);
			domain.setCidade(cidade);
			domain.setComplemento(complemento);
			domain.setContato(contato);
			domain.setCpfCnpj(cpfCnpj);
			domain.setEmail(email);
			domain.setEndereco(endereco);
			domain.setFoneFax(foneFax);
			domain.setInscricaoEstadual(inscricaoEstadual);
			domain.setInscricaoMunicipal(inscricaoMunicipal);
			domain.setNomeFantasia(nomeFantasia);
			domain.setNumero(numero);
			domain.setPaís(país);
			domain.setRazaoSocial(razaoSocial);
			domain.setDescricao(descricao);
			domain.setStatus(status);
			domain.setTelefone(telefone);
			domain.setUf(uf);

			InserirFornecedor(domain, Conexao.abrirConexao());
			Conexao.FecharConexao(Conexao.abrirConexao());

		}

	}

	/**
	 * INSERÇÃO UM NOVO RAMO EMPRESARIAL NO BANCO DE DADOS
	 * 
	 * @author JOAO DE SOUZA NETO
	 *
	 * */
	public void InserirRamoEmpresarial(Fornecedor domain, Connection con) {

		ModeloMensagem util = new ModeloMensagem();
		String sql = "insert into ramoEmpresarialFornecedor values(0,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, domain.getRamoEmpresarial());

			if (ps.executeUpdate() > 0) {
				util.MensagemModeloInformation("CADASTRO DE RAMO EMPRESARIAL REALIZADO COM SUCESSO");

				Conexao.FecharConexao(Conexao.abrirConexao());

				if (CadastrarFornecedor.tela.isVisible() == true) {
					AtualizaComboRamoEmpresarial(CadastrarFornecedor.jcbComboRamoEmpresarial);

				} else if (AtualizarFornecedor.tela.isVisible() == true) {
					AtualizaComboRamoEmpresarial(AtualizarFornecedor.jcbComboRamoEmpresarial);

				}
				CadastrarRamoEmpresarial.tela.dispose();
				CadastrarRamoEmpresarial.tela = null;

			} else {
				util.MensagemModeloError("(ERRO 0004) - (MODELO FORNECEDOR)\n"
						+ "RECOMENDAÇÕES: \n"
						+ "- CONSULTAR O MANUAL DO SISTEMA\n"
						+ "- CONTRATAR O PROGRAMADOR DO SISTEMA");
			}
		} catch (SQLException e) {
			util.MensagemModeloError("(ERRO 0005) - (MODELO FORNECEDOR)\n"
					+ "RECOMENDAÇÕES: \n" + "- CONSULTAR O MANUAL DO SISTEMA\n"
					+ "- CONTRATAR O PROGRAMADOR DO SISTEMA");

		} catch (java.lang.NullPointerException e) {
			util.MensagemModeloError("(ERRO 0006) - (MODELO FORNECEDOR)\n"
					+ "RECOMENDAÇÕES: \n" + "- CONSULTAR O MANUAL DO SISTEMA\n"
					+ "- CONTRATAR O PROGRAMADOR DO SISTEMA");
		}

	}

	/**
	 * FUNÇÃO DO BOTÃO DE ADD RAMO EMPRESARIAL
	 * 
	 * @author JOAO DE SOUZA NETO
	 *
	 * */
	public void BotaoCadastrarRamoEmpreresarial() {
		String ramoEmpresarial = CadastrarRamoEmpresarial.jtfCampoRamoEmpresarial
				.getText();
		ModeloTestarItem util = new ModeloTestarItem();
		ModeloMensagem utilMensagem = new ModeloMensagem();

		String sql = "select * from ramoEmpresarialFornecedor where ramoEmpresarial like '"
				+ ramoEmpresarial + "'";

		if (ramoEmpresarial.equals("")) {
			CadastrarRamoEmpresarial.jlRamoEmpresarial.setForeground(new Color(
					149, 2, 5));

			CadastrarRamoEmpresarial.jtfCampoRamoEmpresarial.requestFocus();

			utilMensagem
					.MensagemModeloWarning("CAMPO COM ASTERISCO OBRIGATÓRIO");

		} else

		if (util.TestarItemExistente(Conexao.abrirConexao(), sql) == true) {
			utilMensagem
					.MensagemModeloWarning("RAMO EMPRESARIAL JÁ CADASTRADO NO SISTEMA");
			Conexao.FecharConexao(Conexao.abrirConexao());

		} else {

			Fornecedor domain = new Fornecedor();
			domain.setRamoEmpresarial(ramoEmpresarial);
			InserirRamoEmpresarial(domain, Conexao.abrirConexao());
			Conexao.FecharConexao(Conexao.abrirConexao());
		}

	}

	/**
	 * CAPTURA RAMO EMPRESARIAIS JÁ CADASTRADOS NO BANCO
	 * 
	 * @author JOAO DE SOUZA NETO
	 *
	 * */

	public List<Fornecedor> ListarComboRamoEmpresarial(Connection con) {

		ModeloMensagem util = new ModeloMensagem();

		String sql = "Select distinct ramoEmpresarial from ramoEmpresarialFornecedor ORDER BY ramoEmpresarial";
		List<Fornecedor> lista = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Fornecedor domain = new Fornecedor();
					domain.setRamoEmpresarial(rs.getString(1));
					lista.add(domain);
				}
				return lista;

			} else {
				util.MensagemModeloError("(ERRO 0007) - (MODELO FORNECEDOR)\n"
						+ "RECOMENDAÇÕES: \n"
						+ "- CONSULTAR O MANUAL DO SISTEMA\n"
						+ "- CONTRATAR O PROGRAMADOR DO SISTEMA");
				return null;
			}

		} catch (SQLException e) {
			util.MensagemModeloError("(ERRO 0008) - (MODELO FORNECEDOR)\n"
					+ "RECOMENDAÇÕES: \n" + "- CONSULTAR O MANUAL DO SISTEMA\n"
					+ "- CONTRATAR O PROGRAMADOR DO SISTEMA");
			return null;
		}
	}

	/**
	 * LISTA OS RAMO EMPRESARIAS NO COMBO SOLICITADO
	 * 
	 * @author JOAO DE SOUZA NETO
	 *
	 * */
	public void AtualizaComboRamoEmpresarial(JComboBox<String> combo) {
		combo.removeAllItems();
		combo.addItem("");
		List<Fornecedor> lista = new ArrayList<>();

		lista = ListarComboRamoEmpresarial(Conexao.abrirConexao());
		for (Fornecedor domain : lista) {
			combo.addItem(domain.getRamoEmpresarial());
		}
		Conexao.FecharConexao(Conexao.abrirConexao());
	}

	/**
	 * CAPTURA FORNECEDOR DE ACORDO COM O CÓDIGO DIGITADO
	 * 
	 * @author JOAO DE SOUZA NETO
	 *
	 * */
	public void CapturarFornecedor(Fornecedor domain, Connection con) {
		String co = AtualizarFornecedor.jtfCampoCodigo.getText();
		int cod = Integer.parseInt(co);
		String sql = "select * from fornecedor where id =" + cod + "";

		ModeloMensagem util = new ModeloMensagem();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					domain.setId(rs.getLong(1));
					domain.setRazaoSocial(rs.getString(2));
					domain.setNomeFantasia(rs.getString(3));
					domain.setCpfCnpj(rs.getString(4));
					domain.setInscricaoEstadual(rs.getString(5));
					domain.setInscricaoMunicipal(rs.getString(6));
					domain.setRamoEmpresarial(rs.getString(7));
					domain.setStatus(rs.getString(8));
					domain.setCep(rs.getString(9));
					domain.setEndereco(rs.getString(10));
					domain.setNumero(rs.getString(11));
					domain.setComplemento(rs.getString(12));
					domain.setBairro(rs.getString(13));
					domain.setCidade(rs.getString(14));
					domain.setUf(rs.getString(15));
					domain.setPaís(rs.getString(16));
					domain.setContato(rs.getString(17));
					domain.setTelefone(rs.getString(18));
					domain.setCelular(rs.getString(19));
					domain.setFoneFax(rs.getString(20));
					domain.setEmail(rs.getString(21));
					domain.setDescricao(rs.getString(22));
				}

			} else {
				util.MensagemModeloError("(ERRO 0009) - (MODELO FORNECEDOR)\n"
						+ "RECOMENDAÇÕES: \n"
						+ "- CONSULTAR O MANUAL DO SISTEMA\n"
						+ "- CONTRATAR O PROGRAMADOR DO SISTEMA");

			}
		} catch (SQLException e) {
			util.MensagemModeloError("(ERRO 0010) - (MODELO FORNECEDOR)\n"
					+ "RECOMENDAÇÕES: \n" + "- CONSULTAR O MANUAL DO SISTEMA\n"
					+ "- CONTRATAR O PROGRAMADOR DO SISTEMA");
		}

	}

	/**
	 * ALTERAÇÃO DAS INFORMAÇÕES DO FORNECEDOR NO BANCO DE DADOS
	 * 
	 * @author JOAO DE SOUZA NETO
	 *
	 * */
	public void AlterarFornecedor(Fornecedor domain, Connection con) {

		ModeloMensagem util = new ModeloMensagem();

		String sql = "update fornecedor set razaoSocial=?,nomeFantasia=?,cpfCnpj=?,inscricaoEstadual=?,"
				+ "inscricaoMunicipal=?,ramoEmpresarial=?,status=?,cep=?,endereco=?,"
				+ "numero=?,complemento=?,bairro=?,cidade=?,uf=?,pais=?,contato=?,telefone=?,celular=?,"
				+ "foneFax=?,email=?,descricao=? where id = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, domain.getRazaoSocial());
			ps.setString(2, domain.getNomeFantasia());
			ps.setString(3, domain.getCpfCnpj());
			ps.setString(4, domain.getInscricaoEstadual());
			ps.setString(5, domain.getInscricaoMunicipal());
			ps.setString(6, domain.getRamoEmpresarial());
			ps.setString(7, domain.getStatus());
			ps.setString(8, domain.getCep());
			ps.setString(9, domain.getEndereco());
			ps.setString(10, domain.getNumero());
			ps.setString(11, domain.getComplemento());
			ps.setString(12, domain.getBairro());
			ps.setString(13, domain.getCidade());
			ps.setString(14, domain.getUf());
			ps.setString(15, domain.getPaís());
			ps.setString(16, domain.getContato());
			ps.setString(17, domain.getTelefone());
			ps.setString(18, domain.getCelular());
			ps.setString(19, domain.getFoneFax());
			ps.setString(20, domain.getEmail());
			ps.setString(21, domain.getDescricao());
			ps.setLong(22, domain.getId());

			if (ps.executeUpdate() > 0) {

				util.MensagemModeloInformation("ATUALIZAÇÃO DE FORNECEDOR REALIZADA COM SUCESSO");

				Conexao.FecharConexao(Conexao.abrirConexao());
				AtualizarFornecedor.jtfCampoBairro.setText("");
				AtualizarFornecedor.jtfCampoCelular.setText("");
				AtualizarFornecedor.jtfCampoCidade.setText("");
				AtualizarFornecedor.jtfCampoComplemento.setText("");
				AtualizarFornecedor.jtfCampoContato.setText("");
				AtualizarFornecedor.jtfCampoCpfCnpj.setText("");
				AtualizarFornecedor.jtfCampoEmail.setText("");
				AtualizarFornecedor.jtfCampoEndereco.setText("");
				AtualizarFornecedor.jtfCampoFoneFax.setText("");
				AtualizarFornecedor.jtfCampoInscricaoEstadual.setText("");
				AtualizarFornecedor.jtfCampoInscricaoMunicipal.setText("");
				AtualizarFornecedor.jtfCampoNomeFantasia.setText("");
				AtualizarFornecedor.jtfCampoNomeRazaoSocial.setText("");
				AtualizarFornecedor.jtfCampoNumero.setText("");
				AtualizarFornecedor.jtfCampoPaís.setText("");
				AtualizarFornecedor.jtaCampoDescricao.setText("");
				AtualizarFornecedor.jtfCampoTelefone.setText("");
				AtualizarFornecedor.jcbComboRamoEmpresarial.setSelectedItem("");
				AtualizarFornecedor.jcbComboStatus.setSelectedItem("");
				AtualizarFornecedor.jcbComboUf.setSelectedItem("");
				AtualizarFornecedor.jftfCampoCep.setText("");

				AtualizarFornecedor.jtfCampoCodigo.setText("");
				AtualizarFornecedor.jtfCampoCodigo.setEnabled(true);
				AtualizarFornecedor.jtfCampoBairro.setEnabled(false);
				AtualizarFornecedor.jtfCampoCelular.setEnabled(false);
				AtualizarFornecedor.jtfCampoCidade.setEnabled(false);
				AtualizarFornecedor.jtfCampoComplemento.setEnabled(false);
				AtualizarFornecedor.jtfCampoContato.setEnabled(false);
				AtualizarFornecedor.jtfCampoCpfCnpj.setEnabled(false);
				AtualizarFornecedor.jtfCampoEmail.setEnabled(false);
				AtualizarFornecedor.jtfCampoFoneFax.setEnabled(false);
				AtualizarFornecedor.jtfCampoInscricaoEstadual.setEnabled(false);
				AtualizarFornecedor.jtfCampoInscricaoMunicipal
						.setEnabled(false);
				AtualizarFornecedor.jtfCampoNomeFantasia.setEnabled(false);
				AtualizarFornecedor.jtfCampoNomeRazaoSocial.setEnabled(false);
				AtualizarFornecedor.jtfCampoNumero.setEnabled(false);
				AtualizarFornecedor.jtfCampoPaís.setEnabled(false);
				AtualizarFornecedor.jtaCampoDescricao.setEnabled(false);
				AtualizarFornecedor.jtfCampoTelefone.setEnabled(false);
				AtualizarFornecedor.jcbComboRamoEmpresarial.setEnabled(false);
				AtualizarFornecedor.jcbComboStatus.setEnabled(false);
				AtualizarFornecedor.jcbComboUf.setEnabled(false);
				AtualizarFornecedor.jtfCampoEndereco.setEnabled(false);
				AtualizarFornecedor.jftfCampoCep.setEnabled(false);
				AtualizarFornecedor.jbAtualizarFornecedor.setEnabled(false);
				AtualizarFornecedor.jbNovoRamoEmpresarial.setEnabled(false);

				AtualizarFornecedor.tela.dispose();
				AtualizarFornecedor.tela = null;

				try {
					AtualizaTable();

				} catch (java.lang.NullPointerException e) {
					util.MensagemModeloError("(ERRO 0011) - (MODELO FORNECEDOR)\n"
							+ "RECOMENDAÇÕES: \n"
							+ "- CONSULTAR O MANUAL DO SISTEMA\n"
							+ "- CONTRATAR O PROGRAMADOR DO SISTEMA");
				}

			} else {
				util.MensagemModeloError("(ERRO 0012) - (MODELO FORNECEDOR)\n"
						+ "RECOMENDAÇÕES: \n"
						+ "- CONSULTAR O MANUAL DO SISTEMA\n"
						+ "- CONTRATAR O PROGRAMADOR DO SISTEMA");
			}
		} catch (SQLException e) {
			util.MensagemModeloError("(ERRO 0013) - (MODELO FORNECEDOR)\n"
					+ "RECOMENDAÇÕES: \n" + "- CONSULTAR O MANUAL DO SISTEMA\n"
					+ "- CONTRATAR O PROGRAMADOR DO SISTEMA");
		}

	}

	/**
	 * PREENCHIMENTO DOS CAMPOS COM AS INFORMAÇÕES DO FORNECEDOR CAPTURADO
	 * 
	 * @author JOAO DE SOUZA NETO
	 *
	 * */
	public void InseririDadosFornecedor(Fornecedor f) {
		AtualizarFornecedor.jtfCampoBairro.setEnabled(true);
		AtualizarFornecedor.jtfCampoCelular.setEnabled(true);
		AtualizarFornecedor.jtfCampoCidade.setEnabled(true);
		AtualizarFornecedor.jtfCampoComplemento.setEnabled(true);
		AtualizarFornecedor.jtfCampoContato.setEnabled(true);
		AtualizarFornecedor.jtfCampoCpfCnpj.setEnabled(true);
		AtualizarFornecedor.jtfCampoEmail.setEnabled(true);
		AtualizarFornecedor.jtfCampoFoneFax.setEnabled(true);
		AtualizarFornecedor.jtfCampoInscricaoEstadual.setEnabled(true);
		AtualizarFornecedor.jtfCampoInscricaoMunicipal.setEnabled(true);
		AtualizarFornecedor.jtfCampoNomeFantasia.setEnabled(true);
		AtualizarFornecedor.jtfCampoNomeRazaoSocial.setEnabled(true);
		AtualizarFornecedor.jtfCampoNumero.setEnabled(true);
		AtualizarFornecedor.jtfCampoPaís.setEnabled(true);
		AtualizarFornecedor.jtaCampoDescricao.setEnabled(true);
		AtualizarFornecedor.jtfCampoTelefone.setEnabled(true);
		AtualizarFornecedor.jcbComboRamoEmpresarial.setEnabled(true);
		AtualizarFornecedor.jcbComboStatus.setEnabled(true);
		AtualizarFornecedor.jcbComboUf.setEnabled(true);
		AtualizarFornecedor.jtfCampoEndereco.setEnabled(true);
		AtualizarFornecedor.jftfCampoCep.setEnabled(true);
		AtualizarFornecedor.jbAtualizarFornecedor.setEnabled(true);
		AtualizarFornecedor.jbNovoRamoEmpresarial.setEnabled(true);

		AtualizarFornecedor.jtfCampoBairro.setText("" + f.getBairro());
		AtualizarFornecedor.jtfCampoCelular.setText("" + f.getCelular());
		AtualizarFornecedor.jtfCampoCidade.setText("" + f.getCidade());
		AtualizarFornecedor.jtfCampoComplemento
				.setText("" + f.getComplemento());
		AtualizarFornecedor.jtfCampoContato.setText("" + f.getContato());
		AtualizarFornecedor.jtfCampoCpfCnpj.setText("" + f.getCpfCnpj());
		AtualizarFornecedor.jtfCampoEmail.setText("" + f.getEmail());
		AtualizarFornecedor.jtfCampoEndereco.setText("" + f.getEndereco());
		AtualizarFornecedor.jtfCampoFoneFax.setText("" + f.getFoneFax());
		AtualizarFornecedor.jtfCampoInscricaoEstadual.setText(""
				+ f.getInscricaoEstadual());
		AtualizarFornecedor.jtfCampoInscricaoMunicipal.setText(""
				+ f.getInscricaoMunicipal());
		AtualizarFornecedor.jtfCampoNomeFantasia.setText(""
				+ f.getNomeFantasia());
		AtualizarFornecedor.jtfCampoNomeRazaoSocial.setText(""
				+ f.getRazaoSocial());
		AtualizarFornecedor.jtfCampoNumero.setText("" + f.getNumero());
		AtualizarFornecedor.jtfCampoPaís.setText("" + f.getPaís());
		AtualizarFornecedor.jtaCampoDescricao.setText("" + f.getDescricao());
		AtualizarFornecedor.jtfCampoTelefone.setText("" + f.getTelefone());
		AtualizarFornecedor.jcbComboRamoEmpresarial.setSelectedItem(""
				+ f.getRamoEmpresarial());
		AtualizarFornecedor.jcbComboStatus.setSelectedItem("" + f.getStatus());
		AtualizarFornecedor.jcbComboUf.setSelectedItem("" + f.getUf());
		AtualizarFornecedor.jftfCampoCep.setText("" + f.getCep());

		AtualizarFornecedor.cpfCnpj = AtualizarFornecedor.jtfCampoCpfCnpj
				.getText();

	}

	/**
	 * FUNÇÃO DO BOTÃO OK - ATUALIZAR FORNECEDOR
	 * 
	 * @author JOAO DE SOUZA NETO
	 *
	 * */
	public void AcaoDoBotaoOkFornecedor() {
		String ok = AtualizarFornecedor.jtfCampoCodigo.getText();
		ModeloMensagem utilMensagem = new ModeloMensagem();

		if (ok.equals("")) {
			utilMensagem
					.MensagemModeloWarning("DIGITE O CÓDIGO PARA ATUALIZAR");

		} else {
			Fornecedor domain = new Fornecedor();
			Long cod = Long.parseLong(ok);
			String sql = "select * from fornecedor where id = " + cod + "";
			ModeloTestarItem util = new ModeloTestarItem();

			try {
				if (util.TestarItemExistente(Conexao.abrirConexao(), sql) == false) {
					utilMensagem.MensagemModeloWarning("CÓDIGO NÃO ENCONTRADO");
					Conexao.FecharConexao(Conexao.abrirConexao());

				} else if (util
						.TestarItemExistente(Conexao.abrirConexao(), sql) == true) {
					AtualizarFornecedor.jtfCampoBairro.setText("");
					AtualizarFornecedor.jtfCampoCelular.setText("");
					AtualizarFornecedor.jtfCampoCidade.setText("");
					AtualizarFornecedor.jtfCampoComplemento.setText("");
					AtualizarFornecedor.jtfCampoContato.setText("");
					AtualizarFornecedor.jtfCampoCpfCnpj.setText("");
					AtualizarFornecedor.jtfCampoEmail.setText("");
					AtualizarFornecedor.jtfCampoEndereco.setText("");
					AtualizarFornecedor.jtfCampoFoneFax.setText("");
					AtualizarFornecedor.jtfCampoInscricaoEstadual.setText("");
					AtualizarFornecedor.jtfCampoInscricaoMunicipal.setText("");
					AtualizarFornecedor.jtfCampoNomeFantasia.setText("");
					AtualizarFornecedor.jtfCampoNomeRazaoSocial.setText("");
					AtualizarFornecedor.jtfCampoNumero.setText("");
					AtualizarFornecedor.jtfCampoPaís.setText("");
					AtualizarFornecedor.jtaCampoDescricao.setText("");
					AtualizarFornecedor.jtfCampoTelefone.setText("");
					AtualizarFornecedor.jcbComboRamoEmpresarial
							.setSelectedItem("");
					AtualizarFornecedor.jcbComboStatus.setSelectedItem("");
					AtualizarFornecedor.jcbComboUf.setSelectedItem("");
					AtualizarFornecedor.jftfCampoCep.setText("");

					CapturarFornecedor(domain, Conexao.abrirConexao());
					Conexao.FecharConexao(Conexao.abrirConexao());
					InseririDadosFornecedor(domain);

					AtualizarFornecedor.jtfCampoCodigo.setEnabled(false);

				}
			} catch (NumberFormatException e) {
				utilMensagem
						.MensagemModeloError("(ERRO 0014) - (MODELO FORNECEDOR)\n"
								+ "RECOMENDAÇÕES: \n"
								+ "- CONSULTAR O MANUAL DO SISTEMA\n"
								+ "- CONTRATAR O PROGRAMADOR DO SISTEMA");

			}

		}

	}

	/**
	 * AÇÃO DO BOTÃO ATUALIZAR FORNECEDOR
	 * 
	 * @author JOAO DE SOUZA NETO
	 *
	 * */
	public void AcaoDoBotaoAlterarFornecedor() {
		String codigo = AtualizarFornecedor.jtfCampoCodigo.getText();
		String razaoSocial = AtualizarFornecedor.jtfCampoNomeRazaoSocial
				.getText();
		String nomeFantasia = AtualizarFornecedor.jtfCampoNomeFantasia
				.getText();
		String cpfCnpj = AtualizarFornecedor.jtfCampoCpfCnpj.getText();
		String inscricaoEstadual = AtualizarFornecedor.jtfCampoInscricaoEstadual
				.getText();
		String inscricaoMunicipal = AtualizarFornecedor.jtfCampoInscricaoMunicipal
				.getText();
		String endereco = AtualizarFornecedor.jtfCampoEndereco.getText();
		String numero = AtualizarFornecedor.jtfCampoNumero.getText();
		String complemento = AtualizarFornecedor.jtfCampoComplemento.getText();
		String bairro = AtualizarFornecedor.jtfCampoBairro.getText();
		String cidade = AtualizarFornecedor.jtfCampoCidade.getText();
		String país = AtualizarFornecedor.jtfCampoPaís.getText();
		String telefone = AtualizarFornecedor.jtfCampoTelefone.getText();
		String celular = AtualizarFornecedor.jtfCampoCelular.getText();
		String cep = AtualizarFornecedor.jftfCampoCep.getText();
		String foneFax = AtualizarFornecedor.jtfCampoFoneFax.getText();
		String email = AtualizarFornecedor.jtfCampoEmail.getText();
		String descricao = AtualizarFornecedor.jtaCampoDescricao.getText();
		String contato = AtualizarFornecedor.jtfCampoContato.getText();
		String ramoEmpresarial = AtualizarFornecedor.jcbComboRamoEmpresarial
				.getSelectedItem().toString();
		String status = AtualizarFornecedor.jcbComboStatus.getSelectedItem()
				.toString();
		String uf = AtualizarFornecedor.jcbComboUf.getSelectedItem().toString();

		String co = AtualizarFornecedor.jtfCampoCpfCnpj.getText();
		String cpfCnpj2 = AtualizarFornecedor.cpfCnpj;

		String sql = "select * from fornecedor where cpfCnpj like '" + co
				+ "' and cpfCnpj != '" + cpfCnpj2 + "'";

		ModeloTestarItem utilTestarItem = new ModeloTestarItem();
		ModeloMensagem util = new ModeloMensagem();

		String cep1 = cep.substring(0, 1);
		String cep2 = cep.substring(1, 2);
		String cep3 = cep.substring(2, 3);
		String cep4 = cep.substring(3, 4);
		String cep5 = cep.substring(4, 5);
		String cep6 = cep.substring(6, 7);
		String cep7 = cep.substring(7, 8);
		String cep8 = cep.substring(8, 9);

		if (nomeFantasia.equals("")) {
			AtualizarFornecedor.jlNomeFantasia.setForeground(new Color(149, 2,
					5));
			AtualizarFornecedor.jlCpfCnpj.setForeground(Color.BLACK);
			AtualizarFornecedor.jlContato.setForeground(Color.BLACK);
			AtualizarFornecedor.jlRamoEmpresarial.setForeground(Color.BLACK);
			AtualizarFornecedor.jlStatus.setForeground(Color.BLACK);
			AtualizarFornecedor.jlCep.setForeground(Color.BLACK);
			AtualizarFornecedor.jtfCampoNomeFantasia.requestFocus();

			util.MensagemModeloWarning("CAMPOS COM ASTERISCO SÃO OBRIGATÓRIOS");

		} else if (cpfCnpj.equals("")) {
			AtualizarFornecedor.jlCpfCnpj.setForeground(new Color(149, 2, 5));
			AtualizarFornecedor.jlNomeFantasia.setForeground(Color.BLACK);
			AtualizarFornecedor.jlContato.setForeground(Color.BLACK);
			AtualizarFornecedor.jlStatus.setForeground(Color.BLACK);
			AtualizarFornecedor.jlRamoEmpresarial.setForeground(Color.BLACK);
			AtualizarFornecedor.jlCep.setForeground(Color.BLACK);
			AtualizarFornecedor.jtfCampoCpfCnpj.requestFocus();

			util.MensagemModeloWarning("CAMPOS COM ASTERISCO SÃO OBRIGATÓRIOS");

		} else if (ramoEmpresarial.equals("")) {
			AtualizarFornecedor.jlRamoEmpresarial.setForeground(new Color(149,
					2, 5));
			AtualizarFornecedor.jlCpfCnpj.setForeground(Color.BLACK);
			AtualizarFornecedor.jlContato.setForeground(Color.BLACK);
			AtualizarFornecedor.jlNomeFantasia.setForeground(Color.BLACK);
			AtualizarFornecedor.jlStatus.setForeground(Color.BLACK);
			AtualizarFornecedor.jlCep.setForeground(Color.BLACK);
			AtualizarFornecedor.jcbComboRamoEmpresarial.requestFocus();

			util.MensagemModeloWarning("CAMPOS COM ASTERISCO SÃO OBRIGATÓRIOS");

		} else if (contato.equals("")) {
			AtualizarFornecedor.jlContato.setForeground(new Color(149, 2, 5));
			AtualizarFornecedor.jlCpfCnpj.setForeground(Color.BLACK);
			AtualizarFornecedor.jlNomeFantasia.setForeground(Color.BLACK);
			AtualizarFornecedor.jlRamoEmpresarial.setForeground(Color.BLACK);
			AtualizarFornecedor.jlStatus.setForeground(Color.BLACK);
			AtualizarFornecedor.jlCep.setForeground(Color.BLACK);
			AtualizarFornecedor.jtfCampoContato.requestFocus();

			util.MensagemModeloWarning("CAMPOS COM ASTERISCO SÃO OBRIGATÓRIOS");

		} else if (status.equals("")) {
			AtualizarFornecedor.jlStatus.setForeground(new Color(149, 2, 5));
			AtualizarFornecedor.jlCpfCnpj.setForeground(Color.BLACK);
			AtualizarFornecedor.jlNomeFantasia.setForeground(Color.BLACK);
			AtualizarFornecedor.jlRamoEmpresarial.setForeground(Color.BLACK);
			AtualizarFornecedor.jlContato.setForeground(Color.BLACK);
			AtualizarFornecedor.jlCep.setForeground(Color.BLACK);
			AtualizarFornecedor.jcbComboStatus.requestFocus();

			util.MensagemModeloWarning("CAMPOS COM ASTERISCO SÃO OBRIGATÓRIOS");

		} else if (AtualizarFornecedor.jftfCampoCep.getText().trim().length() > 1) {

			if (cep1.equals(" ") || cep2.equals(" ") || cep3.equals(" ")
					|| cep4.equals(" ") || cep5.equals(" ") || cep6.equals(" ")
					|| cep7.equals(" ") || cep8.equals(" ")) {
				AtualizarFornecedor.jlCpfCnpj.setForeground(Color.BLACK);
				AtualizarFornecedor.jlContato.setForeground(Color.BLACK);
				AtualizarFornecedor.jlNomeFantasia.setForeground(Color.BLACK);
				AtualizarFornecedor.jlRamoEmpresarial
						.setForeground(Color.BLACK);
				AtualizarFornecedor.jlStatus.setForeground(Color.BLACK);
				AtualizarFornecedor.jlCep.setForeground(new Color(149, 2, 5));
				AtualizarFornecedor.jftfCampoCep.requestFocus();

				util.MensagemModeloWarning("CAMPO (CEP) COM PREENCHIMENTO INCOMPLETO");

			} else

			if (utilTestarItem.TestarItemExistente(Conexao.abrirConexao(), sql) == true) {

				util.MensagemModeloWarning("FORNECEDOR COM MESMO CPF/CNPJ JÁ CADASTRADO NO SISTEMA");

				Conexao.FecharConexao(Conexao.abrirConexao());

			}

			else if (AtualizarFornecedor.jftfCampoCep.getText().trim().length() == 9) {
				Long cod = Long.parseLong(codigo);
				Fornecedor domain = new Fornecedor();
				domain.setId(cod);
				domain.setRamoEmpresarial(ramoEmpresarial);
				domain.setBairro(bairro);
				domain.setCelular(celular);
				domain.setCep(cep);
				domain.setCidade(cidade);
				domain.setComplemento(complemento);
				domain.setContato(contato);
				domain.setCpfCnpj(cpfCnpj);
				domain.setEmail(email);
				domain.setEndereco(endereco);
				domain.setFoneFax(foneFax);
				domain.setInscricaoEstadual(inscricaoEstadual);
				domain.setInscricaoMunicipal(inscricaoMunicipal);
				domain.setNomeFantasia(nomeFantasia);
				domain.setNumero(numero);
				domain.setPaís(país);
				domain.setRazaoSocial(razaoSocial);
				domain.setDescricao(descricao);
				domain.setStatus(status);
				domain.setTelefone(telefone);
				domain.setUf(uf);

				AlterarFornecedor(domain, Conexao.abrirConexao());
				Conexao.FecharConexao(Conexao.abrirConexao());

			}

		}

		else

		if (utilTestarItem.TestarItemExistente(Conexao.abrirConexao(), sql) == true) {
			util.MensagemModeloWarning("FORNECEDOR COM MESMO CPF/CNPJ JÁ CADASTRADO NO SISTEMA");
			Conexao.FecharConexao(Conexao.abrirConexao());

		} else {
			Long cod = Long.parseLong(codigo);
			Fornecedor domain = new Fornecedor();
			domain.setId(cod);
			domain.setRamoEmpresarial(ramoEmpresarial);
			domain.setBairro(bairro);
			domain.setCelular(celular);
			domain.setCep(cep);
			domain.setCidade(cidade);
			domain.setComplemento(complemento);
			domain.setContato(contato);
			domain.setCpfCnpj(cpfCnpj);
			domain.setEmail(email);
			domain.setEndereco(endereco);
			domain.setFoneFax(foneFax);
			domain.setInscricaoEstadual(inscricaoEstadual);
			domain.setInscricaoMunicipal(inscricaoMunicipal);
			domain.setNomeFantasia(nomeFantasia);
			domain.setNumero(numero);
			domain.setPaís(país);
			domain.setRazaoSocial(razaoSocial);
			domain.setDescricao(descricao);
			domain.setStatus(status);
			domain.setTelefone(telefone);
			domain.setUf(uf);

			AlterarFornecedor(domain, Conexao.abrirConexao());
			Conexao.FecharConexao(Conexao.abrirConexao());

		}
	}

	/**
	 * CAPTURAR FORNECEDORES NO BANCO DE ACORDO COM OS FILTROS
	 * 
	 * @author JOAO DE SOUZA NETO
	 *
	 * */
	public List<Fornecedor> ListarFornecedor(Connection con,
			String razaoSocial, String nomeFantasia, String cpfCnpj,
			String atividade, String status, String cidade, String estado,
			String contato, String email) {
		String sql = "select id,razaoSocial,nomeFantasia,cpfCnpj,ramoEmpresarial,status,"
				+ "contato"
				+ " from fornecedor where razaoSocial like '"
				+ razaoSocial
				+ "%' and nomeFantasia like '"
				+ nomeFantasia
				+ "%' and cpfCnpj like '"
				+ cpfCnpj
				+ "%' and ramoEmpresarial like '"
				+ atividade
				+ "%' and status like '"
				+ status
				+ "%' and cidade like '"
				+ cidade
				+ "%' and uf like '"
				+ estado
				+ "%' and contato like '"
				+ contato
				+ "%' and email like '"
				+ email + "%'";
		List<Fornecedor> lista = new ArrayList<Fornecedor>();
		ModeloMensagem util = new ModeloMensagem();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Fornecedor domain = new Fornecedor();
					domain.setId(rs.getLong(1));
					domain.setRazaoSocial(rs.getString(2));
					domain.setNomeFantasia(rs.getString(3));
					domain.setCpfCnpj(rs.getString(4));
					domain.setRamoEmpresarial(rs.getString(5));
					domain.setStatus(rs.getString(6));
					domain.setContato(rs.getString(7));

					lista.add(domain);
				}
				return lista;
			} else {
				util.MensagemModeloError("(ERRO 0017) - (MODELO FORNECEDOR)\n"
						+ "RECOMENDAÇÕES: \n"
						+ "- CONSULTAR O MANUAL DO SISTEMA\n"
						+ "- CONTRATAR O PROGRAMADOR DO SISTEMA");

				return null;
			}

		} catch (SQLException e) {
			util.MensagemModeloError("(ERRO 0018) - (MODELO FORNECEDOR)\n"
					+ "RECOMENDAÇÕES: \n" + "- CONSULTAR O MANUAL DO SISTEMA\n"
					+ "- CONTRATAR O PROGRAMADOR DO SISTEMA");
			return null;
		}
	}

	/**
	 * ATUALIZAR TABELA DE ACORDO COM OS FILTORS
	 * 
	 * @author JOAO DE SOUZA NETO
	 *
	 * */
	public void AtualizaTable() {
		List<Fornecedor> lista = new ArrayList<>();
		String razaoSocial = ConsultarFornecedor.jtfCampoRazaoSocial.getText();
		String nomeFantasia = ConsultarFornecedor.jtfCampoNomeFantasia
				.getText();
		String cpfCnpj = ConsultarFornecedor.jtfCampoCpfCnpj.getText();
		String ramoEmpresarial = ConsultarFornecedor.jcbComboRamoEmpresarial
				.getSelectedItem().toString();
		String status = ConsultarFornecedor.jcbComboStatus.getSelectedItem()
				.toString();
		String email = ConsultarFornecedor.jtfCampoEmail.getText();
		String cidade = ConsultarFornecedor.jtfCampoCidade.getText();
		String contato = ConsultarFornecedor.jtfCampoContato.getText();
		String estado = ConsultarFornecedor.jcbComboEstado.getSelectedItem()
				.toString();

		lista = ListarFornecedor(Conexao.abrirConexao(), razaoSocial,
				nomeFantasia, cpfCnpj, ramoEmpresarial, status, cidade, estado,
				contato, email);

		DefaultTableModel tbm = (DefaultTableModel) ConsultarFornecedor.jtTabela
				.getModel();
		while (tbm.getRowCount() > 0) {
			tbm.removeRow(0);

		}

		int i = 0;
		for (Fornecedor domain : lista) {
			tbm.addRow(new String[i]);
			ConsultarFornecedor.jtTabela.setValueAt(domain.getId(), i, 0);
			ConsultarFornecedor.jtTabela.setValueAt(domain.getRazaoSocial(), i,
					1);
			ConsultarFornecedor.jtTabela.setValueAt(domain.getNomeFantasia(),
					i, 2);
			ConsultarFornecedor.jtTabela.setValueAt(domain.getCpfCnpj(), i, 3);
			ConsultarFornecedor.jtTabela.setValueAt(domain.getContato(), i, 4);
			ConsultarFornecedor.jtTabela.setValueAt(domain.getStatus(), i, 5);
			ConsultarFornecedor.jtTabela.setValueAt(
					domain.getRamoEmpresarial(), i, 6);

			i++;

		}
		Conexao.FecharConexao(Conexao.abrirConexao());
		ConsultarFornecedor.jtfCampoCodigoDeletar.setText("");
		ConsultarFornecedor.jtfCampoCpfCnpjDeletar.setText("");
		ConsultarFornecedor.jtfCampoNomeFantasiaDeletar.setText("");
	}

	/**
	 * PREENCHIMENTO DOS CAMPOS DE ACORDO COM O ITEM SELECIONADO NA TABELA
	 * 
	 * @author JOAO DE SOUZA NETO
	 *
	 * */
	public void selecionarItens() {
		int seleciona = ConsultarFornecedor.jtTabela.getSelectedRow();
		ConsultarFornecedor.jtfCampoCodigoDeletar
				.setText(ConsultarFornecedor.jtTabela.getModel()
						.getValueAt(seleciona, 0).toString());
		ConsultarFornecedor.jtfCampoNomeFantasiaDeletar
				.setText(ConsultarFornecedor.jtTabela.getModel()
						.getValueAt(seleciona, 2).toString());
		ConsultarFornecedor.jtfCampoCpfCnpjDeletar
				.setText(ConsultarFornecedor.jtTabela.getModel()
						.getValueAt(seleciona, 3).toString());
	}

	/**
	 * EXCLUSÃO DO FORNECEDOR DO BANCO DE DADOS
	 * 
	 * @author JOAO DE SOUZA NETO
	 *
	 * */
	public void ExcluirFornecedor(Connection con, Fornecedor domain) {

		String codigo = ConsultarFornecedor.jtfCampoCodigoDeletar.getText();
		Long codigoInt = Long.parseLong(codigo);

		domain.setId(codigoInt);

		String sql = "delete from fornecedor where id =?";
		ModeloMensagem util = new ModeloMensagem();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, domain.getId());

			if (ps.executeUpdate() > 0) {
				util.MensagemModeloInformation("DELETADO COM SUCESSO");

				AtualizaTable();
			} else {
				util.MensagemModeloError("(ERRO 0019) - (MODELO FORNECEDOR)\n"
						+ "RECOMENDAÇÕES: \n"
						+ "- CONSULTAR O MANUAL DO SISTEMA\n"
						+ "- CONTRATAR O PROGRAMADOR DO SISTEMA");
			}
		} catch (SQLException e) {
			util.MensagemModeloError("(ERRO 0020) - (MODELO FORNECEDOR)\n"
					+ "RECOMENDAÇÕES: \n" + "- CONSULTAR O MANUAL DO SISTEMA\n"
					+ "- CONTRATAR O PROGRAMADOR DO SISTEMA");
		}
	}

	/**
	 * FUNÇÃO DO BOTÃO DELETAR FORNECEDOR
	 * 
	 * @author JOAO DE SOUZA NETO
	 *
	 * */
	public void AcaodoBotaoDeletarFornecedor() {
		ModeloMensagem util = new ModeloMensagem();
		try {
			Fornecedor domain = new Fornecedor();
			String nomeFantasia = ConsultarFornecedor.jtfCampoNomeFantasiaDeletar
					.getText();
			String codigo = ConsultarFornecedor.jtfCampoCodigoDeletar.getText();
			String cpfCnpj = ConsultarFornecedor.jtfCampoCpfCnpjDeletar
					.getText();

			if (codigo.equals("")) {
				util.MensagemModeloWarning("NENHUM ITEM SELECIONADO PARA EXCLUSÃO");

			} else {
				int b = JOptionPane.showConfirmDialog(null,
						"DESEJA REALMENTE EXCLUIR?" + "\n (" + nomeFantasia
								+ ")" + "\n CÓDIGO: (" + codigo + ")"
								+ "\n CPF/CNPJ: (" + cpfCnpj + ")",
						"IMPERIUM C.E.V 1.0", JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				if (b == 0) {
					ExcluirFornecedor(Conexao.abrirConexao(), domain);
					Conexao.FecharConexao(Conexao.abrirConexao());
				}
			}
		} catch (NullPointerException e) {
			util.MensagemModeloError("(ERRO 0021) - (MODELO FORNECEDOR)\n"
					+ "RECOMENDAÇÕES: \n" + "- CONSULTAR O MANUAL DO SISTEMA\n"
					+ "- CONTRATAR O PROGRAMADOR DO SISTEMA");
		}

	}

	/**
	 * CAPTURAR FORNECEDOR DE ACORDO COM O ITEM SELECIONADO NA TABELA
	 * 
	 * @author JOAO DE SOUZA NETO
	 *
	 * */
	public void ListarFornecedorFicha(Fornecedor domain, Connection con) {
		String co = ConsultarFornecedor.jtfCampoCodigoDeletar.getText();
		int cod = Integer.parseInt(co);
		String sql = "select * from fornecedor where id =" + cod + "";
		ModeloMensagem util = new ModeloMensagem();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					domain.setId(rs.getLong(1));
					domain.setRazaoSocial(rs.getString(2));
					domain.setNomeFantasia(rs.getString(3));
					domain.setCpfCnpj(rs.getString(4));
					domain.setInscricaoEstadual(rs.getString(5));
					domain.setInscricaoMunicipal(rs.getString(6));
					domain.setRamoEmpresarial(rs.getString(7));
					domain.setStatus(rs.getString(8));
					domain.setCep(rs.getString(9));
					domain.setEndereco(rs.getString(10));
					domain.setNumero(rs.getString(11));
					domain.setComplemento(rs.getString(12));
					domain.setBairro(rs.getString(13));
					domain.setCidade(rs.getString(14));
					domain.setUf(rs.getString(15));
					domain.setPaís(rs.getString(16));
					domain.setContato(rs.getString(17));
					domain.setTelefone(rs.getString(18));
					domain.setCelular(rs.getString(19));
					domain.setFoneFax(rs.getString(20));
					domain.setEmail(rs.getString(21));
					domain.setDescricao(rs.getString(22));
				}

			} else {
				util.MensagemModeloError("(ERRO 0022) - (MODELO FORNECEDOR)\n"
						+ "RECOMENDAÇÕES: \n"
						+ "- CONSULTAR O MANUAL DO SISTEMA\n"
						+ "- CONTRATAR O PROGRAMADOR DO SISTEMA");

			}
		} catch (SQLException e) {
			util.MensagemModeloError("(ERRO 0023) - (MODELO FORNECEDOR)\n"
					+ "RECOMENDAÇÕES: \n" + "- CONSULTAR O MANUAL DO SISTEMA\n"
					+ "- CONTRATAR O PROGRAMADOR DO SISTEMA");
		}

	}

	/**
	 * FUNÇÃO DO BOTÃO GERAR FICHA DE CADASTRO DE FORNECEDOR
	 * 
	 * @author JOAO DE SOUZA NETO
	 *
	 * */
	public void RelatorioFicha() {

		ModeloMensagem util = new ModeloMensagem();

		// CRIAÇÃO DO DOCUMENTO
		try {
			// String caminho = null;
			Rectangle layout = new Rectangle(PageSize.A4);
			layout.setBackgroundColor(new BaseColor(247, 249, 251));

			Fornecedor domain = new Fornecedor();

			Document document = new Document(layout);
			Font f = new Font(FontFamily.TIMES_ROMAN, 18.0f, Font.BOLD,
					new BaseColor(19, 33, 47));
			Font f2 = new Font(FontFamily.TIMES_ROMAN, 18.0f, Font.BOLD,
					new BaseColor(19, 33, 47));
			Font f3 = new Font(FontFamily.TIMES_ROMAN, 16.0f, Font.NORMAL,
					new BaseColor(19, 33, 47));
			Font f4 = new Font(FontFamily.TIMES_ROMAN, 18.0f, Font.BOLD,
					new BaseColor(232, 230, 230));
			Font f5 = new Font(FontFamily.UNDEFINED, 20.0f, Font.BOLD,
					new BaseColor(19, 33, 47));

			ListarFornecedorFicha(domain, Conexao.abrirConexao());

			JFileChooser jFileChooser = new JFileChooser();

			// SETA PARA SELECIONAR APENAS OS ARQUIVOS
			jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

			// DESABILITA TODOS OS TIPOS DE ARQUIVOS
			jFileChooser.setAcceptAllFileFilterUsed(false);

			// FILTRA POR EXTENSÃO
			jFileChooser.setFileFilter(new FileFilter() {
				@Override
				public String getDescription() {
					return "ARQUIVO PDF";
				}

				@Override
				public boolean accept(File f) {
					return f.getName().toLowerCase().endsWith(".pdf");
				}
			});

			// MOSTRA JANELA PARA SALVAR
			int acao = jFileChooser.showSaveDialog(null);

			// EXECUTA AÇÃO CONFROME OPÇÃO SELECIONADA
			if (acao == JFileChooser.APPROVE_OPTION) {

				int b = JOptionPane
						.showConfirmDialog(
								null,
								"DESEJA CONFIRMAR CRIAÇÃO DA FICHA DE CADASTRO? \n"
										+ "(OBS):\n"
										+ "(ARQUIVOS COM MESMA NOMECLATURA SERÃO AUTOMATICAMENTE SUBSTÍTUIDOS)",
								"IMPERIUM C.E.V 1.0",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE);
				if (b == 0) {

					// ESCOLHE ARQUIVO
					File caminho = jFileChooser.getSelectedFile();

					PdfWriter.getInstance(document, new FileOutputStream(""
							+ caminho + ".pdf"));
					document.open();

					// INICIALIZAÇÃO DOS PARAGRÁFOS
					Paragraph titulo = new Paragraph(
							"CADASTRO DE FORNECEDORES", f2);
					Paragraph rodape = new Paragraph(
							"\nIMPERIUM CONTROLE DE ESTOQUE VERSÃO 1.0", f4);
					Paragraph titulo2 = new Paragraph(
							"FICHA CADASTRAL DE FORNECEDOR", f2);
					Paragraph linha = new Paragraph(
							"___________________________________________", f5);
					Paragraph tituloIdentificacao = new Paragraph(
							"DADOS DE IDENTIFICAÇÃO", f);
					Paragraph tituloLocalizacao = new Paragraph(
							"DADOS DE LOCALIZAÇÃO", f);
					Paragraph tituloContato = new Paragraph("DADOS DE CONTATO",
							f);
					Paragraph razaoSocial = new Paragraph("RAZÃO SOCIAL: "
							+ domain.getRazaoSocial(), f3);
					Paragraph nomeFantasia = new Paragraph("NOME FANTASIA: "
							+ domain.getNomeFantasia(), f3);
					Paragraph cpfCnpj = new Paragraph("CPF/CNPJ: "
							+ domain.getCpfCnpj(), f3);
					Paragraph inscricaoEstadual = new Paragraph(
							"INSCRIÇÃO ESTADUAL: "
									+ domain.getInscricaoEstadual(), f3);
					Paragraph inscricaoMuniciapl = new Paragraph(
							"INSCRIÇÃO MUNICIPAL: "
									+ domain.getInscricaoMunicipal(), f3);
					Paragraph atividade = new Paragraph("ATIVIDADE: "
							+ domain.getRamoEmpresarial(), f3);
					Paragraph status = new Paragraph("STATUS: "
							+ domain.getStatus(), f3);
					Paragraph enderecoNumero = new Paragraph("ENDEREÇO: "
							+ domain.getEndereco() + "     NÚMERO: "
							+ domain.getNumero(), f3);
					Paragraph complemento = new Paragraph("COMPLEMENTO: "
							+ domain.getComplemento(), f3);
					Paragraph bairroCidade = new Paragraph("BAIRRO: "
							+ domain.getBairro() + "     CIDADE:"
							+ domain.getCidade(), f3);
					Paragraph ufPaísCep = new Paragraph("UF: " + domain.getUf()
							+ "     PAÍS: " + domain.getPaís() + "     CEP: "
							+ domain.getCep(), f3);
					Paragraph contato = new Paragraph("CONTATO: "
							+ domain.getContato(), f3);
					Paragraph telefoneCelularFone = new Paragraph("TELEFONE: "
							+ domain.getTelefone() + "     CELULAR: "
							+ domain.getCelular(), f3);
					Paragraph email = new Paragraph("EMAIL: "
							+ domain.getEmail() + "     FONE(FAX): "
							+ domain.getFoneFax(), f3);
					Paragraph descricao = new Paragraph("DESCRIÇÃO: "
							+ domain.getDescricao(), f3);

					// ALINHAMENTO
					// tituloIdentificacao.setAlignment(Element.ALIGN_CENTER);
					titulo2.setAlignment(Element.ALIGN_CENTER);
					// tituloLocalizacao.setAlignment(Element.ALIGN_CENTER);
					titulo.setAlignment(Element.ALIGN_CENTER);
					rodape.setAlignment(Element.ALIGN_CENTER);
					// tituloContato.setAlignment(Element.ALIGN_CENTER);

					// ADICIONAMENTO NA PÁGINA
					document.add(titulo);
					document.add(titulo2);
					document.add(linha);
					document.add(tituloIdentificacao);
					document.add(razaoSocial);
					document.add(nomeFantasia);
					document.add(cpfCnpj);
					document.add(inscricaoEstadual);
					document.add(inscricaoMuniciapl);
					document.add(atividade);
					document.add(status);
					document.add(linha);
					document.add(tituloLocalizacao);
					document.add(enderecoNumero);
					document.add(complemento);
					document.add(bairroCidade);
					document.add(ufPaísCep);
					document.add(linha);
					document.add(tituloContato);
					document.add(contato);
					document.add(telefoneCelularFone);
					document.add(email);
					document.add(descricao);
					document.add(rodape);

					util.MensagemModeloInformation("FICHA GERADA COM SUCESSO");

					document.close();
				}

			} else if (acao == JFileChooser.CANCEL_OPTION) {

			} else if (acao == JFileChooser.ERROR_OPTION) {
				util.MensagemModeloError("(ERRO 0024) - (MODELO FORNECEDOR)\n"
						+ "RECOMENDAÇÕES: \n"
						+ "- CONSULTAR O MANUAL DO SISTEMA\n"
						+ "- CONTRATAR O PROGRAMADOR DO SISTEMA");
			}

		} catch (DocumentException d) {
			util.MensagemModeloError("(ERRO 0025) - (MODELO FORNECEDOR)\n"
					+ "RECOMENDAÇÕES: \n" + "- CONSULTAR O MANUAL DO SISTEMA\n"
					+ "- CONTRATAR O PROGRAMADOR DO SISTEMA");
		} catch (IOException ioe) {

			util.MensagemModeloWarning("ARQUIVO COM MESMA NOMECLATURA EM EXECUÇÃO\n"
					+ "RECOMENDAÇÕES: \n" + "- FECHAR ARQUIVO EM EXECUÇÃO");
		} catch (java.lang.NumberFormatException ioe) {
			util.MensagemModeloWarning("SELECIONE ALGUM ITEM PARA GERAÇÃO DA FICHA DE CADASTRO");
		}
	}
}
