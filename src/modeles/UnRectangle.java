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
		pointsSaisie = new ArrayList<>();
		int xA = pointsMemoire.get(0).getX();
		int yA = pointsMemoire.get(0).getY();
		int xB = pointsMemoire.get(1).getX();
		int yB = pointsMemoire.get(1).getY();
	}
}
