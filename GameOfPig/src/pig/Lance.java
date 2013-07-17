/**
 * 
 */
package pig;

import br.ufsc.inf.leobr.cliente.Jogada;

/**
 * @author vitor
 *
 */
public class Lance implements Jogada {

	private static final long serialVersionUID = -2175450423664732112L;

	protected int pontuacaoDaVez;
	
	protected boolean passou;
	
	protected int situacao;
	
	protected int dado1;
	protected int dado2;

	/**
	 * @param pontuacaoDaVez
	 * @param dado2 
	 * @param dado1 
	 * @param passou
	 * @param situacao 
	 */
	public Lance(int pontuacaoDaVez, int dado1, int dado2, boolean passou, int situacao) {
		super();
		this.pontuacaoDaVez = pontuacaoDaVez;
		this.passou = passou;
		this.situacao = situacao;
		this.dado1 = dado1;
		this.dado2 = dado2;
	}

	public int getPontuacaoDaVez() {
		return pontuacaoDaVez;
	}

	public void setPontuacaoDaVez(int pontuacaoDaVez) {
		this.pontuacaoDaVez = pontuacaoDaVez;
	}

	public boolean isPassou() {
		return passou;
	}

	public void setPassou(boolean passou) {
		this.passou = passou;
	}

	public int getSituacao() {
		return situacao;
	}

	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}

	public int getDado1() {
		return dado1;
	}

	public void setDado1(int dado1) {
		this.dado1 = dado1;
	}

	public int getDado2() {
		return dado2;
	}

	public void setDado2(int dado2) {
		this.dado2 = dado2;
	}

}
