package questao01;

import java.util.Scanner;
//Professor, no enunciado da quest�o, h� uma parte que diz que a classe onde h� o m�todo main
//ser� a respons�vel por executar todas as modifica��es no territ�rio, por conta disso todos 
//os m�todos que o modificar est�o inclu�dos aqui
//aqui est� o enunciado desta parte:
/*
Voc� deve criar uma classe � parte que contenha o m�todo main para simular a execu��o
do jogo. Est� classe instanciar� o Territorio e far� as devidas altera��es no estado do
mesmo para simular o jogo atrav�s da execu��o de m�todos, tais como:
movimentarJogador(String dire��o); checarColisao(); checarLimites() ou toString(). Voc�
est� livre para criar quais m�todo precisar na classe.
*/


public class Teste {
	
	
	static Territorio movimentarCima(Jogador player, Territorio terr) {
		terr.terr[player.y][player.x] = player.carac;
		terr.terr[player.y - 1][player.x] = player.carac;
		
		player.setY(player.y - 1);
		
		return terr;
	}
	
	static Territorio movimentarBaixo(Jogador player, Territorio terr) {
		terr.terr[player.y][player.x] = player.carac;
		terr.terr[player.y + 1][player.x] = player.carac;
		player.setY(player.y + 1);
		return terr;
	}
	
	static Territorio movimentarDireita(Jogador player, Territorio terr) {
		terr.terr[player.y][player.x] = player.carac;
		terr.terr[player.y][player.x + 1] = player.carac;
		player.setX(player.x+1);
		return terr;
	}
	
	static Territorio movimentarEsquerda(Jogador player, Territorio terr) {
		terr.terr[player.y][player.x] = player.carac;
		terr.terr[player.y][player.x - 1] = player.carac;
		player.setX(player.x - 1); 
		return terr;
	}
	
	static Territorio checarLimites(Territorio terr, char key, Jogador player, int fim[]) {
		
		if(key == 'w') {
			if(player.y == 0) {
				System.out.println("Voc� est� no limite do mapa, n�o pode se mover para cima");
				fim[0]++;
			}
			else {
				if(terr.terr[player.y - 1][player.x] != '.') {
					System.out.println("Voc� colidiu com uma unidade!");
					fim[0]++;
				}
				movimentarCima(player, terr);
			}
		}
		
		
		if(key == 's') {
			
			if(player.y == 5) {
				System.out.println("Voc� est� no limite do mapa, n�o pode se mover para baixo");
				fim[0]++;
			}
			else {
				if(terr.terr[player.y + 1][player.x] != '.' ) {
					System.out.println("Voc� colidiu com uma unidade!");
					fim[0]++;
				}
				movimentarBaixo(player, terr);
			}
			
			
		}
		
		if(key == 'd') {
			if(player.x == 5) {
				System.out.println("Voc� est� no limite do mapa, n�o pode se mover para a direita");
				fim[0]++;
			}
			else {
				if(terr.terr[player.y][player.x + 1] != '.') {
					fim[0]++;
					System.out.println("Voc� colidiu com uma unidade!");
				}
				movimentarDireita(player, terr);
			}
		}
		
		if(key == 'a') {
			if(player.x == 0) {
				System.out.println("Voc� est� no limite do mapa, n�o pode se mover para a esquerda");
				fim[0]++;
			}
			else {
				if(terr.terr[player.y][player.x -1] != '.') {
					fim[0]++;
					System.out.println("Voc� colidiu com uma unidade!");
				}
				movimentarEsquerda(player, terr);
			}
		}
		
		return terr;
		
	}
	
	static void imprimirMapa(Territorio terr) {
		
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 6; j++) {
				System.out.printf("%c ", terr.terr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();

	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String nome1;
		String nome2;
		System.out.println("Digite o nome do player1:");
		nome1 = sc.nextLine();
		System.out.println("Digite o nome do player2:");
		nome2 = sc.nextLine();
		
		Jogador player1 = new Jogador(0, 0, nome1, nome1.charAt(0));
		Jogador player2 = new Jogador(5, 5, nome2, nome2.charAt(0));
		
		
		
		Territorio terr = new Territorio();
		terr.terr[0][0] = nome1.charAt(0);
		terr.terr[5][5] = nome2.charAt(0);
		
		int fim[] = new int[1];
		fim[0] = 1;
 
		
		System.out.println("Nome do bezerrinho: " + player1.getNome());
		System.out.println("Nome do bodinho: " + player2.getNome());
		System.out.println("Tamanho do territorio: 6x6");
		System.out.println();
		
		char aux;
		while(fim[0] == 1) {
			imprimirMapa(terr);
			System.out.print("Jogada de " + player1.getNome() + " (w,a,s,d): ");
			aux = sc.nextLine().charAt(0);
			System.out.println();
			terr = checarLimites(terr, aux, player1, fim);
			
			if(fim[0] != 1) {
				System.out.println("O jogador " + player2.getNome() + " venceu!");
				break;
			}
			
			imprimirMapa(terr);
			
			System.out.print("Jogada de " + player2.getNome() + " (w,a,s,d): ");
			aux = sc.nextLine().charAt(0);
			System.out.println();
			terr = checarLimites(terr, aux, player2, fim);
			
			if(fim[0] != 1) {
				System.out.println("O jogador " + player1.getNome() + " venceu!");
				break;
			}
			
		}
		
		sc.close();
		
		
		
	}

}
