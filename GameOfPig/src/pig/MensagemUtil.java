package pig;

import java.awt.Component;

import javax.swing.JOptionPane;

/**
 * @author vitor
 *
 */
public class MensagemUtil {
	
    public static void mostrarErro(String mensagem, Component obj) {
        
        JOptionPane.showMessageDialog(obj, mensagem, Messages.getString("MensagemUtil.0"), JOptionPane.ERROR_MESSAGE); //$NON-NLS-1$
    }
    
    public static void mostrar(String mensagem, Component obj) {
        
        JOptionPane.showMessageDialog(obj, mensagem, Messages.getString("MensagemUtil.1"), JOptionPane.INFORMATION_MESSAGE); //$NON-NLS-1$
    }	

}
