package modeles;

/**
 * Modélise un point
 * @author Clément DOSDA, Louis FRIEDRICH, Loïc STEINMETZ, Julien TAVERNIER
 *
 */
public class UnPoint {
	
	private int x, y;
	
	/**
	 * Constructeur
	 * @param x
	 * @param y
	 */
	public UnPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Déplace un point
	 * @param x le déplacement en abcisse
	 * @param y le déplacement en ordonnée
	 */
	public void translater(int x, int y) {
		this.x += x;
		this.y += y;
	}
	
}
