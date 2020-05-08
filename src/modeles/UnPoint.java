package modeles;

/**
 * Modélisation d'un point
 * @author Clément DOSDA, Louis FRIEDRICH, Loïc STEINMETZ, Julien TAVERNIER
 *
 */
public class UnPoint implements Translatable {
	
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
	 * @param x déplacement sur l'axe des abscisses
	 * @param y déplacement sur l'axe des ordonnées
	 */
	public void translater(int x, int y) {
		this.x += x;
		this.y += y;
	}
	
	/**
	 * Retourne l'abscisse du point
	 * @return abscisse du point
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Retourne l'ordonnée du point
	 * @return ordonnée du point
	 */
	public int getY() {
		return y;
	}
	
}
