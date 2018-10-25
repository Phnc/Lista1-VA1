package questao02;

import java.util.Scanner;

public class Blackjack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Seja bem-vindo(a) ao Blackjack!");
		Scanner sc = new Scanner(System.in);
		int qtd;
		
		System.out.println("Com quantos decks você quer jogar? (Min 2, Max 10)");
		System.out.println();
		System.out.println();
		qtd = sc.nextInt();
		
		if(qtd < 2) {
			qtd = 2;
		}
		if(qtd > 10) {
			qtd = 10;
		}
		
		
		int fichas = 100;
		
		Deck deckDeJogar = new Deck(qtd);
		Deck deckJogador = new Deck(0);
		Deck deckBanca = new Deck(0);
		Deck deckAuxiliar = new Deck(0);
		deckDeJogar.criarDeck();
		
		deckDeJogar.embaralhar();
		
	
		while(fichas > 0) {
			System.out.println("Você tem " + fichas + " fichas");
			System.out.println("Digite sua aposta. A aposta mínima é 2");
			System.out.println("Se um valor menor que este for digitado, a aposta será mudada para 2");
			
			int aposta = sc.nextInt();
			if(aposta < 2) {
				aposta = 2;
			}
			
			if(aposta > fichas) {
				System.out.println("Pare de trapacear!!");
				break;
			}
			boolean fimTurno = false;
			
			
			deckJogador.comprar(deckDeJogar);
			deckJogador.comprar(deckDeJogar);
			

			deckBanca.comprar(deckDeJogar);
			boolean aux = true;
			while(aux == true) {
				
				System.out.println("Sua mão: ");
				System.out.println(deckJogador.toString());
				System.out.println("Valor na sua mão: " + deckJogador.valorCartas());
				
				
				System.out.println();
				System.out.println("Mão da banca: ");
				System.out.println(deckBanca.toString());
				System.out.println("Valor da mão da banca: " + deckBanca.valorCartas());
				System.out.println();
				
				
				System.out.println("O que você deseja fazer? Hit(1) Stay(2)");
				int resposta = sc.nextInt();
				
				if(resposta == 1) {
					deckJogador.comprar(deckDeJogar);
					System.out.println("Você comprou um(a): " + deckJogador.getCarta(deckJogador.tamanhoDeck() - 1).toString());
					if(deckJogador.valorCartas() > 21) {
						System.out.println("Você estourou 21 pontos!" + " Você tem  " + deckJogador.valorCartas());
						fichas = fichas - aposta;
						fimTurno = true;
						break;
					}
				}
				if(resposta == 2) {
					break;
				}
			}
			
			if(deckBanca.valorCartas() > deckJogador.valorCartas() && fimTurno == false) {
				System.out.println("A banca venceu!");
				fichas = fichas - aposta;
				fimTurno = true;
				
			}
			
			while(deckBanca.valorCartas() < deckJogador.valorCartas() && fimTurno == false) {
				deckBanca.comprar(deckDeJogar);
				
			}
			
			System.out.println("Mão da banca: " + deckBanca.toString());
			System.out.println("Valor da mão da banca: " + deckBanca.valorCartas());
			System.out.println();
			if(deckBanca.valorCartas() > 21 && fimTurno == false) {
				System.out.println("A banca estourou 21 pontos! Você vence o turno!");
				fichas += aposta;
				fimTurno = true;
			}
			
			if(deckJogador.valorCartas() == deckBanca.valorCartas() && fimTurno == false) {
				System.out.println("Empate, ninguém perde nada!");
				fimTurno = true;
			}
			
			else if(fimTurno == false) {
				System.out.println("Você perdeu!");
				fichas = fichas - aposta;
				fimTurno = true;
			}
			
			deckJogador.moverParaDeck(deckAuxiliar);
			deckBanca.moverParaDeck(deckAuxiliar);
			
			System.out.println("Cartas restantes: " + deckDeJogar.tamanhoDeck());
			System.out.println();
			
			if(deckDeJogar.valorCartas() == 0) {
				deckAuxiliar.moverParaDeck(deckDeJogar);
			}
			
			System.out.println("Fim de turno!");
			System.out.println();
			System.out.println("Deseja continuar jogando?");
			System.out.println("Digite 1 apra sim e qualquer outro número para não");
			int terminar;
			terminar = sc.nextInt();
			if(terminar == 1) {
				aux = false;
			}
			else {
				aux = true;
			}
			
		}
		sc.close();
		System.out.println("Fim de jogo!");
		
		
	}

}
