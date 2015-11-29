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
		txtrLalala.setText(Messages.getString("ComoJogarDialog.0")); //$NON-NLS-1$
		txtrLalala.setBounds(12, 60, 542, 270);
		contentPanel.add(txtrLalala);
		{
			JLabel lblGameOfPig = new JLabel(Messages.getString("ComoJogarDialog.1")); //$NON-NLS-1$
			lblGameOfPig.setFont(new Font("Dialog", Font.BOLD, 20)); //$NON-NLS-1$
			lblGameOfPig.setHorizontalAlignment(SwingConstants.CENTER);
			lblGameOfPig.setBounds(193, 12, 159, 20);
			contentPanel.add(lblGameOfPig);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton(Messages.getString("ComoJogarDialog.3")); //$NON-NLS-1$
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				okButton.setActionCommand(Messages.getString("ComoJogarDialog.4")); //$NON-NLS-1$
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		setLocationRelativeTo(null);
		setTitle(Messages.getString("ComoJogarDialog.5"));		 //$NON-NLS-1$
		setPreferredSize(new Dimension(573, 394));
	}
}
