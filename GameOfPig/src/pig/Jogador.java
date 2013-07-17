package pig;

/**
 * @author vitor
 *
 */
public class Jogador {

	protected boolean daVez;
	protected TipoPorco tipo; // 1-Verde ou 2-Azul
	private String nome;
	private int pontuacao;
	protected boolean vencedor;
	
	public Jogador(String nome, TipoPorco tipo) {
		
		this.setNome(nome);
		this.tipo = tipo;
		this.daVez = false;
	}

	public void reiniciar() {
		this.daVez = false;
		this.vencedor = false;
	}

	public boolean isDaVez() {
		return daVez;
	}

	public void setDaVez(boolean daVez) {
		this.daVez = daVez;
	}

	public TipoPorco getTipo() {
		return tipo;
	}

	public void setTipo(TipoPorco tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public boolean isVencedor() {
		return vencedor;
	}

	public void setVencedor(boolean vencedor) {
		this.vencedor = vencedor;
	}


}
