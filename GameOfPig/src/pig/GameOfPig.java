/**
 * 
 */
package pig;

import java.awt.EventQueue;

/**
 * @author vitor
 *
 */
public class GameOfPig {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		 * Launch the application.
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtorJogador frame = new AtorJogador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
