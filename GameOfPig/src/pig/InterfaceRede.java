package pig;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class InterfaceRede implements ActionListener {

	private JFrame viewFrame;

	private JPanel conectarViewPanel = new JPanel(),
			camposViewPanel = new JPanel(),
			botoesViewPanel = new JPanel();

	private JButton contectarButton = new JButton(Messages.getString("InterfaceRede.0")), //$NON-NLS-1$
			cancelarButton = new JButton(Messages.getString("InterfaceRede.1")); //$NON-NLS-1$

	private JTextField nickField = new JTextField(15),
			ipServidorField = new JTextField(15);

	private JLabel nickLabel = new JLabel(Messages.getString("InterfaceRede.2")), //$NON-NLS-1$
			ipServidorLabel = new JLabel(Messages.getString("InterfaceRede.3")); //$NON-NLS-1$

	// private ProxyImpl clienteJogador;

	private AtorNetGames jogo;

	public InterfaceRede(AtorNetGames jogo) {
		this.jogo = jogo;
		this.ipServidorField.setText("venus.inf.ufsc.br"); //$NON-NLS-1$
	}

	/**
	 * Cria a janela gráfica de conexões
	 */
	public void createFront() {

		JFrame.setDefaultLookAndFeelDecorated(true);

		viewFrame = new JFrame(Messages.getString("InterfaceRede.5")); //$NON-NLS-1$
		viewFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		this.createPanel();

		viewFrame.add(conectarViewPanel);

		viewFrame.pack();
		viewFrame.setSize(400, 130);
		viewFrame.setVisible(true);

	}

	public void createPanel() {
		// Insere os elementos de campos e labels no painel de campos
		camposViewPanel.setLayout(new GridLayout(2, 2, 2, 2));

		camposViewPanel.add(nickLabel);
		camposViewPanel.add(nickField);

		camposViewPanel.add(ipServidorLabel);
		camposViewPanel.add(ipServidorField);

		// Define os listeners dos botões
		contectarButton.addActionListener(this);
		cancelarButton.addActionListener(this);

		// Insere os elementos de botões no painel de botões
		botoesViewPanel.add(contectarButton);
		botoesViewPanel.add(cancelarButton);

		conectarViewPanel.add(camposViewPanel);
		conectarViewPanel.add(botoesViewPanel);
	}

	 
	public void actionPerformed(ActionEvent e) {

		Object o = e.getSource();

		if (o != null && o instanceof JButton) {

			JButton item = (JButton) o;

			if (item == this.contectarButton) {
				this.conectar();
			}
			if (item == this.cancelarButton) {
				this.cancelar();
			}

		}

	}

	/**
	 * Retorna para a tela principal
	 */
	private void cancelar() {
		viewFrame.setVisible(false);
		viewFrame.dispose();
	}

	/**
	 * Tenta se conectar com o servidor Caso consigua emite uma mensagem de
	 * afirma��o e retorna para a tela principal Do contrario emite uma mensagem
	 * de erro e continua na mesma tela
	 */
	 
	private void conectar() {

		String nome = nickField.getText();
		String ipServidor = ipServidorField.getText();

		// valida��es
		if (nome.equals("")) { //$NON-NLS-1$
			JOptionPane.showMessageDialog(this.viewFrame,
					Messages.getString("InterfaceRede.7"), Messages.getString("InterfaceRede.8"), //$NON-NLS-1$ //$NON-NLS-2$
					JOptionPane.ERROR_MESSAGE, null);

			return;
		}

		jogo.conectarRede(nome, ipServidor);

		// fecha a janela
		this.cancelar();

	}

}
