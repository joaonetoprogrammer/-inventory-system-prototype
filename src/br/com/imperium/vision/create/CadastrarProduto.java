package br.com.imperium.vision.create;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * CLASSE CADASTRARPRODUTO DO PACOTE BR.COM.IMPERIUM.VISAO.CADASTRAR.CADASTROS
 * 
 * @author JOAO DE SOUZA NETO
 *
 * */
public class CadastrarProduto extends JFrame {

	/*
	 * SERIAL DA VERSÃO DO JAVA
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * CRIAÇÃO DOS COMPONENTES DA CLASSE
	 */
	public static JLabel jlTituloPainel;
	public static JLabel jlTituloContainer;
	public static JLabel jlCodigoBarrras;
	public static JLabel jlCodigoPersonalizado;
	public static JLabel jlCategoria;
	public static JLabel jlTipo;
	public static JLabel jlDescricao;

	public static JTextField jtfCampoCodigoBarras;
	public static JTextField jtfCampoCodigoPersonalizado;
	public static JComboBox <String> jcbComboCategoria;
	public static JComboBox <String> jcbComboTipo;
	public static JTextField jtfCampoDescricao;


	public static JButton jbFechar;
	public static JButton jbCadastrarProduto;

	public static JPanel jpCentral;

	public static JLabel jlIconeProduto;
	public static JLabel jlIconeProduto2;

	public static JFrame tela;

	Font font;
	Font font2;
	Font font3;
	Font font4;
	Font font5;
	Font font6;

	private static Point point;

	/**
	 * METÓDO CONSTRUTOR DA CLASSE CADASTRAR PRODUTO RESPONSÁVEL POR TODA A
	 * PARTE VISUAL DA TELA
	 * 
	 * @author JOAO DE SOUZA NETO
	 *
	 * */

	public CadastrarProduto() {
		setUndecorated(true);
		Container c = getContentPane();
		tela = this;
		setSize(1060, 550);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		c.setBackground(Color.black);
		c.setLayout(null);

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

		point = new Point();

		jpCentral = new JPanel();

		jlTituloPainel = new JLabel("Cadastrar Produto");
		jlTituloContainer = new JLabel("Cadastro de Produtos");
		jlCodigoBarrras = new JLabel("Código de Barras: ");
		jlCodigoPersonalizado = new JLabel("Código Personalizado: ");
		jlCategoria = new JLabel("Categoria: ");
		jlTipo = new JLabel("Tipo: ");
		jlDescricao = new JLabel("Descrição: ");


		jtfCampoCodigoBarras = new JTextField();
		jtfCampoCodigoPersonalizado = new JTextField();
		jcbComboCategoria = new JComboBox<String>();
		jcbComboTipo = new JComboBox<String>();
		jtfCampoDescricao = new JTextField();

		jbFechar = new JButton("X");
		jbCadastrarProduto = new JButton("Finalizar Produto");

		jlIconeProduto = new JLabel(new ImageIcon("res/produto.png"));
		jlIconeProduto2 = new JLabel(new ImageIcon("res/produto.png"));

		/*
		 * ADICIONAMENTO AO CONTAINER
		 */

		c.add(jpCentral);

		c.add(jbFechar);

		c.add(jlTituloContainer);

		c.add(jlIconeProduto);

		/*
		 * DEFINIÇÃO DE LAYOUTS
		 */

		jpCentral.setLayout(null);

		/*
		 * ACICIONAMENTO AO PAINEL CENTRAL
		 */

		jpCentral.add(jlTituloPainel);
		jpCentral.add(jlCodigoBarrras);
		jpCentral.add(jlCodigoPersonalizado);
		jpCentral.add(jlCategoria);
		jpCentral.add(jlTipo);
		jpCentral.add(jlDescricao);

		jpCentral.add(jtfCampoCodigoBarras);
		jpCentral.add(jtfCampoCodigoPersonalizado);
		jpCentral.add(jtfCampoDescricao);
		jpCentral.add(jcbComboCategoria);
		jpCentral.add(jcbComboTipo);

		jpCentral.add(jbCadastrarProduto);

		jpCentral.add(jlIconeProduto2);

		/*
		 * ACICIONAMENTO DE FONTES
		 */

		jlTituloContainer.setFont(font4);
		jlTituloPainel.setFont(font3);
		jlCodigoBarrras.setFont(font2);
		jlCodigoPersonalizado.setFont(font2);
		jlCategoria.setFont(font2);
		jlDescricao.setFont(font2);
		jlTipo.setFont(font2);


		jtfCampoCodigoBarras.setFont(font);
		jtfCampoCodigoPersonalizado.setFont(font);
		jtfCampoDescricao.setFont(font);
		jcbComboCategoria.setFont(font);
		jcbComboTipo.setFont(font);

		jbCadastrarProduto.setFont(font4);

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
		Dimension dCodigoBarras = jlCodigoBarrras.getPreferredSize();
		jlCodigoBarrras.setBounds(12, 121, dCodigoBarras.width,
				dCodigoBarras.height);
		Dimension dCodigoPersonalizado = jlCodigoPersonalizado.getPreferredSize();
		jlCodigoPersonalizado.setBounds(324, 121, dCodigoPersonalizado.width,
				dCodigoPersonalizado.height);
		Dimension dCategoria = jlCategoria.getPreferredSize();
		jlCategoria.setBounds(12, 61, dCategoria.width,
				dCategoria.height);
		Dimension dTipo = jlTipo.getPreferredSize();
		jlTipo.setBounds(324,61, dTipo.width,
				dTipo.height);
		Dimension dDescricao = jlDescricao.getPreferredSize();
		jlDescricao.setBounds(636, 61, dDescricao.width,
				dDescricao.height);

		jtfCampoCodigoBarras.setBounds(8, 145, 300, 34);
		jtfCampoCodigoPersonalizado.setBounds(320, 145, 300, 34);
		jcbComboCategoria.setBounds(8, 85, 235, 34);
		jcbComboTipo.setBounds(320, 85, 235, 34); 
		jtfCampoDescricao.setBounds(632, 85, 300, 34);

		jbFechar.setBounds(1015, 4, 35, 25);
		jbCadastrarProduto.setBounds(390, 450, 260, 40);

		Dimension dIconeProduto = jlIconeProduto.getPreferredSize();
		jlIconeProduto.setBounds(8, 3, dIconeProduto.width,
				dIconeProduto.height);

		Dimension dIconeProduto2 = jlIconeProduto2.getPreferredSize();
		jlIconeProduto2.setBounds(382, 22, dIconeProduto2.width,
				dIconeProduto2.height);

		/*
		 * QUANTIDADE DE CARACTERES
		 */
		jtfCampoCodigoBarras.setDocument(new MeuDocument(70));
		jtfCampoCodigoPersonalizado.setDocument(new MeuDocument(70));
		jtfCampoDescricao.setDocument(new MeuDocument(70));

		/*
		 * COR DE FONTE DOS COMPONENTES
		 */
		jlTituloContainer.setForeground(Color.white);
		jlTituloPainel.setForeground(Color.black);
		jlCodigoBarrras.setForeground(Color.black);
		jlCodigoPersonalizado.setForeground(Color.black);
		jlCategoria.setForeground(Color.black);
		jlTipo.setForeground(Color.black);
		jlDescricao.setForeground(Color.black);

		jtfCampoCodigoBarras.setForeground(Color.black);
		jtfCampoCodigoPersonalizado.setForeground(Color.black);
		jtfCampoDescricao.setForeground(Color.black);
		jcbComboCategoria.setForeground(Color.black);
		jcbComboTipo.setForeground(Color.black);


		jbCadastrarProduto.setForeground(Color.white);
		jbFechar.setForeground(Color.white);

		/*
		 * DEFINIÇÃO DE BACKGROUNDS DOS COMPONETES
		 */

		jpCentral.setBackground(new Color(237, 241, 244));

		jtfCampoCodigoBarras.setBackground(new Color(219, 219, 219));
		jtfCampoCodigoPersonalizado.setBackground(new Color(219, 219, 219));
		jtfCampoDescricao.setBackground(new Color(219, 219, 219));
		jcbComboCategoria.setBackground(Color.gray);
		jcbComboTipo.setBackground(Color.gray);

		jbFechar.setBackground(Color.black);
		jbCadastrarProduto.setBackground(Color.black);

		/*
		 * FOREGROUND E SELEÇÃO DE TEXTOS EFETIOS
		 */
		jtfCampoCodigoBarras.setSelectedTextColor(Color.WHITE);
		jtfCampoCodigoPersonalizado.setSelectedTextColor(Color.WHITE);
		jtfCampoDescricao.setBackground(new Color(219, 219, 219));

		jtfCampoCodigoBarras.setSelectionColor(Color.black);
		jtfCampoCodigoPersonalizado.setSelectionColor(Color.black);
		jtfCampoDescricao.setSelectionColor(Color.black);


		/*
		 * TOOTIPS DOS COMPONENTES
		 */
		jlCodigoBarrras.setToolTipText("Informe o Código de Barras");
		jlCodigoPersonalizado.setToolTipText("Informe o Código Personalizado");
		jlCategoria.setToolTipText("Informe a Categoria do Produto");
		jlTipo.setToolTipText("Informe o Tipo de Produto");
		jlDescricao.setToolTipText("Informe a Descrição do Produto");

		/*
		 * FOCUS AO EXECUTAR TELA
		 */
		CadastrarProduto.jtfCampoCodigoBarras.requestFocus();

		/*
		 * ADCIONAMENTO DE INTES AOS COMBOS
		 */

		jcbComboCategoria.addItem("");
		jcbComboTipo.addItem("");
		
		/*
		 * EVENTOS QUE DEFINE QUAIS CARACTERES SERÃO UTILIZADOS EM CADA CAMPO
		 */

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
					CadastrarProduto.tela.dispose();
					CadastrarProduto.tela = null;
				}
			}
		});

		/*
		 * EVENTO RESPONSÁVEL PELA AÇÃO DE MOVIMENTAÇÃO DA TELA
		 */
		tela.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				point.x = e.getX();
				point.y = e.getY();
			}
		});
		tela.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point p = tela.getLocation();
				tela.setLocation(p.x + e.getX() - point.x, p.y + e.getY()
						- point.y);
			}
		});

		/*
		 * EVENTO RESPONSÁVEL PELA AÇÃO DO CLIQUE DE OUTRA AÇÃO QUE NÃO SEJA DO
		 * SISTEMA, COMO O DO SISTEMA OPERACIONAL
		 */
		tela.addWindowListener(new WindowListener() {

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
					CadastrarProduto.tela.dispose();
					CadastrarProduto.tela = null;
					JOptionPane
							.showMessageDialog(
									null,
									"(MANUSEIO INCORRETO DO SISTEMA) \n"
											+ "OPERAÇÕES DO SISTEMA IMPERIUM - RECOMENDADAS\n"
											+ "OPERAÇÕES DO SISTEMA OPERACIONAL - NÃO RECOMENDADAS",
									"CADASTRO DE FORNECEDORES",
									JOptionPane.WARNING_MESSAGE);
				} catch (NullPointerException ex) {
					JOptionPane.showMessageDialog(null,
							"(ERRO 0027) - (MODELO FORNECEDOR)\n"
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

	/**
	 * CLASSE PERSONALIZADA QUE AMPLIA PLAINDOCUMENT
	 * */
	class MeuDocument extends PlainDocument {
		private static final long serialVersionUID = 1L;
		int maximo;

		public MeuDocument(int max) {
			maximo = max;
		}

		public void insertString(int offs, String str, AttributeSet a) {
			if ((getLength() + str.length()) <= maximo)
				try {
					super.insertString(offs, str, a);
				} catch (BadLocationException e) {
					JOptionPane.showMessageDialog(null,
							"(ERRO 0028) - (MODELO FORNECEDOR)\n"
									+ "(CONTRATE O PROGRAMADOR DO SISTEMA)",
							"FORNECEDOR", JOptionPane.ERROR_MESSAGE);
				}
		}
	}

	public static void main(String[] args) {
		new CadastrarProduto();
	}
}
