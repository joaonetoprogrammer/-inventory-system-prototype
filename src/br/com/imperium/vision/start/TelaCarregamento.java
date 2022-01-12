package br.com.imperium.vision.start;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class TelaCarregamento extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// TELA
	public static JDialog jfTela;

	// PAINEIS
	public static JPanel cabecalho;
	
	// ICONES
	public static JLabel jlFundoCabecalho;

	public static JProgressBar pbar;

	static final int MY_MINIMUM = 0;

	static final int MY_MAXIMUM = 1000;

	// FONTES
	Font font1;
	Font font2;
	Font font3;

	/**
	 * METÓDO CONSTRUTOR
	 */
	public TelaCarregamento(JDialog frame, boolean modal) {
		super(frame, modal);
	}

	public TelaCarregamento() {
		initComponents();
		setModal(true);
	}
	
	
	public void initComponents() {
		setUndecorated(true);
		Container c = getContentPane();
		jfTela = new JDialog();
		jfTela = this;
		c.setBackground(Color.black);
		setSize(440, 320);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLayout(null);

		// FONTES
		font1 = new Font("Times New Roman", Font.BOLD, 28);
		font2 = new Font("Times New Roman", Font.BOLD, 24);
		font3 = new Font("Times New Roman", Font.BOLD, 30);

		/****
		 * INICILIZAÇÃO DOS ELEMENTOS
		 *****/

		// BAR
		pbar = new JProgressBar();
		pbar.setMinimum(MY_MINIMUM);
		pbar.setMaximum(MY_MAXIMUM);
		pbar.setStringPainted(true);

		cabecalho = new JPanel();
		
		jlFundoCabecalho = new JLabel("IMPERIUM");
		jlFundoCabecalho.setForeground(new Color(251, 152, 4));
		jlFundoCabecalho.setFont(font2);

		/****
		 * COORDENADAS
		 ****/
		cabecalho.setBounds(1, 1, 438, 340);
        jlFundoCabecalho.setBounds(20,20,300,40);
        
		/****
		 * ADICIONAMENTO AO PAINEL
		 ****/
		c.add(cabecalho);
		cabecalho.add(jlFundoCabecalho);
		cabecalho.add(pbar);
		
		
		pbar.setBounds(-2,305, 445, 15);
        pbar.setBackground(new Color(204, 204, 204));
        
		/****
		 * BACKGROUND
		 ****/
		cabecalho.setBackground(Color.black);

		try {
			UIManager
					.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void atualizaBarra(int valor) {
		pbar.setValue(valor);
	}

	public static void main(String[] args) {
		final TelaCarregamento barra = new TelaCarregamento();

		for (int i = MY_MINIMUM; i <= MY_MAXIMUM; i++) {
			final int percent = i;
			try {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						barra.atualizaBarra(percent);
					}
				});
				Thread.sleep(5);
			} catch (InterruptedException e) {

			}
		}
        TelaDeLogin objeto = new TelaDeLogin();
        objeto.setVisible(true);
        TelaCarregamento.jfTela.dispose();

	}

}
