package br.com.imperium.vision.update;

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
import br.com.imperium.vision.create.CadastrarRamoEmpresarial;

/**
 * CLASSE ATUALIZARFORNECEDOR DO PACOTE
 * BR.COM.IMPERIUM.VISAO.ATUALIZAR.CADASTROS
 * 
 * @author JOAO DE SOUZA NETO
 *
 * */
public class AtualizarFornecedor extends JDialog {

	/*
	 * SERIAL DA VERSÃO DO JAVA
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * CRIAÇÃO DOS COMPONENTES DA CLASSE
	 */
	public static JLabel jlTituloPainel, jlTituloContainer, jlCodigo,
			jlNomeRazaoSocial, jlNomeFantasia, jlCpfCnpj, jlInscricaoEstadual,
			jlInscricaoMunicipal, jlRamoEmpresarial, jlCep, jlEndereco,
			jlNumero, jlComplemento, jlBairro, jlCidade, jlUf, jlPaís,
			jlContato, jlEmail, jlTelefone, jlCelular, jlFoneFax, jlStatus,
			jlIconeFornecedor, jlIconeAdicionar, jlDescricao;

	public static JTextField jtfCampoCodigo, jtfCampoNomeRazaoSocial,
			jtfCampoNomeFantasia, jtfCampoCpfCnpj, jtfCampoInscricaoEstadual,
			jtfCampoInscricaoMunicipal, jtfCampoEndereco, jtfCampoNumero,
			jtfCampoComplemento, jtfCampoBairro, jtfCampoCidade, jtfCampoPaís,
			jtfCampoContato, jtfCampoEmail, jtfCampoTelefone, jtfCampoCelular,
			jtfCampoFoneFax;
	public static JComboBox<String> jcbComboStatus;
	public static JComboBox<String> jcbComboRamoEmpresarial;
	public static JComboBox<String> jcbComboUf;
	public static JFormattedTextField jftfCampoCep;
	public static JTextArea jtaCampoDescricao;

	public static JButton jbFechar, jbAtualizarFornecedor,
			jbNovoRamoEmpresarial, jbOk;

	public static JPanel jpCentral;

	public static MaskFormatter mfCampoCep;

	public static JDialog tela;

	Font font, font2, font3, font4, font5;

	public static JScrollPane scrool;

	public static String cpfCnpj;

	/**
	 * METÓDO CONSTRUTOR DA CLASSE ATUALIZAR FORNECEDOR RESPONSÁVEL POR TODA A
	 * PARTE VISUAL DA TELA
	 * 
	 * @author JOAO DE SOUZA NETO
	 *
	 * */

	public AtualizarFornecedor(JDialog frame, boolean modal) {
		super(frame, modal);
	}

	public AtualizarFornecedor() {
		initComponents();
		setModal(true);
	}

	public void initComponents() {
		setUndecorated(true);
		Container c = getContentPane();
		tela = new JDialog();
		tela = this;
		setBackground(Color.WHITE);
		setSize(1060, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		c.setBackground(Color.black);
		c.setLayout(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		font = new Font("CAMBRIA", Font.PLAIN, 20);
		font2 = new Font("CAMBRIA", Font.BOLD, 22);
		font3 = new Font("CAMBRIA", Font.BOLD, 24);
		font4 = new Font("CAMBRIA", Font.PLAIN, 20);
		font5 = new Font("CAMBRIA", Font.PLAIN, 14);

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

		jlTituloPainel = new JLabel("Atualizar Fornecedor");
		jlTituloContainer = new JLabel("Atualização de Fornecedores");
		jlCodigo = new JLabel("Código: ");
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

		jtfCampoCodigo = new JTextField();
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
		jbAtualizarFornecedor = new JButton("Finalizar Atualização");
		jbNovoRamoEmpresarial = new JButton("New");
		jbOk = new JButton("Ok");

		jlIconeFornecedor = new JLabel(new ImageIcon("res/fornecedor.png"));
		jlIconeAdicionar = new JLabel(new ImageIcon("res/fornecedor.png"));

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
		jpCentral.add(jlCodigo);
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

		jpCentral.add(jtfCampoCodigo);
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

		jpCentral.add(jbAtualizarFornecedor);
		jpCentral.add(jbNovoRamoEmpresarial);
		jpCentral.add(jbOk);

		jpCentral.add(jlIconeAdicionar);

		jpCentral.add(scrool);

		/*
		 * ACICIONAMENTO DE FONTES
		 */

		jlTituloContainer.setFont(font4);
		jlTituloPainel.setFont(font3);
		jlCodigo.setFont(font2);
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

		jtfCampoCodigo.setFont(font);
		jtfCampoNomeRazaoSocial.setFont(font);
		jtfCampoNomeFantasia.setFont(font);
		jtfCampoCpfCnpj.setFont(font);
		jtfCampoInscricaoEstadual.setFont(font);
		jtfCampoInscricaoMunicipal.setFont(font);
		jcbComboRamoEmpresarial.setFont(font);
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

		jbAtualizarFornecedor.setFont(font4);
		jbNovoRamoEmpresarial.setFont(font5);
		jbOk.setFont(font4);

		/*
		 * EDITABILIADADE DA ÁREA
		 */
		jtaCampoDescricao.setEditable(true);

		/*
		 * COORDENADAS DOS COMPONETES
		 */

		jpCentral.setBounds(5, 35, 1050, 560);

		Dimension dTituloContainer = jlTituloContainer.getPreferredSize();
		jlTituloContainer.setBounds(45, 6, dTituloContainer.width,
				dTituloContainer.height);
		Dimension dTituloPainel = jlTituloPainel.getPreferredSize();
		jlTituloPainel.setBounds(420, 20, dTituloPainel.width,
				dTituloPainel.height);
		Dimension dCodigo = jlCodigo.getPreferredSize();
		jlCodigo.setBounds(407, 71, dCodigo.width, dCodigo.height);
		Dimension dNomeRazaoSocial = jlNomeRazaoSocial.getPreferredSize();
		jlNomeRazaoSocial.setBounds(12, 111, dNomeRazaoSocial.width,
				dNomeRazaoSocial.height);
		Dimension dNomeFantasia = jlNomeFantasia.getPreferredSize();
		jlNomeFantasia.setBounds(12, 169, dNomeFantasia.width,
				dNomeFantasia.height);
		Dimension dCpfCnpj = jlCpfCnpj.getPreferredSize();
		jlCpfCnpj.setBounds(360, 111, dCpfCnpj.width, dCpfCnpj.height);
		Dimension dInscricaoEstadual = jlInscricaoEstadual.getPreferredSize();
		jlInscricaoEstadual.setBounds(710, 111, dInscricaoEstadual.width,
				dInscricaoEstadual.height);
		Dimension dInscricaoMunicipal = jlInscricaoMunicipal.getPreferredSize();
		jlInscricaoMunicipal.setBounds(710, 169, dInscricaoMunicipal.width,
				dInscricaoMunicipal.height);
		Dimension dRamoEmpresarial = jlRamoEmpresarial.getPreferredSize();
		jlRamoEmpresarial.setBounds(360, 169, dRamoEmpresarial.width,
				dRamoEmpresarial.height);
		Dimension dEndereco = jlEndereco.getPreferredSize();
		jlEndereco.setBounds(12, 231, dEndereco.width, dEndereco.height);
		Dimension dComplemento = jlComplemento.getPreferredSize();
		jlComplemento.setBounds(710, 231, dComplemento.width,
				dComplemento.height);
		Dimension dCep = jlCep.getPreferredSize();
		jlCep.setBounds(509, 231, dCep.width, dCep.height);
		Dimension dNumero = jlNumero.getPreferredSize();
		jlNumero.setBounds(360, 231, dNumero.width, dNumero.height);
		Dimension dBairro = jlBairro.getPreferredSize();
		jlBairro.setBounds(12, 293, dBairro.width, dBairro.height);
		Dimension dCidade = jlCidade.getPreferredSize();
		jlCidade.setBounds(360, 293, dCidade.width, dCidade.height);
		Dimension dUf = jlUf.getPreferredSize();
		jlUf.setBounds(360, 419, dUf.width, dUf.height);
		Dimension dPaís = jlPaís.getPreferredSize();
		jlPaís.setBounds(474, 419, dPaís.width, dPaís.height);
		Dimension dContato = jlContato.getPreferredSize();
		jlContato.setBounds(12, 356, dContato.width, dContato.height);
		Dimension dEmail = jlEmail.getPreferredSize();
		jlEmail.setBounds(12, 419, dEmail.width, dEmail.height);
		Dimension dTelefone = jlTelefone.getPreferredSize();
		jlTelefone.setBounds(360, 356, dTelefone.width, dTelefone.height);
		Dimension dCelular = jlCelular.getPreferredSize();
		jlCelular.setBounds(535, 356, dCelular.width, dCelular.height);
		Dimension dFoneFax = jlFoneFax.getPreferredSize();
		jlFoneFax.setBounds(710, 293, dFoneFax.width, dFoneFax.height);
		Dimension dStatus = jlStatus.getPreferredSize();
		jlStatus.setBounds(935, 293, dStatus.width, dStatus.height);
		Dimension dDescricao = jlDescricao.getPreferredSize();
		jlDescricao.setBounds(710, 356, dDescricao.width, dDescricao.height);

		jtfCampoCodigo.setBounds(498, 66, 80, 34);
		jtfCampoNomeRazaoSocial.setBounds(8, 135, 330, 34);
		jtfCampoNomeFantasia.setBounds(8, 194, 330, 34);
		jtfCampoCpfCnpj.setBounds(356, 135, 330, 34);
		jtfCampoInscricaoEstadual.setBounds(706, 135, 330, 34);
		jtfCampoInscricaoMunicipal.setBounds(706, 194, 330, 34);
		jcbComboRamoEmpresarial.setBounds(356, 194, 265, 34);
		jtfCampoEndereco.setBounds(8, 256, 330, 34);
		jtfCampoComplemento.setBounds(706, 256, 330, 34);
		jftfCampoCep.setBounds(505, 256, 180, 34);
		jtfCampoNumero.setBounds(356, 256, 135, 34);
		jtfCampoBairro.setBounds(8, 318, 330, 34);
		jtfCampoCidade.setBounds(356, 318, 330, 34);
		jcbComboUf.setBounds(356, 444, 100, 34);
		jtfCampoPaís.setBounds(470, 444, 216, 34);
		jtfCampoContato.setBounds(8, 381, 330, 34);
		jtfCampoEmail.setBounds(8, 444, 330, 34);
		jtfCampoTelefone.setBounds(356, 381, 160, 34);
		jtfCampoCelular.setBounds(531, 381, 155, 34);
		jtfCampoFoneFax.setBounds(706, 318, 160, 34);
		jcbComboStatus.setBounds(881, 318, 155, 34);
		scrool.setBounds(706, 381, 330, 96);

		jbFechar.setBounds(1015, 4, 35, 25);
		jbAtualizarFornecedor.setBounds(390, 500, 260, 40);
		jbNovoRamoEmpresarial.setBounds(627, 194, 60, 34);
		jbOk.setBounds(585, 65, 60, 36);

		Dimension dIconeFornecedor = jlIconeFornecedor.getPreferredSize();
		jlIconeFornecedor.setBounds(8, 3, dIconeFornecedor.width,
				dIconeFornecedor.height);

		Dimension dIconeAdicionar = jlIconeAdicionar.getPreferredSize();
		jlIconeAdicionar.setBounds(382, 22, dIconeAdicionar.width,
				dIconeAdicionar.height);

		/*
		 * COR DE FONTE DOS COMPONENTES
		 */

		jlTituloContainer.setForeground(Color.white);
		jlTituloPainel.setForeground(Color.black);
		jlCodigo.setForeground(Color.black);
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

		// CAMPOS DE DIGITAÇÃO
		jtfCampoCodigo.setForeground(Color.black);
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

		jbAtualizarFornecedor.setForeground(Color.white);
		jbFechar.setForeground(Color.white);
		jbNovoRamoEmpresarial.setForeground(Color.white);
		jbOk.setForeground(Color.white);

		/*
		 * DEFINIÇÃO DE BACKGROUNDS DOS COMPONETES
		 */

		jpCentral.setBackground(new Color(237, 241, 244));

		jtfCampoCodigo.setBackground(new Color(219, 219, 219));
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
		jbAtualizarFornecedor.setBackground(Color.black);
		jbNovoRamoEmpresarial.setBackground(Color.black);
		jbOk.setBackground(Color.black);

		/*
		 * QUANTIDADE DE CARACTERES
		 */
		jtfCampoCodigo.setDocument(new MeuDocument(9));
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

		jlCodigo.setToolTipText("Informe o Código");
		jlNomeRazaoSocial
				.setToolTipText("Atualização de Nome ou a Razão Social");
		jlNomeFantasia.setToolTipText("Atualização de Nome Fantasia");
		jlCpfCnpj
				.setToolTipText("Atualização de CPF ou CNPJ, apenas (números, pontos e barras).");
		jlInscricaoEstadual.setToolTipText("Atualização de Inscrição Estadual");
		jlInscricaoMunicipal
				.setToolTipText("Atualização de Inscrição Municipal");
		jlRamoEmpresarial.setToolTipText("Atualização de Ramo Empresarial");
		jlCep.setToolTipText("Atualização de CEP");
		jlEndereco.setToolTipText("Atualização de Endereço");
		jlNumero.setToolTipText("Atualização de Número");
		jlComplemento
				.setToolTipText("Caso necessário atualização de (COMPLEMENTO)");
		jlBairro.setToolTipText("Atualização de Bairro");
		jlCidade.setToolTipText("Atualização de Cidade");
		jlUf.setToolTipText("Atualização de Estado");
		jlPaís.setToolTipText("Atualização de País");
		jlContato.setToolTipText("Atualização de Nome de Contato");
		jlEmail.setToolTipText("Atualização de Email");
		jlTelefone.setToolTipText("Atualização de Telefone");
		jlCelular.setToolTipText("Atualização de Celular");
		jlFoneFax.setToolTipText("Atualização de Fone(fax)");
		jlStatus.setToolTipText("Atualização de Fone(Celular)");
		jlDescricao.setToolTipText("Informe uma descrição");

		/*
		 * TDESABILITAÇÃO DOS COMPOENTES
		 */

		jtfCampoBairro.setEnabled(false);
		jtfCampoCelular.setEnabled(false);
		jtfCampoCidade.setEnabled(false);
		jtfCampoComplemento.setEnabled(false);
		jtfCampoContato.setEnabled(false);
		jtfCampoCpfCnpj.setEnabled(false);
		jtfCampoEmail.setEnabled(false);
		jtfCampoFoneFax.setEnabled(false);
		jtfCampoInscricaoEstadual.setEnabled(false);
		jtfCampoInscricaoMunicipal.setEnabled(false);
		jtfCampoNomeFantasia.setEnabled(false);
		jtfCampoNomeRazaoSocial.setEnabled(false);
		jtfCampoNumero.setEnabled(false);
		jtfCampoPaís.setEnabled(false);
		jtfCampoTelefone.setEnabled(false);
		jcbComboRamoEmpresarial.setEnabled(false);
		jcbComboStatus.setEnabled(false);
		jcbComboUf.setEnabled(false);
		jtfCampoEndereco.setEnabled(false);
		jtaCampoDescricao.setEnabled(false);
		jftfCampoCep.setEnabled(false);
		jbAtualizarFornecedor.setEnabled(false);
		jbNovoRamoEmpresarial.setEnabled(false);

		/*
		 * FOREGROUND E SELEÇÃO DE TEXTOS EFETIOS
		 */
		jtfCampoCodigo.setSelectedTextColor(Color.WHITE);
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

		jtfCampoCodigo.setSelectionColor(Color.black);
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
		 * FOCUS AO EXECUTAR TELA
		 */
		AtualizarFornecedor.jtfCampoNomeRazaoSocial.requestFocus();

		/*
		 * CONTROLE
		 */
		ControleFornecedor listener = new ControleFornecedor();
		jbAtualizarFornecedor.addActionListener(listener);
		jbFechar.addActionListener(listener);
		jbNovoRamoEmpresarial.addActionListener(listener);
		jbOk.addActionListener(listener);

		/*
		 * INSTÂNCIA E METÓDO DE ATUALIZAR COMBO ATIVIDADE
		 */
		FornecedorDAO dao = new FornecedorDAO();
		dao.AtualizaComboRamoEmpresarial(jcbComboRamoEmpresarial);

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
		 * EVENTO RESPONSÁVEL PELO ENTER DO TECLADO DO OK ATUALIZAR FORNECEDOR
		 */
		jtfCampoCodigo.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent ev) {

				String caracteres = "0987654321";

				if (!caracteres.contains(ev.getKeyChar() + "")) {

					ev.consume();

				}

			}

		});

		/*
		 * EVENTO RESPONSÁVEL PELO ENTER DO TECLADO DO BOTÃO ATUALIZAR
		 * FORNECEDOR
		 */

		jbAtualizarFornecedor.addKeyListener(new KeyListener() {

			// INSTÂNCIA DE FORNECEDOR
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
					dao.AcaoDoBotaoAlterarFornecedor();
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
					AtualizarFornecedor.tela.dispose();
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

		/*
		 * EVENTO RESPONSÁVEL PELO ENTER DO TECLADO DO CAMPO CODIGO
		 */
		jtfCampoCodigo.addKeyListener(new KeyListener() {
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
					dao.AcaoDoBotaoOkFornecedor();
				}
			}
		});

		/*
		 * EVENTO RESPONSÁVEL PELO ENTER DO TECLADO DO BOTÃO OK
		 */
		jbOk.addKeyListener(new KeyListener() {
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
					dao.AcaoDoBotaoOkFornecedor();
				}
			}
		});

	}
}
