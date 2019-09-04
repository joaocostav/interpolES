package DominioDoProblema;

public class ElementoDominioProblema {
	
	protected boolean conectado = false;
	protected boolean partidaAndamento = false;

	public ElementoDominioProblema() {
		// TODO Auto-generated constructor stub
	}

	public void definirConectado(boolean valor) {
		conectado = valor;
	}
	
	public boolean estaConectado() {
		return conectado;
	}
	
	public void definirPartidaAndamento(boolean valor) {
		partidaAndamento = valor;
	}
	
	public boolean informarPartidaAndamento() {
		return partidaAndamento;
	}
	
	public boolean permitidoConectar() {
		return !conectado;
		// defina a lógica do seu jogo
	}
	
	public boolean permitidoDesconectar() {
		return conectado;
		// defina a lógica do seu jogo
	}

	public boolean permitidoIniciarPartida() {
		return !partidaAndamento;
		// defina a lógica do seu jogo
	}


}
