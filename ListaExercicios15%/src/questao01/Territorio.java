package questao01;

public class Territorio {
	
	public char terr[][];

	public Territorio() {
		super();
		this.terr = new char[6][6];
		
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 6; j++) {
				this.terr[i][j] = '.';
			}
		}
	}
	
	

}
