package questao03;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Random;


public class BilheteDeLoteria {
	Random rand = new Random();
	
	ArrayList<Integer> bilhete;
	
	public BilheteDeLoteria(int tamanho) {
		
		bilhete = new ArrayList<Integer>(tamanho);
		
		for(int i = 0; i < tamanho; ) {
			int random = rand.nextInt(60) + 1;
			if(!bilhete.contains(random)) {
				bilhete.add(random);
				i++;
			}
		}
		
		Collections.sort(bilhete);
		
			
	}

	@Override
	public String toString() {
		String imprimir = "[ ";
		for(int i = 0; i < bilhete.size(); i++) {
			imprimir += bilhete.get(i) + ", ";
		}
		imprimir += "]";
		
		return imprimir;
	}
	
	
	
	public int qtdNumerosContidos(BilheteDeLoteria outro) {
	
		int devolver = 0;
		
		for(int i = 0; i < outro.bilhete.size(); i++) {
			for(int j = 0; j < this.bilhete.size(); j++) {
				if(this.bilhete.get(j) == outro.bilhete.get(i)) {
					devolver += 1;
				}
			}
		}
		
		return devolver;
	}
	
	
	
}
