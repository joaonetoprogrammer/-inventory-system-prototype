package br.com.imperium.vision.read;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import br.com.imperium.control.ControleFornecedor;
import br.com.imperium.dao.FornecedorDAO;
import br.com.imperium.util.MeuDocument;
import br.com.imperium.vision.create.CadastrarFornecedor;
import br.com.imperium.vision.update.AtualizarFornecedor;

/**
 * CLASSE CONSULTARFORNECEDOR DO PACOTE
 * BR.COM.IMPERIUM.VISAO.CONSULTAR.CADASTROS
 * 
 * @author JOAO DE SOUZA NETO
 *
 * */

public class ConsultarFornecedor extends JDialog {

	/*
	 * SERIAL DA VERSÃO DO JAVA
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * CRIAÇÃO DOS COMPONENTES DA CLASSE
	 */
	public static JLabel jlTituloPainel, jlTituloContainer, jlRazaoSocial,
			jlNomeFantasia, jlCpfCnpj, jlRamoEmpresarial, jlContato, jlEmail,
			jlCidade, jlEstado, jlStatus, jlCodigoDeletar,
			jlNomeFantasiaDeletar, jlCpfCnpjDeletar, jlIconeFornecedor,
			jlIconeConsultar;

	public static JTextField jtfCampoRazaoSocial, jtfCampoNomeFantasia,
			jtfCampoCpfCnpj, jtfCampoContato, jtfCampoEmail, jtfCampoCidade,
			jtfCampoNomeFantasiaDeletar, jtfCampoCodigoDeletar,
			jtfCampoCpfCnpjDeletar;
	public static JComboBox<String> jcbComboRamoEmpresarial, jcbComboEstado,
			jcbComboStatus;

	public static JButton jbFechar, jbDeletarItem, jbAddNovo, jbAtualizar,
			jbGerarFicha;

	public static JPanel jpCentral;

	public static JTable jtTabela;

	public static JScrollPane jspScroll;

	public static DefaultTableModel dftModelo;

	public static JDialog jftela;

	public static DefaultTableCellRenderer dtcrLinhadireita;

	Font font, font2, font3, font4, font5, font6;

	/**
	 * METÓDO CONSTRUTOR DA CLASSE CONSULTAR FORNECEDOR RESPONSÁVEL POR TODA A
	 * PARTE VISUAL DA TELA
	 * 
	 * @author JOAO DE SOUZA NETO
	 *
	 * */

	public ConsultarFornecedor(JDialog frame, boolean modal) {
		super(frame, modal);
	}

	public ConsultarFornecedor() {
		initComponents();
		setModal(true);
	}

	public void initComponents() {
		setUndecorated(true);
		Container c = getContentPane();
		jftela = new JDialog();
		jftela = this;
		setSize(1125, 604);
		setLocationRelativeTo(null);
		setResizable(false);
		c.setBackground(Color.black);
		c.setLayout(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		font = new Font("CAMBRIA", Font.PLAIN, 20);
		font2 = new Font("CAMBRIA", Font.BOLD, 22);
		font3 = new Font("CAMBRIA", Font.BOLD, 24);
		font4 = new Font("CAMBRIA", Font.PLAIN, 20);
		font5 = new Font("CAMBRIA", Font.BOLD, 20);
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

		jpCentral = new JPanel();

		jspScroll = new JScrollPane();

		dftModelo = new DefaultTableModel(new String[] { "Código",
				"Razão Social", "Nome Fantasia", "CPF/CNPJ", "Contato",
				"Status", "Atividade/Ramo" }, 0) {
			public boolean isCellEditable(int row, int col) {
				if (col == 0 || col == 1 || col == 2 || col == 3 || col == 4
						|| col == 5 || col == 6) {
					return false;
				}
				return true;
			}

			private static final long serialVersionUID = 1L;

		};

		jtTabela = new JTable(dftModelo);

		dtcrLinhadireita = new DefaultTableCellRenderer();

		jlTituloPainel = new JLabel("Menu Fornecedor");
		jlTituloContainer = new JLabel("Menu Fornecedor");
		jlRazaoSocial = new JLabel("Razão Social:");
		jlNomeFantasia = new JLabel("Nome Fantasia:");
		jlCpfCnpj = new JLabel("Cpf/Cnpj:");
		jlRamoEmpresarial = new JLabel("Ramo Empresarial:");
		jlContato = new JLabel("Contato:");
		jlEmail = new JLabel("Email:");
		jlCidade = new JLabel("Cidade:");
		jlEstado = new JLabel("Estado:");
		jlStatus = new JLabel("Status:");
		jlNomeFantasiaDeletar = new JLabel("Nome Fantasia:");
		jlCpfCnpjDeletar = new JLabel("Cpf/Cnpj:");
		jlCodigoDeletar = new JLabel("Código:");

		jtfCampoRazaoSocial = new JTextField();
		jtfCampoNomeFantasia = new JTextField();
		jtfCampoCpfCnpj = new JTextField();
		jcbComboRamoEmpresarial = new JComboBox<String>();
		jtfCampoContato = new JTextField();
		jtfCampoEmail = new JTextField();
		jtfCampoCidade = new JTextField();
		jcbComboEstado = new JComboBox<String>();
		jcbComboStatus = new JComboBox<String>();
		jtfCampoNomeFantasiaDeletar = new JTextField();
		jtfCampoCpfCnpjDeletar = new JTextField();
		jtfCampoCodigoDeletar = new JTextField();

		jbFechar = new JButton("X");
		jbDeletarItem = new JButton("Deletar Item");
		jbAtualizar = new JButton("Atualizar");
		jbGerarFicha = new JButton("Gerar Ficha");
		jbAddNovo = new JButton("Add Fornecedor");

		jlIconeFornecedor = new JLabel(new ImageIcon("res/fornecedor.png"));
		jlIconeConsultar = new JLabel(new ImageIcon("res/fornecedor.png"));

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
		jpCentral.add(jlRazaoSocial);
		jpCentral.add(jlNomeFantasia);
		jpCentral.add(jlCpfCnpj);
		jpCentral.add(jlRamoEmpresarial);
		jpCentral.add(jlContato);
		jpCentral.add(jlEmail);
		jpCentral.add(jlCidade);
		jpCentral.add(jlEstado);
		jpCentral.add(jlStatus);
		jpCentral.add(jlNomeFantasiaDeletar);
		jpCentral.add(jlCpfCnpjDeletar);
		jpCentral.add(jlCodigoDeletar);

		jpCentral.add(jtfCampoRazaoSocial);
		jpCentral.add(jtfCampoNomeFantasia);
		jpCentral.add(jtfCampoCpfCnpj);
		jpCentral.add(jcbComboRamoEmpresarial);
		jpCentral.add(jtfCampoContato);
		jpCentral.add(jtfCampoEmail);
		jpCentral.add(jtfCampoCidade);
		jpCentral.add(jcbComboEstado);
		jpCentral.add(jcbComboStatus);
		jpCentral.add(jtfCampoNomeFantasiaDeletar);
		jpCentral.add(jtfCampoCpfCnpjDeletar);
		jpCentral.add(jtfCampoCodigoDeletar);

		jpCentral.add(jbDeletarItem);
		jpCentral.add(jbAtualizar);
		jpCentral.add(jbGerarFicha);
		jpCentral.add(jbAddNovo);

		jpCentral.add(jlIconeConsultar);

		jpCentral.add(jspScroll);

		/*
		 * ACICIONAMENTO DE FONTES
		 */

		jlTituloContainer.setFont(font4);
		jlTituloPainel.setFont(font3);
		jlRazaoSocial.setFont(font2);
		jlNomeFantasia.setFont(font2);
		jlCpfCnpj.setFont(font2);
		jlRamoEmpresarial.setFont(font2);
		jlContato.setFont(font2);
		jlEmail.setFont(font2);
		jlCidade.setFont(font2);
		jlEstado.setFont(font2);
		jlStatus.setFont(font2);
		jlNomeFantasiaDeletar.setFont(font2);
		jlCodigoDeletar.setFont(font2);
		jlCpfCnpjDeletar.setFont(font2);

		jtfCampoRazaoSocial.setFont(font);
		jtfCampoNomeFantasia.setFont(font);
		jtfCampoCpfCnpj.setFont(font);
		jcbComboRamoEmpresarial.setFont(font);
		jtfCampoContato.setFont(font);
		jtfCampoEmail.setFont(font);
		jtfCampoCidade.setFont(font);
		jcbComboEstado.setFont(font);
		jcbComboStatus.setFont(font);
		jtfCampoNomeFantasiaDeletar.setFont(font);
		jtfCampoCodigoDeletar.setFont(font);
		jtfCampoCpfCnpjDeletar.setFont(font);

		jbDeletarItem.setFont(font6);
		jbAtualizar.setFont(font6);
		jbGerarFicha.setFont(font6);
		jbAddNovo.setFont(font6);

		jtTabela.setFont(font6);

		/*
		 * COORDENADAS DOS COMPONETES
		 */

		jpCentral.setBounds(5, 35, 1115, 564);

		Dimension dTituloContainer = jlTituloContainer.getPreferredSize();
		jlTituloContainer.setBounds(43, 7, dTituloContainer.width,
				dTituloContainer.height);
		Dimension dTituloPainel = jlTituloPainel.getPreferredSize();
		jlTituloPainel.setBounds(460, 9, dTituloPainel.width,
				dTituloPainel.height);
		Dimension dNomeEmpresa = jlRazaoSocial.getPreferredSize();
		jlRazaoSocial
				.setBounds(15, 58, dNomeEmpresa.width, dNomeEmpresa.height);
		Dimension dNomeFantasia = jlNomeFantasia.getPreferredSize();
		jlNomeFantasia.setBounds(15, 99, dNomeFantasia.width,
				dNomeFantasia.height);
		Dimension dCpfCnpj = jlCpfCnpj.getPreferredSize();
		jlCpfCnpj.setBounds(15, 140, dCpfCnpj.width, dCpfCnpj.height);
		Dimension dRamoEmpresarial = jlRamoEmpresarial.getPreferredSize();
		jlRamoEmpresarial.setBounds(410, 58, dRamoEmpresarial.width,
				dRamoEmpresarial.height);
		Dimension dContato = jlContato.getPreferredSize();
		jlContato.setBounds(410, 99, dContato.width, dContato.height);
		Dimension dEmail = jlEmail.getPreferredSize();
		jlEmail.setBounds(770, 140, dEmail.width, dEmail.height);
		Dimension dCidade = jlCidade.getPreferredSize();
		jlCidade.setBounds(770, 58, dCidade.width, dCidade.height);
		Dimension dEstado = jlEstado.getPreferredSize();
		jlEstado.setBounds(770, 99, dEstado.width, dEstado.height);
		Dimension dStatus = jlStatus.getPreferredSize();
		jlStatus.setBounds(410, 140, dStatus.width, dStatus.height);
		Dimension dNomeFantasiaDeletar = jlNomeFantasiaDeletar
				.getPreferredSize();
		jlNomeFantasiaDeletar.setBounds(120, 490, dNomeFantasiaDeletar.width,
				dNomeFantasiaDeletar.height);
		Dimension dCpfCnpjDeletar = jlCpfCnpjDeletar.getPreferredSize();
		jlCpfCnpjDeletar.setBounds(440, 490, dCpfCnpjDeletar.width,
				dCpfCnpjDeletar.height);
		Dimension dCodigoDeletar = jlCodigoDeletar.getPreferredSize();
		jlCodigoDeletar.setBounds(25, 490, dCodigoDeletar.width,
				dCodigoDeletar.height);

		jtfCampoRazaoSocial.setBounds(170, 56, 235, 34);
		jtfCampoNomeFantasia.setBounds(190, 97, 215, 34);
		jtfCampoCpfCnpj.setBounds(170, 138, 235, 34);
		jcbComboRamoEmpresarial.setBounds(530, 56, 235, 34);
		jtfCampoContato.setBounds(530, 97, 235, 34);
		jtfCampoEmail.setBounds(860, 138, 235, 34);
		jtfCampoCidade.setBounds(860, 56, 235, 34);
		jcbComboEstado.setBounds(860, 97, 235, 34);
		jcbComboStatus.setBounds(530, 138, 235, 34);
		jtfCampoCodigoDeletar.setBounds(21, 518, 90, 34);
		jtfCampoNomeFantasiaDeletar.setBounds(116, 518, 313, 34);
		jtfCampoCpfCnpjDeletar.setBounds(436, 518, 225, 34);

		jbFechar.setBounds(1080, 4, 35, 25);
		jbDeletarItem.setBounds(815, 518, 140, 34);
		jbAtualizar.setBounds(960, 518, 135, 34);
		jbGerarFicha.setBounds(670, 518, 140, 34);
		jbAddNovo.setBounds(935, 10, 160, 34);

		Dimension dIconeFornecedor = jlIconeFornecedor.getPreferredSize();
		jlIconeFornecedor.setBounds(8, 3, dIconeFornecedor.width,
				dIconeFornecedor.height);

		Dimension dIconeConsultar = jlIconeConsultar.getPreferredSize();
		jlIconeConsultar.setBounds(422, 6, dIconeConsultar.width,
				dIconeConsultar.height);

		jspScroll.setBounds(14, 180, 1085, 305);

		/*
		 * QUANTIDADE DE CARACTERES
		 */
		jtfCampoRazaoSocial.setDocument(new MeuDocument(70));
		jtfCampoNomeFantasia.setDocument(new MeuDocument(70));
		jtfCampoCpfCnpj.setDocument(new MeuDocument(40));
		jtfCampoCidade.setDocument(new MeuDocument(60));
		jtfCampoContato.setDocument(new MeuDocument(60));
		jtfCampoEmail.setDocument(new MeuDocument(70));

		/*
		 * COR DE FONTE DOS COMPONENTES
		 */

		jlTituloContainer.setForeground(Color.white);
		jlTituloPainel.setForeground(Color.black);
		jlRazaoSocial.setForeground(Color.black);
		jlNomeFantasia.setForeground(Color.black);
		jlCpfCnpj.setForeground(Color.black);
		jlRamoEmpresarial.setForeground(Color.black);
		jlContato.setForeground(Color.black);
		jlEmail.setForeground(Color.black);
		jlCidade.setForeground(Color.black);
		jlEstado.setForeground(Color.black);
		jlStatus.setForeground(Color.black);
		jlNomeFantasiaDeletar.setForeground(Color.black);
		jlCodigoDeletar.setForeground(Color.black);
		jlCpfCnpjDeletar.setForeground(Color.black);

		jtfCampoRazaoSocial.setForeground(Color.black);
		jtfCampoNomeFantasia.setForeground(Color.black);
		jtfCampoCpfCnpj.setForeground(Color.black);
		jcbComboRamoEmpresarial.setForeground(Color.black);
		jcbComboEstado.setForeground(Color.black);
		jcbComboStatus.setForeground(Color.black);
		jtfCampoContato.setForeground(Color.black);
		jtfCampoEmail.setForeground(Color.black);
		jtfCampoCidade.setForeground(Color.black);
		jtfCampoNomeFantasiaDeletar.setForeground(Color.black);
		jtfCampoCodigoDeletar.setForeground(Color.black);
		jtfCampoCpfCnpjDeletar.setForeground(Color.black);

		jbFechar.setForeground(Color.white);
		jbDeletarItem.setForeground(Color.white);
		jbAtualizar.setForeground(Color.white);
		jbGerarFicha.setForeground(Color.white);
		jbAddNovo.setForeground(Color.white);

		jtTabela.setForeground(Color.white);

		/*
		 * DEFINIÇÃO DE BACKGROUNDS DOS COMPONETES
		 */

		jpCentral.setBackground(new Color(237, 241, 244));

		jbFechar.setBackground(Color.black);
		jbDeletarItem.setBackground(Color.black);
		jbAtualizar.setBackground(Color.black);
		jbGerarFicha.setBackground(Color.black);
		jbAddNovo.setBackground(Color.black);

		jtfCampoRazaoSocial.setBackground(new Color(219, 219, 219));
		jtfCampoNomeFantasia.setBackground(new Color(219, 219, 219));
		jtfCampoCpfCnpj.setBackground(new Color(219, 219, 219));
		jcbComboRamoEmpresarial.setBackground(Color.gray);
		jcbComboEstado.setBackground(Color.gray);
		jcbComboStatus.setBackground(Color.gray);
		jtfCampoContato.setBackground(new Color(219, 219, 219));
		jtfCampoEmail.setBackground(new Color(219, 219, 219));
		jtfCampoCidade.setBackground(new Color(219, 219, 219));
		jtfCampoNomeFantasiaDeletar.setBackground(new Color(219, 219, 219));
		jtfCampoCodigoDeletar.setBackground(new Color(219, 219, 219));
		jtfCampoCpfCnpjDeletar.setBackground(new Color(219, 219, 219));
		jtTabela.setBackground(new Color(20, 20, 20));

		/*
		 * EDITABLIDADE DOS CAMPOS
		 */
		jtfCampoCodigoDeletar.setEditable(false);
		jtfCampoNomeFantasiaDeletar.setEditable(false);
		jtfCampoCpfCnpjDeletar.setEditable(false);

		/*
		 * DEFINIÇÕES DA TABELA
		 */

		dtcrLinhadireita.setHorizontalAlignment(SwingConstants.LEFT);

		jtTabela.getColumnModel().getColumn(0).setPreferredWidth(110);
		jtTabela.getColumnModel().getColumn(0)
				.setCellRenderer(dtcrLinhadireita);

		jtTabela.getColumnModel().getColumn(1).setPreferredWidth(350);

		jtTabela.getColumnModel().getColumn(1)
				.setCellRenderer(dtcrLinhadireita);

		jtTabela.getColumnModel().getColumn(2).setPreferredWidth(350);

		jtTabela.getColumnModel().getColumn(2)
				.setCellRenderer(dtcrLinhadireita);

		jtTabela.getColumnModel().getColumn(3).setPreferredWidth(240);

		jtTabela.getColumnModel().getColumn(3)
				.setCellRenderer(dtcrLinhadireita);

		jtTabela.getColumnModel().getColumn(4).setPreferredWidth(350);

		jtTabela.getColumnModel().getColumn(4)
				.setCellRenderer(dtcrLinhadireita);

		jtTabela.getColumnModel().getColumn(5).setPreferredWidth(140);

		jtTabela.getColumnModel().getColumn(5)
				.setCellRenderer(dtcrLinhadireita);

		jtTabela.getColumnModel().getColumn(6).setPreferredWidth(320);

		jtTabela.getColumnModel().getColumn(6)
				.setCellRenderer(dtcrLinhadireita);

		jtTabela.getTableHeader().setReorderingAllowed(false);
		jtTabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jspScroll.setViewportView(jtTabela);
		jtTabela.setRowHeight(24);

		JTableHeader cabecalho = jtTabela.getTableHeader();
		cabecalho.setFont(font5);
		cabecalho.setForeground(new Color(19, 33, 47));

		jtTabela.setShowGrid(true);
		jtTabela.setGridColor(Color.darkGray);
		jtTabela.setSelectionBackground(new Color(219, 219, 219));
		jtTabela.setSelectionForeground(Color.black);

		jspScroll.setBorder(BorderFactory.createBevelBorder(1));
		jspScroll.getViewport().setBackground(Color.white);

		/*
		 * CONTROLE
		 */
		ControleFornecedor listener = new ControleFornecedor();
		jbDeletarItem.addActionListener(listener);
		jbAtualizar.addActionListener(listener);
		jbGerarFicha.addActionListener(listener);
		jbFechar.addActionListener(listener);
		jbAddNovo.addActionListener(listener);

		/*
		 * FOCUS AO EXECUTAR TELA
		 */
		ConsultarFornecedor.jtfCampoRazaoSocial.requestFocus();

		/*
		 * FOREGROUND E SELEÇÃO DE TEXTOS EFETIOS
		 */
		jtfCampoCidade.setSelectedTextColor(Color.WHITE);
		jtfCampoContato.setSelectedTextColor(Color.WHITE);
		jtfCampoCpfCnpj.setSelectedTextColor(Color.WHITE);
		jtfCampoEmail.setSelectedTextColor(Color.WHITE);
		jtfCampoNomeFantasia.setSelectedTextColor(Color.WHITE);
		jtfCampoRazaoSocial.setSelectedTextColor(Color.WHITE);

		jtfCampoCidade.setSelectionColor(Color.black);
		jtfCampoContato.setSelectionColor(Color.black);
		jtfCampoCpfCnpj.setSelectionColor(Color.black);
		jtfCampoEmail.setSelectionColor(Color.black);
		jtfCampoNomeFantasia.setSelectionColor(Color.black);
		jtfCampoRazaoSocial.setSelectionColor(Color.black);

		/*
		 * ADCIONAMENTO DE INTES AOS COMBOS
		 */
		jcbComboRamoEmpresarial.addItem("");

		jcbComboStatus.addItem("");
		jcbComboStatus.addItem("Ativo");
		jcbComboStatus.addItem("Inativo");

		jcbComboEstado.addItem("");
		jcbComboEstado.addItem("AC");
		jcbComboEstado.addItem("AL");
		jcbComboEstado.addItem("AP");
		jcbComboEstado.addItem("AM");
		jcbComboEstado.addItem("BA");
		jcbComboEstado.addItem("CE");
		jcbComboEstado.addItem("DF");
		jcbComboEstado.addItem("ES");
		jcbComboEstado.addItem("GO");
		jcbComboEstado.addItem("MA");
		jcbComboEstado.addItem("MT");
		jcbComboEstado.addItem("MS");
		jcbComboEstado.addItem("MG");
		jcbComboEstado.addItem("PA");
		jcbComboEstado.addItem("PB");
		jcbComboEstado.addItem("PR");
		jcbComboEstado.addItem("PE");
		jcbComboEstado.addItem("PI");
		jcbComboEstado.addItem("RJ");
		jcbComboEstado.addItem("RN");
		jcbComboEstado.addItem("RS");
		jcbComboEstado.addItem("RO");
		jcbComboEstado.addItem("RR");
		jcbComboEstado.addItem("SC");
		jcbComboEstado.addItem("SP");
		jcbComboEstado.addItem("SE");
		jcbComboEstado.addItem("TO");

		/*
		 * INSTÂNCIA E METÓDO DE ATUALIZAR COMBO ATIVIDADE
		 */
		FornecedorDAO dao = new FornecedorDAO();
		dao.AtualizaTable();
		dao.AtualizaComboRamoEmpresarial(jcbComboRamoEmpresarial);

		/*
		 * EVENTOS RESPONSÁVEIS POR CHAMAR OS METÓDOS QUE ATUALIZAR AS
		 * INFORMAÇÕES DA TABELA
		 */
		jtfCampoRazaoSocial.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent ev) {
				String caracteres = "'";

				if (caracteres.contains(ev.getKeyChar() + "")) {

					ev.consume();

				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				FornecedorDAO dao = new FornecedorDAO();
				dao.AtualizaTable();

			}

			@Override
			public void keyPressed(KeyEvent e) {

			}
		});

		jtfCampoNomeFantasia.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent ev) {
				String caracteres = "'";

				if (caracteres.contains(ev.getKeyChar() + "")) {

					ev.consume();

				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				FornecedorDAO f = new FornecedorDAO();
				f.AtualizaTable();

			}

			@Override
			public void keyPressed(KeyEvent e) {

			}
		});

		jtfCampoCpfCnpj.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent ev) {
				String caracteres = "/.-0987654321";

				if (!caracteres.contains(ev.getKeyChar() + "")) {

					ev.consume();

				}

			}

			@Override
			public void keyReleased(KeyEvent e) {
				FornecedorDAO f = new FornecedorDAO();
				f.AtualizaTable();

			}

			@Override
			public void keyPressed(KeyEvent e) {

			}
		});

		jtfCampoContato.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent ev) {
				String caracteres = "'";

				if (caracteres.contains(ev.getKeyChar() + "")) {

					ev.consume();

				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				FornecedorDAO dao = new FornecedorDAO();
				dao.AtualizaTable();

			}

			@Override
			public void keyPressed(KeyEvent e) {

			}
		});

		jtfCampoEmail.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent arg0) {
				ConsultarFornecedor.jtfCampoCodigoDeletar.requestFocus();

			}

			@Override
			public void focusGained(FocusEvent arg0) {

			}
		});

		jtfCampoEmail.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent ev) {
				String caracteres = "'";

				if (caracteres.contains(ev.getKeyChar() + "")) {

					ev.consume();

				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				FornecedorDAO dao = new FornecedorDAO();
				dao.AtualizaTable();

			}

			@Override
			public void keyPressed(KeyEvent e) {

			}
		});

		jtfCampoCidade.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent ev) {
				String caracteres = "'";

				if (caracteres.contains(ev.getKeyChar() + "")) {

					ev.consume();

				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				FornecedorDAO dao = new FornecedorDAO();
				dao.AtualizaTable();

			}

			@Override
			public void keyPressed(KeyEvent e) {

			}
		});

		jcbComboRamoEmpresarial.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FornecedorDAO dao = new FornecedorDAO();
				dao.AtualizaTable();
			}
		});

		jcbComboEstado.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FornecedorDAO dao = new FornecedorDAO();
				dao.AtualizaTable();
			}
		});

		jcbComboStatus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FornecedorDAO dao = new FornecedorDAO();
				dao.AtualizaTable();
			}
		});

		/*
		 * EVENTO RESPONÁVEL PELO CLIQUE EM UM ITEM DA TABELA
		 */
		jtTabela.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				FornecedorDAO dao = new FornecedorDAO();
				dao.selecionarItens();
				String codigo = ConsultarFornecedor.jtfCampoCodigoDeletar
						.getText();

				if (e.getClickCount() == 2) {
					AtualizarFornecedor objeto = new AtualizarFornecedor();
					AtualizarFornecedor.jtfCampoCodigo.setText(codigo);
					dao.AcaoDoBotaoOkFornecedor();
					objeto.setVisible(true);
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
					ConsultarFornecedor.jftela.dispose();
				}
			}
		});

		/*
		 * EVENTO RESPONSÁVEL PELO ENTER DO TECLADO DO BOTÃO GERAR FICHA
		 */

		jbGerarFicha.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					FornecedorDAO dao = new FornecedorDAO();
					dao.RelatorioFicha();
				}
			}
		});

		/*
		 * EVENTO RESPONSÁVEL PELO ENTER DO TECLADO DO BOTÃO ATUALIZAR
		 */

		jbAtualizar.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					FornecedorDAO dao = new FornecedorDAO();
					String codigo = ConsultarFornecedor.jtfCampoCodigoDeletar
							.getText();
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

		});

		/*
		 * EVENTO RESPONSÁVEL PELO ENTER DO TECLADO DO BOTÃO ATUALIZAR
		 */

		jbAddNovo.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				CadastrarFornecedor objeto = new CadastrarFornecedor();
				objeto.setVisible(true);
			}

		});

		/*
		 * EVENTO RESPONSÁVEL PELO ENTER DO TECLADO DO BOTÃO DELETAR ITEM
		 */
		jbDeletarItem.addKeyListener(new KeyListener() {

			// EVENTOS DE KEYLISTENER

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				FornecedorDAO dao = new FornecedorDAO();
				dao.AcaodoBotaoDeletarFornecedor();

			}
		});

		/*
		 * EVENTO RESPONSÁVEL PELO DELETE DO TECLADO NA TABELA
		 */

		jtTabela.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				FornecedorDAO dao = new FornecedorDAO();
				dao.selecionarItens();
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					dao.AcaodoBotaoDeletarFornecedor();
				} else if (e.getKeyCode() == KeyEvent.VK_TAB) {
					ConsultarFornecedor.jtfCampoCodigoDeletar.requestFocus();
				}
			}
		});
	}
	
}
