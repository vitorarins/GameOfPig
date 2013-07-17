package pig;

import br.ufsc.inf.leobr.cliente.Jogada;
import br.ufsc.inf.leobr.cliente.OuvidorProxy;
import br.ufsc.inf.leobr.cliente.Proxy;
import br.ufsc.inf.leobr.cliente.exception.ArquivoMultiplayerException;
import br.ufsc.inf.leobr.cliente.exception.JahConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoConectadoException;
import br.ufsc.inf.leobr.cliente.exception.NaoJogandoException;
import br.ufsc.inf.leobr.cliente.exception.NaoPossivelConectarException;


public class AtorNetGames implements OuvidorProxy {

	private static final long serialVersionUID = 1L;

	protected boolean ehMinhaVez = false;
	
	protected AtorJogador atorJogador;
	
	public AtorNetGames(AtorJogador atorJogador) {
		this.atorJogador = atorJogador;
	}

	@Override
	public void receberJogada(Jogada jogada) {
		// Recebe uma jogada do outro lado
		Lance jg = (Lance) jogada;
		int pontuacaoVez = jg.getPontuacaoDaVez();
		int valorDado1 = jg.getDado1();
		int valorDado2 = jg.getDado2();
		boolean passou = jg.isPassou();
		int situacao = jg.getSituacao();
		atorJogador.efetuarJogadaRede(pontuacaoVez, valorDado1, valorDado2, passou, situacao);
		ehMinhaVez = jg.isPassou();
	}

	@Override
	public void finalizarPartidaComErro(String message) {
		
		MensagemUtil.mostrar(message, atorJogador);					
	}

	@Override
	public void tratarConexaoPerdida() {
		
		MensagemUtil.mostrar("A conexão com o servidor foi perdida.", atorJogador);					
	}

	@Override
	public void tratarPartidaNaoIniciada(String message) {
		
		MensagemUtil.mostrar("A partida não pode ser iniciada devido ao seguinte erro: " + message, atorJogador);					
	}

	@Override
	public void receberMensagem(String msg) {
		
		MensagemUtil.mostrar("Mensagem recebida do servidor:" + msg, atorJogador);					
	}

	@Override
	public void iniciarNovaPartida(Integer posicao) {
		if (posicao == 1) {
			MensagemUtil.mostrar("Partida Iniciada, você começa jogando!", atorJogador);
			ehMinhaVez = true;
			atorJogador.iniciarPartidaRede(ehMinhaVez);
		} else {
			MensagemUtil.mostrar("Partida Iniciada, aguarde uma jogada", atorJogador);			
			ehMinhaVez = false;
			atorJogador.iniciarPartidaRede(ehMinhaVez);
		}
	}
	
	public void conectar() {
		InterfaceRede ic = new InterfaceRede(this);
		ic.createFront();
	}

	protected void iniciarPartidaRede() {
		try {
			Proxy.getInstance().iniciarPartida(2);
		} catch (NaoConectadoException e) {
			e.printStackTrace();
			MensagemUtil.mostrarErro(e.getMessage(), atorJogador);
		}
	}


	protected void desconectar() {
		try {
			atorJogador.terminarPartidaEmAndamento();
			Proxy.getInstance().desconectar();
		} catch (NaoConectadoException e) {
			e.printStackTrace();
			MensagemUtil.mostrarErro("Erro: " + e.getMessage(), atorJogador);
		}
	}

	public boolean ehMinhaVez() {
		return ehMinhaVez;
	}

	public void enviarJogadaRede(int pontuacaoDaVez, int dado1, int dado2, boolean passou, int situacao) {		
		
		Lance jg = new Lance(pontuacaoDaVez, dado1, dado2, passou, situacao);
		try {
			Proxy.getInstance().enviaJogada(jg);
		} catch (NaoJogandoException e) {
			e.printStackTrace();
			MensagemUtil.mostrarErro(e.getMessage(), atorJogador);
			ehMinhaVez = !passou;
		}
		
	}
	
	public String obtemNomeJogador() {
		
		return Proxy.getInstance().getNomeJogador();
	}

	public String obtemNomeAdversario() {
		
		return Proxy.getInstance().obterNomeAdversarios().get(0);
	}

	protected void conectarRede(String nome, String ipServidor) {
		try {
			Proxy.getInstance().conectar(ipServidor, nome);
			//Adiciona o ator como um dos ouvintes do Proxy.
			Proxy.getInstance().addOuvinte(this);
		} catch (JahConectadoException e) {
			e.printStackTrace();
			MensagemUtil.mostrarErro(e.getMessage(), atorJogador);
		} catch (NaoPossivelConectarException e) {
			e.printStackTrace();
			MensagemUtil.mostrarErro("Erro: " + e.getMessage(), atorJogador);
		} catch (ArquivoMultiplayerException e) {
			e.printStackTrace();
			MensagemUtil.mostrarErro("Erro: " + e.getMessage(), atorJogador);
		}
	}

}
