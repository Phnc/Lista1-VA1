package questao03;

import java.util.ArrayList;

public class MinhaLoteria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BilheteDeLoteria bilhetePremiado = new BilheteDeLoteria(6);
		//System.out.println(bilhetePremiado);
		
		
		
		
		for(int i = 6; i <=15; i++) {
			boolean aux = true;
			int quadra = 0;
			int quina = 0;
			int sorteios = 0;
			ArrayList<BilheteDeLoteria> bilhetes = new ArrayList<BilheteDeLoteria>(i);
			bilhetes.add(bilhetePremiado);
			
			while(aux == true) {
				
				
				BilheteDeLoteria bilheteSorteado = new BilheteDeLoteria(i);
				bilhetes.set(0, bilheteSorteado);
				sorteios++;
				
				if(bilhetePremiado.qtdNumerosContidos(bilheteSorteado) == 4) {
					quadra++;
				}
				
				else if(bilhetePremiado.qtdNumerosContidos(bilheteSorteado) == 5) {
					quina++;
				}
				
				else if(bilhetePremiado.qtdNumerosContidos(bilheteSorteado) == 6) {
					System.out.println("Você ganhou na mega com " + i + " numeros" +" após " + sorteios + " sorteios"+" acertando " + quadra + " quadras e " + quina + " quinas");
					System.out.println("o bilhete sorteado foi: " + bilheteSorteado);
					aux = false;
				}
				/*
				else {
					System.out.println("Sorteio nº " + sorteios+ " o bilhete sorteado " + bilheteSorteado + " não contém todos os números do bilhete premiado " + bilhetePremiado);
				}*/
				
				
			}
		}

	}

}
