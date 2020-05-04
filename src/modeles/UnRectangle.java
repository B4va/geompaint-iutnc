package modeles;

import java.util.ArrayList;

/**
 * Modélise un rectangle
 * @author Clément DOSDA, Louis FRIEDRICH, Loïc STEINMETZ, Julien TAVERNIER
 *
 */
public class UnRectangle extends UnPolygone {

	/**
	 * Constructeur
	 * @param pointsConstruction points permettant de construire la figure
	 */
	public UnRectangle(ArrayList<UnPoint> pointsConstruction) {
		super(pointsConstruction);
	}

	@Override
	/**
	 * Enregistre les points de saisie
	 */
	protected void iniPointsSaisie() {
		// modifier
		pointsSaisie = null;
	}
}
