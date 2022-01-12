package br.com.imperium.vision.start;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import br.com.imperium.control.ControleMenuInicial;
import br.com.imperium.vision.read.ConsultarFornecedor;

public class MenuInicial extends JDialog {

	/**
	 * SERIAL DA VERSÃO DO JAVA
	 */
	private static final long serialVersionUID = 1L;
	// TELA
	public static JDialog jfTela;

	// PANEL RODAPÉ
	public static JPanel jpRodape;
	public static JPanel jpCabecalho;
	public static JPanel jpCentral;

	// BOTÕES
	public static JButton jbProduto;
	public static JButton jbFornecedor;
	public static JButton jbEntrada;
	public static JButton jbSaida;
	public static JButton jbVendas;
	public static JButton jbRelatorios;
	public static JButton jbAdministrador;
	public static JButton jbFinalizar;
	public static JButton jbFechar;

	// RESOLUÇÃO DA TELA
	Dimension vResolucao;

	// ICONES COM JLABELS
	public static JLabel jlIconeLogo;
	public static JLabel jlIconeChave;
	public static JLabel jlIconeUsuario;
	public static JLabel jlIconeData;
	public static JLabel jlIconeDepartamento;
	public static JLabel jlIconeDepartamentoCabecalho;

	public static JLabel jlIconeProduto;
	public static JLabel jlIconeFornecedor;
	public static JLabel jlIconeEntrada;
	public static JLabel jlIconeSaida;
	public static JLabel jlIconeAdministrador;
	public static JLabel jlIconeFinalizar;
	public static JLabel jlIconeRelatorios;
	public static JLabel jlIconeVendas;

	// NOMES DO BOTÕES
	public static JLabel jlFornecedor;
	public static JLabel jlVendas;
	public static JLabel jlProduto;
	public static JLabel jlEntrada;
	public static JLabel jlSaida;
	public static JLabel jlRelatorios;
	public static JLabel jlAdministrador;
	public static JLabel jlFinalizar;

	// LABELS
	public static JLabel jlUsuario;
	public static JLabel jlDefinicaoDeUsuario;
	public static JLabel jlData;
	public static JLabel jlDepartamento;
	public static JLabel jlTituloCabecalho;

	// FONTES
	Font font1;
	Font font2;
	Font font3;

	/**
	 * METÓDO CONSTRUTOR
	 */
	public MenuInicial(JDialog frame, boolean modal) {
		super(frame, modal);
	}

	public MenuInicial() {
		initComponents();
		setModal(true);
	}
	
	public void initComponents() {
		setUndecorated(true);
		Container c = getContentPane();
		jfTela = new JDialog();
		jfTela = this;
		c.setBackground(new Color(237, 241, 244));
		vResolucao = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(vResolucao);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLayout(null);
		setVisible(true);

		try {
			UIManager
					.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			//
			e.printStackTrace();
		}

		// CÓDIGO QUE CAPTURA A ALTURA E A LATERAL DA RESOLUÇÃO DO COMPUTADOR
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int alturaDaTela = dim.height;
		int larguraDaTela = dim.width;

		int alturaRodape = alturaDaTela - 40;
		int larguraRodape = larguraDaTela;

		int larguraCabecalho = larguraDaTela;

		// INICIALIZAÇÃO E DEFINIÇÃO DE FONTES
		font1 = new Font("CAMBRIA", Font.BOLD, 24);
		font2 = new Font("CAMBRIA", Font.BOLD, 22);
		font3 = new Font("CAMBRIA", Font.BOLD, 14);

		/** --------------- INICIALIZÁVEIS ------------- */

		// LOGO DO SISTEMA
		jlIconeLogo = new JLabel(new ImageIcon("res/logoSsitema.jpg"));

		// ICONE CHAVE - RODAPÉ
		jlIconeChave = new JLabel(new ImageIcon("res/chave2.png"));

		// ICONE USUÁRIO - RODAPÉ
		jlIconeUsuario = new JLabel(new ImageIcon("res/iconeUsuario.png"));

		// ICONE DATA - RODAPÉ
		jlIconeData = new JLabel(new ImageIcon("res/iconeData.png"));

		// ICONE DEPARTAMENTO - RODAPÉ
		jlIconeDepartamento = new JLabel(new ImageIcon(
				"res/iconeDepartamento.png"));

		jlIconeDepartamentoCabecalho = new JLabel(new ImageIcon(
				"res/iconeDepartamento.png"));

		// PAINEL CABEÇALHO
		jpCabecalho = new JPanel();

		// PAINEL CENTRAL
		jpCentral = new JPanel();

		// PANEL RODAPÉ
		jpRodape = new JPanel();

		// LABELS - NOMES
		jlUsuario = new JLabel("Usuário::>>");
		jlDefinicaoDeUsuario = new JLabel("Administrador");
		jlData = new JLabel("21/04/2015");
		jlDepartamento = new JLabel("Imperium C.E 1.1.1");
		jlTituloCabecalho = new JLabel(
				"SOFTWARE IMPERIUM - VERSÃO CONTROLE DE ESTOQUE E VENDAS 1.1.1");

		// LABELS DOS BOTÕES
		jlAdministrador = new JLabel("ADMINISTRADOR");
		jlEntrada = new JLabel("ENTRADA");
		jlFinalizar = new JLabel("FINALIZAR");
		jlFornecedor = new JLabel("FORNECEDOR");
		jlProduto = new JLabel("PRODUTO");
		jlRelatorios = new JLabel("RELATÓRIOS");
		jlSaida = new JLabel("SAÍDA");
		jlVendas = new JLabel("VENDAS");

		// BOTÕES
		jbAdministrador = new JButton();
		jbEntrada = new JButton();
		jbFinalizar = new JButton();
		jbFornecedor = new JButton();
		jbProduto = new JButton();
		jbRelatorios = new JButton();
		jbSaida = new JButton();
		jbVendas = new JButton();
		jbFechar = new JButton("X");

		// ICONES DOS BOTÕES
		jlIconeAdministrador = new JLabel(new ImageIcon(
				"res/menuAdministrador.png"));
		jlIconeEntrada = new JLabel(new ImageIcon("res/menuEntrada.png"));
		jlIconeFinalizar = new JLabel(new ImageIcon("res/menuFinalizar.png"));
		jlIconeFornecedor = new JLabel(new ImageIcon("res/menuFornecedor.png"));
		jlIconeProduto = new JLabel(new ImageIcon("res/menuProduto.png"));
		jlIconeRelatorios = new JLabel(new ImageIcon("res/menuRelatorios.png"));
		jlIconeSaida = new JLabel(new ImageIcon("res/menuSaida.png"));
		jlIconeVendas = new JLabel(new ImageIcon("res/menuVendas.png"));

		/** -------- FIM DOS INICIALIZÁVEIS ----------- */

		/**** -------- COFIGRUAÇÕES DO CABECALHO ------- ****/
		// CABEÇALHO
		c.add(jpCabecalho);
		jpCabecalho.setBackground(Color.black);
		jpCabecalho.setBounds(0, 0, larguraCabecalho, 40);
		jpCabecalho.setLayout(null);

		jpCabecalho.add(jbFechar);
		jbFechar.setForeground(Color.white);
		jbFechar.setBackground(Color.black);
		jbFechar.setBounds(larguraCabecalho - 50, 6, 40, 30);

		jpCabecalho.add(jlIconeDepartamentoCabecalho);
		Dimension dIconeDepartamentoCabecalho = jlIconeDepartamentoCabecalho
				.getPreferredSize();
		jlIconeDepartamentoCabecalho.setBounds(5, 5,
				dIconeDepartamentoCabecalho.width,
				dIconeDepartamentoCabecalho.height);

		jpCabecalho.add(jlTituloCabecalho);
		jlTituloCabecalho.setFont(font2);
		Dimension dTitulo = jlTituloCabecalho.getPreferredSize();
		jlTituloCabecalho.setBounds(55, 7, dTitulo.width, dTitulo.height);
		jlTituloCabecalho.setForeground(Color.WHITE);

		/**** -------- COFIGRUAÇÕES DO PAINEL CENTRAL ------- ****/
		// CENTRAL
		c.add(jpCentral);
		jpCentral.setSize(1095, 130);
		int pontoLargura = ((this.getWidth() / 2) - jpCentral.getWidth() / 2) - 2;
		jpCentral.setLocation(pontoLargura, 60);
		jpCentral.setLayout(null);
		jpCentral.setBackground(new Color(237, 241, 244));

		// LAYOUT NULL
		jbAdministrador.setLayout(null);
		jbEntrada.setLayout(null);
		jbFinalizar.setLayout(null);
		jbFornecedor.setLayout(null);
		jbProduto.setLayout(null);
		jbRelatorios.setLayout(null);
		jbSaida.setLayout(null);
		jbVendas.setLayout(null);

		// FONTES LABELS DOS BOTÕES
		jlAdministrador.setFont(font3);
		jlEntrada.setFont(font3);
		jlFinalizar.setFont(font3);
		jlFornecedor.setFont(font3);
		jlProduto.setFont(font3);
		jlVendas.setFont(font3);
		jlSaida.setFont(font3);
		jlRelatorios.setFont(font3);

		// ADCIONAMENTO DE ICONES
		jbAdministrador.add(jlIconeAdministrador);
		jbEntrada.add(jlIconeEntrada);
		jbFinalizar.add(jlIconeFinalizar);
		jbFornecedor.add(jlIconeFornecedor);
		jbProduto.add(jlIconeProduto);
		jbRelatorios.add(jlIconeRelatorios);
		jbSaida.add(jlIconeSaida);
		jbVendas.add(jlIconeVendas);

		// ADCIONAMENTO DE LABELS
		jbAdministrador.add(jlAdministrador);
		jbEntrada.add(jlEntrada);
		jbFinalizar.add(jlFinalizar);
		jbFornecedor.add(jlFornecedor);
		jbProduto.add(jlProduto);
		jbRelatorios.add(jlRelatorios);
		jbSaida.add(jlSaida);
		jbVendas.add(jlVendas);

		// ADINICONA COMPONETES AO PAINEL CENTRAL
		jpCentral.add(jbFornecedor);
		jpCentral.add(jbProduto);
		jpCentral.add(jbEntrada);
		jpCentral.add(jbSaida);
		jpCentral.add(jbVendas);
		jpCentral.add(jbRelatorios);
		jpCentral.add(jbAdministrador);
		jpCentral.add(jbFinalizar);

		// COORDENADAS DOS BOTÕES
		jbFornecedor.setBounds(5, 5, 130, 120);
		jbProduto.setBounds(140, 5, 130, 120);
		jbEntrada.setBounds(275, 5, 130, 120);
		jbSaida.setBounds(410, 5, 130, 120);
		jbVendas.setBounds(545, 5, 130, 120);
		jbRelatorios.setBounds(680, 5, 130, 120);
		jbAdministrador.setBounds(815, 5, 130, 120);
		jbFinalizar.setBounds(950, 5, 130, 120);

		// COORDENADAS DOS ICONES
		jlIconeAdministrador.setBounds(20, 10, 90, 81);
		jlIconeEntrada.setBounds(20, 10, 90, 81);
		jlIconeFinalizar.setBounds(20, 10, 90, 81);
		jlIconeFornecedor.setBounds(20, 10, 90, 81);
		jlIconeProduto.setBounds(20, 10, 90, 81);
		jlIconeRelatorios.setBounds(20, 10, 90, 81);
		jlIconeSaida.setBounds(20, 10, 90, 81);
		jlIconeVendas.setBounds(20, 10, 90, 81);

		// FOREGROUNDS
		jlAdministrador.setForeground(Color.black);
		jlEntrada.setForeground(Color.black);
		jlSaida.setForeground(Color.black);
		jlRelatorios.setForeground(Color.black);
		jlVendas.setForeground(Color.black);
		jlFinalizar.setForeground(Color.black);
		jlFornecedor.setForeground(Color.black);
		jlProduto.setForeground(Color.black);

		// COORDENADAS DOS LABLES DO BOTÕES
		Dimension dAdministrador = jlAdministrador.getPreferredSize();
		jlAdministrador.setBounds(10, 95, dAdministrador.width,
				dAdministrador.height);
		Dimension dProduto = jlProduto.getPreferredSize();
		jlProduto.setBounds(30, 95, dProduto.width, dProduto.height);
		Dimension dFornecedor = jlFornecedor.getPreferredSize();
		jlFornecedor.setBounds(20, 95, dFornecedor.width, dFornecedor.height);
		Dimension dFinalizar = jlFinalizar.getPreferredSize();
		jlFinalizar.setBounds(28, 95, dFinalizar.width, dFinalizar.height);
		Dimension dVendas = jlVendas.getPreferredSize();
		jlVendas.setBounds(36, 95, dVendas.width, dVendas.height);
		Dimension dRelatorios = jlRelatorios.getPreferredSize();
		jlRelatorios.setBounds(22, 95, dRelatorios.width, dRelatorios.height);
		Dimension dEntrada = jlEntrada.getPreferredSize();
		jlEntrada.setBounds(30, 95, dEntrada.width, dEntrada.height);
		Dimension dSaida = jlSaida.getPreferredSize();
		jlSaida.setBounds(40, 95, dSaida.width, dSaida.height);

		// BACKGROUNDS BOTÕES

		/**** -------- COFIGRUAÇÕES DO RODAPÉ ------- ****/
		// RODAPÉ
		c.add(jpRodape);
		jpRodape.setBackground(Color.black);
		jpRodape.setBounds(0, alturaRodape, larguraRodape, 50);
		jpRodape.setLayout(null);

		// ADINICONA COMPONETES AO PAINEL RODAPÉ
		jpRodape.add(jlIconeChave);
		jpRodape.add(jlUsuario);
		jpRodape.add(jlDefinicaoDeUsuario);
		jpRodape.add(jlIconeUsuario);
		jpRodape.add(jlData);
		jpRodape.add(jlIconeData);
		jpRodape.add(jlIconeDepartamento);
		jpRodape.add(jlDepartamento);

		// DEFINE FONTE DOS COMPONETES DO RODAPÉ
		jlUsuario.setFont(font1);
		jlDefinicaoDeUsuario.setFont(font1);
		jlData.setFont(font1);
		jlDepartamento.setFont(font1);

		// DEFINE COORDENADAS E TAMANHO DOS COMPONETES DO RODAPÉ
		Dimension dIconeChave = jlIconeChave.getPreferredSize();
		jlIconeChave.setBounds(10, 5, dIconeChave.width, dIconeChave.height);

		Dimension dUsuario = jlUsuario.getPreferredSize();
		jlUsuario.setBounds(45, 5, dUsuario.width, dUsuario.height);

		Dimension dDefinicaoDeUsuario = jlDefinicaoDeUsuario.getPreferredSize();
		jlDefinicaoDeUsuario.setBounds(220, 5, dDefinicaoDeUsuario.width,
				dDefinicaoDeUsuario.height);

		Dimension dIconeUsuario = jlIconeUsuario.getPreferredSize();
		jlIconeUsuario.setBounds(185, 5, dIconeUsuario.width,
				dIconeUsuario.height);

		// DATA
		Dimension dimData = Toolkit.getDefaultToolkit().getScreenSize();
		int larguraDaTelaData = dimData.width;
		int larguraData = larguraDaTelaData - 145;

		Dimension dData = jlData.getPreferredSize();
		jlData.setBounds(larguraData, 5, dData.width, dData.height);

		// ICONE DATA
		Dimension dimIconeData = Toolkit.getDefaultToolkit().getScreenSize();
		int larguraDaTelaIconeData = dimIconeData.width;
		int larguraIconeData = larguraDaTelaIconeData - 180;

		Dimension dIconeData = jlIconeData.getPreferredSize();
		jlIconeData.setBounds(larguraIconeData, 6, dIconeData.width,
				dIconeData.height);

		// ICONE DEPARTAMENTO
		Dimension dimIconeDepartamento = Toolkit.getDefaultToolkit()
				.getScreenSize();
		int larguraDaTelaIconeDepartamento = dimIconeDepartamento.width;
		int larguraIconeDepartamento = larguraDaTelaIconeDepartamento - 230;

		Dimension dIconeDepartamento = jlIconeDepartamento.getPreferredSize();
		jlIconeDepartamento.setBounds(larguraIconeDepartamento, 5,
				dIconeDepartamento.width, dIconeDepartamento.height);

		// ICONE DEPARTAMENTO
		Dimension dimDepartamento = Toolkit.getDefaultToolkit().getScreenSize();
		int larguraDaTelaDepartamento = dimDepartamento.width;
		int larguraDepartamento = larguraDaTelaDepartamento - 450;

		Dimension dDepartamento = jlDepartamento.getPreferredSize();
		jlDepartamento.setBounds(larguraDepartamento, 5, dDepartamento.width,
				dDepartamento.height);

		// DEFINE COR DE FONTE E BACKGROUND DOS COMPONETES DO RODAPÉ
		jlUsuario.setForeground(Color.white);
		jlDefinicaoDeUsuario.setForeground(Color.white);
		jlData.setForeground(Color.white);
		jlDepartamento.setForeground(Color.white);
		// ADICIONAMENTO DE LISTENERS

		ControleMenuInicial listener = new ControleMenuInicial();
		jbAdministrador.addActionListener(listener);
		jbEntrada.addActionListener(listener);
		jbFinalizar.addActionListener(listener);
		jbFornecedor.addActionListener(listener);
		jbProduto.addActionListener(listener);
		jbRelatorios.addActionListener(listener);
		jbSaida.addActionListener(listener);
		jbVendas.addActionListener(listener);
		jbFechar.addActionListener(listener);

		try {
			jlDefinicaoDeUsuario.setText(TelaDeLogin.jtfUsuario.getText());
		} catch (NullPointerException e) {

		}

		jbFornecedor.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                 ConsultarFornecedor objeto = new ConsultarFornecedor();
                 objeto.setVisible(true);
				}
			}
		});
	}
	
	public static void main(String[] args) {
		new MenuInicial();
	}
}
