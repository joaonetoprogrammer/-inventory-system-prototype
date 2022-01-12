package br.com.imperium.vision.create;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;

import br.com.imperium.control.ControleFornecedor;
import br.com.imperium.dao.FornecedorDAO;
import br.com.imperium.util.MeuDocument;

/**
 * CLASSE CADASTRARFORNECEDOR DO PACOTE
 * BR.COM.IMPERIUM.VISAO.CADASTRAR.CADASTROS
 * 
 * @author JOAO DE SOUZA NETO
 *
 * */
public class CadastrarFornecedor extends JDialog {

	/*
	 * SERIAL DA VERSÃO DO JAVA
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * CRIAÇÃO DOS COMPONENTES DA CLASSE
	 */
	public static JLabel jlTituloPainel, jlTituloContainer, jlNomeRazaoSocial,
			jlNomeFantasia, jlCpfCnpj, jlInscricaoEstadual,
			jlInscricaoMunicipal, jlRamoEmpresarial, jlCep, jlEndereco,
			jlNumero, jlComplemento, jlBairro, jlCidade, jlUf, jlPaís,
			jlContato, jlEmail, jlTelefone, jlCelular, jlFoneFax, jlStatus,
			jlDescricao, jlIconeFornecedor, jlIconeFornecedor2;

	public static JTextField jtfCampoNomeRazaoSocial, jtfCampoNomeFantasia,
			jtfCampoCpfCnpj, jtfCampoInscricaoEstadual,
			jtfCampoInscricaoMunicipal, jtfCampoEndereco, jtfCampoNumero,
			jtfCampoCidade, jtfCampoComplemento, jtfCampoBairro, jtfCampoPaís,
			jtfCampoContato, jtfCampoEmail, jtfCampoTelefone, jtfCampoCelular,
			jtfCampoFoneFax;

	public static JComboBox<String> jcbComboRamoEmpresarial, jcbComboUf,
			jcbComboStatus;
	public static JFormattedTextField jftfCampoCep;
	public static JTextArea jtaCampoDescricao;

	public static JButton jbFechar, jbCadastrarFornecedor,
			jbNovoRamoEmpresarial;

	public static JPanel jpCentral;

	public static MaskFormatter mfCampoCep;

	public static JDialog tela;

	Font font, font2, font3, font4, font5, font6;

	public static JScrollPane scrool;

	/**
	 * METÓDO CONSTRUTOR DA CLASSE CADASTRAR FORNECEDOR RESPONSÁVEL POR TODA A
	 * PARTE VISUAL DA TELA
	 * 
	 * @author JOAO DE SOUZA NETO
	 *
	 * */

	public CadastrarFornecedor(JDialog frame, boolean modal) {
		super(frame, modal);
	}

	public CadastrarFornecedor() {
		initComponents();
		setModal(true);
	}

	public void initComponents() {
		setUndecorated(true);
		Container c = getContentPane();
		tela = new JDialog();
		setSize(1060, 550);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		c.setBackground(Color.black);
		c.setLayout(null);
		setVisible(true);

		font = new Font("CAMBRIA", Font.PLAIN, 20);
		font2 = new Font("CAMBRIA", Font.BOLD, 22);
		font3 = new Font("CAMBRIA", Font.BOLD, 24);
		font4 = new Font("CAMBRIA", Font.PLAIN, 20);
		font5 = new Font("CAMBRIA", Font.PLAIN, 14);
		font6 = new Font("CAMBRIA", Font.PLAIN, 18);

		// LINHA DE CÓDIGO REPONSÁVEL PELO DESIGN DO LAYOUT
		try {
			UIManager
					.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			//
			e.printStackTrace();
		}

		/*
		 * INICIALIZÁVEIS
		 */

		mfCampoCep = new MaskFormatter();

		jpCentral = new JPanel();

		jlTituloPainel = new JLabel("Cadastrar Fornecedor");
		jlTituloContainer = new JLabel("Cadastro de Fornecedores");
		jlNomeRazaoSocial = new JLabel("Nome ou Razão Social: ");
		jlNomeFantasia = new JLabel("Nome Fantasia: *");
		jlCpfCnpj = new JLabel("CPF ou CNPJ: *");
		jlInscricaoEstadual = new JLabel("Inscrição Estadual:");
		jlInscricaoMunicipal = new JLabel("Inscrição Municipal:");
		jlRamoEmpresarial = new JLabel("Ramo Empresarial: *");
		jlCep = new JLabel("CEP:");
		jlEndereco = new JLabel("Endereço:");
		jlNumero = new JLabel("N°:");
		jlComplemento = new JLabel("Complemento:");
		jlBairro = new JLabel("Bairro:");
		jlCidade = new JLabel("Cidade:");
		jlUf = new JLabel("UF:");
		jlPaís = new JLabel("País:");
		jlContato = new JLabel("Nome de Contato: *");
		jlEmail = new JLabel("Email:");
		jlTelefone = new JLabel("Telefone:");
		jlCelular = new JLabel("Celular:");
		jlFoneFax = new JLabel("Fone(fax):");
		jlStatus = new JLabel("Status: *");
		jlDescricao = new JLabel("Descrição:");

		jtfCampoNomeRazaoSocial = new JTextField();
		jtfCampoNomeFantasia = new JTextField();
		jtfCampoCpfCnpj = new JTextField();
		jtfCampoInscricaoEstadual = new JTextField();
		jtfCampoInscricaoMunicipal = new JTextField();
		jcbComboRamoEmpresarial = new JComboBox<String>();
		jftfCampoCep = new JFormattedTextField();
		jtfCampoEndereco = new JTextField();
		jtfCampoNumero = new JTextField();
		jtfCampoComplemento = new JTextField();
		jtfCampoBairro = new JTextField();
		jtfCampoCidade = new JTextField();
		jcbComboUf = new JComboBox<String>();
		jtfCampoPaís = new JTextField();
		jtfCampoContato = new JTextField();
		jtfCampoEmail = new JTextField();
		jtfCampoTelefone = new JTextField();
		jtfCampoCelular = new JTextField();
		jtfCampoFoneFax = new JTextField();
		jcbComboStatus = new JComboBox<String>();
		jtaCampoDescricao = new JTextArea();

		scrool = new JScrollPane(jtaCampoDescricao);
		scrool.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		jbFechar = new JButton("X");
		jbCadastrarFornecedor = new JButton("Finalizar Cadastro");
		jbNovoRamoEmpresarial = new JButton("New");

		jlIconeFornecedor = new JLabel(new ImageIcon("res/fornecedor.png"));
		jlIconeFornecedor2 = new JLabel(new ImageIcon("res/fornecedor.png"));

		/*
		 * ADICIONAMENTO AO CONTAINER
		 */

		c.add(jpCentral);

		c.add(jbFechar);

		c.add(jlTituloContainer);

		c.add(jlIconeFornecedor);

		/*
		 * DEFINIÇÃO DE LAYOUTS
		 */

		jpCentral.setLayout(null);

		/*
		 * ACICIONAMENTO AO PAINEL CENTRAL
		 */

		jpCentral.add(jlTituloPainel);
		jpCentral.add(jlNomeRazaoSocial);
		jpCentral.add(jlNomeFantasia);
		jpCentral.add(jlCpfCnpj);
		jpCentral.add(jlInscricaoEstadual);
		jpCentral.add(jlInscricaoMunicipal);
		jpCentral.add(jlRamoEmpresarial);
		jpCentral.add(jlCep);
		jpCentral.add(jlEndereco);
		jpCentral.add(jlNumero);
		jpCentral.add(jlComplemento);
		jpCentral.add(jlBairro);
		jpCentral.add(jlCidade);
		jpCentral.add(jlUf);
		jpCentral.add(jlPaís);
		jpCentral.add(jlContato);
		jpCentral.add(jlEmail);
		jpCentral.add(jlTelefone);
		jpCentral.add(jlCelular);
		jpCentral.add(jlFoneFax);
		jpCentral.add(jlStatus);
		jpCentral.add(jlDescricao);

		jpCentral.add(jtfCampoNomeRazaoSocial);
		jpCentral.add(jtfCampoNomeFantasia);
		jpCentral.add(jtfCampoCpfCnpj);
		jpCentral.add(jtfCampoInscricaoEstadual);
		jpCentral.add(jtfCampoInscricaoMunicipal);
		jpCentral.add(jcbComboRamoEmpresarial);
		jpCentral.add(jftfCampoCep);
		jpCentral.add(jtfCampoEndereco);
		jpCentral.add(jtfCampoNumero);
		jpCentral.add(jtfCampoComplemento);
		jpCentral.add(jtfCampoBairro);
		jpCentral.add(jtfCampoCidade);
		jpCentral.add(jcbComboUf);
		jpCentral.add(jtfCampoPaís);
		jpCentral.add(jtfCampoContato);
		jpCentral.add(jtfCampoEmail);
		jpCentral.add(jtfCampoTelefone);
		jpCentral.add(jtfCampoCelular);
		jpCentral.add(jtfCampoFoneFax);
		jpCentral.add(jcbComboStatus);

		jpCentral.add(jbCadastrarFornecedor);
		jpCentral.add(jbNovoRamoEmpresarial);

		jpCentral.add(jlIconeFornecedor2);

		jpCentral.add(scrool);

		/*
		 * ACICIONAMENTO DE FONTES
		 */

		jlTituloContainer.setFont(font4);
		jlTituloPainel.setFont(font3);
		jlNomeRazaoSocial.setFont(font2);
		jlNomeFantasia.setFont(font2);
		jlCpfCnpj.setFont(font2);
		jlInscricaoEstadual.setFont(font2);
		jlInscricaoMunicipal.setFont(font2);
		jlRamoEmpresarial.setFont(font2);
		jlCep.setFont(font2);
		jlEndereco.setFont(font2);
		jlNumero.setFont(font2);
		jlComplemento.setFont(font2);
		jlBairro.setFont(font2);
		jlCidade.setFont(font2);
		jlUf.setFont(font2);
		jlPaís.setFont(font2);
		jlContato.setFont(font2);
		jlEmail.setFont(font2);
		jlTelefone.setFont(font2);
		jlCelular.setFont(font2);
		jlFoneFax.setFont(font2);
		jlStatus.setFont(font2);
		jlDescricao.setFont(font2);

		jtfCampoNomeRazaoSocial.setFont(font);
		jtfCampoNomeFantasia.setFont(font);
		jtfCampoCpfCnpj.setFont(font);
		jtfCampoInscricaoEstadual.setFont(font);
		jtfCampoInscricaoMunicipal.setFont(font);
		jcbComboRamoEmpresarial.setFont(font6);
		jftfCampoCep.setFont(font);
		jtfCampoEndereco.setFont(font);
		jtfCampoNumero.setFont(font);
		jtfCampoComplemento.setFont(font);
		jtfCampoBairro.setFont(font);
		jtfCampoCidade.setFont(font);
		jcbComboUf.setFont(font);
		jtfCampoPaís.setFont(font);
		jtfCampoContato.setFont(font);
		jtfCampoEmail.setFont(font);
		jtfCampoCelular.setFont(font);
		jtfCampoTelefone.setFont(font);
		jtfCampoFoneFax.setFont(font);
		jcbComboStatus.setFont(font);
		jtaCampoDescricao.setFont(font);

		jbCadastrarFornecedor.setFont(font4);
		jbNovoRamoEmpresarial.setFont(font5);

		/*
		 * EDITABILIDADE
		 */
		jtaCampoDescricao.setEditable(true);

		/*
		 * COORDENADAS DOS COMPONETES
		 */

		jpCentral.setBounds(5, 35, 1050, 510);

		Dimension dTituloContainer = jlTituloContainer.getPreferredSize();
		jlTituloContainer.setBounds(45, 6, dTituloContainer.width,
				dTituloContainer.height);
		Dimension dTituloPainel = jlTituloPainel.getPreferredSize();
		jlTituloPainel.setBounds(420, 20, dTituloPainel.width,
				dTituloPainel.height);
		Dimension dNomeRazaoSocial = jlNomeRazaoSocial.getPreferredSize();
		jlNomeRazaoSocial.setBounds(12, 61, dNomeRazaoSocial.width,
				dNomeRazaoSocial.height);
		Dimension dNomeFantasia = jlNomeFantasia.getPreferredSize();
		jlNomeFantasia.setBounds(12, 119, dNomeFantasia.width,
				dNomeFantasia.height);
		Dimension dCpfCnpj = jlCpfCnpj.getPreferredSize();
		jlCpfCnpj.setBounds(360, 61, dCpfCnpj.width, dCpfCnpj.height);
		Dimension dInscricaoEstadual = jlInscricaoEstadual.getPreferredSize();
		jlInscricaoEstadual.setBounds(710, 61, dInscricaoEstadual.width,
				dInscricaoEstadual.height);
		Dimension dInscricaoMunicipal = jlInscricaoMunicipal.getPreferredSize();
		jlInscricaoMunicipal.setBounds(710, 119, dInscricaoMunicipal.width,
				dInscricaoMunicipal.height);
		Dimension dRamoEmpresarial = jlRamoEmpresarial.getPreferredSize();
		jlRamoEmpresarial.setBounds(360, 119, dRamoEmpresarial.width,
				dRamoEmpresarial.height);
		Dimension dEndereco = jlEndereco.getPreferredSize();
		jlEndereco.setBounds(12, 181, dEndereco.width, dEndereco.height);
		Dimension dComplemento = jlComplemento.getPreferredSize();
		jlComplemento.setBounds(710, 181, dComplemento.width,
				dComplemento.height);
		Dimension dCep = jlCep.getPreferredSize();
		jlCep.setBounds(509, 181, dCep.width, dCep.height);
		Dimension dNumero = jlNumero.getPreferredSize();
		jlNumero.setBounds(360, 181, dNumero.width, dNumero.height);
		Dimension dBairro = jlBairro.getPreferredSize();
		jlBairro.setBounds(12, 243, dBairro.width, dBairro.height);
		Dimension dCidade = jlCidade.getPreferredSize();
		jlCidade.setBounds(360, 243, dCidade.width, dCidade.height);
		Dimension dUf = jlUf.getPreferredSize();
		jlUf.setBounds(360, 369, dUf.width, dUf.height);
		Dimension dPaís = jlPaís.getPreferredSize();
		jlPaís.setBounds(474, 369, dPaís.width, dPaís.height);
		Dimension dContato = jlContato.getPreferredSize();
		jlContato.setBounds(12, 306, dContato.width, dContato.height);
		Dimension dEmail = jlEmail.getPreferredSize();
		jlEmail.setBounds(12, 369, dEmail.width, dEmail.height);
		Dimension dTelefone = jlTelefone.getPreferredSize();
		jlTelefone.setBounds(360, 306, dTelefone.width, dTelefone.height);
		Dimension dCelular = jlCelular.getPreferredSize();
		jlCelular.setBounds(535, 306, dCelular.width, dCelular.height);
		Dimension dFoneFax = jlFoneFax.getPreferredSize();
		jlFoneFax.setBounds(710, 243, dFoneFax.width, dFoneFax.height);
		Dimension dStatus = jlStatus.getPreferredSize();
		jlStatus.setBounds(885, 243, dStatus.width, dStatus.height);
		Dimension dDescricao = jlDescricao.getPreferredSize();
		jlDescricao.setBounds(710, 306, dDescricao.width, dDescricao.height);

		jtfCampoNomeRazaoSocial.setBounds(8, 85, 330, 34);
		jtfCampoNomeFantasia.setBounds(8, 144, 330, 34);
		jtfCampoCpfCnpj.setBounds(356, 85, 330, 34);
		jtfCampoInscricaoEstadual.setBounds(706, 85, 330, 34);
		jtfCampoInscricaoMunicipal.setBounds(706, 144, 330, 34);
		jcbComboRamoEmpresarial.setBounds(356, 144, 265, 34);
		jtfCampoEndereco.setBounds(8, 206, 330, 34);
		jtfCampoComplemento.setBounds(706, 206, 330, 34);
		jftfCampoCep.setBounds(505, 206, 180, 34);
		jtfCampoNumero.setBounds(356, 206, 135, 34);
		jtfCampoBairro.setBounds(8, 268, 330, 34);
		jtfCampoCidade.setBounds(356, 268, 330, 34);
		jcbComboUf.setBounds(356, 394, 100, 34);
		jtfCampoPaís.setBounds(470, 394, 216, 34);
		jtfCampoContato.setBounds(8, 331, 330, 34);
		jtfCampoEmail.setBounds(8, 394, 330, 34);
		jtfCampoTelefone.setBounds(356, 331, 160, 34);
		jtfCampoCelular.setBounds(531, 331, 155, 34);
		jtfCampoFoneFax.setBounds(706, 268, 160, 34);
		jcbComboStatus.setBounds(881, 268, 155, 34);
		scrool.setBounds(706, 331, 330, 96);

		jbFechar.setBounds(1015, 4, 35, 25);
		jbCadastrarFornecedor.setBounds(390, 450, 260, 40);
		jbNovoRamoEmpresarial.setBounds(627, 144, 60, 34);

		Dimension dIconeFornecedor = jlIconeFornecedor.getPreferredSize();
		jlIconeFornecedor.setBounds(8, 3, dIconeFornecedor.width,
				dIconeFornecedor.height);

		Dimension dIconeFornecedor2 = jlIconeFornecedor2.getPreferredSize();
		jlIconeFornecedor2.setBounds(382, 22, dIconeFornecedor2.width,
				dIconeFornecedor2.height);

		/*
		 * QUANTIDADE DE CARACTERES
		 */
		jtfCampoNomeRazaoSocial.setDocument(new MeuDocument(70));
		jtfCampoNomeFantasia.setDocument(new MeuDocument(70));
		jtfCampoCpfCnpj.setDocument(new MeuDocument(40));
		jtfCampoInscricaoEstadual.setDocument(new MeuDocument(30));
		jtfCampoInscricaoMunicipal.setDocument(new MeuDocument(30));
		jtfCampoEndereco.setDocument(new MeuDocument(100));
		jtfCampoNumero.setDocument(new MeuDocument(12));
		jtfCampoComplemento.setDocument(new MeuDocument(100));
		jtfCampoBairro.setDocument(new MeuDocument(60));
		jtfCampoCidade.setDocument(new MeuDocument(60));
		jtfCampoPaís.setDocument(new MeuDocument(50));
		jtfCampoContato.setDocument(new MeuDocument(60));
		jtfCampoEmail.setDocument(new MeuDocument(70));
		jtfCampoTelefone.setDocument(new MeuDocument(30));
		jtfCampoFoneFax.setDocument(new MeuDocument(30));
		jtfCampoCelular.setDocument(new MeuDocument(30));
		jtaCampoDescricao.setDocument(new MeuDocument(300));

		/*
		 * COR DE FONTE DOS COMPONENTES
		 */

		jlTituloContainer.setForeground(Color.white);
		jlTituloPainel.setForeground(Color.black);
		jlNomeRazaoSocial.setForeground(Color.black);
		jlNomeFantasia.setForeground(Color.black);
		jlCpfCnpj.setForeground(Color.black);
		jlInscricaoEstadual.setForeground(Color.black);
		jlInscricaoMunicipal.setForeground(Color.black);
		jlRamoEmpresarial.setForeground(Color.black);
		jlCep.setForeground(Color.black);
		jlEndereco.setForeground(Color.black);
		jlNumero.setForeground(Color.black);
		jlComplemento.setForeground(Color.black);
		jlBairro.setForeground(Color.black);
		jlCidade.setForeground(Color.black);
		jlUf.setForeground(Color.black);
		jlPaís.setForeground(Color.black);
		jlContato.setForeground(Color.black);
		jlEmail.setForeground(Color.black);
		jlTelefone.setForeground(Color.black);
		jlCelular.setForeground(Color.black);
		jlFoneFax.setForeground(Color.black);
		jlStatus.setForeground(Color.black);
		jlDescricao.setForeground(Color.black);

		jtfCampoNomeRazaoSocial.setForeground(Color.black);
		jtfCampoNomeFantasia.setForeground(Color.black);
		jtfCampoCpfCnpj.setForeground(Color.black);
		jtfCampoInscricaoEstadual.setForeground(Color.black);
		jtfCampoInscricaoMunicipal.setForeground(Color.black);
		jcbComboRamoEmpresarial.setForeground(Color.black);
		jftfCampoCep.setForeground(Color.black);
		jtfCampoEndereco.setForeground(Color.black);
		jtfCampoNumero.setForeground(Color.black);
		jtfCampoComplemento.setForeground(Color.black);
		jtfCampoBairro.setForeground(Color.black);
		jtfCampoCidade.setForeground(Color.black);
		jcbComboUf.setForeground(Color.black);
		jtfCampoPaís.setForeground(Color.black);
		jtfCampoContato.setForeground(Color.black);
		jtfCampoEmail.setForeground(Color.black);
		jtfCampoTelefone.setForeground(Color.black);
		jtfCampoCelular.setForeground(Color.black);
		jtfCampoFoneFax.setForeground(Color.black);
		jcbComboStatus.setForeground(Color.black);
		scrool.setForeground(Color.black);

		jbCadastrarFornecedor.setForeground(Color.white);
		jbFechar.setForeground(Color.white);
		jbNovoRamoEmpresarial.setForeground(Color.white);

		/*
		 * DEFINIÇÃO DE BACKGROUNDS DOS COMPONETES
		 */

		jpCentral.setBackground(new Color(237, 241, 244));

		jtfCampoNomeRazaoSocial.setBackground(new Color(219, 219, 219));
		jtfCampoNomeFantasia.setBackground(new Color(219, 219, 219));
		jtfCampoCpfCnpj.setBackground(new Color(219, 219, 219));
		jtfCampoInscricaoEstadual.setBackground(new Color(219, 219, 219));
		jtfCampoInscricaoMunicipal.setBackground(new Color(219, 219, 219));
		jftfCampoCep.setBackground(new Color(219, 219, 219));
		jtfCampoEndereco.setBackground(new Color(219, 219, 219));
		jtfCampoNumero.setBackground(new Color(219, 219, 219));
		jtfCampoComplemento.setBackground(new Color(219, 219, 219));
		jtfCampoBairro.setBackground(new Color(219, 219, 219));
		jtfCampoCidade.setBackground(new Color(219, 219, 219));
		jtfCampoPaís.setBackground(new Color(219, 219, 219));
		jtfCampoContato.setBackground(new Color(219, 219, 219));
		jtfCampoEmail.setBackground(new Color(219, 219, 219));
		jtfCampoTelefone.setBackground(new Color(219, 219, 219));
		jtfCampoCelular.setBackground(new Color(219, 219, 219));
		jtfCampoFoneFax.setBackground(new Color(219, 219, 219));
		jcbComboRamoEmpresarial.setBackground(Color.gray);
		jcbComboStatus.setBackground(Color.gray);
		jcbComboUf.setBackground(Color.gray);
		jtaCampoDescricao.setBackground(new Color(219, 219, 219));

		jbFechar.setBackground(Color.black);
		jbCadastrarFornecedor.setBackground(Color.black);
		jbNovoRamoEmpresarial.setBackground(Color.black);

		/*
		 * FOREGROUND E SELEÇÃO DE TEXTOS EFETIOS
		 */

		jtfCampoBairro.setSelectedTextColor(Color.WHITE);
		jtfCampoCelular.setSelectedTextColor(Color.WHITE);
		jtfCampoCidade.setSelectedTextColor(Color.WHITE);
		jtfCampoComplemento.setSelectedTextColor(Color.WHITE);
		jtfCampoContato.setSelectedTextColor(Color.WHITE);
		jtfCampoCpfCnpj.setSelectedTextColor(Color.WHITE);
		jtfCampoEmail.setSelectedTextColor(Color.WHITE);
		jtfCampoEndereco.setSelectedTextColor(Color.WHITE);
		jtfCampoInscricaoEstadual.setSelectedTextColor(Color.WHITE);
		jtfCampoFoneFax.setSelectedTextColor(Color.WHITE);
		jtfCampoInscricaoMunicipal.setSelectedTextColor(Color.WHITE);
		jtfCampoNomeFantasia.setSelectedTextColor(Color.WHITE);
		jtfCampoNomeRazaoSocial.setSelectedTextColor(Color.WHITE);
		jtfCampoNumero.setSelectedTextColor(Color.WHITE);
		jtfCampoPaís.setSelectedTextColor(Color.WHITE);
		jtfCampoTelefone.setSelectedTextColor(Color.WHITE);
		jtaCampoDescricao.setSelectedTextColor(Color.WHITE);
		jftfCampoCep.setSelectedTextColor(Color.WHITE);

		jtfCampoBairro.setSelectionColor(Color.black);
		jtfCampoCelular.setSelectionColor(Color.black);
		jtfCampoCidade.setSelectionColor(Color.black);
		jtfCampoComplemento.setSelectionColor(Color.black);
		jtfCampoContato.setSelectionColor(Color.black);
		jtfCampoCpfCnpj.setSelectionColor(Color.black);
		jtfCampoEmail.setSelectionColor(Color.black);
		jtfCampoEndereco.setSelectionColor(Color.black);
		jtfCampoEndereco.setSelectionColor(Color.black);
		jtfCampoFoneFax.setSelectionColor(Color.black);
		jtfCampoInscricaoEstadual.setSelectionColor(Color.black);
		jtfCampoInscricaoMunicipal.setSelectionColor(Color.black);
		jtfCampoNomeFantasia.setSelectionColor(Color.black);
		jtfCampoNomeRazaoSocial.setSelectionColor(Color.black);
		jtfCampoNumero.setSelectionColor(Color.black);
		jtfCampoPaís.setSelectionColor(Color.black);
		jtfCampoTelefone.setSelectionColor(Color.black);
		jtaCampoDescricao.setSelectionColor(Color.black);
		jftfCampoCep.setSelectionColor(Color.black);

		/*
		 * QUEBRA DE LINHA AREA
		 */
		jtaCampoDescricao.setLineWrap(true);

		/*
		 * MASCARAS DOS CAMPOS
		 */
		try {
			mfCampoCep.setMask("#####-###");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mfCampoCep.install(jftfCampoCep);

		/*
		 * ADCIONAMENTO DE INTES AOS COMBOS
		 */

		jcbComboRamoEmpresarial.addItem("");

		jcbComboStatus.addItem("");
		jcbComboStatus.addItem("Ativo");
		jcbComboStatus.addItem("Inativo");

		jcbComboUf.addItem("");
		jcbComboUf.addItem("AC");
		jcbComboUf.addItem("AL");
		jcbComboUf.addItem("AP");
		jcbComboUf.addItem("AM");
		jcbComboUf.addItem("BA");
		jcbComboUf.addItem("CE");
		jcbComboUf.addItem("DF");
		jcbComboUf.addItem("ES");
		jcbComboUf.addItem("GO");
		jcbComboUf.addItem("MA");
		jcbComboUf.addItem("MT");
		jcbComboUf.addItem("MS");
		jcbComboUf.addItem("MG");
		jcbComboUf.addItem("PA");
		jcbComboUf.addItem("PB");
		jcbComboUf.addItem("PR");
		jcbComboUf.addItem("PE");
		jcbComboUf.addItem("PI");
		jcbComboUf.addItem("RJ");
		jcbComboUf.addItem("RN");
		jcbComboUf.addItem("RS");
		jcbComboUf.addItem("RO");
		jcbComboUf.addItem("RR");
		jcbComboUf.addItem("SC");
		jcbComboUf.addItem("SP");
		jcbComboUf.addItem("SE");
		jcbComboUf.addItem("TO");

		/*
		 * TOOTIPS DOS COMPONENTES
		 */
		jlNomeRazaoSocial.setToolTipText("Informe o Nome ou a Razão Social");
		jlNomeFantasia.setToolTipText("Informe o Nome Fantasia");
		jlCpfCnpj
				.setToolTipText("Informe o CPF ou CNPJ, apenas (números, pontos e barras).");
		jlInscricaoEstadual.setToolTipText("Informe a Inscrição Estadual");
		jlInscricaoMunicipal.setToolTipText("Informe a Inscrição Municipal");
		jlRamoEmpresarial.setToolTipText("Informe o Ramo Empresarial");
		jlCep.setToolTipText("Informe o CEP");
		jlEndereco.setToolTipText("Informe o Endereço");
		jlNumero.setToolTipText("Informe o Número");
		jlComplemento.setToolTipText("Caso necessário (COMPLEMENTO)");
		jlBairro.setToolTipText("Informe o Bairro");
		jlCidade.setToolTipText("Informe a Cidade");
		jlUf.setToolTipText("Informe o Estado");
		jlPaís.setToolTipText("Informe o País");
		jlContato.setToolTipText("Informe o Nome de Contato");
		jlEmail.setToolTipText("Informe o Email");
		jlTelefone.setToolTipText("Informe o Telefone");
		jlCelular.setToolTipText("Informe o Celular");
		jlFoneFax.setToolTipText("Informe o Fone(fax)");
		jlStatus.setToolTipText("Informe o Status");
		jlDescricao.setToolTipText("Informe uma descrição");

		/*
		 * FOCUS AO EXECUTAR TELA
		 */
		CadastrarFornecedor.jtfCampoNomeRazaoSocial.requestFocus();

		/*
		 * CONTROLE
		 */
		ControleFornecedor listener = new ControleFornecedor();
		jbCadastrarFornecedor.addActionListener(listener);
		jbFechar.addActionListener(listener);
		jbNovoRamoEmpresarial.addActionListener(listener);

		/*
		 * INSTÂNCIA E METÓDO DE ATUALIZAR COMBO ATIVIDADE
		 */
		FornecedorDAO dao = new FornecedorDAO();
		//dao.AtualizaComboRamoEmpresarial(jcbComboRamoEmpresarial);

		/*
		 * EVENTOS QUE DEFINE QUAIS CARACTERES SERÃO UTILIZADOS EM CADA CAMPO
		 */
		
		
		jtfCampoCelular.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent ev) {

				String caracteres = "(-)0987654321";

				if (!caracteres.contains(ev.getKeyChar() + "")) {

					ev.consume();

				}

			}

		});

		jtfCampoTelefone.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent ev) {

				String caracteres = "(-)0987654321";

				if (!caracteres.contains(ev.getKeyChar() + "")) {

					ev.consume();

				}

			}

		});

		jtfCampoFoneFax.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent ev) {

				String caracteres = "(-)0987654321";

				if (!caracteres.contains(ev.getKeyChar() + "")) {

					ev.consume();

				}

			}

		});

		jtfCampoInscricaoEstadual.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent ev) {

				String caracteres = "./-0987654321";

				if (!caracteres.contains(ev.getKeyChar() + "")) {

					ev.consume();

				}

			}

		});

		jtfCampoInscricaoMunicipal.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent ev) {

				String caracteres = "./-0987654321";

				if (!caracteres.contains(ev.getKeyChar() + "")) {

					ev.consume();

				}

			}

		});
		jtfCampoCpfCnpj.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent ev) {

				String caracteres = "/.-0987654321";

				if (!caracteres.contains(ev.getKeyChar() + "")) {

					ev.consume();

				}

			}

		});

		/*
		 * EVENTO RESPONSÁVEL PELO ENTER DO TECLADO DO BOTÃO CADASTRAR
		 * FORNECEDOR
		 */

		jbCadastrarFornecedor.addKeyListener(new KeyListener() {

			FornecedorDAO dao = new FornecedorDAO();

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					dao.BotaoCadastrarFornecedor();
				}
			}
		});

		/*
		 * EVENTO RESPONSÁVEL PELO ENTER DO TECLADO DO FECHAR TELA
		 */
		jbFechar.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					CadastrarFornecedor.tela.dispose();
				}
			}
		});

		/*
		 * EVENTO RESPONSÁVEL PELO ENTER DO TECLADO DO BOTÃO NEW
		 */
		jbNovoRamoEmpresarial.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					CadastrarRamoEmpresarial objeto = new CadastrarRamoEmpresarial();
					objeto.setVisible(true);
				}
			}
		});
	}
	
	public static void main(String[] args) {
		new CadastrarFornecedor();
	}
}
