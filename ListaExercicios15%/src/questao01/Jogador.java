package questao01;

public class Jogador {
	public int x;
	public int y;
	public String nome;
	public char carac;
	
	public Jogador(int x, int y, String nome, char carac) {
		super();
		this.x = x;
		this.y = y;
		this.nome = nome;
		this.carac = carac;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public char getCarac() {
		return carac;
	}

	public void setCarac(char carac) {
		this.carac = carac;
	}
	
	
	
	
	
}
