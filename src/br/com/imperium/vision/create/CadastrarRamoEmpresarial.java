package br.com.imperium.vision.create;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import br.com.imperium.control.ControleFornecedor;
import br.com.imperium.dao.FornecedorDAO;
import br.com.imperium.util.MeuDocument;

/**
 * CLASSE NOVAATIVIDADESCADASTRAR DO PACOTE
 * BR.COM.IMPERIUM.VISAO.CADASTRAR.CADASTROS
 * 
 * @author JOAO DE SOUZA NETO
 *
 * */
public class CadastrarRamoEmpresarial extends JDialog {

	/*
	 * SERIAL DA VERSÃO DO JAVA
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * CRIAÇÃO DOS COMPONENTES DA CLASSE
	 */
	public static JLabel jlTituloContainer, jlRamoEmpresarial,
			jlIconeFornecedor;
	public static JTextField jtfCampoRamoEmpresarial;

	public static JButton jbFechar, jbOkRamoEmpresarial;

	public static JPanel jpCentral;

	public static JDialog tela;

	Font font, font2, font3, font4;

	/**
	 * METÓDO CONSTRUTOR DA CLASSE NOVAATIVIDADECADASTRAR RESPONSÁVEL POR TODA A
	 * PARTE VISUAL DA TELA
	 * 
	 * @author JOAO DE SOUZA NETO
	 *
	 * */

	public CadastrarRamoEmpresarial(JDialog frame, boolean modal) {
		super(frame, modal);
	}

	public CadastrarRamoEmpresarial() {
		initComponents();
		setModal(true);
	}

	public void initComponents() {
		setUndecorated(true);
		Container c = getContentPane();
		tela = new JDialog();
		tela = this;
		setSize(390, 200);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		c.setBackground(Color.black);
		c.setLayout(null);

		font = new Font("CAMBRIA", Font.PLAIN, 20);
		font2 = new Font("CAMBRIA", Font.BOLD, 22);
		font3 = new Font("CAMBRIA", Font.BOLD, 24);
		font4 = new Font("CAMBRIA", Font.PLAIN, 20);

		// LINHA DE CÓDIGO REPONSÁVEL PELO DESIGN DO LAYOUT
		try {
			UIManager
					.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * INICIALIZÁVEIS
		 */

		jpCentral = new JPanel();

		jlTituloContainer = new JLabel("Novo Ramo Empresarial");
		jlRamoEmpresarial = new JLabel("Novo Ramo Empresarial:");

		jtfCampoRamoEmpresarial = new JTextField();

		jbFechar = new JButton("X");
		jbOkRamoEmpresarial = new JButton("Add");

		jlIconeFornecedor = new JLabel(new ImageIcon("res/fornecedor.png"));

		/*
		 * ADICIONAMENTO AO CONTAINER
		 */

		c.add(jpCentral);

		c.add(jbFechar);

		c.add(jbOkRamoEmpresarial);

		c.add(jlIconeFornecedor);

		/*
		 * DEFINIÇÃO DE LAYOUTS
		 */

		jpCentral.setLayout(null);

		/*
		 * ACICIONAMENTO AO PAINEL CENTRAL
		 */

		c.add(jlTituloContainer);
		jpCentral.add(jlRamoEmpresarial);

		jpCentral.add(jtfCampoRamoEmpresarial);

		jpCentral.add(jbOkRamoEmpresarial);

		/*
		 * ACICIONAMENTO DE FONTES
		 */

		jlTituloContainer.setFont(font4);

		jlRamoEmpresarial.setFont(font3);

		jtfCampoRamoEmpresarial.setFont(font);

		jbOkRamoEmpresarial.setFont(font4);

		/*
		 * COORDENADAS DOS COMPONETES
		 */

		jpCentral.setBounds(2, 35, 386, 163);

		Dimension dTituloContainer = jlTituloContainer.getPreferredSize();
		jlTituloContainer.setBounds(45, 6, dTituloContainer.width,
				dTituloContainer.height);
		Dimension dRamoEmpresarial = jlRamoEmpresarial.getPreferredSize();
		jlRamoEmpresarial.setBounds(12, 24, dRamoEmpresarial.width,
				dRamoEmpresarial.height);

		jtfCampoRamoEmpresarial.setBounds(8, 54, 368, 34);

		jbFechar.setBounds(345, 4, 35, 25);
		jbOkRamoEmpresarial.setBounds(150, 100, 80, 40);

		Dimension dIconeFornecedor = jlIconeFornecedor.getPreferredSize();
		jlIconeFornecedor.setBounds(8, 3, dIconeFornecedor.width,
				dIconeFornecedor.height);

		/*
		 * QUANTIDADE DE CARACTERES
		 */
		jtfCampoRamoEmpresarial.setDocument(new MeuDocument(30));

		/*
		 * COR DE FONTE DOS COMPONENTES
		 */

		jlTituloContainer.setForeground(Color.white);
		jlRamoEmpresarial.setForeground(Color.black);

		jtfCampoRamoEmpresarial.setForeground(Color.black);

		jbOkRamoEmpresarial.setForeground(Color.white);
		jbFechar.setForeground(Color.white);

		/*
		 * DEFINIÇÃO DE BACKGROUNDS DOS COMPONETES
		 */

		jpCentral.setBackground(new Color(237, 241, 244));

		jtfCampoRamoEmpresarial.setBackground(new Color(219, 219, 219));

		jbFechar.setBackground(Color.black);
		jbOkRamoEmpresarial.setBackground(Color.black);

		/*
		 * FOREGROUND E SELEÇÃO DE TEXTOS EFETIOS
		 */

		jtfCampoRamoEmpresarial.setSelectedTextColor(Color.WHITE);

		jtfCampoRamoEmpresarial.setSelectionColor(Color.black);

		/*
		 * FOCUS AO EXECUTAR A TELA
		 */
		jtfCampoRamoEmpresarial.requestFocus();

		/*
		 * CONTROLE
		 */
		ControleFornecedor listener = new ControleFornecedor();
		jbOkRamoEmpresarial.addActionListener(listener);
		jbFechar.addActionListener(listener);

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
					CadastrarRamoEmpresarial.tela.dispose();
				}
			}
		});

		/*
		 * EVENTO RESPONSÁVEL PELO ENTER DO TECLADO DO BOTÃO ADD NOVA ATIVIDADE
		 */
		jbOkRamoEmpresarial.addKeyListener(new KeyListener() {

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
					dao.BotaoCadastrarRamoEmpreresarial();
				}
			}
		});

		/*
		 * EVENTO RESPONSÁVEL PELO ENTER DO TECLADO DOCAMPO NOVA ATIVIDADE
		 */
		jtfCampoRamoEmpresarial.addKeyListener(new KeyListener() {

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
					dao.BotaoCadastrarRamoEmpreresarial();

				}
			}
		});
	}
}
