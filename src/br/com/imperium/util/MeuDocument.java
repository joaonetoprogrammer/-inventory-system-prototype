package br.com.imperium.util;


import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class MeuDocument extends PlainDocument{
	
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
				ModeloMensagem utilMensagem = new ModeloMensagem();
				utilMensagem
						.MensagemModeloError("(ERRO 0002) - (MODELO FORNECEDOR)\n"
								+ "RECOMENDAÇÕES: \n"
								+ "- CONSULTAR O MANUAL DO SISTEMA\n"
								+ "- CONTRATAR O PROGRAMADOR DO SISTEMA");
			}
	}

}
