package questao02;

public class Carta {
	private Naipe naipe;
	private Valor valor;
	
	
	public Carta(Naipe naipe, Valor valor) {
		super();
		this.naipe = naipe;
		this.valor = valor;
	}


	@Override
	public String toString() {
		return this.naipe.toString() + " - " + this.valor.toString();
	}
	
	public Valor getValor() {
		return this.valor;	
	}
	
}
