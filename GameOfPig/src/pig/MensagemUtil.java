package pig;

import java.awt.Component;

import javax.swing.JOptionPane;

/**
 * @author vitor
 *
 */
public class MensagemUtil {
	
    public static void mostrarErro(String mensagem, Component obj) {
        
        JOptionPane.showMessageDialog(obj, mensagem, "Game of Pig", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void mostrar(String mensagem, Component obj) {
        
        JOptionPane.showMessageDialog(obj, mensagem, "Game of Pig", JOptionPane.INFORMATION_MESSAGE);
    }	

}
