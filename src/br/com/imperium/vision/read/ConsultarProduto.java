package br.com.imperium.vision.read;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import br.com.imperium.vision.update.AtualizarFornecedor;

public class ConsultarProduto extends JFrame {

	// SERIAL DA VERSÃO DO JAVA
	private static final long serialVersionUID = 1L;

	// TEXTOS
	public static JLabel jlTituloPainel;
	public static JLabel jlTituloContainer;
	public static JLabel jlCodigoBarras;
	public static JLabel jlCodigoPersonalizado;
	public static JLabel jlDescricao;
	public static JLabel jlCategoria;
	public static JLabel jlFornecedor;
	public static JLabel jlTipo;
	public static JLabel jlStatus;
	public static JLabel jlCodigoDeletar;
	public static JLabel jlNomeFantasiaDeletar;
	public static JLabel jlCpfCnpjDeletar;

	// CAMPOS DE DIGITAÇÃO
	public static JTextField jtfCampoCodigoBarras;
	public static JTextField jtfCampoCodigoPersonalizado;
	public static JTextField jtfCampoDescricao;
	public static JComboBox<String> jcbComboCategoria;
	public static JComboBox<String> jcbComboFornecedor;
	public static JComboBox<String> jcbComboTipo;
	public static JComboBox<String> jcbComboStatus;
	public static JTextField jtfCampoNomeFantasiaDeletar;
	public static JTextField jtfCampoCodigoDeletar;
	public static JTextField jtfCampoCpfCnpjDeletar;

	// BOTÕES
	public static JButton jbFechar;
	public static JButton jbDeletarItem;
	public static JButton jbAddNovo;
	public static JButton jbAtualizar;
	public static JButton jbGerarFicha;

	public static JPanel jpCentral;
	// ICONES

	public static JLabel jlIconeFornecedor;
	public static JLabel jlIconeConsultar;

	// TABELA
	public static JTable jtTabela;

	// SCROLL
	public static JScrollPane jspScroll;

	// MODELO
	public static DefaultTableModel dftModelo;

	// TELA
	public static JFrame jftela;

	// CELL
	public static DefaultTableCellRenderer dtcrLinhadireita;

	private static Point point;

	Font font;
	Font font2;
	Font font3;
	Font font4;
	Font font5;
	Font font6;

	/** METÓDO CONSTRUTUTOR **/
	public ConsultarProduto() {
		setUndecorated(true);
		Container c = getContentPane();
		jftela = this;
		setSize(1125, 604);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		// CONTAINER
		c.setBackground(Color.black);
		c.setLayout(null);

		font = new Font("CAMBRIA", Font.PLAIN, 20);
		font2 = new Font("CAMBRIA", Font.BOLD, 22);
		font3 = new Font("CAMBRIA", Font.BOLD, 24);
		font4 = new Font("CAMBRIA", Font.PLAIN, 20);
		font5 = new Font("CAMBRIA", Font.BOLD, 20);
		font6 = new Font("CAMBRIA", Font.PLAIN, 18);

		try {
			UIManager
					.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			//
			e.printStackTrace();
		}

		/**
		 * ------------ INICIO DAS INICIALIZÁVEIS -----------
		 */

		// POINT
		point = new Point();

		// PAINEL
		jpCentral = new JPanel();

		// SCROLL DA TABELA
		jspScroll = new JScrollPane();

		// MODELO
		dftModelo = new DefaultTableModel(new String[] { "Código", "Descrição",
				"Tipo", "Categoria", "Em Estoque", "Código de Barras",
				"Código Personalizado", "Fornecedor", "Esotuqe Mínimo",
				"Valor de Custo", "Margem de Lucro", "Valor de Venda",
				"Status", "Data de Cadastro" }, 0) {
			public boolean isCellEditable(int row, int col) {
				if (col == 0 || col == 1 || col == 2 || col == 3 || col == 4
						|| col == 5 || col == 6 || col == 7 || col == 8
						|| col == 9 || col == 10 || col == 11 || col == 12
						|| col == 13) {
					return false;
				}
				return true;
			}

			private static final long serialVersionUID = 1L;

		};

		// TABELA
		jtTabela = new JTable(dftModelo);

		// LINHA
		dtcrLinhadireita = new DefaultTableCellRenderer();

		// NOMES
		jlTituloPainel = new JLabel("Menu Produto");
		jlTituloContainer = new JLabel("Módulo Cadastros - Menu Produto");
		jlCodigoBarras = new JLabel("Cód. de Barras:");
		jlCodigoPersonalizado = new JLabel("Cód. Personalizado:");
		jlDescricao = new JLabel("Descricao:");
		jlCategoria = new JLabel("Categoria:");
		jlFornecedor = new JLabel("Fornecedor:");
		jlTipo = new JLabel("Tipo:");
		jlStatus = new JLabel("Status:");
		jlNomeFantasiaDeletar = new JLabel("Descrição:");
		jlCpfCnpjDeletar = new JLabel("Código de Barras:");
		jlCodigoDeletar = new JLabel("Código:");

		// CAMPOS DE DOGOTAÇÃO
		jtfCampoCodigoBarras = new JTextField();
		jtfCampoCodigoPersonalizado = new JTextField();
		jtfCampoDescricao = new JTextField();
		jcbComboCategoria = new JComboBox<String>();
		jcbComboFornecedor = new JComboBox<String>();
		jcbComboTipo = new JComboBox<String>();
		jcbComboStatus = new JComboBox<String>();
		jtfCampoNomeFantasiaDeletar = new JTextField();
		jtfCampoCpfCnpjDeletar = new JTextField();
		jtfCampoCodigoDeletar = new JTextField();

		// BOTÕES
		jbFechar = new JButton("X");
		jbDeletarItem = new JButton("Deletar Item");
		jbAtualizar = new JButton("Atualizar");
		jbGerarFicha = new JButton("Gerar Ficha");
		jbAddNovo = new JButton("Add Produto");

		// ICONES
		jlIconeFornecedor = new JLabel(new ImageIcon("res/produto.png"));
		jlIconeConsultar = new JLabel(new ImageIcon("res/produto.png"));

		/**
		 * -------- FIM DOS INICIALIZÁVEIS -----------
		 */

		/**
		 * -------- INICIO DO ADICIONANDO AO CONTAINER -----------
		 */

		// PAINEL
		c.add(jpCentral);

		// BOTÕES
		c.add(jbFechar);

		// NOMES
		c.add(jlTituloContainer);

		// ICONES
		c.add(jlIconeFornecedor);

		/**
		 * -------- FIM DO ADICIONAMENTO AO CONTAINER -----------
		 */

		/**
		 * -------- INICIO DA DEFINIÇÃO DE LAYOUTS -----------
		 */

		jpCentral.setLayout(null);

		/**
		 * -------- FIM DA DEFINIÇÃO DE LAYOUTS -----------
		 */

		/**
		 * -------- INICIO DO ADICIONANDO AO PAINEL CENTRAL -----------
		 */

		// NOMES
		jpCentral.add(jlTituloPainel);
		jpCentral.add(jlCodigoBarras);
		jpCentral.add(jlCodigoPersonalizado);
		jpCentral.add(jlDescricao);
		jpCentral.add(jlCategoria);
		jpCentral.add(jlFornecedor);
		jpCentral.add(jlTipo);
		jpCentral.add(jlStatus);
		jpCentral.add(jlNomeFantasiaDeletar);
		jpCentral.add(jlCpfCnpjDeletar);
		jpCentral.add(jlCodigoDeletar);

		// CAMPOS DE DIGITAÇÃO
		jpCentral.add(jtfCampoCodigoBarras);
		jpCentral.add(jtfCampoCodigoPersonalizado);
		jpCentral.add(jtfCampoDescricao);
		jpCentral.add(jcbComboCategoria);
		jpCentral.add(jcbComboFornecedor);
		jpCentral.add(jcbComboTipo);
		jpCentral.add(jcbComboStatus);
		jpCentral.add(jtfCampoNomeFantasiaDeletar);
		jpCentral.add(jtfCampoCpfCnpjDeletar);
		jpCentral.add(jtfCampoCodigoDeletar);

		// BOTÕES
		jpCentral.add(jbDeletarItem);
		jpCentral.add(jbAtualizar);
		jpCentral.add(jbGerarFicha);
		jpCentral.add(jbAddNovo);

		// ICONES
		jpCentral.add(jlIconeConsultar);

		// SRCOLL DA TABELA
		jpCentral.add(jspScroll);

		/**
		 * -------- FIM DO ADICIONAMENTO AO PAINEL CENTRAL -----------
		 */

		/***
		 * ----- INICIO DA DEFINIÇÃO DE TAMANHO DE FONTE DOS COMPONENTES ----
		 ***/

		// NOMES
		jlTituloContainer.setFont(font4);
		jlTituloPainel.setFont(font3);
		jlCodigoBarras.setFont(font2);
		jlCodigoPersonalizado.setFont(font2);
		jlDescricao.setFont(font2);
		jlCategoria.setFont(font2);
		jlFornecedor.setFont(font2);
		jlTipo.setFont(font2);
		jlStatus.setFont(font2);
		jlNomeFantasiaDeletar.setFont(font2);
		jlCodigoDeletar.setFont(font2);
		jlCpfCnpjDeletar.setFont(font2);

		// CAMPOS DE DIGITAÇÃO
		jtfCampoCodigoBarras.setFont(font);
		jtfCampoCodigoPersonalizado.setFont(font);
		jtfCampoDescricao.setFont(font);
		jcbComboCategoria.setFont(font);
		jcbComboFornecedor.setFont(font);
		jcbComboTipo.setFont(font);
		jcbComboStatus.setFont(font);
		jtfCampoNomeFantasiaDeletar.setFont(font);
		jtfCampoCodigoDeletar.setFont(font);
		jtfCampoCpfCnpjDeletar.setFont(font);

		// BOTÕES
		jbDeletarItem.setFont(font6);
		jbAtualizar.setFont(font6);
		jbGerarFicha.setFont(font6);
		jbAddNovo.setFont(font6);

		jtTabela.setFont(font6);

		/***
		 * ----- FIM DA DEFINIÇÃO DE TAMANHO DE FONTE DOS COMPONENTES ----
		 ***/
		/**
		 * -------- INICIO DA DEFINIÇÃO DE COORDENADAS E TAMANHO DOS COMPONENTES
		 * -----------
		 */

		// PAINEL
		jpCentral.setBounds(5, 35, 1115, 564);

		// NOMES
		Dimension dTituloContainer = jlTituloContainer.getPreferredSize();
		jlTituloContainer.setBounds(43, 7, dTituloContainer.width,
				dTituloContainer.height);
		Dimension dTituloPainel = jlTituloPainel.getPreferredSize();
		jlTituloPainel.setBounds(460, 9, dTituloPainel.width,
				dTituloPainel.height);
		Dimension dCodigoBarras = jlCodigoBarras.getPreferredSize();
		jlCodigoBarras.setBounds(15, 99, dCodigoBarras.width,
				dCodigoBarras.height);
		Dimension dCodigoPersonalizado = jlCodigoPersonalizado
				.getPreferredSize();
		jlCodigoPersonalizado.setBounds(15, 140, dCodigoPersonalizado.width,
				dCodigoPersonalizado.height);
		Dimension dDescricao = jlDescricao.getPreferredSize();
		jlDescricao.setBounds(15, 58, dDescricao.width, dDescricao.height);
		Dimension dCategoria = jlCategoria.getPreferredSize();
		jlCategoria.setBounds(410, 58, dCategoria.width, dCategoria.height);
		Dimension dFornecedor = jlFornecedor.getPreferredSize();
		jlFornecedor.setBounds(410, 99, dFornecedor.width, dFornecedor.height);
		Dimension dTipo = jlTipo.getPreferredSize();
		jlTipo.setBounds(410, 140, dTipo.width, dTipo.height);
		Dimension dStatus = jlStatus.getPreferredSize();
		jlStatus.setBounds(770, 140, dStatus.width, dStatus.height);
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

		// CAMPOS DE DIGITAÇÃO
		jtfCampoCodigoBarras.setBounds(180, 97, 225, 34);
		jtfCampoCodigoPersonalizado.setBounds(220, 138, 185, 34);
		jtfCampoDescricao.setBounds(130, 56, 275, 34);
		jcbComboCategoria.setBounds(530, 56, 235, 34);
		jcbComboFornecedor.setBounds(530, 97, 235, 34);
		jcbComboTipo.setBounds(530, 138, 235, 34);
		jcbComboStatus.setBounds(860, 138, 235, 34);
		jtfCampoCodigoDeletar.setBounds(21, 518, 90, 34);
		jtfCampoNomeFantasiaDeletar.setBounds(116, 518, 313, 34);
		jtfCampoCpfCnpjDeletar.setBounds(436, 518, 225, 34);

		// BOTÕES
		jbFechar.setBounds(1080, 4, 35, 25);
		jbDeletarItem.setBounds(815, 518, 140, 34);
		jbAtualizar.setBounds(960, 518, 135, 34);
		jbGerarFicha.setBounds(670, 518, 140, 34);
		jbAddNovo.setBounds(935, 10, 160, 34);

		// ICONES
		Dimension dIconeFornecedor = jlIconeFornecedor.getPreferredSize();
		jlIconeFornecedor.setBounds(8, 3, dIconeFornecedor.width,
				dIconeFornecedor.height);

		Dimension dIconeConsultar = jlIconeConsultar.getPreferredSize();
		jlIconeConsultar.setBounds(422, 6, dIconeConsultar.width,
				dIconeConsultar.height);

		// SCROOL
		jspScroll.setBounds(14, 180, 1085, 305);

		/***
		 * ----- FIM DA DEFINIÇÃO DE COORDENADAS E TAMANHO DOS COMPONENTES ----
		 ***/

		/***
		 * ----- INICIO DA DEFINIÇÃO DE COR DA FONTE DOS COMPONENTES ----
		 ***/

		// NOMES
		jlTituloContainer.setForeground(Color.white);
		jlTituloPainel.setForeground(Color.black);
		jlCodigoBarras.setForeground(Color.black);
		jlCodigoPersonalizado.setForeground(Color.black);
		jlDescricao.setForeground(Color.black);
		jlCategoria.setForeground(Color.black);
		jlFornecedor.setForeground(Color.black);
		jlTipo.setForeground(Color.black);
		jlStatus.setForeground(Color.black);
		jlNomeFantasiaDeletar.setForeground(Color.black);
		jlCodigoDeletar.setForeground(Color.black);
		jlCpfCnpjDeletar.setForeground(Color.black);

		// CAMPOS DE DOGITACAO
		jtfCampoCodigoBarras.setForeground(Color.black);
		jtfCampoCodigoPersonalizado.setForeground(Color.black);
		jtfCampoDescricao.setForeground(Color.black);
		jcbComboCategoria.setForeground(Color.black);
		jcbComboTipo.setForeground(Color.black);
		jcbComboStatus.setForeground(Color.black);
		jcbComboFornecedor.setForeground(Color.black);
		jtfCampoNomeFantasiaDeletar.setForeground(Color.black);
		jtfCampoCodigoDeletar.setForeground(Color.black);
		jtfCampoCpfCnpjDeletar.setForeground(Color.black);

		// BOTÕES
		jbFechar.setForeground(Color.white);
		jbDeletarItem.setForeground(Color.white);
		jbAtualizar.setForeground(Color.white);
		jbGerarFicha.setForeground(Color.white);
		jbAddNovo.setForeground(Color.white);

		// TABELA
		jtTabela.setForeground(Color.white);

		/***
		 * ----- FIM DA DEFINIÇÃO DE COR DA FONTE DOS COMPONENTES ----
		 ***/

		/***
		 * ----- INICIO DA DEFINIÇÃO DE BACKGROUND DOS COMPONENTES ----
		 ***/

		// PAINEL
		jpCentral.setBackground(new Color(237, 241, 244));

		// BOTÕES
		jbFechar.setBackground(Color.black);
		jbDeletarItem.setBackground(Color.black);
		jbAtualizar.setBackground(Color.black);
		jbGerarFicha.setBackground(Color.black);
		jbAddNovo.setBackground(Color.black);

		// CAMPOS DE DOGITACAO
		jtfCampoCodigoBarras.setBackground(new Color(219, 219, 219));
		jtfCampoCodigoPersonalizado.setBackground(new Color(219, 219, 219));
		jtfCampoDescricao.setBackground(new Color(219, 219, 219));
		jcbComboCategoria.setBackground(Color.gray);
		jcbComboTipo.setBackground(Color.gray);
		jcbComboStatus.setBackground(Color.gray);
		jcbComboFornecedor.setBackground(Color.gray);
		jtfCampoNomeFantasiaDeletar.setBackground(new Color(219, 219, 219));
		jtfCampoCodigoDeletar.setBackground(new Color(219, 219, 219));
		jtfCampoCpfCnpjDeletar.setBackground(new Color(219, 219, 219));

		// TABELA
		jtTabela.setBackground(new Color(20, 20, 20));

		/***
		 * ----- FIM DA DEFINIÇÃO DE COR DE BACKGROUND DOS COMPONENTES ----
		 ***/

		// EDITABILIDADE DOS CAMPOS FALSA
		jtfCampoCodigoDeletar.setEditable(false);
		jtfCampoNomeFantasiaDeletar.setEditable(false);
		jtfCampoCpfCnpjDeletar.setEditable(false);

		/***
		 * ----- INICIO DAS CONFIGURAÇÕES DE COLUNAS E LINHAS DATABELA ----
		 ***/

		dtcrLinhadireita.setHorizontalAlignment(SwingConstants.LEFT);

		// EDITANDO AS COLUNAS

		// COLUNA 0
		jtTabela.getColumnModel().getColumn(0).setPreferredWidth(110);
		jtTabela.getColumnModel().getColumn(0)
				.setCellRenderer(dtcrLinhadireita);

		// COLUNA 1
		jtTabela.getColumnModel().getColumn(1).setPreferredWidth(350);

		jtTabela.getColumnModel().getColumn(1)
				.setCellRenderer(dtcrLinhadireita);

		// COLUNA 2
		jtTabela.getColumnModel().getColumn(2).setPreferredWidth(300);

		jtTabela.getColumnModel().getColumn(2)
				.setCellRenderer(dtcrLinhadireita);

		// COLUNA 3
		jtTabela.getColumnModel().getColumn(3).setPreferredWidth(300);

		jtTabela.getColumnModel().getColumn(3)
				.setCellRenderer(dtcrLinhadireita);

		// COLUNA 4
		jtTabela.getColumnModel().getColumn(4).setPreferredWidth(180);

		jtTabela.getColumnModel().getColumn(4)
				.setCellRenderer(dtcrLinhadireita);

		// COLUNA 5
		jtTabela.getColumnModel().getColumn(5).setPreferredWidth(250);

		jtTabela.getColumnModel().getColumn(5)
				.setCellRenderer(dtcrLinhadireita);

		// COLUNA 6
		jtTabela.getColumnModel().getColumn(6).setPreferredWidth(250);

		jtTabela.getColumnModel().getColumn(6)
				.setCellRenderer(dtcrLinhadireita);

		// COLUNA 7
		jtTabela.getColumnModel().getColumn(7).setPreferredWidth(320);

		jtTabela.getColumnModel().getColumn(7)
				.setCellRenderer(dtcrLinhadireita);

		// COLUNA 8
		jtTabela.getColumnModel().getColumn(8).setPreferredWidth(180);

		jtTabela.getColumnModel().getColumn(8)
				.setCellRenderer(dtcrLinhadireita);

		// COLUNA 9
		jtTabela.getColumnModel().getColumn(9).setPreferredWidth(200);

		jtTabela.getColumnModel().getColumn(9)
				.setCellRenderer(dtcrLinhadireita);

		// COLUNA 10
		jtTabela.getColumnModel().getColumn(10).setPreferredWidth(200);

		jtTabela.getColumnModel().getColumn(10)
				.setCellRenderer(dtcrLinhadireita);

		// COLUNA 11
		jtTabela.getColumnModel().getColumn(11).setPreferredWidth(200);

		jtTabela.getColumnModel().getColumn(11)
				.setCellRenderer(dtcrLinhadireita);

		// COLUNA 12
		jtTabela.getColumnModel().getColumn(12).setPreferredWidth(200);

		jtTabela.getColumnModel().getColumn(12)
				.setCellRenderer(dtcrLinhadireita);

		// COLUNA 13
		jtTabela.getColumnModel().getColumn(13).setPreferredWidth(200);

		jtTabela.getColumnModel().getColumn(13)
				.setCellRenderer(dtcrLinhadireita);

		jtTabela.getTableHeader().setReorderingAllowed(false);
		jtTabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jspScroll.setViewportView(jtTabela);
		jtTabela.setRowHeight(24);

		JTableHeader cabecalho = jtTabela.getTableHeader();
		cabecalho.setFont(font5);
		cabecalho.setForeground(new Color(19, 33, 47));

		// GRADE
		jtTabela.setShowGrid(true);
		jtTabela.setGridColor(Color.darkGray);
		jtTabela.setSelectionBackground(new Color(219, 219, 219));
		jtTabela.setSelectionForeground(Color.black);

		jspScroll.setBorder(BorderFactory.createBevelBorder(1));
		jspScroll.getViewport().setBackground(Color.white);

		// Produto p = new Produto();
		// f.AtualizaTable();
		// f.AtualizaComboAtividadeConsultar();

		ControleFornecedor listener = new ControleFornecedor();
		jbDeletarItem.addActionListener(listener);
		jbAtualizar.addActionListener(listener);
		jbGerarFicha.addActionListener(listener);
		jbFechar.addActionListener(listener);
		jbAddNovo.addActionListener(listener);

		ConsultarProduto.jtfCampoDescricao.requestFocus();

		/***
		 * ----- INICIO DO EFEITO DE CORES DE SELÇÃO DO TEXTO ----
		 ***/

		jtfCampoDescricao.setSelectedTextColor(Color.WHITE);
		jtfCampoCodigoPersonalizado.setSelectedTextColor(Color.WHITE);
		jtfCampoCodigoBarras.setSelectedTextColor(Color.WHITE);

		jtfCampoDescricao.setSelectionColor(Color.black);
		jtfCampoCodigoPersonalizado.setSelectionColor(Color.black);
		jtfCampoCodigoBarras.setSelectionColor(Color.black);

		/***
		 * ----- FIM DO EFEITO DE CORES DE SELÇÃO DO TEXTO ----
		 ***/

		/***
		 * ----- INICIO DO ADICIONAMENTO DE ITENS AOS COMBOS ----
		 ***/
		// COMBO ATIVIDADE
		jcbComboCategoria.addItem("");

		// COMBO STATUS
		jcbComboStatus.addItem("");
		jcbComboStatus.addItem("Ativo");
		jcbComboStatus.addItem("Inativo");

		// COMBO UF
		jcbComboTipo.addItem("");

		/***
		 * ----- FIM DO ADICIONAMENTO DE ITENS AOS COMBOS ----
		 ***/

		jtfCampoCodigoBarras.addKeyListener(new KeyListener() {

			// EVENTOS DE KEYLISTENER
			@Override
			public void keyTyped(KeyEvent e) {

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

		jtfCampoCodigoPersonalizado.addKeyListener(new KeyListener() {

			// EVENTOS DE KEYLISTENER
			@Override
			public void keyTyped(KeyEvent e) {

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

		jtfCampoDescricao.addKeyListener(new KeyListener() {

			// EVENTOS DE KEYLISTENER
			@Override
			public void keyTyped(KeyEvent e) {

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

		jcbComboCategoria.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FornecedorDAO f = new FornecedorDAO();
				f.AtualizaTable();
			}
		});

		jcbComboTipo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FornecedorDAO f = new FornecedorDAO();
				f.AtualizaTable();
			}
		});

		jcbComboFornecedor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FornecedorDAO f = new FornecedorDAO();
				f.AtualizaTable();
			}
		});

		jcbComboStatus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FornecedorDAO f = new FornecedorDAO();
				f.AtualizaTable();
			}
		});

		// CLIQUE NO ITEM DA TABELA
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
				FornecedorDAO f = new FornecedorDAO();
				f.selecionarItens();

				if (e.getClickCount() == 2) {
					FornecedorDAO forne = new FornecedorDAO();
					String codigo = ConsultarProduto.jtfCampoCodigoDeletar
							.getText();

					if (AtualizarFornecedor.tela == null) {
						if (codigo.equals("")) {
							new AtualizarFornecedor();
							AtualizarFornecedor.jtfCampoCodigo.requestFocus();

						} else {
							new AtualizarFornecedor();
							AtualizarFornecedor.jtfCampoCodigo
									.setText(ConsultarProduto.jtfCampoCodigoDeletar
											.getText());
							forne.AcaoDoBotaoOkFornecedor();
							AtualizarFornecedor.jtfCampoNomeRazaoSocial
									.requestFocus();

						}

					} else if (AtualizarFornecedor.tela != null) {
						JOptionPane.showMessageDialog(null,
								"(ATENÇÃO - TELA EM EXECUÇÃO)",
								"ATUALIZAÇÃO DE FORNECEDORES",
								JOptionPane.WARNING_MESSAGE);
						AtualizarFornecedor.tela.setLocationRelativeTo(null);
						AtualizarFornecedor.tela.requestFocus();

						try {
							int originalX = AtualizarFornecedor.tela
									.getLocation().x;
							int originalY = AtualizarFornecedor.tela
									.getLocation().y;
							long sleepTime = 30;

							for (int i = 0; i <= 2; i++) {
								AtualizarFornecedor.tela.setLocation(
										originalX + 5, originalY);
								Thread.sleep(sleepTime);
								AtualizarFornecedor.tela.setLocation(
										originalX + 5, originalY + 5);
								Thread.sleep(sleepTime);
								AtualizarFornecedor.tela.setLocation(originalX,
										originalY + 5);
								Thread.sleep(sleepTime);
								AtualizarFornecedor.tela.setLocation(originalX,
										originalY);
								Thread.sleep(sleepTime);
								AtualizarFornecedor.tela.setLocation(
										originalX - 5, originalY);
								Thread.sleep(sleepTime);
								AtualizarFornecedor.tela.setLocation(
										originalX - 5, originalY - 5);
								Thread.sleep(sleepTime);
								AtualizarFornecedor.tela.setLocation(originalX,
										originalY - 5);
								Thread.sleep(sleepTime);
							}
							AtualizarFornecedor.tela.setLocation(originalX,
									originalY);

						} catch (Exception ex) {
							JOptionPane
									.showMessageDialog(
											null,
											"(ERRO 0031) - (MODELO FORNECEDOR)\n"
													+ "(CONTRATE O PROGRAMADOR DO SISTEMA)",
											"FORNECEDOR",
											JOptionPane.ERROR_MESSAGE);
						}
					}

				}
			}
		});

		jbFechar.addKeyListener(new KeyListener() {

			// EVENTOS DE KEYLISTENER

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					ConsultarProduto.jftela.dispose();
					ConsultarProduto.jftela = null;
				}
			}
		});

		jbGerarFicha.addKeyListener(new KeyListener() {

			// EVENTOS DE KEYLISTENER

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					FornecedorDAO f = new FornecedorDAO();
					f.RelatorioFicha();
				}
			}
		});

		jbAtualizar.addKeyListener(new KeyListener() {

			// EVENTOS DE KEYLISTENER

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				FornecedorDAO f = new FornecedorDAO();
				String codigo = ConsultarProduto.jtfCampoCodigoDeletar
						.getText();

				if (AtualizarFornecedor.tela == null) {
					if (codigo.equals("")) {
						new AtualizarFornecedor();
						AtualizarFornecedor.jtfCampoCodigo.requestFocus();

					} else {
						new AtualizarFornecedor();
						AtualizarFornecedor.jtfCampoCodigo
								.setText(ConsultarProduto.jtfCampoCodigoDeletar
										.getText());
						f.AcaoDoBotaoOkFornecedor();
						AtualizarFornecedor.jtfCampoNomeRazaoSocial
								.requestFocus();

					}

				} else if (AtualizarFornecedor.tela != null) {
					JOptionPane.showMessageDialog(null,
							"(ATENÇÃO - TELA EM EXECUÇÃO)",
							"ATUALIZAÇÃO DE FORNECEDORES",
							JOptionPane.WARNING_MESSAGE);
					AtualizarFornecedor.tela.setLocationRelativeTo(null);
					AtualizarFornecedor.tela.requestFocus();

					try {
						int originalX = AtualizarFornecedor.tela.getLocation().x;
						int originalY = AtualizarFornecedor.tela.getLocation().y;
						long sleepTime = 30;

						for (int i = 0; i <= 2; i++) {
							AtualizarFornecedor.tela.setLocation(originalX + 5,
									originalY);
							Thread.sleep(sleepTime);
							AtualizarFornecedor.tela.setLocation(originalX + 5,
									originalY + 5);
							Thread.sleep(sleepTime);
							AtualizarFornecedor.tela.setLocation(originalX,
									originalY + 5);
							Thread.sleep(sleepTime);
							AtualizarFornecedor.tela.setLocation(originalX,
									originalY);
							Thread.sleep(sleepTime);
							AtualizarFornecedor.tela.setLocation(originalX - 5,
									originalY);
							Thread.sleep(sleepTime);
							AtualizarFornecedor.tela.setLocation(originalX - 5,
									originalY - 5);
							Thread.sleep(sleepTime);
							AtualizarFornecedor.tela.setLocation(originalX,
									originalY - 5);
							Thread.sleep(sleepTime);
						}
						AtualizarFornecedor.tela.setLocation(originalX,
								originalY);

					} catch (Exception ex) {
						JOptionPane
								.showMessageDialog(
										null,
										"(ERRO 0032) - (MODELO FORNECEDOR)\n"
												+ "(CONTRATE O PROGRAMADOR DO SISTEMA)",
										"FORNECEDOR", JOptionPane.ERROR_MESSAGE);
					}
				}
			}

		});

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
				FornecedorDAO f = new FornecedorDAO();
				f.AcaodoBotaoDeletarFornecedor();

			}
		});

		jtTabela.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				FornecedorDAO f = new FornecedorDAO();
				f.selecionarItens();
				if (e.getKeyCode() == KeyEvent.VK_DELETE) {
					f.AcaodoBotaoDeletarFornecedor();
				}
			}
		});

		jftela.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				point.x = e.getX();
				point.y = e.getY();
			}
		});
		jftela.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point p = jftela.getLocation();
				jftela.setLocation(p.x + e.getX() - point.x, p.y + e.getY()
						- point.y);
			}
		});

		jftela.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {

			}

			@Override
			public void windowIconified(WindowEvent e) {

			}

			@Override
			public void windowDeiconified(WindowEvent e) {

			}

			@Override
			public void windowDeactivated(WindowEvent e) {

			}

			@Override
			public void windowClosing(WindowEvent e) {
				try {
					ConsultarProduto.jftela.dispose();
					ConsultarProduto.jftela = null;
					JOptionPane
							.showMessageDialog(
									null,
									"(MANUSEIO INCORRETO DO SISTEMA) \n"
											+ "OPERAÇÕES DO SISTEMA PEGGYSYSTEM - RECOMENDADAS\n"
											+ "OPERAÇÕES DO SISTEMA OPERACIONAL - NÃO RECOMENDADAS",
									"CONSULTA DE FORNECEDORES",
									JOptionPane.WARNING_MESSAGE);
				} catch (NullPointerException ex) {
					JOptionPane.showMessageDialog(null,
							"(ERRO 0033) - (MODELO FORNECEDOR)\n"
									+ "(CONTRATE O PROGRAMADOR DO SISTEMA)",
							"FORNECEDOR", JOptionPane.ERROR_MESSAGE);
				}
			}

			@Override
			public void windowClosed(WindowEvent e) {

			}

			@Override
			public void windowActivated(WindowEvent e) {

			}
		});
	}

	public static void main(String[] args) {
		new ConsultarProduto();
	}
}
