package br.com.imperium.vision.start;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import br.com.imperium.control.ControleAdministrador;
import br.com.imperium.dao.AdministradorDAO;

public class TelaDeLogin extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// TELA
	public static JDialog jfTela;

	// PAINEL CENTRAL
	public static JPanel jpCentral;

	// LABELS - NOMES
	public static JLabel jlLogin;
	public static JLabel jlSenha;
	public static JLabel jlTitulo;
	public static JLabel jlTituloComplemento;
	public static JLabel jlRodape;

	// TEXTFIELDS - CAMPOS DE DIGITAÇÃO
	public static JTextField jtfUsuario;
	public static JPasswordField jpssSenha;

	// BOTÕES
	public static JButton jbEntrar;
	public static JButton jbSair;

	// RESOLUÇÃO DA TELA
	Dimension vResolucao;

	// ICONES
	public static JLabel jlIconeLogin;

	// FONTES
	Font font1;
	Font font2;
	Font font3;
	Font font4;

	/**
	 * METÓDO CONSTRUTOR
	 */

	public TelaDeLogin(JDialog frame, boolean modal) {
		super(frame, modal);
	}

	public TelaDeLogin() {
		initComponents();
		setModal(true);
	}
	
	public void initComponents() {
		setUndecorated(true);
		Container c = getContentPane();
		jfTela = new JDialog();
		jfTela = this;
		c.setBackground(Color.black);
		vResolucao = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(vResolucao);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLayout(null);
		
		// FONTES
		font1 = new Font("CAMBRIA", Font.PLAIN, 26);
		font2 = new Font("CAMBRIA", Font.PLAIN, 18);
		font3 = new Font("CAMBRIA", Font.PLAIN, 28);
		font4 = new Font("CAMBRIA", Font.PLAIN, 18);

		try {
			UIManager
					.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		/** --------------- INICIALIZÁVEIS ------------- */
		// ---------- PAINEL CENTRAL ---------- //
		jpCentral = new JPanel();

		// ---------- LABELS - NOMES ---------- //
		jlLogin = new JLabel("Usuário:");
		jlSenha = new JLabel("Senha:");
		jlTitulo = new JLabel("Software de Gerenciamento");
		jlTituloComplemento = new JLabel("Estoque e Vendas");
		jlRodape = new JLabel("Software Imperium - Versão C.E.V 1.0");

		// ---------- TEXTFIELS - CAMPOS DE DIGITAÇÃO ---------- //
		jtfUsuario = new JTextField();
		jpssSenha = new JPasswordField();

		// ---------- BOTÕES ---------- //
		jbEntrar = new JButton("Logar");
		jbSair = new JButton("Sair");

		// ------- PLANO DE FUNDO ------------//
		// jlPlanoDeFundo = new JLabel(new ImageIcon("res/planoDeFundo.jpg"));

		// ------- ICONES ------------//
		jlIconeLogin = new JLabel(new ImageIcon("res/chave.png"));

		/** --------------- FIM DOS INICIALIZÁVEIS ---------- */

		/** ------------- LOCALIZAÇÃO DE CADA ITEM ---------- */
		jpCentral.add(jlTitulo);
		jpCentral.add(jlTituloComplemento);
		c.add(jlRodape);
		c.add(jpCentral);
		jpCentral.setBackground(new Color(10, 10, 10));
		jpCentral.add(jlLogin);
		jpCentral.add(jlSenha);
		jpCentral.add(jtfUsuario);
		jpCentral.add(jpssSenha);
		jpCentral.add(jbEntrar);
		jpCentral.add(jbSair);
		jpCentral.add(jlIconeLogin);

		/**
		 * ------------- COORDENADAS, TAMANHO E CONFIGURAÇÕES DE CADA ITEM
		 * ----------
		 */

		// ------- PAINEL CENTRAL -----------//
		jpCentral.setSize(430, 310);
		jpCentral.setBorder(BorderFactory.createEtchedBorder());
		int pontoLargura = ((this.getWidth() / 2) - jpCentral.getWidth() / 2) - 2;
		int pontoAltura = ((this.getHeight() / 2) - jpCentral.getHeight() / 2) - 16;
		jpCentral.setLocation(pontoLargura, pontoAltura);
		jpCentral.setLayout(null);

		
		jlSenha.setFont(font1);
		jlLogin.setFont(font1);
		jlRodape.setFont(font4);
		jlTitulo.setFont(font3);
		jlTituloComplemento.setFont(font3);
		// TITULO

		// --------- LABELS - NOMES ------------- //
		Dimension dLogin = jlLogin.getPreferredSize();
		jlLogin.setBounds(140, 100, dLogin.width, dLogin.height);
		jlLogin.setForeground(Color.white);

		Dimension dSenha = jlSenha.getPreferredSize();
		jlSenha.setBounds(140, 165, dSenha.width, dSenha.height);
		jlSenha.setForeground(Color.white);

		Dimension dTitulo = jlTitulo.getPreferredSize();
		jlTitulo.setBounds(50,20,
				dTitulo.width, dTitulo.height);
		jlTitulo.setForeground(new Color(190, 190, 190));
		
		Dimension dTituloComplemento = jlTituloComplemento.getPreferredSize();
		jlTituloComplemento.setBounds(110,50,
				dTituloComplemento.width, dTituloComplemento.height);
		jlTituloComplemento.setForeground(new Color(190, 190, 190));
		
		Dimension dRodape = jlRodape.getPreferredSize();
		jlRodape.setBounds(pontoLargura+65, pontoAltura + 320,
				dRodape.width, dRodape.height);
		jlRodape.setForeground(new Color(20, 20, 20));

		// --------- ICONES ------------- //
		jlIconeLogin.setBounds(-35, 75, 200, 200);

		// --------- TEXT FIELDS - CAMPO ------------- //
		jtfUsuario.setBounds(140, 130, 250, 34);
		jtfUsuario.setFont(font2);
		jtfUsuario.setForeground(Color.black);
		jtfUsuario.setBackground(new Color(190, 190, 190));

		jpssSenha.setBounds(140, 195, 250, 34);
		jpssSenha.setFont(font2);
		jpssSenha.setForeground(Color.black);
		jpssSenha.setBackground(new Color(190, 190, 190));

		// -------------- BOTÕES -------------- //
		jbEntrar.setBounds(200, 240, 90, 32);
		jbEntrar.setFont(font2);
		jbEntrar.setForeground(Color.white);
		jbEntrar.setBackground(Color.black);

		jbSair.setBounds(300, 240, 90, 32);
		jbSair.setFont(font2);
		jbSair.setForeground(Color.white);
		jbSair.setBackground(Color.black);

		/***
		 * ----- INICIO DO EFEITO DE CORES DE SELÇÃO DO TEXTO ----
		 ***/
		
		jtfUsuario.setSelectedTextColor(Color.WHITE);
		jpssSenha.setSelectedTextColor(Color.WHITE);

		jtfUsuario.setSelectionColor(Color.black);
		jpssSenha.setSelectionColor(Color.black);
	

		/***
		 * ----- FIM DO EFEITO DE CORES DE SELÇÃO DO TEXTO ----
		 ***/
		
		
		// FOCUS
		jtfUsuario.requestFocus();

		ControleAdministrador listener = new ControleAdministrador();
		jbEntrar.addActionListener(listener);
		jbSair.addActionListener(listener);

		jpssSenha.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					AdministradorDAO adm = new AdministradorDAO();
					adm.Metodo_Botao_Entrar();
				}

			}
		});

		jbEntrar.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					AdministradorDAO adm = new AdministradorDAO();
					adm.Metodo_Botao_Entrar();
				}

			}
		});

		jbSair.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					TelaDeLogin.jfTela.dispose();
				}

			}
		});
	}

	public static void main(String[] args) {
		new TelaDeLogin();
	}

}
