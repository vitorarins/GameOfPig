package pig;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SobreDialog extends JDialog {

	private static final long serialVersionUID = -274661600194881083L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public SobreDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel label = new JLabel(""); //$NON-NLS-1$
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon(SobreDialog.class.getResource("/assets/ufsc.png"))); //$NON-NLS-1$
		label.setBounds(12, 43, 130, 136);
		contentPanel.add(label);
		
		JLabel lblDisciplinaIne = new JLabel(Messages.getString("SobreDialog.2")); //$NON-NLS-1$
		lblDisciplinaIne.setBounds(146, 32, 290, 20);
		contentPanel.add(lblDisciplinaIne);
		
		JLabel lblProjetoDeSitemas = new JLabel(Messages.getString("SobreDialog.3")); //$NON-NLS-1$
		lblProjetoDeSitemas.setBounds(156, 53, 273, 15);
		contentPanel.add(lblProjetoDeSitemas);
		
		JLabel lblJogoTwodicePig = new JLabel(Messages.getString("SobreDialog.4")); //$NON-NLS-1$
		lblJogoTwodicePig.setBounds(146, 93, 283, 15);
		contentPanel.add(lblJogoTwodicePig);
		
		JLabel lblAutorVitorArins = new JLabel(Messages.getString("SobreDialog.5")); //$NON-NLS-1$
		lblAutorVitorArins.setBounds(146, 134, 283, 15);
		contentPanel.add(lblAutorVitorArins);
		
		JLabel lblParaMelhorAuxlio = new JLabel(Messages.getString("SobreDialog.6")); //$NON-NLS-1$
		lblParaMelhorAuxlio.setBounds(146, 171, 256, 15);
		contentPanel.add(lblParaMelhorAuxlio);
		
		JLabel lblEnvieOSeu = new JLabel(Messages.getString("SobreDialog.7")); //$NON-NLS-1$
		lblEnvieOSeu.setBounds(154, 185, 275, 15);
		contentPanel.add(lblEnvieOSeu);
		
		JLabel lblVitorarinsinfufscbr = new JLabel("vitorarins@inf.ufsc.br"); //$NON-NLS-1$
		lblVitorarinsinfufscbr.setBounds(156, 198, 246, 15);
		contentPanel.add(lblVitorarinsinfufscbr);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton(Messages.getString("SobreDialog.9")); //$NON-NLS-1$
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				okButton.setActionCommand(Messages.getString("SobreDialog.10")); //$NON-NLS-1$
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		setLocationRelativeTo(null);
		setTitle(Messages.getString("SobreDialog.11")); //$NON-NLS-1$
		setPreferredSize(new Dimension(500,300));		
	}
}
