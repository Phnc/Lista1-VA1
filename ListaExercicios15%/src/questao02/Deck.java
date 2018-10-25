package questao02;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	int quantidade;
	private ArrayList<Carta> cartas;

	public Deck(int newQuantidade) {
		super();
		this.quantidade = newQuantidade;
		this.cartas = new ArrayList<Carta>();
	}
	
	
	public void criarDeck() {
		for(int i = 0; i < this.quantidade; i++) {
			
			for(Naipe naipeCarta : Naipe.values()){
				for(Valor valorCarta : Valor.values()) {
					this.cartas.add(new Carta(naipeCarta, valorCarta));
				}
			}
		}
	}
	
	public String toString() {
		String imprimir = " ";
		
		
		for(Carta carta1 : this.cartas) {
			imprimir += "\n" + carta1.toString();
		}
		
		return imprimir;
		
	}
	
	public void embaralhar() {
		Collections.shuffle(this.cartas);
	}
	
	public void removerCarta(int i) {
		this.cartas.remove(i);
	}
	
	public Carta getCarta(int i) {
		return this.cartas.get(i);
	}
	
	public void addCarta(Carta add) {
		this.cartas.add(add);
	}
	
	public void comprar(Deck primeiro) {
		this.cartas.add(primeiro.getCarta(0));
		primeiro.removerCarta(0);
	}
	
	
	public int tamanhoDeck() {
		return this.cartas.size();
	}
	
	public void moverParaDeck(Deck moverPara) {
		int tamanhoMeuDeck = this.tamanhoDeck();
		for(int i = 0; i < tamanhoMeuDeck; i++) {
			moverPara.addCarta(this.getCarta(i));
		}
		
		for(int i = 0; i < tamanhoMeuDeck; i++) {
			this.removerCarta(0);
		}
	}
	
	public int valorCartas() {
		int valor = 0;
		int ases = 0;
		
		for(Carta carta1 : this.cartas) {
			switch(carta1.getValor()) {
				
			case DOIS: valor += 2; break;
			case TRES: valor += 3; break;
			case QUATRO: valor += 4; break;
			case CINCO: valor += 5; break;
			case SEIS: valor += 6; break;
			case SETE: valor += 7; break;
			case OITO: valor += 8; break;
			case NOVE: valor += 9; break;
			case DEZ: valor += 10; break;
			case VALETE: valor += 10; break;
			case REI: valor += 10; break;
			case RAINHA: valor += 10; break;
			case AS: ases += 1; break;
			
			}
		}
		
		for(int i = 0; i < ases; i++) {
			if(valor > 10) {
				valor += 1;
			}
			else {
				valor += 11;
			}
		}
		
		return valor;
	}

}
