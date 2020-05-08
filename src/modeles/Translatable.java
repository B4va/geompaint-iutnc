package modeles;

/**
 * Elément translatable
 * @author Clément DOSDA, Louis FRIEDRICH, Loïc STEINMETZ, Julien TAVERNIER
 *
 */
public interface Translatable {
	
	/**
	 * Déplace l'élément
	 * @param x déplacement sur l'axe des abscisses
	 * @param y déplacement sur l'axe des ordonnées
	 */
	void translater(int x, int y);
}
