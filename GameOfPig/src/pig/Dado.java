package pig;

public class Dado {

	protected int valor;
	
	public int rolar(){
		this.setValor(1 + (int)(6*Math.random()));
		return this.getValor();
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

}
