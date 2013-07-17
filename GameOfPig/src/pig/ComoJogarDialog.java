package pig;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ComoJogarDialog extends JDialog {

	private static final long serialVersionUID = -3870217329851123512L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public ComoJogarDialog() {
		setBounds(100, 100, 573, 394);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextArea txtrLalala = new JTextArea();
		txtrLalala.setEditable(false);
		txtrLalala.setCursor(null);
		txtrLalala.setOpaque(false);
		txtrLalala.setFocusable(false);
		txtrLalala.setLineWrap(true);
		txtrLalala.setWrapStyleWord(true);
		txtrLalala.setText("1. Para jogar é preciso estar conectado ao Servidor: \n    - Vá no menu \"Partida\" -> \"Conectar\"\n    - Digite seu nome e o servidor depois clique \"OK\"\n\n2. Para iniciar uma partida:\n    - Vá no menu \"Partida\" -> \"Iniciar Partida\"\n\n3. O jogo:\n    - Os jogadores vão jogar os dados até que alguém chegue na pontuação máxima.\n    - Se um dos dados for \"1\", o jogador perde os pontos da jogada e passa a vez.\n    - Se ambos os dados forem \"1\", o jogador perde todos os pontos e passa a vez.\n    - Há duas opções ao jogador, \"Jogar os dados\" ou \"Passar a vez\".\n\n4. Caso queira se conectar a outro servidor:\n    - Vá no menu \"Partida\" -> \"Desconectar\"\n    - Depois vá em \"Partida\" - > \"Conectar\"\n    - Digite seu nome e o novo endereço de servidor.");
		txtrLalala.setBounds(12, 60, 542, 270);
		contentPanel.add(txtrLalala);
		{
			JLabel lblGameOfPig = new JLabel("Game of Pig");
			lblGameOfPig.setFont(new Font("Dialog", Font.BOLD, 20));
			lblGameOfPig.setHorizontalAlignment(SwingConstants.CENTER);
			lblGameOfPig.setBounds(193, 12, 159, 20);
			contentPanel.add(lblGameOfPig);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		setLocationRelativeTo(null);
		setTitle("Sobre");		
		setPreferredSize(new Dimension(573, 394));
	}
}
